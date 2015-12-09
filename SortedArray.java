import java.util.*;

public class SortedArray
{
    int size;
    int top;
    int increment;
    Comparable[] initial;

    public SortedArray(int initialize, int incrementAmount)
    {
        size = initialize;
        increment = incrementAmount;
        top = -1;
        initial = new Comparable[size];
    }

    public int appropriatePosition(Comparable dataInsert)
    {
        if (top > -1)
        {
            for (int i = 0; i < top+1; i++)
            {
                if (initial[i].compareTo(dataInsert) > 0 || initial[i].compareTo(dataInsert) == 0)
                {
                    return i;
                }
                else
                {
                    return top+1;
                }
            }
        }
        return 0;
    }

    public Comparable smallest()
    {
        Comparable small = 0;
        small = initial[0];
        return small;
    }

    public Comparable largest()
    {
        Comparable large = 0;
        large = initial[top];
        return large;
    }

    public void insert(Comparable dataItem)
    {
        int newSize = initial.length;
        if (top == initial.length-1)
        {
            newSize += increment;
            Comparable[] tempArray = new Comparable[newSize];

            for (int p = 0; p < initial.length; p++)
            {
                tempArray[p] = initial[p];
            }

            initial = tempArray;
        }

        int position = appropriatePosition(dataItem);

        for (int m = top; m > position-1; m--)
        {
            if (m != -1)
            {
                initial[m+1] = initial[m];
            }
        }

        if (position == -1)
        {
            initial[0] = dataItem;
        }
        else
        {
            initial[position] = dataItem;
        }
        top = top + 1;
    }

    public int find(Comparable itemFind)
    {
        int lo = 0;
        int hi = top+1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (itemFind.compareTo(initial[mid]) < 0)
                hi = mid - 1;
            else if (itemFind.compareTo(initial[mid]) > 0)
                lo = mid +1;
            else
                return mid;
        }
        return -1;
    }

    public void delete(Comparable remove)
    {
        int deleteIndex = 0;

        if (top == -1)
        {
            System.out.println("The array is already empty!");
        }
        else
        {
            deleteIndex = find(remove);
        
            if (deleteIndex == -1)
            {
                System.out.println("That data item was not found in the array.");
            }
            else
            {
                for (int n = deleteIndex; n < top; n++)
                {
                    initial[n] = initial[n+1];
                }

                top = top - 1;
            }
        }
    }

    public void clear()
    {
        top = -1;
    }

    public boolean full()
    {
        if (top == initial.length-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean empty()
    {
        if (top == -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
