import Valuables.Valuable;

import java.util.ArrayList;

public class Accountant implements Runnable {
    private TreasureRoomDoor treasureRoomDoor;
    private int sum;
    private ArrayList<Valuable> list;
    private Logger logger;

    public Accountant(TreasureRoomDoor treasureRoomDoor) {
        this.treasureRoomDoor=treasureRoomDoor;
        sum=0;
        

    }

    @Override
    public void run() {

        while (true) {
            
            
            treasureRoomDoor.aquireRead();
            for (int i = 0; i < treasureRoomDoor.getSize(); i++) {

                sum+=list.get(i).getWorth();

            }

            logger.log(String.valueOf(sum));
            treasureRoomDoor.releaseRead();
            spendTime(1000);

        }

    }

    public void spendTime(int sleepTime)
    {
        try
        {
            Thread.sleep(sleepTime);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}
