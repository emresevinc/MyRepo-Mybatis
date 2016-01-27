package mybatis;

import java.util.List;

import mybatis.bean.Customer;
import mybatis.bean.CustomerExample;
import mybatis.config.SessionFactory;
import mybatis.mapper.CustomerMapper;

public class Test {

	static CustomerMapper mapper = (CustomerMapper) SessionFactory.getSqlSession().getMapper(CustomerMapper.class);
	
	public static void main(String[] args) {
		CustomerExample example = new CustomerExample();
		List<Customer> customerList = mapper.selectByExample(example);
		
		for (Customer customer : customerList) {
			System.out.println(customer.getName()+" "+customer.getSurname()+" "+customer.getBirthYear()+" "+customer.getCardNo());
		}
	}
}
