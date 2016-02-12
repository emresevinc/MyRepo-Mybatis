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
		CustomerExample example = new CustomerExample();// Sorgular her zaman example nesnesi �zerinden yap�l�r.
		CustomerExample.Criteria criteria = example.createCriteria();// Example'a ait kriter belirtmek i�in kriter
																	//olu�turuyoruz.
		criteria.andNameEqualTo(firstName); // Kriter olarak firstName alan� belirleniyor
		return getMapper().selectByExample(example);
	}
	
	public static int getCustomerCount(){
		CustomerExample example = new CustomerExample();
		return getMapper().countByExample(example); //Customer kay�t say�s�n� verir.
	}
	
	public static List<Customer> getCustomerByAge(int birthYear1,int birthYear2){
		CustomerExample example = new CustomerExample();
		CustomerExample.Criteria criteria = example.createCriteria();
		criteria.andBirthYearBetween(birthYear1, birthYear2);// Belirtilen aral�ktaki kay�tlar al�n�yor.
		example.setOrderByClause("BIRTH_YEAR DESC"); // Kay�tlar, do�um y�l�na g�re ASC veya DESC �eklinde s�ralan�yor.
		return getMapper().selectByExample(example);
	}
	
	public static void insert(Customer customer){
		getMapper().insert(customer);
		System.out.println("Bir kayit basari ile eklendi.");
	}
}
