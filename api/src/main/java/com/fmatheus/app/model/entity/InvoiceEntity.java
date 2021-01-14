package com.fmatheus.app.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "invoice", catalog = "cem", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"access_key"}),
    @UniqueConstraint(columnNames = {"id"})})

public class InvoiceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "number", nullable = false, length = 45)
    private String number;

    @Basic(optional = false)
    @Column(name = "access_key", nullable = false, length = 70)
    private String accessKey;

    @Basic(optional = false)
    @Column(name = "date_issue", nullable = false)
    private LocalDate dateIssue;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInvoice")
    private Collection<EquipamentEntity> equipamentEntityCollection;

    @JoinColumn(name = "id_provider", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ProviderEntity idProvider;

    public InvoiceEntity() {
    }

    public InvoiceEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public LocalDate getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(LocalDate dateIssue) {
        this.dateIssue = dateIssue;
    }

    public Collection<EquipamentEntity> getEquipamentEntityCollection() {
        return equipamentEntityCollection;
    }

    public void setEquipamentEntityCollection(Collection<EquipamentEntity> equipamentEntityCollection) {
        this.equipamentEntityCollection = equipamentEntityCollection;
    }

    public ProviderEntity getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(ProviderEntity idProvider) {
        this.idProvider = idProvider;
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
        if (!(object instanceof InvoiceEntity)) {
            return false;
        }
        InvoiceEntity other = (InvoiceEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.fmatheus.app.model.entity.InvoiceEntity[ id=" + id + " ]";
    }

}
