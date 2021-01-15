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
@Table(name = "model", catalog = "cem", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"partnumber"}),
    @UniqueConstraint(columnNames = {"id"})})

public class ModelEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "partnumber", nullable = false, length = 20)
    private String partnumber;

    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModel")
    private Collection<EquipamentEntity> equipamentEntityCollection;

    @JoinColumn(name = "id_brand", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private BrandEntity idBrand;

    @JoinColumn(name = "id_category", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private CategoryEntity idCategory;

    public ModelEntity() {
    }

    public ModelEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartnumber() {
        return partnumber;
    }

    public void setPartnumber(String partnumber) {
        this.partnumber = partnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<EquipamentEntity> getEquipamentEntityCollection() {
        return equipamentEntityCollection;
    }

    public void setEquipamentEntityCollection(Collection<EquipamentEntity> equipamentEntityCollection) {
        this.equipamentEntityCollection = equipamentEntityCollection;
    }

    public BrandEntity getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(BrandEntity idBrand) {
        this.idBrand = idBrand;
    }

    public CategoryEntity getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(CategoryEntity idCategory) {
        this.idCategory = idCategory;
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
        if (!(object instanceof ModelEntity)) {
            return false;
        }
        ModelEntity other = (ModelEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.fmatheus.app.model.entity.ModelEntity[ id=" + id + " ]";
    }

}
