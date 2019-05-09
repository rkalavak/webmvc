package com.kalavakuri.webmvc.business.valueobject;

public class FamilyAddress extends ValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int addressId;
	private String address;

	/**
	 * @return the addressId
	 */
	public int getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId
	 *            the addressId to set
	 */
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
}
