package mybatis.mapper;

import java.util.List;
import mybatis.bean.Customer;
import mybatis.bean.CustomerExample;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CUSTOMER
     *
     * @mbggenerated Mon Jan 25 20:09:24 EET 2016
     */
    int countByExample(CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CUSTOMER
     *
     * @mbggenerated Mon Jan 25 20:09:24 EET 2016
     */
    int deleteByExample(CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CUSTOMER
     *
     * @mbggenerated Mon Jan 25 20:09:24 EET 2016
     */
    @Insert({
        "insert into CUSTOMER (NAME, SURNAME, ",
        "BIRTH_YEAR, CARD_NO, ",
        "STATUS)",
        "values (#{name,jdbcType=VARCHAR}, #{surname,jdbcType=VARCHAR}, ",
        "#{birthYear,jdbcType=INTEGER}, #{cardNo,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=CHAR})"
    })
    int insert(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CUSTOMER
     *
     * @mbggenerated Mon Jan 25 20:09:24 EET 2016
     */
    int insertSelective(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CUSTOMER
     *
     * @mbggenerated Mon Jan 25 20:09:24 EET 2016
     */
    List<Customer> selectByExample(CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CUSTOMER
     *
     * @mbggenerated Mon Jan 25 20:09:24 EET 2016
     */
    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CUSTOMER
     *
     * @mbggenerated Mon Jan 25 20:09:24 EET 2016
     */
    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);
}