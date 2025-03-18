import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import EmployeeObjects.CommissionEmployee;

public class CommissionEmployeeTest {
    private CommissionEmployee emp;

    @Before
    public void setUp() {
        emp = new CommissionEmployee("Clint", "Barton", 6847, "Sales", "Customer Representative", 0.0265);
    }

    @Test
    public void testIncreaseSales() {
        emp.increaseSales(1000);
        emp.increaseSales(500);
        emp.increaseSales(-300);
        assertEquals("Sales should only include positive values", 1500, emp.getSales(), 0.001);
    }

    @Test
    public void testHolidayBonus() {
        double bonus = emp.holidayBonus();
        assertEquals("Commission employees should receive no holiday bonus", 0.0, bonus, 0.001);
    }

    @Test
    public void testAnnualRaise() {
        emp.annualRaise();
        emp.annualRaise();
        assertEquals("Rate should be 0.0305 after two annual raises", 0.0305, emp.getRate(), 0.0001);
    }
}
