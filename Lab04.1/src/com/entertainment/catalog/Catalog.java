/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import com.entertainment.Television;

public class Catalog {
  // in-memory catalog of Televisions
  private static final Collection<Television> catalog = new ArrayList<>(30);

  // prevent direct instantiation, this is an all-static class
  private Catalog() {
  }
  
  /**
   * Searches catalog by brand, and returns a collection of matching Televisions.
   * A no-matches result should be an empty collection (not null).
   */
  public static Collection<Television> findByBrand(String brand) {
    //return null; //NOTE this is only here so that the program compiles even when you just have a stub here. (You could also throw an UnsupportedOperationException to get around this and compile)
    Collection<Television> tvs = new ArrayList<>();
    for(Television cat : catalog){
      if(brand == cat.getBrand()){ // brand.equals(cat.getBrand());
        tvs.add(cat);
      }

    }
    System.out.println("This is the tvs"+ tvs);
    return tvs;
  }
  
  /**
   * Searches catalog by one or more brands, and returns a map with an entry for each brand supplied, 
   * with a corresponding collection of matching Televisions for that brand.
   * A no-brands-passed result should be an empty map (not null).
   */
  public static Map<String,Collection<Television>> findByBrands(String... brands) {
    return null;
  }

  /**
   * Returns entire catalog.
   * NOTE: returning a direct reference to it has consequences!
   *  A client can manipulate it, since it has a direct reference to it.
   *  Sometimes this is okay, but not here.
   *  
   * TODO: change this to return a read-only view of the catalog.
   * 
   * You should explore the Javadoc for the java.util.Collections *class*.
   *  This is an all-static utility class, not the java.util.Collection interface.
   */
  public static Collection<Television> getInventory() {
    return catalog;
  }

  /*
   * Loads catalog.
   * Static initializers execute when the class is loaded into the JVM.
   */
  static {
    catalog.add(new Television("Zenith",  0));
    catalog.add(new Television("Sony",    4));
    catalog.add(new Television("Sony",    50));
    catalog.add(new Television("Zenith",  33));
    catalog.add(new Television("RCA",     50));
    catalog.add(new Television("Zenith",  86));
    catalog.add(new Television("Hitachi", 13));
    catalog.add(new Television("Hitachi", 40));
    catalog.add(new Television("Zenith",  46));
    catalog.add(new Television("RCA",     50));
    catalog.add(new Television("Sony",    94));
    catalog.add(new Television("RCA",     50));
    catalog.add(new Television("Sony",    50));
    catalog.add(new Television("Hitachi", 50));
    catalog.add(new Television("Zenith",  37));
    catalog.add(new Television("RCA",     31));
    catalog.add(new Television("Sony",    87));
    catalog.add(new Television("Hitachi", 39));
    catalog.add(new Television("Zenith",  27));
    catalog.add(new Television("Zenith",  12));
    catalog.add(new Television("RCA",     10));
    catalog.add(new Television("Hitachi", 50));
    catalog.add(new Television("RCA",     4));
    catalog.add(new Television("RCA",     50));
    catalog.add(new Television("RCA",     50));
    catalog.add(new Television("Sony",    28));
    catalog.add(new Television("Zenith",  50));
    catalog.add(new Television("Zenith",  77));
    catalog.add(new Television("Sony",    22));
    catalog.add(new Television("RCA",     50));
  }
}
