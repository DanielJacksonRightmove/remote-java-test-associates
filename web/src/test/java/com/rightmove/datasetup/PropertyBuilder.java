package com.rightmove.datasetup;

import com.rightmove.property.dto.Property;

public class PropertyBuilder {

	private long id;
	private long price;
	private int bedrooms;
	private Integer bathrooms;
	private String number;
	private String address;
	private String region;
	private String postcode;

	private PropertyBuilder() {

	}

	public static PropertyBuilder aDefaultPropertyEntity(long id) {
		return new PropertyBuilder()
				.id(id)
				.price(1_000_000L)
				.bedrooms(2)
				.bathrooms(1)
				.number("33")
				.address("Soho Square")
				.region("Soho")
				.postcode("E2  8RS");
	}

	public PropertyBuilder id(long id) {
		this.id = id;
		return this;
	}

	public PropertyBuilder price(long price) {
		this.price = price;
		return this;
	}

	public PropertyBuilder bedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
		return this;
	}

	public PropertyBuilder bathrooms(Integer bathrooms) {
		this.bathrooms = bathrooms;
		return this;
	}

	public PropertyBuilder number(String number) {
		this.number = number;
		return this;
	}

	public PropertyBuilder address(String address) {
		this.address = address;
		return this;
	}

	public PropertyBuilder region(String region) {
		this.region = region;
		return this;
	}

	public PropertyBuilder postcode(String postcode) {
		this.postcode = postcode;
		return this;
	}

	public Property build() {
		return new Property(id, price, bedrooms, bathrooms, number, address, region, postcode);
	}
}