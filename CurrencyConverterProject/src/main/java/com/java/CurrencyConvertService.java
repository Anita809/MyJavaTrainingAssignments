package com.java;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//nouns vs verbs

//Resource URI

//http://localhost:8080/CurrencyConverterProject/rest/conversion/myconvert
	
@Path("/conversion")
public class CurrencyConvertService {
	
	static ArrayList<Currency> allCurrencies = new ArrayList<Currency>();
	
	static {
		System.out.println("static initializer ...setting up all values...");
		
		Currency currency1 = new Currency();
		currency1.setCurrencyId(1);
		currency1.setSourceCurrency("USD");	
		currency1.setTargetCurrency("INR");
		currency1.setAmountToConvert(6000);
		
		Currency currency2 = new Currency();
		currency2.setCurrencyId(2);
		currency2.setSourceCurrency("EUR");	
		currency2.setTargetCurrency("INR");
		currency2.setAmountToConvert(5000);
		
		Currency currency3 = new Currency();
		currency3.setCurrencyId(3);
		currency3.setSourceCurrency("NEP");	
		currency3.setTargetCurrency("INR");
		currency3.setAmountToConvert(4000);

		
		Currency currency4 = new Currency();
		currency4.setCurrencyId(4);
		currency4.setSourceCurrency("ANZ");	
		currency4.setTargetCurrency("INR");
		currency4.setAmountToConvert(7000);

		
		Currency currency5 = new Currency();
		currency5.setCurrencyId(5);
		currency5.setSourceCurrency("GER");	
		currency5.setTargetCurrency("INR");
		currency5.setAmountToConvert(9000);

		
		allCurrencies.add(currency1);  
		allCurrencies.add(currency2);
		allCurrencies.add(currency3);
		allCurrencies.add(currency4);
		allCurrencies.add(currency5);
		
	}
	
	
//	http://localhost:8080/CurrencyConverterProject/rest/conversion/myconvert
	@GET
	@Path("/myconvert")
	@Produces(MediaType.APPLICATION_JSON)
	public Currency convert() {
		
		System.out.println("convert....");
		Currency currency = new Currency();
		currency.setSourceCurrency("USD");
		currency.setTargetCurrency("INR");
		currency.setAmountToConvert(6000);
		
		return currency;
	}

// http://localhost:8080/CurrencyConverterProject/rest/conversion/allconverts
	@GET 
	@Path("/getCurrencies")	
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Currency> getAllCurrencies() {
		System.out.println("getAllCurrencies....");
		return allCurrencies;
	}
	
	//  http://localhost:8080/CurrencyConverterProject/rest/conversion/getCurrency/1
		@GET 
		@Path("/getCurrency/{cid}")	
		@Produces(MediaType.APPLICATION_JSON)
		public Currency getCurrency(@PathParam("cid") int tempCid) {
			System.out.println("getCurrency...."+tempCid);
			Currency tempCurrency = null;
			for(Currency theCurrency  : allCurrencies) {
				if(theCurrency.getCurrencyId() == tempCid) {
					tempCurrency = theCurrency;
					break;
				}
			}
			return tempCurrency;
		}
		
	//  http://localhost:8080/CurrencyConverterProject/rest/conversion/deleteCurrency/1
			@GET 
			@Path("/deleteCurrency/{cid}")	
			@Produces(MediaType.APPLICATION_JSON)
			public void removeCurrency(@PathParam("cid") int tempCid) {
				System.out.println("deleteCurrency...."+tempCid);		
				for(int i=0;i<allCurrencies.size();i++) {
					Currency currency = allCurrencies.get(i);
					
					if(currency.getCurrencyId() == tempCid) {
						currency  = allCurrencies.get(i);
						allCurrencies.remove(i);
						System.out.println("currency removed...");
						break;
					}
				}
			}
			
			@POST 
			@Path("/addCurrency")	
			@Produces(MediaType.APPLICATION_JSON)
			public Response addCurrency(Currency newCurrency) {
				System.out.println("adding currency....");
				allCurrencies.add(newCurrency);
				return Response.status(201).build();
	
}
			
			@PUT 
			@Path("/updateCurrency")	
			@Produces(MediaType.APPLICATION_JSON)
			public void modifyCurrency(Currency currencyToModify) {
				System.out.println("modifying currency...."+currencyToModify);		
				for(int i=0;i<allCurrencies.size();i++) {
					Currency currency = allCurrencies.get(i);
					System.out.println("currency to modify is...."+currencyToModify);	
					
					
					
					if(currency.getCurrencyId() == currencyToModify.getCurrencyId()) {
					    allCurrencies.remove(currency);
						allCurrencies.add(i, currencyToModify);
						System.out.println("currency  is modified...");
						break;
					}
				}
			}
			

	
}


/*
 
	org.glassfish.jersey.servlet.ServletContainer <-- life cycle of all the objects
													request / response management
													
					web.xml
					|
			------------------
			|				|
		servlet-name		servlet-mapping
								|
							/rest/*
																
 <--------------welcome file index.html------->|    <----com.java-------->
 http://localhost:8080/CurrencyConverterProject/rest/conversion/myconvert
 http://localhost:8080/CurrencyConverterProject/rest/conversion/allconverts
 													 |        |	
												   CurrencyConvertService
														|
										------------------------------
										|			|			|
										myconvert	allconverts
										|				|
									convert() { }	convertAll()
*/