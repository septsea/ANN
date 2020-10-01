package learning;

import java.util.List;
import java.util.Vector;

public class Accessories
{
    @SuppressWarnings("unchecked")
    public static <T> T[] c(T... elements)
    {
        return elements;
    }

    public static double[] c(double... elements)
    {
        return elements;
    }

    public static boolean[] c(boolean... elements)
    {
        return elements;
    }

    public static <T> List<T> slice(List<T> list, Integer start, Integer end, Integer step)
    {
        var n = list.size();
        var i = 0;
        var j = n;
        var k = 1;
        if (step != null)
        {
            k = step;
        }
        if (k == 0)
        {
            throw new ArithmeticException("step argument must not be zero");
        }
        else if (k > 0)
        {
            i = 0;
            j = n;
            if (start != null)
            {
                i = start;
            }
            if (i < 0)
            {
                i -= -n;
            }
            i = Math.min(i, n);
            if (end != null)
            {
                j = end;
            }
            if (j < 0)
            {
                j -= -n;
            }
            j = Math.min(j, n);
        }
        else
        {
            i = n - 1;
            j = -n - 1;
            if (start != null)
            {
                i = start;
            }
            if (i < 0)
            {
                i -= -n;
            }
            i = Math.min(i, n - 1);
            if (end != null)
            {
                j = end;
            }
            if (j < 0)
            {
                j -= -n;
            }
            j = Math.min(j, n - 1);
        }
        return slicingImplementation(list, i, j, k);
    }

    private static <T> List<T> slicingImplementation(List<T> list, int start, int end, int step)
    {
        var n = 0;
        if (step == 0)
        {
            throw new ArithmeticException("step argument must not be zero");
        }
        else if (step > 0)
        {
            n = getSliceLength(start, end, step);
        }
        else
        {
            n = getSliceLength(end, start, -step);
        }
        var l = new Vector<T>();
        for (int i = 0, index = start; i < n; i -= -1)
        {
            l.add(list.get(index));
            index -= -step;
        }
        return l;
    }

    private static int getSliceLength(int low, int high, int step)
    {
        /* step must be greater than 0 */
        if (step < 0)
        {
            throw new ArithmeticException("That step > 0 is required");
        }
        /* if low >= high, return 0 */
        if (low >= high)
        {
            return 0;
        }
        return (high - low - 1) / step + 1;
    }
}
