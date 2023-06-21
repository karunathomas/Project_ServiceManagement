package com.qa.utilities;

//import java.util.Date;
import java.util.Locale;
//import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class FakerUtility {

	
	public static String clientName() {
		Faker faker=new Faker();
		String clientname=faker.name().username();
		return clientname;	
	}

	public static String location() {
		Faker faker=new Faker();
		String location=faker.address().latitude();
		return location;	
	}
	public static String postalCode() {
		Faker faker=new Faker();
		String postalcode=faker.address().countryCode();
		return postalcode;	
	}
	public static String cityNam() {
		Faker faker=new Faker();
		String city=faker.address().cityName();
		return city;
	}
	public static String fakeValuesServiceEmail() {
        FakeValuesService fakeValuesService = new FakeValuesService(  new Locale("en-GB"), new RandomService());
        //en-GB => lang
        String email = fakeValuesService.bothify("????##@gmail.com");
        return email;
    }
	public static String address() {
		Faker faker=new Faker();
		String adrs=faker.address().streetAddress();
		return adrs;
	}
	public static String companyName() {
		Faker faker=new Faker();
		String cName=faker.company().name();
		return cName;
	}
//	public static String fakeValuesServiceMobile() {
//        FakeValuesService fakeValuesService = new FakeValuesService(  new Locale("en-GB"), new RandomService());
//         String mobile = fakeValuesService.bothify("##########");
//         return mobile;
//    }
	public static String phoneNum() {
		Faker faker=new Faker();
		String number=faker.phoneNumber().phoneNumber();
		return number;
	}
	public static String vat() {
		Faker faker=new Faker();
		String vatNo=faker.idNumber().ssnValid();
		return vatNo;
	}
	public static String ssn() {
		Faker faker=new Faker();
		String ssnNo=faker.idNumber().ssnValid();
		return ssnNo;
	}
//	public static void  dateFuture() {
//        Faker faker = new Faker();
//        Date dateFuture = faker.date().future(5, TimeUnit.DAYS);
//       
//    }
//    public  static void datePast() {
//        Faker faker = new Faker();
//        Date datePast = faker.date().past(20, TimeUnit.DAYS); 
//    }   
}
