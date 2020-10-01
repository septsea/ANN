package learning.test;

import static learning.Accessories.c;
import learning.Hebbian;
import learning.Tuple;

public class Problem24
{
    public static void main(String... args)
    {
        var initialWeight = new Tuple(1, -1);
        var inputs        = c(new Tuple(1, -2), new Tuple(0, 1), new Tuple(2, 3), new Tuple(1, 1));
        var p24_1         = new Hebbian(x -> x >= 0 ? 1 : -1, 1, 0);
        var p24_2         = new Hebbian(x -> Math.tanh(x / 2), 1, 0);
        System.out.println("(1)");
        p24_1.start(4, initialWeight, inputs);
        System.out.println();
        System.out.println("(2)");
        p24_2.start(4, initialWeight, inputs);
        System.out.println();
    }
}
