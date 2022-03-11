package com.assigment1.Razvan.persistence;

import javax.persistence.*;
import javax.print.attribute.standard.Destination;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "vacationpackage", schema = "sdassigment1", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")})
public class VacationpackageEntity {
    private int id;
    private String name;
    private Integer price;
    private String extraDetails;
    private Date startDate;
    private Date endDate;
    private Integer totalSlots;
    private Integer slotsAvailable;
    private DestinationsEntity destination;
    //@ElementCollection(targetClass=UserEntity.class)
    private Set<UserEntity> users;

    @Id
    @Basic
    @Column(name = "ID")
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
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "extra_details")
    public String getExtraDetails() {
        return extraDetails;
    }

    public void setExtraDetails(String extraDetails) {
        this.extraDetails = extraDetails;
    }

    @Basic
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "slots_available")
    public Integer getSlotsAvailable() {
        return slotsAvailable;
    }

    public void setSlotsAvailable(Integer slotsAvailable) {
        this.slotsAvailable = slotsAvailable;
    }

    @Basic
    @Column(name = "total_slots")
    public Integer getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(Integer totalSlots) {
        this.totalSlots = totalSlots;
    }

    @ManyToOne
    @JoinColumn(name = "destination")
    public DestinationsEntity getDestination() {
        return destination;
    }

    public void setDestination(DestinationsEntity destination) {
        this.destination = destination;
    }

    @ManyToMany(mappedBy = "packages")
    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VacationpackageEntity that = (VacationpackageEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (extraDetails != null ? !extraDetails.equals(that.extraDetails) : that.extraDetails != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (slotsAvailable != null ? !slotsAvailable.equals(that.slotsAvailable) : that.slotsAvailable != null)
            return false;
        if (destination != null ? !destination.equals(that.destination) : that.destination != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (extraDetails != null ? extraDetails.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (slotsAvailable != null ? slotsAvailable.hashCode() : 0);
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        return result;
    }
}
