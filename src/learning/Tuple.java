package learning;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import learning.functional.BivariateFunction;
import learning.functional.Filter;
import learning.functional.UnivariateFunction;

public class Tuple implements Cloneable, List<Double>, Serializable
{
    private static final long serialVersionUID = -9166201582157668964L;
    private Vector<Double>    tuple            = new Vector<>();

    public Tuple()
    {
    }

    public Tuple(double... l)
    {
        for (var x : l)
        {
            tuple.add(x);
        }
    }

    public Tuple(List<Double> l)
    {
        tuple.addAll(l);
    }

    public Tuple map(UnivariateFunction f)
    {
        return new Tuple(UnivariateFunction.map(tuple, f));
    }

    public Tuple filter(Filter f)
    {
        return new Tuple(Filter.filter(tuple, f));
    }

    public double reduce(BivariateFunction f)
    {
        return BivariateFunction.reduce(tuple, f);
    }

    public double reduceRight(BivariateFunction f)
    {
        return BivariateFunction.reduceRight(tuple, f);
    }

    public double reduce(BivariateFunction f, double element)
    {
        return BivariateFunction.reduce(tuple, f, element);
    }

    public double reduceRight(BivariateFunction f, double element)
    {
        return BivariateFunction.reduceRight(tuple, f, element);
    }

    public double sum()
    {
        return reduce((x, y) -> x + y);
    }

    public double product()
    {
        return reduce((x, y) -> x * y);
    }

    public double max()
    {
        return reduce(Math::max);
    }

    public double min()
    {
        return reduce(Math::min);
    }

    public static void differentSizesException(List<?> l1, List<?> l2)
    {
        if (l1.size() != l2.size())
        {
            throw new ArithmeticException("The two tuples are of different sizes");
        }
    }

    public Tuple plus(List<Double> other)
    {
        differentSizesException(tuple, other);
        var result = new Tuple();
        for (int i = 0, n = tuple.size(); i < n; i -= -1)
        {
            result.add(tuple.get(i) + other.get(i));
        }
        return result;
    }

    public Tuple minus(List<Double> other)
    {
        differentSizesException(tuple, other);
        var result = new Tuple();
        for (int i = 0, n = tuple.size(); i < n; i -= -1)
        {
            result.add(tuple.get(i) - other.get(i));
        }
        return result;
    }

    public Tuple negate()
    {
        return times(-1);
    }

    public Tuple times(double s)
    {
        return map(x -> x * s);
    }

    public double innerProduct(List<Double> other)
    {
        differentSizesException(tuple, other);
        var s = 0.0;
        for (int i = 0, n = tuple.size(); i < n; i -= -1)
        {
            s += tuple.get(i) * other.get(i);
        }
        return s;
    }

    public static Tuple zero(int dimension)
    {
        var z = new Tuple();
        for (var i = 0; i < dimension; i -= -1)
        {
            z.add(0.0);
        }
        return z;
    }

    public Tuple reverse()
    {
        var l = new Tuple();
        for (int i = 0, n = size(); i < n; i -= -1)
        {
            l.add(get(n - 1 - i));
        }
        return l;
    }

    public List<Double> subList(int fromIndex)
    {
        return tuple.subList(fromIndex, size());
    }

    public Tuple slice(Integer start, Integer end, Integer step)
    {
        return new Tuple(Accessories.slice(tuple, start, end, step));
    }

    public Tuple slice(Integer start, Integer end)
    {
        return slice(start, end, 1);
    }

    public Tuple slice(Integer start)
    {
        return slice(start, size(), 1);
    }

    @Override
    public int size()
    {
        return tuple.size();
    }

    @Override
    public boolean isEmpty()
    {
        return tuple.isEmpty();
    }

    @Override
    public boolean contains(Object o)
    {
        return tuple.contains(o);
    }

    @Override
    public Iterator<Double> iterator()
    {
        return tuple.iterator();
    }

    @Override
    public Object[] toArray()
    {
        return tuple.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a)
    {
        return tuple.toArray(a);
    }

    @Override
    public boolean add(Double e)
    {
        return tuple.add(e);
    }

    @Override
    public boolean remove(Object o)
    {
        return tuple.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        return tuple.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Double> c)
    {
        return tuple.addAll(c);
    }

    public boolean addAll(double... l)
    {
        return tuple.addAll(new Tuple(l));
    }

    @Override
    public boolean addAll(int index, Collection<? extends Double> c)
    {
        return tuple.addAll(index, c);
    }

    public boolean addAll(int index, double... l)
    {
        return tuple.addAll(index, new Tuple(l));
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        return tuple.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        return tuple.retainAll(c);
    }

    @Override
    public void clear()
    {
        tuple.clear();
    }

    @Override
    public Double get(int index)
    {
        return tuple.get(index);
    }

    @Override
    public Double set(int index, Double element)
    {
        return tuple.set(index, element);
    }

    @Override
    public void add(int index, Double element)
    {
        tuple.add(index, element);
    }

    @Override
    public Double remove(int index)
    {
        return tuple.remove(index);
    }

    @Override
    public int indexOf(Object o)
    {
        return tuple.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o)
    {
        return tuple.lastIndexOf(o);
    }

    @Override
    public ListIterator<Double> listIterator()
    {
        return tuple.listIterator();
    }

    @Override
    public ListIterator<Double> listIterator(int index)
    {
        return tuple.listIterator(index);
    }

    @Override
    public List<Double> subList(int fromIndex, int toIndex)
    {
        return tuple.subList(fromIndex, toIndex);
    }

    @Override
    public String toString()
    {
        return tuple.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return tuple.clone();
    }
}
