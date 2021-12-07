package org.zerock.mapper.p05mapper;


import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	@Select("SELECT NOW()")
	public String getTime();
	
	@Select("SELECT CustomerName FROM Customers WHERE CustomerID = 1")
	public String getCustomerName();
	
	@Select("SELECT LastName FROM Employees WHERE EmployeeID = 1")
	public String getLastName();
	
	@Select("SELECT CustomerName FROM Customers WHERE CustomerID = #{id}")
	public String getCustomerNameByID(Integer id);
	
	@Select("SELECT LastName FROM Employees WHERE EmployeeID = #{id}")
	public String getLastNameByID(Integer id);
	
	@Select("SELECT CustomerName FROM Customers")
	public List<String> getCustomerNames();
	
	// 직원 테이블의 LastName 들을 조회하는 쿼리를 실행하는 메소드(getLastNames) 작성
	@Select("SELECT LastName FROM Employees")
	public List<String> getLastNames();
}
