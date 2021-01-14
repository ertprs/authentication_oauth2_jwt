package com.fmatheus.app.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author fmatheus
 */
@Entity
@Table(name = "user", catalog = "cem", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"avatar"}),
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"username"})})

public class UserEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 70)
    private String password;

    @Basic(optional = false)
    @Column(name = "avatar", nullable = false, length = 20)
    private String avatar;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCreatedUser")
    private Collection<EquipamentEntity> equipamentEntityCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUpdatedUser")
    private Collection<EquipamentEntity> equipamentEntityCollection1;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCreatedUser")
    private Collection<EquipamentHistoricEntity> equipamentHistoricEntityCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUpdatedUser")
    private Collection<EquipamentHistoricEntity> equipamentHistoricEntityCollection1;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCreatedUser")
    private Collection<EmployeeEntity> employeeEntityCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUpdatedUser")
    private Collection<EmployeeEntity> employeeEntityCollection1;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCreatedUser")
    private Collection<ProviderEntity> providerEntityCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUpdatedUser")
    private Collection<ProviderEntity> providerEntityCollection1;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idUser")
    private UserPermissionJoinEntity userPermissionJoinEntity;

    @JoinColumn(name = "id_employee", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private EmployeeEntity idEmployee;

    @JoinColumn(name = "id_user_status", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UserStatusEntity userStatusEntity;

    @JoinTable(name = "user_permission_join",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_permission")
    )
    @ManyToMany(fetch = FetchType.EAGER)
    private List<PermissionEntity> permissions;

    public UserEntity() {
    }

    public UserEntity(Integer id) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Collection<EquipamentEntity> getEquipamentEntityCollection() {
        return equipamentEntityCollection;
    }

    public void setEquipamentEntityCollection(Collection<EquipamentEntity> equipamentEntityCollection) {
        this.equipamentEntityCollection = equipamentEntityCollection;
    }

    public Collection<EquipamentEntity> getEquipamentEntityCollection1() {
        return equipamentEntityCollection1;
    }

    public void setEquipamentEntityCollection1(Collection<EquipamentEntity> equipamentEntityCollection1) {
        this.equipamentEntityCollection1 = equipamentEntityCollection1;
    }

    public Collection<EquipamentHistoricEntity> getEquipamentHistoricEntityCollection() {
        return equipamentHistoricEntityCollection;
    }

    public void setEquipamentHistoricEntityCollection(Collection<EquipamentHistoricEntity> equipamentHistoricEntityCollection) {
        this.equipamentHistoricEntityCollection = equipamentHistoricEntityCollection;
    }

    public Collection<EquipamentHistoricEntity> getEquipamentHistoricEntityCollection1() {
        return equipamentHistoricEntityCollection1;
    }

    public void setEquipamentHistoricEntityCollection1(Collection<EquipamentHistoricEntity> equipamentHistoricEntityCollection1) {
        this.equipamentHistoricEntityCollection1 = equipamentHistoricEntityCollection1;
    }

    public Collection<EmployeeEntity> getEmployeeEntityCollection() {
        return employeeEntityCollection;
    }

    public void setEmployeeEntityCollection(Collection<EmployeeEntity> employeeEntityCollection) {
        this.employeeEntityCollection = employeeEntityCollection;
    }

    public Collection<EmployeeEntity> getEmployeeEntityCollection1() {
        return employeeEntityCollection1;
    }

    public void setEmployeeEntityCollection1(Collection<EmployeeEntity> employeeEntityCollection1) {
        this.employeeEntityCollection1 = employeeEntityCollection1;
    }

    public Collection<ProviderEntity> getProviderEntityCollection() {
        return providerEntityCollection;
    }

    public void setProviderEntityCollection(Collection<ProviderEntity> providerEntityCollection) {
        this.providerEntityCollection = providerEntityCollection;
    }

    public Collection<ProviderEntity> getProviderEntityCollection1() {
        return providerEntityCollection1;
    }

    public void setProviderEntityCollection1(Collection<ProviderEntity> providerEntityCollection1) {
        this.providerEntityCollection1 = providerEntityCollection1;
    }

    public UserPermissionJoinEntity getUserPermissionJoinEntity() {
        return userPermissionJoinEntity;
    }

    public void setUserPermissionJoinEntity(UserPermissionJoinEntity userPermissionJoinEntity) {
        this.userPermissionJoinEntity = userPermissionJoinEntity;
    }

    public EmployeeEntity getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(EmployeeEntity idEmployee) {
        this.idEmployee = idEmployee;
    }

    public UserStatusEntity getUserStatusEntity() {
        return userStatusEntity;
    }

    public void setUserStatusEntity(UserStatusEntity userStatusEntity) {
        this.userStatusEntity = userStatusEntity;
    }

    public List<PermissionEntity> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionEntity> permissions) {
        this.permissions = permissions;
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
        if (!(object instanceof UserEntity)) {
            return false;
        }
        UserEntity other = (UserEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.fmatheus.app.model.entity.UserEntity[ id=" + id + " ]";
    }

}
