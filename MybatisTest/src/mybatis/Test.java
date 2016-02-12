package mybatis;

import java.util.List;

import mybatis.bean.Customer;
import mybatis.bean.CustomerExample;
import mybatis.config.SessionFactory;
import mybatis.manager.CustomerManager;
import mybatis.mapper.CustomerMapper;

public class Test {

	static CustomerMapper mapper = (CustomerMapper) SessionFactory.getSqlSession().getMapper(CustomerMapper.class);
	
	public static void main(String[] args) {
		List<Customer> customerList1 = CustomerManager.getCustomerListByCustomerFirtName("Emre");
		int customerCount = CustomerManager.getCustomerCount();
		List<Customer> customerList2 = CustomerManager.getCustomerByAge(1990, 2000);
		
		for (Customer customer : customerList1) {
			System.out.println(customer.getName() +" "+ customer.getSurname() +" "+ customer.getBirthYear());
		}
		System.out.println();
		System.out.println("Customer count : "+customerCount);
		System.out.println();
		for (Customer customer : customerList2) {
			System.out.println(customer.getName() +" "+ customer.getSurname() +" "+ customer.getBirthYear());
		}
		
		Customer cust = new Customer();
		cust.setName("Alvarez");
		cust.setSurname("Miguel");
		cust.setBirthYear(1991);
		cust.setCardNo("143214312431");
		CustomerManager.insert(cust);
	}
}
