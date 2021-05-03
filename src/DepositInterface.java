import Valuables.Valuable;

public interface DepositInterface
{
  void addValuables(Valuable retrievedValuable) throws InterruptedException;
  Valuable getValuables() throws InterruptedException;
}
