package com.fmatheus.app.model.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fmatheus.app.controller.util.AppUtil;

/**
 *
 * @author fmatheus
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "person", catalog = "cem", schema = "", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "document" }), @UniqueConstraint(columnNames = { "id" }) })

public class PersonEntity extends BaseEntity {

	@Basic(optional = false)
	@Column(name = "name", nullable = false, length = 70)
	private String name;

	@Basic(optional = false)
	@Column(name = "document", nullable = false, length = 20)
	private String document;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "idPerson")
	private EmployeeEntity employeeEntity;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "idPerson")
	private ContactEntity contactEntity;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "idPerson")
	private ProviderEntity providerEntity;

	@JoinColumn(name = "id_person_type", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private PersonTypeEntity idPersonType;

	public PersonEntity() {
	}

	public PersonEntity(Integer id) {
		super.setId(id);
	}

	@Override
	public Integer getId() {
		return super.getId();
	}

	@Override
	public void setId(Integer id) {
		super.setId(id);
	}

	public String getName() {
		if (name != null) {
			return AppUtil.convertFirstUppercaseCharacter(AppUtil.removeDuplicateSpace(name));
		}
		return name;
	}

	public void setName(String name) {
		this.name = AppUtil.convertAllUppercaseCharacters(AppUtil.removeDuplicateSpace(AppUtil.removeAccent(name)));
	}

	public String getDocument() {
		if (document != null) {
			return AppUtil.removeSpecialCharacters(document);
		}
		return document;
	}

	public void setDocument(String document) {
		this.document = AppUtil.removeSpecialCharacters(document);
	}

	public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}

	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
	}

	public ProviderEntity getProviderEntity() {
		return providerEntity;
	}

	public void setProviderEntity(ProviderEntity providerEntity) {
		this.providerEntity = providerEntity;
	}

	public PersonTypeEntity getIdPersonType() {
		return idPersonType;
	}

	public void setIdPersonType(PersonTypeEntity idPersonType) {
		this.idPersonType = idPersonType;
	}

	public ContactEntity getContactEntity() {
		return contactEntity;
	}

	public void setContactEntity(ContactEntity contactEntity) {
		this.contactEntity = contactEntity;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (super.getId() != null ? super.getId().hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PersonEntity)) {
			return false;
		}
		PersonEntity other = (PersonEntity) object;
		return !((super.getId() == null && other.getId() != null)
				|| (super.getId() != null && !super.getId().equals(other.getId())));
	}

	@Override
	public String toString() {
		return "com.fmatheus.app.model.entity.PersonEntity[ id=" + super.getId() + " ]";
	}

}
