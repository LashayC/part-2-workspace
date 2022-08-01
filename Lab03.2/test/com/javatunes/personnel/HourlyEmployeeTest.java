package com.javatunes.personnel;

import static org.junit.Assert.*;

import gov.irs.TaxPayer;
import java.sql.Date;
import org.junit.Before;
import org.junit.Test;

public class HourlyEmployeeTest {
  private HourlyEmployee employee;

  @Before
  public void setUp() throws Exception {
    employee = new HourlyEmployee("John", new Date(0), 15.0, 40.0);
  }

  @Test
  public void pay() {
    assertEquals(600, employee.pay(), 0.0005);
  }

  @Test
  public void payTaxes() {
    assertEquals(600 * TaxPayer.HOURLY_TAX_RATE, employee.payTaxes(), 0.0005);
  }

  @Test
  public void testEquals_same() {
    Employee employee2 = new HourlyEmployee("John", new Date(0), 15.0, 40.0);
    assertTrue(employee.equals(employee2));
  }
  @Test
  public void testEquals_different() {
    Employee employee2 = new HourlyEmployee("John", new Date(0), 30.0, 40.0);
    assertFalse(employee.equals(employee2));
  }
  @Test
  public void testHashCode_same() {
    Employee employee2 = new HourlyEmployee("John", new Date(0), 15.0, 40.0);
    assertEquals(employee.hashCode(), employee2.hashCode());
  }
  @Test
  public void testHashCode_different() {
    Employee employee2 = new HourlyEmployee("John", new Date(1), 15.0, 40.0);
    assertNotEquals(employee.hashCode(), employee2.hashCode());
  }
}