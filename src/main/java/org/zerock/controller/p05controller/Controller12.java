package org.zerock.controller.p05controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.controller.p05controller.bean.Bean17;
import org.zerock.controller.p05controller.bean.Bean18;
import org.zerock.mapper.p05mapper.Mapper03;

import lombok.Setter;

@Controller
@RequestMapping("/cont12")
public class Controller12 {
	
	@Setter(onMethod_ = @Autowired)
	private Mapper03 mapper;
	
	@RequestMapping("/met01")
	public void method01() {
		String customerName = "ironman";
		String contactName = "tony";
		
		int cnt = mapper.isertCustomer(customerName, contactName);
		System.out.println(cnt);
	}

	@RequestMapping("/met02")
	public void method02() {
		String supplierName = "captain";
		String contactName = "steve";
		
		int cnt = mapper.insertSupplier(supplierName, contactName);
		System.out.println(cnt);
	}
	
	@RequestMapping("/met03")
	public void method03() {
		// 2. request 가공 분석
		Bean17 bean = new Bean17();
		bean.setContactName("peter");
		bean.setCustomerName("spiderman");
		bean.setAddress("queens");
		bean.setCity("ny");
		bean.setPostalCode("2222");
		bean.setCountry("usa");
		
		// 3. business logic
		mapper.insertCustomer2(bean);
	}
	
	@RequestMapping("/met04")
	public void method04() {
		// 2. bean 작성(bean18)
		Bean18 bean = new Bean18();
		bean.setSupplierName("hulk");
		bean.setContactName("beno");
		bean.setAddress("washongton");
		bean.setCity("ny");
		bean.setPostalCode("33333");
		bean.setCountry("usa");
		bean.setPhone("01023456789");
		
		// 3. mapper 작성
		mapper.insertSupplier2(bean);
	}
	
	@RequestMapping("/met05")
	public void method05() {
		// 2. request 가공 분석
		Bean17 bean = new Bean17();
		bean.setContactName("marvle");
		bean.setCustomerName("danvers");
		bean.setAddress("gangnam");
		bean.setCity("seoul");
		bean.setPostalCode("99999");
		bean.setCountry("france");
		
		// 3. business logic
		// insert 하기전 id
		System.out.println(bean.getId()); // null or 0
		
		mapper.insertCustomer3(bean);
		
		System.out.println(bean.getId()); // key
	}
	
	@RequestMapping("/met06")
	public void method06() {
		Bean18 bean = new Bean18();
		bean.setAddress("yeoksam");
		bean.setCity("incheon");
		bean.setContactName("deadpool");
		bean.setSupplierName("wade");
		bean.setCountry("uk");
		bean.setPostalCode("33333");
		bean.setPhone("1111");
		
		// 3.
		System.out.println(bean.getSupplierID());
		mapper.insertSupplier3(bean);
		System.out.println(bean.getSupplierID());
	}
	
	@RequestMapping("/met07")
	public void method07() {
		// 2. 
		Bean17 bean = new Bean17();
		bean.setId(110);
		bean.setContactName("widow");
		bean.setCustomerName("nat");
		bean.setAddress("jongro");
		bean.setCity("dokdo");
		bean.setCountry("korea");
		bean.setPostalCode("77777");
		
		// 3.
		int cnt = mapper.updateCustomer(bean);
		System.out.println(cnt);
	}
	
	@RequestMapping("/met08")
	public void method08() {
		Bean18 bean = new Bean18();
		bean.setSupplierID(38);
		bean.setContactName("halkeye");
		bean.setSupplierName("edan");
		bean.setAddress("guro");
		bean.setCity("seoul");
		bean.setPhone("11111");
		bean.setPostalCode("55555");
		
		int cnt = mapper.updateSupplier(bean);
		System.out.println(cnt);
	}
	
	@RequestMapping("/met09")
	public void method09(Integer id) {
		int cnt = mapper.deleteCustomer(id);
	}
	
	@RequestMapping("/met10")
	public void method10(Integer supplierID) {
		int cnt = mapper.deleteSupplier(supplierID);
	}
	
	
	
	
	
}
