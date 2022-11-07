package my.demo.security.demoTestSecurity.controllers;

import my.demo.security.demoTestSecurity.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("rest/v1/men")
public class EmployeeController {
    //получаем коллекцию сотрудников
    private List<Employee> men = Stream.of(
            new Employee(1L, "Ivan", "Ivanov", "programmer", 2000),
            new Employee(2L, "Petr", "Petrov", "programmer", 20000),
            new Employee(3L, "Ann", "Annova", "programmer", 25000),
            new Employee(4L, "Yura", "Yurov", "programmer", 26000)
    ).collect(Collectors.toList());

    @GetMapping
    //получаем всех сотрудников
    public List<Employee> getMen() {
        return men;
    }

    //получаем элемент по ид
    @GetMapping("/{id}")
    public Employee getByID(@PathVariable Long id) {
        return men.stream().filter(man -> man.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


    //создаем сотрудника
    @PostMapping
    public Employee create(@RequestBody Employee man) {
        men.add(man);
        return man;
    }

    //удаляем сотрудника
    @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable Long id) {
        men.removeIf(man -> man.getId().equals(id));
    }
}
