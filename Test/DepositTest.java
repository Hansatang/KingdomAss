import Valuables.ResourceType;
import Valuables.Valuable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepositTest
{
  private DepositInterface deposit;

  @BeforeEach public void setup()
  {
    deposit = new Deposit();
  }

  @Test public void normalAdd() throws InterruptedException
  {
    deposit.addValuables(Valuable.getInstance(ResourceType.GOLD));
    assertEquals(ResourceType.GOLD, deposit.getValuables().getResourceType());

    deposit.addValuables(Valuable.getInstance(ResourceType.IRON));
    assertEquals(ResourceType.IRON, deposit.getValuables().getResourceType());
    deposit.addValuables(Valuable.getInstance(ResourceType.DIAMOND));
    assertEquals(ResourceType.DIAMOND,
        deposit.getValuables().getResourceType());
  }

  @Test public void nullAdd()
  {
    assertThrows(IllegalStateException.class, () -> deposit.addValuables(null));
  }

  //  @Test public void addOverCap() throws InterruptedException
  //  {
  //    for (int i = 0; i < deposit.getMax(); i++)
  //    {
  //      deposit.addValuables(Valuable.getInstance(ResourceType.GOLD));
  //    }
  //   deposit.addValuables(Valuable.getInstance(ResourceType.DIAMOND));
  //
  //  }

  //  @Test public void getFromEmpty() throws InterruptedException
  //  {
  //    assertThrows(IndexOutOfBoundsException.class, () -> deposit.getValuables());
  //  }

  @Test public void getNormal() throws InterruptedException
  {
    deposit.addValuables(Valuable.getInstance(ResourceType.DIAMOND));
    assertEquals(ResourceType.DIAMOND,
        deposit.getValuables().getResourceType());
  }
}