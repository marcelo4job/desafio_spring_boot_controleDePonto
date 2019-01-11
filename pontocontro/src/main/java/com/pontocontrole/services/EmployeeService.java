package com.pontocontrole.services;

import com.pontocontrole.domain.Employee;
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

    public Employee findById(Integer id){

        Optional<Employee> obj = employeeRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo" + Employee.class.getName()));

    }

    public Employee insert(Employee obj) {
        obj.setId(null);
        return employeeRepository.save(obj);
    }

    public Employee update(Employee obj) {
        Employee newObj = findById(obj.getId());
        updateData(newObj, obj);
        return employeeRepository.save(newObj);
    }

    private void updateData(Employee newObj, Employee obj){
        newObj.setName(obj.getName());
        newObj.setRole(obj.getRole());
        newObj.setDepartament(obj.getDepartament());
    }

    public void delete(Integer id) {
        findById(id);
        try {
            employeeRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não é possivel excluir um fucionario com registro no banco de horas");
        }

    }
}
