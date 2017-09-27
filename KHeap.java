import korat.finitization.*;
import korat.finitization.impl.*;
import java.util.Arrays;

public class KHeap {
    private int k;
    private int size;
    private int array[];

    public boolean repOK() {
        // returns true if the node, shape and heap properties are satisfied
        // Your code goes here
        if (array == null)
            return false;
        if (size < 0 || size > array.length)
            return false;
        for (int i = 0; i < size; i++) {
            int elem_i = array[i];
            if (elem_i == -1)
                return false;
            if (i > 0) {
                int elem_parent = array[(i - 1) / k];
                if (elem_i > elem_parent)
                    return false;
            }
        }
        for (int i = size; i < array.length; i++)
            if (array[i] != -1)
                return false;
        return true;
    }

    public static IFinitization finKHeap(int k, int maxSize, int maxArrayLength, int maxArrayValue) {
        IFinitization f = FinitizationFactory.create(KHeap.class);
        IIntSet ks = f.createIntSet(k, k);
        IIntSet sizes = f.createIntSet(0, 1, maxSize);
        IIntSet arrayLength = f.createIntSet(0, 1, maxArrayLength);
        IIntSet arrayValues = f.createIntSet(-1, 1, maxArrayValue);
        IArraySet arrays = f.createArraySet(int[].class, arrayLength, arrayValues, 1);
        f.set("k", ks);
        f.set("size", sizes);
        f.set("array", arrays);
        
        return f;
    }

    public String toString(){
    // Override of toString().  You may optionally complete this method to support printing heaps at the command line.
        return "My Heap: K:";//+ k + " Size:" + size;
    }
}

