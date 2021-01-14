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

/**
 *
 * @author fmatheus
 */
@Entity
@Table(name = "category", catalog = "cem", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"}),
    @UniqueConstraint(columnNames = {"id"})})

public class CategoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategory")
    private Collection<PeripheralEntity> peripheralEntityCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategory")
    private Collection<ModelEntity> modelEntityCollection;

    public CategoryEntity() {
    }

    public CategoryEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @javax.xml.bind.annotation.XmlTransient
    public Collection<PeripheralEntity> getPeripheralEntityCollection() {
        return peripheralEntityCollection;
    }

    public void setPeripheralEntityCollection(Collection<PeripheralEntity> peripheralEntityCollection) {
        this.peripheralEntityCollection = peripheralEntityCollection;
    }

    @javax.xml.bind.annotation.XmlTransient
    public Collection<ModelEntity> getModelEntityCollection() {
        return modelEntityCollection;
    }

    public void setModelEntityCollection(Collection<ModelEntity> modelEntityCollection) {
        this.modelEntityCollection = modelEntityCollection;
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
        if (!(object instanceof CategoryEntity)) {
            return false;
        }
        CategoryEntity other = (CategoryEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.fmatheus.app.model.entity.CategoryEntity[ id=" + id + " ]";
    }

}
