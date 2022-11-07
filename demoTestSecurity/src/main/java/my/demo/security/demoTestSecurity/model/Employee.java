package my.demo.security.demoTestSecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data  //анотация, которая генрирует геттеры и сетеры
@AllArgsConstructor //генерирует все конструкторы
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private Integer salary;
}
