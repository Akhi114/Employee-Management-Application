package com.EmployeeManagement.App.EMP.Controller;

import com.EmployeeManagement.App.EMP.Entity.Employee;
import com.EmployeeManagement.App.EMP.Repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public String viewEmployees(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "index";  // Resolves to index.html
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add_employee";
    }

    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee,
                               BindingResult result,
                               Model model) {
        if(result.hasErrors()) {
            return "add_employee";
        }
        try {
        employeeRepository.save(employee);
        return "redirect:/";
        } catch (DataIntegrityViolationException ex) {
            model.addAttribute("errorMessage", "Email already exists. Please use a different email.");
            return "add_employee";
        }
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id, @Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
        if(result.hasErrors()){
            return "update_employee";
        }
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employeeRepository.delete(employee);
        return "redirect:/employees";
    }
}
