/*-------------------------------------------------------------------------------
 * The MIT License (MIT)
 *
 * Copyright (c) 2015-16 Scripps Institute (USA) - Dr. Benjamin Good
 *                       STAR Informatics / Delphinai Corporation (Canada) - Dr. Richard Bruskiewich
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *-------------------------------------------------------------------------------
 */
package bio.knowledge.model;

import java.util.HashSet;
import java.util.Set;

import bio.knowledge.model.Annotation;
import bio.knowledge.model.Evidence;
import bio.knowledge.model.Statement;
import bio.knowledge.model.core.IdentifiedEntity;
import bio.knowledge.model.core.AbstractIdentifiedEntity;

/**
 * @author Kenneth
 *
 * September 16, 2016 revision:
 * 
 * The former SemMedDb "Evidence" class was generalized to track 
 * a more diverse range of 'Annotation'
 *
 */
public class EvidenceImpl extends AbstractIdentifiedEntity implements Evidence {
	
	private Statement statement ;
	
	private Set<Annotation> annotations = new HashSet<Annotation>() ;

	private Integer count = 0;
	
	private String publicationDate;
	
	public String getPublicationDate() {
		return publicationDate;
	}
	
	public void setPublicationDate(String date) {
		this.publicationDate = date;
	}

	public EvidenceImpl() {}

	/* (non-Javadoc)
	 * @see bio.knowledge.model.Evidence#setStatement(bio.knowledge.model.Statement)
	 */
	@Override
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	
	/* (non-Javadoc)
	 * @see bio.knowledge.model.Evidence#getStatement()
	 */
	@Override
	public Statement getStatement() {
		return statement;
	}
	
	/* (non-Javadoc)
	 * @see bio.knowledge.model.Evidence#setAnnotations(java.util.Set)
	 */
	@Override
	public void setAnnotations(Set<Annotation> annotations) {
		this.annotations.addAll(annotations);
	}

	/* (non-Javadoc)
	 * @see bio.knowledge.model.Evidence#addAnnotation(bio.knowledge.model.neo4j.Neo4jAnnotation)
	 */
	@Override
	public void addAnnotation(Annotation annotation) {
		this.annotations.add(annotation);
		incrementCount();
	}

	/* (non-Javadoc)
	 * @see bio.knowledge.model.Evidence#getAnnotations()
	 */
	@Override
	public Set<Annotation> getAnnotations() {
		return annotations;
	}
	
	/* (non-Javadoc)
	 * @see bio.knowledge.model.Evidence#setCount(java.lang.Integer)
	 */
	@Override
	public void setCount(Integer count) {
		this.count = count;
	}

	/* (non-Javadoc)
	 * @see bio.knowledge.model.Evidence#incrementCount()
	 */
	@Override
	public void incrementCount() {
		this.count += 1;
	}

	/* (non-Javadoc)
	 * @see bio.knowledge.model.Evidence#getCount()
	 */
	@Override
	public Integer getCount() {
		if(count==null)
			count = annotations.size() ;
		return count;
	}

	/* (non-Javadoc)
	 * @see bio.knowledge.model.core.neo4j.Neo4jIdentifiedEntity#toString()
	 */
	/* (non-Javadoc)
	 * @see bio.knowledge.model.Evidence#toString()
	 */
	@Override
	public String toString() {
		/*
		 *  The String representation of Evidence is simply the count of Annotations
		 */
		return getCount().toString() ;
	}
	
	/* (non-Javadoc)
	 * @see bio.knowledge.model.Evidence#compareTo(bio.knowledge.model.core.IdentifiedEntity)
	 */
	@Override
	public int compareTo(IdentifiedEntity other) {
		return getCount().compareTo(((Evidence) other).getCount());
	}
	
}
