package learning.test;

import static learning.Accessories.c;
import learning.DiscretePerceptron;
import learning.Tuple;

public class Problem25
{
    public static void main(String... args)
    {
        var initialWeight    = new Tuple(0, 1, 0);
        var inputs           = c(new Tuple(2, 1, -1), new Tuple(0, -1, -1));
        var desiredResponses = c(-1, 1);
        var p25              = new DiscretePerceptron(1, 0);
        p25.start(2, initialWeight, inputs, desiredResponses);
    }
}
