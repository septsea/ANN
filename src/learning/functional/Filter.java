package learning.functional;

import java.util.List;
import java.util.Vector;

@FunctionalInterface
public interface Filter extends Function
{
    public boolean function(double x);

    public static List<Double> filter(List<Double> l, Filter f)
    {
        var result = new Vector<Double>();
        l.forEach(e ->
        {
            if (f.function(e))
            {
                result.add(e);
            }
        });
        return result;
    }
}
