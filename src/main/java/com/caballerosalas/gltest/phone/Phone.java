package com.caballerosalas.gltest.phone;

import com.caballerosalas.gltest.gluser.GLUser;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class Phone {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    @ColumnDefault("random_uuid()")
    @Type(type = "uuid-char")
    private UUID id;
    private long number;
    private int citycode;
    private String countrycode;

    @ManyToOne
    @JoinColumn(name="userId")
    private GLUser user;

    public Phone() {

    }

    public Phone(UUID id, long number, int citycode, String countrycode) {
        this.id = id;
        this.number = number;
        this.citycode = citycode;
        this.countrycode = countrycode;
    }

    public Phone(long number, int citycode, String countrycode, GLUser user) {
        this.number = number;
        this.citycode = citycode;
        this.countrycode = countrycode;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getCitycode() {
        return citycode;
    }

    public void setCitycode(int citycode) {
        this.citycode = citycode;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public GLUser getUser() {
        return user;
    }

    public void setUser(GLUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", number=" + number +
                ", citycode='" + citycode + '\'' +
                ", countrycode='" + countrycode + '\'' +
//                ", User Id='" + user.getId().toString() + '\'' +
                '}';
    }
}


