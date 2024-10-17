package com.hexaware.couriermanagement.entity;

import java.sql.Date;
import java.time.LocalDate;

public class Courier {

	 
	private static int trackingNumberGenerator = 1000;
    private int courierID;
    private String senderName;
    private String senderAddress;
    private String receiverName;
    private String receiverAddress;
    private double weight;
    private String status;
    private int trackingNumber;
    private Date deliveryDate;
    private int userID;
    private int employeeID;
    
	public Courier() {
		super();
	}

	public Courier(int courierID, String senderName, String senderAddress, String receiverName, String receiverAddress,
			double weight, String status, int trackingNumber, Date deliveryDate, int userID, int employeeID ) {
		super();
		this.courierID = courierID;
		this.senderName = senderName;
		this.senderAddress = senderAddress;
		this.receiverName = receiverName;
		this.receiverAddress = receiverAddress;
		this.weight = weight;
		this.status = status;
		this.trackingNumber = trackingNumberGenerator++;
		this.deliveryDate = Date.valueOf(LocalDate.now().plusDays(3));
		this.userID = userID;
		this.employeeID = employeeID;
	}

	public int getCourierID() {
		return courierID;
	}

	public void setCourierID(int courierID) {
		this.courierID = courierID;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber() {
		this.trackingNumber = trackingNumberGenerator++;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	 

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	@Override
	public String toString() {
		return "Courier [courierID=" + courierID + ", senderName=" + senderName + ", senderAddress=" + senderAddress
				+ ", receiverName=" + receiverName + ", receiverAddress=" + receiverAddress + ", weight=" + weight
				+ ", status=" + status + ", trackingNumber=" + trackingNumber + ", deliveryDate=" + deliveryDate
				+ ", userID=" + userID + ", employeeID=" + employeeID + "]";
	}


	
    
    
    
}
