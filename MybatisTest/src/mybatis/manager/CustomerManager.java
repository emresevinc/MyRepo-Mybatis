package mybatis.manager;

import java.util.List;

import mybatis.bean.Customer;
import mybatis.bean.CustomerExample;
import mybatis.config.SessionFactory;
import mybatis.mapper.CustomerMapper;

public class CustomerManager {

	private static CustomerMapper getMapper(){
		return (CustomerMapper) SessionFactory.getSession(CustomerMapper.class);
	}
	
	public static List<Customer> getCustomerListByCustomerFirtName(String firstName){
		CustomerExample example = new CustomerExample();// Sorgular her zaman example nesnesi üzerinden yapýlýr.
		CustomerExample.Criteria criteria = example.createCriteria();// Example'a ait kriter belirtmek için kriter
																	//oluþturuyoruz.
		criteria.andNameEqualTo(firstName); // Kriter olarak firstName alaný belirleniyor
		return getMapper().selectByExample(example);
	}
	
	public static int getCustomerCount(){
		CustomerExample example = new CustomerExample();
		return getMapper().countByExample(example); //Customer kayýt sayýsýný verir.
	}
	
	public static List<Customer> getCustomerByAge(int birthYear1,int birthYear2){
		CustomerExample example = new CustomerExample();
		CustomerExample.Criteria criteria = example.createCriteria();
		criteria.andBirthYearBetween(birthYear1, birthYear2);// Belirtilen aralýktaki kayýtlar alýnýyor.
		example.setOrderByClause("BIRTH_YEAR DESC"); // Kayýtlar, doðum yýlýna göre ASC veya DESC þeklinde sýralanýyor.
		return getMapper().selectByExample(example);
	}
	
	public static void insert(Customer customer){
		getMapper().insert(customer);
		System.out.println("Bir kayit basari ile eklendi.");
	}
}
