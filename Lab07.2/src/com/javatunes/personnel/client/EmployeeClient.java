package com.javatunes.personnel.client;

import com.fastjava.annotation.Fast;
import com.javatunes.personnel.Employee;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Arrays;

public class EmployeeClient {

  public static void main(String[] args) {
    Employee employee = new Employee();
    employee.work();
    employee.pay();

    Class<? extends Employee> cls = Employee.class; //TIP you could also have said employee.getclass() // NOTE Class instance, something that extends Employee.

    Annotation[] annotations = cls.getAnnotations();
    System.out.println(Arrays.toString(annotations)); //NOTE Arrays.toString() looks at the array, separates and puts commas between them to print.

    Method[] methods = cls.getMethods();

    for(Method method : methods){
      System.out.println(method.getName());
      Annotation[] methodAnnotations = method.getDeclaredAnnotations(); //NOTE gets the annotations directly on method
      System.out.println(Arrays.toString(methodAnnotations));
      Annotation fast = method.getAnnotation(Fast.class);
      System.out.printf("Has @Fast ? %s%n", (fast != null ? "Yes" : "No")); //TIP looking at the fast instantation checking if it has a fast annotation. Ternary returns yes or no
    }

  }

}
