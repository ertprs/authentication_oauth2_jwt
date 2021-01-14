package com.fmatheus.app.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author fmatheus
 */
@Entity
@Table(name = "equipament_historic", catalog = "cem", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})

public class EquipamentHistoricEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "date_output", nullable = false)
    private LocalDate dateOutput;

    @Column(name = "date_input")
    private LocalDate dateInput;

    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Basic(optional = false)
    @Column(name = "returned", nullable = false)
    private boolean returned;

    @JoinColumn(name = "id_employee", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private EmployeeEntity idEmployee;

    @JoinColumn(name = "id_equipament", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private EquipamentEntity idEquipament;

    @JoinColumn(name = "id_created_user", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UserEntity idCreatedUser;

    @JoinColumn(name = "id_updated_user", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UserEntity idUpdatedUser;

    public EquipamentHistoricEntity() {
    }

    public EquipamentHistoricEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateOutput() {
        return dateOutput;
    }

    public void setDateOutput(LocalDate dateOutput) {
        this.dateOutput = dateOutput;
    }

    public LocalDate getDateInput() {
        return dateInput;
    }

    public void setDateInput(LocalDate dateInput) {
        this.dateInput = dateInput;
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

    public boolean getReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public EmployeeEntity getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(EmployeeEntity idEmployee) {
        this.idEmployee = idEmployee;
    }

    public EquipamentEntity getIdEquipament() {
        return idEquipament;
    }

    public void setIdEquipament(EquipamentEntity idEquipament) {
        this.idEquipament = idEquipament;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipamentHistoricEntity)) {
            return false;
        }
        EquipamentHistoricEntity other = (EquipamentHistoricEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.fmatheus.app.model.entity.EquipamentHistoricEntity[ id=" + id + " ]";
    }

}
