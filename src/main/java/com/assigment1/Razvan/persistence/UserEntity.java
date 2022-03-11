package com.assigment1.Razvan.persistence;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "user", schema = "sdassigment1", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id") })
public class UserEntity {
    private int id;
    private String name;
    private String hash;
    private String email;
    private Integer type;

    /*@ManyToMany(cascade = { CascadeType.ALL })
//    @ElementCollection(targetClass=VacationpackageEntity.class)
    @JoinTable(
            name = "userpackages",
            joinColumns = { @JoinColumn(name = "UserID", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "PackageID", referencedColumnName = "ID") }
    )*/
    private Set<VacationpackageEntity> packages;

    public UserEntity(String name, String hash, String email, Integer type) {
        //this.id = new Random().nextInt();
        this.name = name;
        this.hash = hash;
        this.email = email;
        this.type = type;
    }

    public UserEntity() {

    }

    @Id
    @Basic
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "hash")
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
//    @ElementCollection(targetClass=VacationpackageEntity.class)
    @JoinTable(
            name = "userpackages",
            joinColumns = { @JoinColumn(name = "UserID", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "PackageID", referencedColumnName = "ID") }
    )
    public Set<VacationpackageEntity> getPackages() {
        return packages;
    }

    /*@ManyToMany(cascade = { CascadeType.ALL })
//    @ElementCollection(targetClass=VacationpackageEntity.class)
    @JoinTable(
            name = "userpackages",
            joinColumns = { @JoinColumn(name = "UserID", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "PackageID", referencedColumnName = "ID") }
    )*/
    public void setPackages(Set<VacationpackageEntity> packages) {
        this.packages = packages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (hash != null ? !hash.equals(that.hash) : that.hash != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (hash != null ? hash.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
