import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import EmployeeObjects.SalaryEmployee;

// salary tests
public class SalaryEmployeeTest {
    private SalaryEmployee emp;

    @Before
    public void setUp() {
        emp = new SalaryEmployee("Steve", "Rodgers", 3781, "Sales", "Manager", 64325);
    }

    @Test
    public void testCalculateWeeklyPay() {
        double weeklyPay = emp.calculateWeeklyPay();
        assertEquals("Weekly pay should be 1237.02", 1237.02, weeklyPay, 0.001);
    }

    @Test
    public void testHolidayBonus() {
        double bonus = emp.holidayBonus();
        assertEquals("Holiday bonus should be 2164.54", 2164.54, bonus, 0.001);
    }
}
