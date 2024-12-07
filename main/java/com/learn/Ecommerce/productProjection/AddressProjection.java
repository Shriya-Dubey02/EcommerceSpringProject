package com.learn.Ecommerce.productProjection;

import org.springframework.beans.factory.annotation.Value;

public interface AddressProjection {
	
	String getCity();
	// @Value("#{target.addressLine1}")
	String getState();
	
	default String getAddress()
	{
		return getCity()+" ,"+getState();
	}

}
