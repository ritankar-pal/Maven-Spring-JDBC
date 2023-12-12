package in.ineuron;
import java.util.List;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import in.ineuron.service.EmployeeManagementServiceImpl;
import in.ineuron.service.IEmployeeManagementService;


public class JdbcTestApp 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
    	
    	IEmployeeManagementService service = context.getBean(EmployeeManagementServiceImpl.class, "service");
    	System.out.println(service);
    	
    	//select query: fetching count(int)
    	int count = service.fetchEmpsCount();
    	System.out.println();
    	System.out.println("Total number of employees are:: " + count);
    	
    	//select query:: fetching single data (employee name)
    	String employeeName = service.getEmployeeName(4);
    	System.out.println("Employee Name is:: " + employeeName);
    	
    	//select query:: fetching single object as per id
    	Map<String, Object> employeeDetailsByNo = service.getEmployeeDetailsByNo(1);
    	System.out.println("The Employee Details are as follows: " + employeeDetailsByNo);
    	
    	//select query:: fetching multiple object as per condition given::
    	System.out.println();
    	List<Map<String, Object>> employeeDetailsByDesignation = service.getEmployeeDetailsByDesignation("developer", "ba");
    	employeeDetailsByDesignation.forEach(System.out::println);
    	
    	
    	//insert Query::
//    	int rowAffected = service.insertEmp("Raunak", "Kolkata", 40000, "analyst");
//    	System.out.println("Row Affected is: " + rowAffected);
    	
    	//update Query::
    	int update = service.addBonusToEmpByDesg("ba", 5000);
    	System.out.println("Row Affected is: " + update);
    	
    	((ConfigurableApplicationContext) context).close();
    	
    }
}
