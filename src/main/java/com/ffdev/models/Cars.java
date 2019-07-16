package com.ffdev.models;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Cars{

    @Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "manufacturer")
	private String manufacturer;
	@Column(name = "model")
	private String model;
    @Column(name = "year")
	private Date year;

	public Cars() {
		super();
	}

	public Cars(Integer id, String manufacturer, String model, Date year) {
		super();
		this.id = id;
		this.manufacturer = manufacturer;
		this.model = model;
		this.year = year;
	}

    public Integer id(){
        return id;
    }
    public void setId (Integer id){
        this.id = id;
    }
    public String manufacturer(){
        return manufacturer;
    }
    public void setManufacturer (String manufacturer){
        this.manufacturer = manufacturer;
    }
    public Date year(){
        return year;
    }
    public void year (Date year){
        this.year = year;
    }

}