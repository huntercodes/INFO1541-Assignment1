package EmployeeObjects;

import EmployeeBlueprints.Employee;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestingAnnotations {
    public static void main(String[] args) {
        HourlyEmployee hourly = new HourlyEmployee("Tony", "Stark", 5749, "Service", "Lead Service Manager", 32.85);
        SalaryEmployee salary = new SalaryEmployee("Steve", "Rodgers", 3781, "Sales", "Manager", 64325);
        CommissionEmployee commission = new CommissionEmployee("Clint", "Barton", 6847, "Sales", "Customer Representative", 0.0265);

        Employee[] employees = {hourly, salary, commission};

        int countEmployeeTypes = 0;
        for (Employee e : employees) {
            if (e.getClass().isAnnotationPresent(EmployeeType.class)) {
                countEmployeeTypes++;
            }
        }
        System.out.println("You have " + countEmployeeTypes + " employee types.");

        for (Employee e : employees) {
            System.out.println("\nProcessing " + e.getClass().getSimpleName() + ":");

            Field[] fields = e.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(PayRate.class)) {
                    field.setAccessible(true);
                    try {
                        Object value = field.get(e);
                        System.out.println("Employee pay rate: $" + value);
                    } catch (IllegalAccessException ex) {
                        ex.printStackTrace();
                    }
                }
            }

            Method[] methods = e.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(WeeklyPayCalculator.class)) {
                    try {
                        Object result = method.invoke(e);
                        System.out.println("Weekly pay calculated: $" + result);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
