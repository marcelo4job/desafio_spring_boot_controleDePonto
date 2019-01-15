package com.pontocontrole.services;

import com.pontocontrole.domain.Employee;
import com.pontocontrole.domain.RecordTime;
import com.pontocontrole.domain.enums.DayOfWeekEnum;
import com.pontocontrole.dto.EmployeeDTO;
import com.pontocontrole.dto.EmployeeNewDTO;
import com.pontocontrole.repositories.EmployeeRepository;
import com.pontocontrole.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee find(Integer id){

        Optional<Employee> obj = employeeRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo" + Employee.class.getName()));

    }

    public Employee insert(Employee obj) {
        obj.setId(null);
        return employeeRepository.save(obj);
    }

    public Employee update(Employee obj) {
        Employee newObj = find(obj.getId());
        updateData(newObj, obj);
        return employeeRepository.save(newObj);
    }

    private void updateData(Employee newObj, Employee obj){
        newObj.setName(obj.getName());
        newObj.setRole(obj.getRole());
        newObj.setDepartament(obj.getDepartament());
    }

    public void delete(Integer id) {
        find(id);
        try {
            employeeRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não é possivel excluir um fucionario com registro no banco de horas");
        }

    }

    public Employee fromDTO(EmployeeDTO objDTO){
        return new Employee(null, objDTO.getName(), objDTO.getRegistry(), objDTO.getRole(), objDTO.getDepartament());

    }

    public Employee fromDTO(EmployeeNewDTO objDTO){
        Employee employee = new Employee(null, objDTO.getName(), objDTO.getRegistry(), objDTO.getRole(), objDTO.getDepartament());
        RecordTime recordTime = new RecordTime(null, null,null, DayOfWeekEnum.toEnum(objDTO.getDayOfWeek()), objDTO.getEmployee());
        employee.getRecords().add(recordTime);
        return employee;
    }


}
