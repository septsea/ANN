package learning.functional;

import java.util.List;
import java.util.Vector;

@FunctionalInterface
public interface UnivariateFunction extends Function
{
    public double func(double x);

    public default UnivariateFunction plus(UnivariateFunction other)
    {
        return x -> this.func(x) + other.func(x);
    }

    public default UnivariateFunction minus(UnivariateFunction other)
    {
        return x -> this.func(x) - other.func(x);
    }

    public default UnivariateFunction times(UnivariateFunction other)
    {
        return x -> this.func(x) * other.func(x);
    }

    public default UnivariateFunction times(double c)
    {
        return x -> this.func(x) * c;
    }

    public default UnivariateFunction negate()
    {
        return times(-1);
    }

    public default UnivariateFunction over(UnivariateFunction other)
    {
        return x -> this.func(x) / other.func(x);
    }

    public default UnivariateFunction compose(UnivariateFunction other)
    {
        return x -> this.func(other.func(x));
    }

    public default UnivariateFunction pow(UnivariateFunction other)
    {
        return x -> Math.pow(this.func(x), other.func(x));
    }

    public static UnivariateFunction identity = x -> x;

    public static List<Double> map(List<Double> l, UnivariateFunction f)
    {
        var result = new Vector<Double>();
        l.forEach(e -> result.add(f.func(e)));
        return result;
    }
}
