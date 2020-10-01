package learning.test;

import static learning.Accessories.c;
import learning.ContinuousPerceptron;
import learning.Tuple;

public class Problem27
{
    public static void main(String... args)
    {
        var initialWeight    = new Tuple(1, 0, 1);
        var inputs           = c(new Tuple(2, 0, -1), new Tuple(1, -2, -1));
        var desiredResponses = c(-1, 1);
        var p27              = new ContinuousPerceptron(x -> x, x -> 1, 0.25, 0);
        p27.start(2, initialWeight, inputs, desiredResponses);
    }
}
