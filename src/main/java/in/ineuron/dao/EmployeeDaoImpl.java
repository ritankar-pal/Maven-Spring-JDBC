package in.ineuron.dao;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;


public class EmployeeDaoImpl implements IEmployeeDao {

	private static String SQL_SELECT_QUERY = "select count(*) from employees";
	private static String SQL_SELECT_NAME = "select ename from employees where eid = ?";
	private static String GET_EMP_BY_NO = "select eid, ename, eaddress, esalary, edesignation from employees where eid = ?";
	private static String GET_EMP_BY_DESG = "select eid, ename, eaddress, esalary, edesignation from employees where edesignation "
			+ "in (?,?) order by esalary";
	private static String INSERT_EMP_DETAILS = "insert into employees (ename, eaddress, esalary, edesignation) values(?,?,?,?)";
	private static String UPDATE_EMP_SAL = "update employees set esalary = esalary + ? where edesignation = ?";
	
	
	private JdbcTemplate jdbcTemplate;

	public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int getEmpsCount() {
		System.out.println("JDBC Template:: " + jdbcTemplate.getClass().getName());
		
		Integer count = jdbcTemplate.queryForObject(SQL_SELECT_QUERY, Integer.class);
		
		return count;
	}

	@Override
	public String getEmployeeName(int eno) {
		
		return jdbcTemplate.queryForObject(SQL_SELECT_NAME, String.class, eno);
	}
	
	@Override
	public Map<String, Object> getEmployeeDetailsByNo(int eno) {

		Map<String, Object> map = jdbcTemplate.queryForMap(GET_EMP_BY_NO, eno);
		return map;
	}
	
	@Override
	public List<Map<String, Object>> getEmployeeDetailsByDesignation(String desg1, String desg2) {
		
		List<Map<String, Object>> listMap = jdbcTemplate.queryForList(GET_EMP_BY_DESG, desg1, desg2);

		return listMap;
	}
	
	@Override
	public int insertEmp(String ename, String eaddress, int esalary, String edesignation) {
		return jdbcTemplate.update(INSERT_EMP_DETAILS, ename, eaddress, esalary, edesignation);
	}
	
	@Override
	public int addBonusToEmpByDesg(String edesignation, int bonus) {
		return jdbcTemplate.update(UPDATE_EMP_SAL, bonus, edesignation);
	}
	
	@Override
	public String toString() {
		return "EmployeeDaoImpl [jdbcTemplate=" + jdbcTemplate + "]";
	}

}
