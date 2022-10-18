package com.yash.rbs.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//RoomAPI

@Entity
@Table(name = "ROOMNAME")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	//private String roomType;
	private int maxGuest;
	private int numberOfBeds;
	private int costPerNight;
	private int numberofadults;
	private int numberofchildren;

	
	private Date checkInDate;

	private Date checkOutDate;
	@OneToOne
	private AdminManager adminManager;

	/*
	 * @ManyToOne private Customer customer;
	 * 
	 * 
	 * public Customer getCustomer() { return customer; }
	 * 
	 * public void setCustomer(Customer customer) { this.customer = customer; }
	 */

	public Room() {
		super();
	}

	/*
	 * public RoomName(int id, String roomType, int maxGuest, int numberOfBeds, int
	 * costPerNight, Date checkInDate, Date checkOutDate, int roomNumber,Customer
	 * customer) { super(); this.id = id; this.roomType = roomType; this.maxGuest =
	 * maxGuest; this.numberOfBeds = numberOfBeds; this.costPerNight = costPerNight;
	 * 
	 * this.checkInDate = checkInDate; this.checkOutDate = checkOutDate;
	 * this.customer= customer; //this.roomNumber = roomNumber; }
	 */
	

	public long getId() {
		return id;
	}

	

	

	
	
	public Room(Long id, String name, String email, int numberOfBeds,
			int numberofadults, int numberofchildren, int checkInDate, int checkOutDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		//this.roomType = roomType;
		//this.maxGuest = maxGuest;
		this.numberOfBeds = numberOfBeds;
		this.numberofadults = numberofadults;
		this.numberofchildren = numberofchildren;
		this.checkInDate = new Date(checkInDate);
		this.checkOutDate = new Date(checkOutDate);
		System.out.println(checkInDate);
		System.out.println(checkOutDate);
	}
	
	
	

	public int getNumberofadults() {
		return numberofadults;
	}

	public void setNumberofadults(int numberofadults) {
		this.numberofadults = numberofadults;
	}

	public int getNumberofchildren() {
		return numberofchildren;
	}

	public void setNumberofchildren(int numberofchildren) {
		this.numberofchildren = numberofchildren;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	public String getRoomType() {
//		return roomType;
//	}
//
//	public void setRoomType(String roomType) {
//		this.roomType = roomType;
//	}

	public int getMaxGuest() {
		return maxGuest;
	}

	public void setMaxGuest(int maxGuest) {
		this.maxGuest = maxGuest;
	}

	public int getNumberOfBeds() {
		return numberOfBeds;
	}

	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}


	public void setCostPerNight(int costPerNight) {
		this.costPerNight = costPerNight;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	@Override
	public String toString() {
		return "RoomName [id=" + id + ", maxGuest=" + maxGuest + ", numberOfBeds="
				+ numberOfBeds + ", costPerNight=" + costPerNight + ", checkInDate=" + checkInDate + ", checkOutDate="
				+ checkOutDate + /* ", roomNumber=" + roomNumber + */ "]";
	}

}