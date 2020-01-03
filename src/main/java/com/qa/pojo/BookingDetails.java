package com.qa.pojo;

public class BookingDetails {

	public String firstname;
	public String lastname;
	public int totalprice;
	public boolean depositpaid;
	public String additionalneeds;
	public BookingDates bookingDates;
	
	public BookingDetails() {
		
		
	}

	public BookingDetails(String firstname, String lastname, int totalprice, boolean depositpaid,
			BookingDates bookingDates, String additionalneeds) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.totalprice = totalprice;
		this.depositpaid = depositpaid;
		this.additionalneeds = additionalneeds;
		this.bookingDates = bookingDates;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public boolean isDepositpaid() {
		return depositpaid;
	}

	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}

	public String getAdditionalneeds() {
		return additionalneeds;
	}

	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}

	public BookingDates getBookingDates() {
		return bookingDates;
	}

	public void setBookingDates(BookingDates bookingDates) {
		this.bookingDates = bookingDates;
	}

}
