/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.sql.Date;
import java.util.Map;
import java.util.Set;

public final class EmployeeFactory { //NOTE the private ctor below means this can't be created outside this class. Adding final here just further reinforces it can't be extended.
  
  // prevent direct instantiation - this is an all-static factory class
  private EmployeeFactory() {
  }
  
  /**
   * TODO: given the input map, create and return the correct object (with its properties set).
   * If the input map's "type" value is not "HE" or "SE", throw IllegalArgumentException with a suitable message.
   */
  public static Employee createEmployee(Map<String,String> inputMap)
  throws IllegalArgumentException {


    // return value
    Employee emp = null;
    String type = inputMap.get("type");
    if(!Set.of("HE", "SE").contains(type)){ //NOTE could make set.of(he,se) a private constant above.
      throw new IllegalArgumentException(String.format("'%s' is not a valid employee type",type )); //NOTE %s means format as a regular string.(You could also do %10s and if type is only two characters it'll just add 10 spaces for the string.

    }

    String name = inputMap.get("name");
    Date hireDate = Date.valueOf(inputMap.get("hireDate")); //TIP you can check if date is SQL or Util by checking imports

    switch (type){
      case "SE":
        Double salary = Double.valueOf(inputMap.get("salary"));
        emp = new SalariedEmployee(name, hireDate, salary);
        break;
      case "HE":
        Double rate = Double.valueOf(inputMap.get("rate"));
        Double hours = Double.valueOf(inputMap.get("hours"));
        emp = new HourlyEmployee(name, hireDate, rate, hours);
        break;
//      default:
//        throw new IllegalArgumentException(String.format("'%s' is not a valid employee type",type )); //NOTE %s means format as a regular string.(You could also do %10s and if type is only two characters it'll just add 10 spaces for the string.
    }
    
    return emp;
  }
}