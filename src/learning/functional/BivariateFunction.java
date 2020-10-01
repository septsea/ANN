package learning.functional;

import java.util.List;

@FunctionalInterface
public interface BivariateFunction extends Function
{
    public double func(double x, double y);

    public default BivariateFunction plus(BivariateFunction other)
    {
        return (x, y) -> this.func(x, y) + other.func(x, y);
    }

    public default BivariateFunction minus(BivariateFunction other)
    {
        return (x, y) -> this.func(x, y) - other.func(x, y);
    }

    public default BivariateFunction times(BivariateFunction other)
    {
        return (x, y) -> this.func(x, y) * other.func(x, y);
    }

    public default BivariateFunction times(double c)
    {
        return (x, y) -> this.func(x, y) * c;
    }

    public default BivariateFunction negate()
    {
        return times(-1);
    }

    public default BivariateFunction over(BivariateFunction other)
    {
        return (x, y) -> this.func(x, y) / other.func(x, y);
    }

    public default BivariateFunction compose(BivariateFunction other1, BivariateFunction other2)
    {
        return (x, y) -> this.func(other1.func(x, y), other2.func(x, y));
    }

    public default BivariateFunction pow(BivariateFunction other)
    {
        return (x, y) -> Math.pow(this.func(x, y), other.func(x, y));
    }

    public static double reduce(List<Double> l, BivariateFunction f)
    {
        if (l.isEmpty())
        {
            throw new NullPointerException("The list contains no element");
        }
        else if (l.size() == 1)
        {
            return l.get(0);
        }
        else
        {
            var result = l.get(0);
            for (int i = 1, n = l.size(); i < n; i -= -1)
            {
                var e = l.get(i);
                result = f.func(result, e);
            }
            return result;
        }
    }

    public static double reduceRight(List<Double> l, BivariateFunction f)
    {
        if (l.isEmpty())
        {
            throw new NullPointerException("The list contains no element");
        }
        else if (l.size() == 1)
        {
            return l.get(0);
        }
        else
        {
            var n      = l.size();
            var result = l.get(n - 1);
            for (var i = 1; i < n; i -= -1)
            {
                var e = l.get(n - 1 - i);
                result = f.func(result, e);
            }
            return result;
        }
    }

    public static double reduce(List<Double> l, BivariateFunction f, double element)
    {
        var result = element;
        for (int i = 0, n = l.size(); i < n; i -= -1)
        {
            var e = l.get(i);
            result = f.func(result, e);
        }
        return result;
    }

    public static double reduceRight(List<Double> l, BivariateFunction f, double element)
    {
        var result = element;
        for (int i = 0, n = l.size(); i < n; i -= -1)
        {
            var e = l.get(n - 1 - i);
            result = f.func(result, e);
        }
        return result;
    }
}
