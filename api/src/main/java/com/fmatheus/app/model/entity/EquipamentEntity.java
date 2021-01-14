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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author fmatheus
 */
@Entity
@Table(name = "equipament", catalog = "cem", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"serial_number"})})

public class EquipamentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "serial_number", nullable = false, length = 20)
    private String serialNumber;

    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @JoinColumn(name = "id_equipament_status", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private EquipamentStatusEntity idEquipamentStatus;

    @JoinColumn(name = "id_invoice", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private InvoiceEntity idInvoice;

    @JoinColumn(name = "id_model", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ModelEntity idModel;

    @JoinColumn(name = "id_created_user", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UserEntity idCreatedUser;

    @JoinColumn(name = "id_updated_user", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UserEntity idUpdatedUser;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipament")
    private Collection<EquipamentHistoricEntity> equipamentHistoricEntityCollection;

    public EquipamentEntity() {
    }

    public EquipamentEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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

    public EquipamentStatusEntity getIdEquipamentStatus() {
        return idEquipamentStatus;
    }

    public void setIdEquipamentStatus(EquipamentStatusEntity idEquipamentStatus) {
        this.idEquipamentStatus = idEquipamentStatus;
    }

    public InvoiceEntity getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(InvoiceEntity idInvoice) {
        this.idInvoice = idInvoice;
    }

    public ModelEntity getIdModel() {
        return idModel;
    }

    public void setIdModel(ModelEntity idModel) {
        this.idModel = idModel;
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

    public Collection<EquipamentHistoricEntity> getEquipamentHistoricEntityCollection() {
        return equipamentHistoricEntityCollection;
    }

    public void setEquipamentHistoricEntityCollection(Collection<EquipamentHistoricEntity> equipamentHistoricEntityCollection) {
        this.equipamentHistoricEntityCollection = equipamentHistoricEntityCollection;
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
        if (!(object instanceof EquipamentEntity)) {
            return false;
        }
        EquipamentEntity other = (EquipamentEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.fmatheus.app.model.entity.EquipamentEntity[ id=" + id + " ]";
    }

}
