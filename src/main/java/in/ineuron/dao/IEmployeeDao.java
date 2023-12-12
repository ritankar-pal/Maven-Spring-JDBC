package in.ineuron.dao;
import java.util.List;
import java.util.Map;


public interface IEmployeeDao {
	
	public int getEmpsCount();
	public String getEmployeeName(int eno);
	public Map<String, Object> getEmployeeDetailsByNo(int eno);
	public List<Map<String, Object>> getEmployeeDetailsByDesignation(String desg1, String desg2);
	public int insertEmp(String ename, String eaddress, int esalary, String edesignation);
	public int addBonusToEmpByDesg(String edesignation, int bonus);
}
