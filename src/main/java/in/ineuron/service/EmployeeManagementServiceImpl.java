package in.ineuron.service;

import java.util.List;
import java.util.Map;

import in.ineuron.dao.IEmployeeDao;

public class EmployeeManagementServiceImpl implements IEmployeeManagementService {

	private IEmployeeDao dao;
	
	public EmployeeManagementServiceImpl(IEmployeeDao dao) {
		this.dao = dao;
	}

	@Override
	public int fetchEmpsCount() {
		System.out.println("DAO Name:: " + dao.getClass().getName());
		return dao.getEmpsCount();
	}


	@Override
	public String getEmployeeName(int eno) {
		
		return dao.getEmployeeName(eno);
	}

	@Override
	public Map<String, Object> getEmployeeDetailsByNo(int eno) {
		return dao.getEmployeeDetailsByNo(eno);
	}
	
	
	@Override
	public List<Map<String, Object>> getEmployeeDetailsByDesignation(String desg1, String desg2) {
		return dao.getEmployeeDetailsByDesignation(desg1, desg2);
	}
	
	
	@Override
	public int insertEmp(String ename, String eaddress, int esalary, String edesignation) {
		return dao.insertEmp(ename, eaddress, esalary, edesignation);
	}
	
	
	@Override
	public int addBonusToEmpByDesg(String edesignation, int bonus) {
		return dao.addBonusToEmpByDesg(edesignation, bonus);
	}
	
	@Override
	public String toString() {
		return "EmployeeManagementServiceImpl [dao=" + dao + "]";
	}

}
