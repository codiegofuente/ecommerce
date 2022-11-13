package com.app.ecommerce;

import com.app.ecommerce.controller.EcommerceC;
import com.app.ecommerce.repository.PricesRInterface;
import com.app.ecommerce.service.EcommerceS;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static com.app.ecommerce.TestTools.exResult;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {EcommerceC.class, EcommerceS.class, EcommerceApplication.class,
		EcommerceApplication.class})
class EcommerceApplicationTests {

	@Autowired
	EcommerceC ecommerceC;

	@Autowired
	EcommerceS ecommerceS;

	@Autowired
	PricesRInterface pricesRepository;

	private ZonedDateTime date;
	private Long productId;
	private Long brandId;

	@BeforeEach
	public void initTests() {
		productId = 35455L;
		brandId = 1L;
	}

	@Test
	@DisplayName("Test 1 - Date: 2020-06-14 10:00, ProductId: 35455, BrandId: 1")
	public void ecommerceCTest1() {
		date = ZonedDateTime.of(
				2020, 6, 14, 10, 0, 0, 0, ZoneId.systemDefault());

		ZonedDateTime startDate = ZonedDateTime.of(
				2020, 6, 14, 0, 0, 0, 0, ZoneId.systemDefault());
		ZonedDateTime endDate = ZonedDateTime.of(
				2020, 12, 31, 23, 59, 59, 0,
				ZoneId.systemDefault());

		Float price = new BigDecimal("35.50").floatValue();
		String expectedProduct = exResult(1L, startDate, endDate, 1L,35455L, price, "EUR");

		ResponseEntity<String> product = ecommerceC.getProductInfo(date, productId, brandId);
		assertEquals(product.getBody(), expectedProduct);
	}

	@Test
	@DisplayName("Test 2 - Date: 2020-06-14 16:00, ProductId: 35455, BrandId: 1")
	public void ecommerceCTest2() {
		date = ZonedDateTime.of(
				2020, 6, 14, 16, 0, 0, 0, ZoneId.systemDefault());

		ZonedDateTime startDate = ZonedDateTime.of(
				2020, 6, 14, 15, 0, 0, 0, ZoneId.systemDefault());
		ZonedDateTime endDate = ZonedDateTime.of(
				2020, 6, 14, 18, 30, 0, 0, ZoneId.systemDefault());

		Float price = new BigDecimal("25.45").floatValue();
		String expectedProduct = exResult(1L, startDate, endDate, 2L, 35455L, price, "EUR");

		ResponseEntity<String> product = ecommerceC.getProductInfo(date, productId, brandId);
		assertEquals(product.getBody(), expectedProduct);
	}

	@Test
	@DisplayName("Test 3 - Date: 2020-06-14 21:00, ProductId: 35455, BrandId: 1")
	public void ecommerceCTest3() {
		date = ZonedDateTime.of(
				2020, 6, 14, 21, 0, 0, 0, ZoneId.systemDefault());

		ZonedDateTime startDate = ZonedDateTime.of(
				2020, 6, 14, 0, 0, 0, 0, ZoneId.systemDefault());
		ZonedDateTime endDate = ZonedDateTime.of(
				2020, 12, 31, 23, 59, 59, 0,
				ZoneId.systemDefault());

		Float price = new BigDecimal("35.50").floatValue();
		String expectedProduct = exResult(1L, startDate, endDate, 1L,35455L, price,
				"EUR");

		ResponseEntity<String> product = ecommerceC.getProductInfo(date, productId, brandId);
		assertEquals(product.getBody(), expectedProduct);
	}

	@Test
	@DisplayName("Test 4 - Date: 2020-06-15 10:00, ProductId: 35455, BrandId: 1")
	public void ecommerceCTest4() {
		date = ZonedDateTime.of(
				2020, 6, 15, 10, 0, 0, 0, ZoneId.systemDefault());

		ZonedDateTime startDate = ZonedDateTime.of(
				2020, 6, 15, 0, 0, 0, 0, ZoneId.systemDefault());
		ZonedDateTime endDate = ZonedDateTime.of(
				2020, 6, 15, 11, 0, 0, 0, ZoneId.systemDefault());

		Float price = new BigDecimal("30.50").floatValue();
		String expectedProduct = exResult(1L, startDate, endDate, 3L, 35455L, price,
				"EUR");

		ResponseEntity<String> product = ecommerceC.getProductInfo(date, productId, brandId);
		assertEquals(product.getBody(), expectedProduct);
	}

	@Test
	@DisplayName("Test 5 - Date: 2020-06-16 21:00, ProductId: 35455, BrandId: 1")
	public void ecommerceCTest5() {
		date = ZonedDateTime.of(
				2020, 6, 15, 21, 0, 0, 0, ZoneId.systemDefault());

		ZonedDateTime startDate = ZonedDateTime.of(
				2020, 6, 15, 16, 0, 0, 0, ZoneId.systemDefault());
		ZonedDateTime endDate = ZonedDateTime.of(
				2020, 12, 31, 23, 59, 59, 0,
				ZoneId.systemDefault());

		Float price = new BigDecimal("38.95").floatValue();
		String expectedProduct = exResult(1L, startDate, endDate, 4L,35455L, price,
				"EUR");

		ResponseEntity<String> product = ecommerceC.getProductInfo(date, productId, brandId);
		assertEquals(product.getBody(), expectedProduct);
	}
}
