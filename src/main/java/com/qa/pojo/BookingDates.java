package com.qa.pojo;

public class BookingDates {

	public String checkin;
	public String checkout;
	
	
	public BookingDates() {
		
		
	}

	public BookingDates(String checkin, String checkout) {

		this.checkin = checkin;
		this.checkout = checkout;
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

}
