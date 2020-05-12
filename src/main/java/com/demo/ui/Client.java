package com.demo.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

public class Client {
	public static void main(String[] args) {
		RestTemplate rt = new RestTemplate();

		//Display particular product by product ID
		String geturl = "http://localhost:8888/api/products/2";
		ProductDto dto = rt.getForObject(geturl, ProductDto.class);
		System.out.println(dto.getProdName());
		System.out.println(dto.getPrice());
		System.out.println(dto.getProdId());

		//Insert product
		String posturl = "http://localhost:8888/api/products";
		ProductDto productDto = new ProductDto();
		// productDto.setProdId(3);
		productDto.setProdName("Samsung");
		productDto.setPrice(3000.00);
		rt.postForEntity(posturl, productDto, ProductDto.class);
		
		//Display all products
		String getAllURL = "http://localhost:8888/api/products";
		List<Map> ls = rt.getForObject(getAllURL, ArrayList.class);
		for (Map map : ls) {
			for(Object o: map.values()) {
				System.out.println(o);
			}
			
		}
	}
}
