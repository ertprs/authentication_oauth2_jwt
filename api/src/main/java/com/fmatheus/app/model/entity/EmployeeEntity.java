package com.fmatheus.app.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author fmatheus
 */
@Entity
@Table(name = "employee", catalog = "cem", schema = "", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "id_person" }), @UniqueConstraint(columnNames = { "id" }) })

public class EmployeeEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Basic(optional = false)
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

	@Basic(optional = false)
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmployee")
	private Collection<EquipamentHistoricEntity> equipamentHistoricEntityCollection;

	@JoinColumn(name = "id_occupation", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private OccupationEntity idOccupation;

	@JoinColumn(name = "id_person", referencedColumnName = "id", nullable = false)
	@OneToOne(optional = false)
	private PersonEntity idPerson;

	@JoinColumn(name = "id_created_user", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private UserEntity idCreatedUser;

	@JoinColumn(name = "id_updated_user", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private UserEntity idUpdatedUser;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmployee")
	private Collection<UserEntity> userEntityCollection;

	@Basic(optional = false)
	@NotNull
	@Lob
	@Size(min = 1, max = 2147483647)
	@Column(name = "filter", nullable = false, length = 2147483647)
	private String filter;

	public EmployeeEntity() {
	}

	public EmployeeEntity(Integer id) {
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Collection<EquipamentHistoricEntity> getEquipamentHistoricEntityCollection() {
		return equipamentHistoricEntityCollection;
	}

	public void setEquipamentHistoricEntityCollection(
			Collection<EquipamentHistoricEntity> equipamentHistoricEntityCollection) {
		this.equipamentHistoricEntityCollection = equipamentHistoricEntityCollection;
	}

	public OccupationEntity getIdOccupation() {
		return idOccupation;
	}

	public void setIdOccupation(OccupationEntity idOccupation) {
		this.idOccupation = idOccupation;
	}

	public PersonEntity getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(PersonEntity idPerson) {
		this.idPerson = idPerson;
	}

	public UserEntity getIdCreatedUser() {
		return idCreatedUser;
	}

	public void setIdCreatedUser(UserEntity idCreatedUser) {
		this.idCreatedUser = idCreatedUser;
	}

	public UserEntity getIdUpdatedUser() {
		return idUpdatedUser;
	}

	public void setIdUpdatedUser(UserEntity idUpdatedUser) {
		this.idUpdatedUser = idUpdatedUser;
	}

	public Collection<UserEntity> getUserEntityCollection() {
		return userEntityCollection;
	}

	public void setUserEntityCollection(Collection<UserEntity> userEntityCollection) {
		this.userEntityCollection = userEntityCollection;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
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
		if (!(object instanceof EmployeeEntity)) {
			return false;
		}
		EmployeeEntity other = (EmployeeEntity) object;
		return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
	}

	@Override
	public String toString() {
		return "com.fmatheus.app.model.entity.EmployeeEntity[ id=" + id + " ]";
	}

}
