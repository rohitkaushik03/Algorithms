package Threading.DiningPhilosphersProblem;

/**
 * Created by rkaushik on 12/28/16.
 * Dining Philosphers problem
 */
public class Philospher extends Thread {

    private int bites = 10;
    Chopstick left;
    Chopstick right;

    public Philospher(Chopstick left,Chopstick right)
    {
        this.left = left;
    }

    public void eat()
    {
        pickup();
        chew();
        putDown();
    }

    public void pickup()
    {
        left.pickup();
        right.pickup();
    }

    public void putDown()
    {
        left.putDown();
        right.putDown();
    }

    public void chew(){}

    public void run()
    {
        for (int i=0;i<bites;i++)
        {
            eat();
        }
    }
}
