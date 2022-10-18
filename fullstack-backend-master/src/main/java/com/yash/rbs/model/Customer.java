package com.yash.rbs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cId;
	private String name;
	private String username;
	private String password;
	private String address;
	private String email;
	@OneToOne
	private Room room;
	
	
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

	private String phone;
	private int noOfAdult;
	private int noOfChildren;
	private int roomNo;
	private String description;

	/*
	 * @ManyToOne private User user;
	 * 
	 * 
	 * @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch =
	 * FetchType.LAZY,mappedBy = "customer") private List<RoomName> rooms=new
	 * ArrayList<>();
	 */
	/*
	 * 
	 * public List<RoomName> getRooms() { return rooms; } public void
	 * setRooms(List<RoomName> rooms) { this.rooms = rooms; }
	 */

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Long cId, String name, String address, String email, String phone, int noOfAdult, int noOfChildren,
			int roomNo, String description) {
		super();
		this.cId = cId;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.noOfAdult = noOfAdult;
		this.noOfChildren = noOfChildren;
		this.roomNo = roomNo;
		this.description = description;

	}

	public Customer(int i, String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * public User getUser() { return user; } public void setUser(User user) {
	 * this.user = user; }
	 */
	public int getNoOfAdult() {
		return noOfAdult;
	}

	public void setNoOfAdult(int noOfAdult) {
		this.noOfAdult = noOfAdult;
	}

	public int getNoOfChildren() {
		return noOfChildren;
	}

	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.cId == ((Customer) obj).getcId();
	}

	/*
	 * @Override public String toString() { return "Customer [cId=" + cId +
	 * ", name=" + name + ", address=" + address + ", email=" + email + ", phone=" +
	 * phone + ", image=" + image + ", description=" + description + ", user=" +
	 * user + "]"; }
	 */

}
