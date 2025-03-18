import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import EmployeeObjects.HourlyEmployee;

public class HourlyEmployeeTest {
    private HourlyEmployee emp;

    @Before
    public void setUp() {
        emp = new HourlyEmployee("Tony", "Stark", 5749, "Service", "Lead Service Manager", 32.85);
    }

    @Test
    public void testIncreaseHours() {
        emp.increaseHours(5);
        emp.increaseHours(3);
        emp.increaseHours(-2);
        assertEquals("increaseHours should only add positive hours", 8, emp.getHoursWorked(), 0.001);
    }

    @Test
    public void testAnnualRaise() {
        emp.annualRaise();
        assertEquals("annualRaise should increase wage by 5% to 34.49", 34.49, emp.getWage(), 0.001);
    }

    @Test
    public void testCalculateWeeklyPayWithoutOvertime() {
        emp.increaseHours(35);
        double weeklyPay = emp.calculateWeeklyPay();
        assertEquals("Weekly pay for 35 hours should be 1149.75", 1149.75, weeklyPay, 0.001);
    }

    @Test
    public void testCalculateWeeklyPayWithOvertime() {
        emp.increaseHours(45);
        double weeklyPay = emp.calculateWeeklyPay();
        assertEquals("Weekly pay for 45 hours should be 1560.38", 1560.38, weeklyPay, 0.001);
    }
}
