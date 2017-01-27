package Threading.DiningPhilosphersProblem;

/**
 * Created by rkaushik on 12/28/16.
 */
public class MainClass {

    public static void main(String[] args)
    {
        Chopstick left = new Chopstick();
        Chopstick right = new Chopstick();

        Philospher phl = new Philospher(left,right);
        phl.run();
    }
}
