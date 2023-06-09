package br.com.trixo.cms.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Entidade persistente que tem o identificador tipado como Long.
 * 
 * @author rafaelabreu
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class TrixoCMSDefaultEntity extends TrixoCMSEntity<Long> {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * @return the id
     */
    public Long getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
	this.id = id;
    }

    /**
     * 
     */
    @Override
    public boolean isCadastrado() {
	return super.isCadastrado() && this.getId() > 0L;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	TrixoCMSDefaultEntity other = (TrixoCMSDefaultEntity) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }
}