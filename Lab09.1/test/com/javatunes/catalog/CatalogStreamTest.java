/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.catalog;

import static org.junit.Assert.*;
//import static java.util.stream.Collectors.*;
//import static java.util.Comparator.*;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

public class CatalogStreamTest {
  
  private Collection<MusicItem> allMusicItems;

  @Before
  public void setUp() {
    Catalog catalog = new InMemoryCatalog();
    allMusicItems = catalog.getAll();
  }
  
  /**
   * TASK: find all MusicItems whose artist starts with "D" and sort them by price.
   * 
   * RESULT: MusicItems 11 and 10, in that order.
   */
  @Test
  public void testArtistStartsWithSortPrice() {
    List<MusicItem> items = allMusicItems.stream()
      .filter(item -> item.getArtist().startsWith("D"))
      .sorted(Comparator.comparing(item -> item.getPrice()))
      .collect(Collectors.toList());
    
    assertEquals(2, items.size());
    assertEquals(Long.valueOf(11), items.get(0).getId());
    assertEquals(Long.valueOf(10), items.get(1).getId());
  }
  
  /**
   * TASK: find all MusicItems where title is same as artist and sort them by natural order.
   * MusicItem implements Comparable: natural order is id increasing.
   * 
   * RESULT:
   */
  @Test
  public void testTitleEqualsArtistSortNaturalOrder() {
    // TODO
   allMusicItems.stream()//NOTE If you just want to print, you need to remove List
        .filter(item -> item.getTitle().equals(item.getArtist()))
        .sorted()
        .forEach(System.out::println);//NOTE an example of how you would terminate by printing

//        .collect(Collectors.toList());

//    assertEquals(2, items.size());
//    assertEquals("Seal", items.get(0).getArtist());
//    assertEquals("Ian Moore", items.get(1).getArtist());

  }
  
  /**
   * TASK: find all MusicItems whose price is less than 12.00 and sort them by genre (MusicCategory).
   * The natural order of an enum is the order in which they're declared (it's not alphabetical).
   * We'll provide that for you here: BLUES, CLASSICAL, JAZZ, RAP, COUNTRY, POP, ALTERNATIVE, ROCK, CLASSIC_ROCK
   * 
   * RESULT:
   */
  @Test
  public void testPriceLessThanSortMusicCategory() {
    // TODO
    List<MusicItem> items = allMusicItems.stream()
        .filter(item -> item.getPrice() < 12.00)
        .sorted(Comparator.comparing(MusicItem::getMusicCategory))
//        .sorted(Comparator. comparing(MusicItem::getMusicCategory, Comparator.comparing((MusicCategory::name)))) //NOTE this says sort by music category then by name
        .collect(Collectors.toList());

    System.out.println(items) ;
    assertEquals(5, items.size());
    assertEquals(Long.valueOf(7), items.get(0).getId());
    assertEquals(Long.valueOf(13), items.get(1).getId());
    assertEquals(Long.valueOf(16), items.get(2).getId());
    assertEquals(Long.valueOf(17), items.get(3).getId());
    assertEquals(Long.valueOf(18), items.get(4).getId());

    //Assert values below 12
//    assertFalse(items.contains(Long.valueOf(12));

  }
  
  /**
   * TASK: find all "rock" items under 15 dollars and sort them by release date (oldest first).
   * 
   * RESULT:
   */
  @Test
  public void testSortMusicCategorySortReleaseDateDesc() {
    // TODO
    List<MusicItem> items = allMusicItems.stream()
        .filter(((Predicate<MusicItem>) (item) -> item.getMusicCategory() == MusicCategory.ROCK).and((item) -> item.getPrice() < 15.0)) //NOTE here you're casting the predicate to it knows which type item is, then you can continue as norma..
//        .filter(item -> item.getPrice() < 15.00 && item.getMusicCategory() == MusicCategory.ROCK) //Note you can use the == here because they're enums. This is the only object type this is safe on, otherwise its .equals
//        .filter((item) -> item.getMusicCategory() == MusicCategory.ROCK)
//        .filter((item) -> item.getPrice() <15.0)
        .sorted(Comparator.comparing(MusicItem::getReleaseDate))
        .collect(Collectors.toList());

    System.out.printf("%s \n", items);

    for(MusicItem item : items){
      System.out.println(item);
    }
  }
  
  /**
   * TASK: find all items that cost more than 17 dollars and sort them by price descending, then by artist.
   * You can use visual inspection (sysout) on this one if you're getting tight on time.
   * 
   * RESULT:
   */
  @Test
  public void testPriceGreaterThanSortPriceDescThenMusicCategory() {
    // TODO
    List<MusicItem> items = allMusicItems.stream()
        .filter(item -> item.getPrice() > 17.00)
        .sorted(Comparator.comparing((MusicItem item) -> item.getPrice()).reversed().thenComparing(MusicItem::getArtist))//NOTE here when writing an expression lambda (method reference) include the type so the compiler knows what the parameter Type is.
        .collect(Collectors.toList());
    System.out.println(items);
  }
  
  /**
   * TASK: find all items under 12 dollars released in the 80s and sort them by artist.
   * Hint: To see if an item was released in the 80s, use item.getReleaseDate().toString().startsWith("198")
   * 
   * RESULT:
   */
  @Test
  public void testReleaseDateSortArtist() {
    // TODO
    List<MusicItem> items = allMusicItems.stream()
        .filter((item) -> item.getPrice() < 12)
        .filter((item) -> item.getReleaseDate().toString().startsWith("198"))
        .sorted(Comparator.comparing(MusicItem::getArtist))
        .collect(Collectors.toList());
    System.out.println(items);
  }

}