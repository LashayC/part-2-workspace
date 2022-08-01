package com.javatunes.personnel;

import static org.junit.Assert.*;

import gov.irs.TaxPayer;
import java.sql.Date;
import org.junit.Before;
import org.junit.Test;

public class SalariedEmployeeTest {

  private SalariedEmployee employeeOne;

  @Before
  public void setUp() throws Exception {
    employeeOne = new SalariedEmployee("Sarah",  new Date(0), 25.0);

  }

  @Test
  public void pay() {
    assertEquals(25.0, employeeOne.pay(), 0.005); //NOTE how do you determine the tolerance(unboxing vs boxing?)

  }

  @Test
  public void payTaxes() {
    assertEquals(25.0 * TaxPayer.SALARIED_TAX_RATE, employeeOne.payTaxes(), 0.0005);

  }

  @Test
  public void testToString() {
  }


  @Test
  public void testEquals_same() {
    //NOTE Create another employee with same name and hire date in order to compare. Salary too.

    Employee employeeTwo = new SalariedEmployee("Sarah", new Date(0), 25.0);
    assertTrue(employeeOne.equals(employeeTwo));
    assertTrue(employeeTwo.equals(employeeOne));//NOTE you're testing that it works in both directions
    //assertEquals(employeeOne, employeeTwo);//TIP Could also write it like this
  }
  @Test
  public void testEquals_different() {
    //NOTE Create another employee with same name and hire date in order to compare. Salary too.
    Employee employeeTwo = new SalariedEmployee("John", new Date(0), 25.0);
    assertFalse(employeeOne.equals(employeeTwo));
  }
  @Test
  public void testHashCode_same() {
    Employee employeeTwo = new SalariedEmployee("Sarah", new Date(0), 25.0);
    assertEquals(employeeOne.hashCode(), employeeTwo.hashCode());

  }
  @Test
  public void testHashCode_different() {
    Employee employeeTwo = new SalariedEmployee("Sarah", new Date(1), 25.0);
    assertNotEquals(employeeOne.hashCode(), employeeTwo.hashCode());

  }
}