/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.billing;

public enum Location { //NOTE enums classes can't be extended bc their instantiated at load time
  USA {
    //NOTE you can treat each enumerator as a subclass enum. This ex here creates a Strategy pattern that can give the Context (order class) which implementation of tax calc to use.

    @Override
    public TaxCalculator getTaxCalculator() {
      return new USATax();
    }
  },
  EUROPE{
    @Override
    public TaxCalculator getTaxCalculator() {
      return new EuropeTax();
    }
  },
  ONLINE{
    @Override
    public TaxCalculator getTaxCalculator() {
      return new OnlineTax();
    }
  };

  public abstract TaxCalculator getTaxCalculator();//NOTE this method is only abstract in the enum because the implemntation changes depending on context. You could also have made it concrete and just overriden it as needed.
}