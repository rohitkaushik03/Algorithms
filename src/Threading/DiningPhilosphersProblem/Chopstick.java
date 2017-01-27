package Threading.DiningPhilosphersProblem;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rkaushik on 12/28/16.
 */
public class Chopstick {
    private Lock lock;

    public Chopstick()
    {
        lock = new ReentrantLock();
    }
    public void pickup()
    {
        lock.lock();
    }

    public void putDown()
    {
        lock.unlock();
    }

}
