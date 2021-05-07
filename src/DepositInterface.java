import Valuables.Valuable;

public interface DepositInterface
{
  /** Method for adding valuables **/
  void addValuables(Valuable retrievedValuable) throws InterruptedException;

  /** Method for getting valuables **/
  Valuable getValuables() throws InterruptedException;

  /** Method for getting max valuables **/
  int getMax();
}
