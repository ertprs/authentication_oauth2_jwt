package com.fmatheus.app.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;

import com.fmatheus.app.controller.util.AppUtil;

/**
 *
 * @author fmatheus
 */
@Entity
@Table(name = "contact", catalog = "cem", schema = "", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "id_person" }), @UniqueConstraint(columnNames = { "id" }),
		@UniqueConstraint(columnNames = { "email" }) })

public class ContactEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Basic(optional = false)
	@Column(name = "phone", nullable = false, length = 15)
	private String phone;

	@Basic(optional = false)
	@Email
	@Column(name = "email", nullable = false, length = 70)
	private String email;

	@JoinColumn(name = "id_person", referencedColumnName = "id", nullable = false)
	@OneToOne(optional = false)
	private PersonEntity idPerson;

	public ContactEntity() {
	}

	public ContactEntity(Integer id) {
		this.id = id;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhone() {
		if (phone != null) {
			return AppUtil.removeSpecialCharacters(phone);
		}
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = AppUtil.removeSpecialCharacters(phone);
	}

	public String getEmail() {
		if (email != null) {
			return AppUtil.convertAllLowercaseCharacters(email);
		}
		return email;
	}

	public void setEmail(String email) {
		this.email = AppUtil.convertAllUppercaseCharacters(email);
	}

	public PersonEntity getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(PersonEntity idPerson) {
		this.idPerson = idPerson;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof ContactEntity)) {
			return false;
		}
		ContactEntity other = (ContactEntity) object;
		return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
	}

	@Override
	public String toString() {
		return "com.fmatheus.app.model.entity.ContactEntity[ id=" + id + " ]";
	}

}
