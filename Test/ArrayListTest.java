import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utility.collection.ArrayList;

import java.sql.Array;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest
{

  private ArrayList<String> list;

  @BeforeEach public void setup()
  {
    list = new ArrayList<String>();
  }

  @Test public void sizeIsZero()
  {
    assertEquals(0, list.size());

  }

  @Test public void sizeIsNotZero()
  {
    list.add("Test");
    list.add("Test");
    assertEquals(2, list.size());
  }

  @Test public void isEmptyWhileEmpty()
  {
    assertTrue(list.isEmpty());
  }

  @Test public void isEmptyWhileNotEmpty()
  {
    list.add("Test");
    assertFalse(list.isEmpty());
  }

  @Test public void removeWithIndex()
  {
    list.add("Test");
    list.remove(0);
    assertEquals(0, list.size());
  }

  @Test public void removeFromEmptyWithIndex()
  {
    assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
  }

  @Test public void removeWithElement()
  {
    list.add("Test");
    list.remove("Test");
    assertEquals(0, list.size());
  }

  @Test public void removeFromEmptyWithElement()
  {
    assertThrows(IllegalStateException.class, () -> list.remove("Test"));
  }

  @Test public void contains()
  {
    list.add("Test");
    assertTrue(list.contains("Test"));
  }

  @Test public void containsNot()
  {
    list.add("Test");
    assertFalse(list.contains("Test1"));
  }

  @Test public void containsOnEmpty()
  {
    assertFalse(list.contains("Test1"));
  }

  @Test public void get()
  {
    list.add("Test");
    assertEquals("Test", list.get(0));
  }

  @Test public void getFromEmpty()
  {
    assertThrows(IllegalStateException.class, () -> list.get(0));
  }

  @Test public void indexOf()
  {
    list.add("Test");
    assertEquals(0, list.indexOf("Test"));
  }

  @Test public void indexOfEmpty()
  {
    list.indexOf("Test");
    assertEquals(-1, list.indexOf("Test"));
  }

  @Test public void set()
  {
    list.add("Test");
    list.add("Test");
    list.add("Test");
    list.set(1, "Change");
    assertEquals("Change", list.get(1));
  }

  @Test public void setToNull()
  {
    list.add("Test");
    list.add("Test");
    list.add("Test");
    list.set(1, null);
    assertNull(list.get(1));
  }

  @Test public void setNonexistent()
  {
    assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, "Test"));
  }

  @Test public void addWithIndex()
  {
    list.add("Test");
    assertEquals("Test", list.get(0));
  }

  @Test public void addWithIndexNull()
  {
    list.add(null);
    assertEquals(null, list.get(0));
  }

  @Test public void addWithElement()
  {
    list.add(0, "Test");
    assertEquals("Test", list.get(0));
  }

  @Test public void toStringTest()
  {
    list.add("Test");
    list.add("Test");
    assertEquals("{Test, Test}", list.toString());
  }

  @Test public void toStringTestEmpty()
  {
    assertEquals("{}", list.toString());
  }

  @Test public void isFull()
  {
    assertTrue(list.isFull());
  }

  @Test public void isFullNotEmpty()
  {
    list.add("Test");
    assertTrue(list.isFull());
  }

  @Test public void isFullNotEmptyAfterRemove()
  {
    list.add("Test");
    System.out.println("A"+list.size());
    list.add("Test");
    list.remove(0);
    System.out.println("B"+list.size());
    assertFalse(list.isFull());
  }

}


