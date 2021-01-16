package com.fmatheus.app.model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fmatheus.app.controller.util.AppUtil;

/**
 *
 * @author fmatheus
 */
@Entity
@Table(name = "occupation", catalog = "cem", schema = "", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "name" }), @UniqueConstraint(columnNames = { "id" }) })

public class OccupationEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Basic(optional = false)
	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOccupation")
	private Collection<EmployeeEntity> employeeEntityCollection;

	public OccupationEntity() {
	}

	public OccupationEntity(Integer id) {
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

	public String getName() {
		if (name != null) {
			return AppUtil.convertFirstUppercaseCharacter(AppUtil.removeDuplicateSpace(name));
		}
		return name;
	}

	public void setName(String name) {
		this.name = AppUtil.convertAllUppercaseCharacters(AppUtil.removeDuplicateSpace(AppUtil.removeAccent(name)));
	}

	@javax.xml.bind.annotation.XmlTransient
	public Collection<EmployeeEntity> getEmployeeEntityCollection() {
		return employeeEntityCollection;
	}

	public void setEmployeeEntityCollection(Collection<EmployeeEntity> employeeEntityCollection) {
		this.employeeEntityCollection = employeeEntityCollection;
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
		if (!(object instanceof OccupationEntity)) {
			return false;
		}
		OccupationEntity other = (OccupationEntity) object;
		return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
	}

	@Override
	public String toString() {
		return "com.fmatheus.app.model.entity.OccupationEntity[ id=" + id + " ]";
	}

}
