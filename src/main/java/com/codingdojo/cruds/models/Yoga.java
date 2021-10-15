package com.codingdojo.cruds.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="yogas")

public class Yoga {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @NotEmpty
	 @Size(min=3, max=25)
	 private String name;
	 
	
	 @NotEmpty
	 @Size(min=3, max=25)
	 private String week;
	 
	 @NotEmpty
	 @Size(min=3, max=25)
	 private String description;

	@NotNull
	@Min(value=0, message="must be greater than 0")
	@Max(value=15, message="must be less than 16")
	private int price;
	
	
	 
	
	 
	 @Column(updatable=false)
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date createdAt;

	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date updatedAt;
	 
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	public Yoga() {}

	
	

	public Yoga(Date publishedOn) {
		super();
		this.publishedOn = publishedOn;
	}




	public Yoga(@NotEmpty @Size(min = 3, max = 25) String name, @NotEmpty @Size(min = 3, max = 25) String week,
			@NotNull @Size(min = 3, max = 25) String description,
			@NotNull @Min(value = 0, message = "must be") @Max(value = 15, message = "must be ") int price,
			User user) {
		super();
		this.name = name;
		this.week = week;
		this.description = description;
		this.price = price;
		this.user = user;
	}




	public java.util.Date getPublishedOn() {
		return publishedOn;
	}




	public void setPublishedOn(java.util.Date publishedOn) {
		this.publishedOn = publishedOn;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getWeek() {
		return week;
	}




	public void setWeek(String week) {
		this.week = week;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public int getPrice() {
		return price;
	}




	public void setPrice(int price) {
		this.price = price;
	}




	public Date getCreatedAt() {
		return createdAt;
	}




	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}




	public Date getUpdatedAt() {
		return updatedAt;
	}




	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	//and getters removed for brevity
	   @PrePersist
	   protected void onCreate(){
	       this.createdAt = new Date();
	   }
	   @PreUpdate
	   protected void onUpdate(){
	       this.updatedAt = new Date();
	       
	       
	       
	   }
	 
	 


}

	
	
	
	
	
	
	
	
	
	
	
	