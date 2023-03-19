package sort;

public class QuickSorter implements AbstractSorter {
    public int partitie(int[] numere, int st, int dr)
    {int aux;
        // select the rightmost element as pivot
        int pivot = numere[dr];

        // pointer for greater element
        int i = st - 1;

        // traverse each element of the array
        // compare them with the pivot
        for (int j = st; j < dr; j++) {
            if (numere[j] <= pivot) {

                // if element smaller than pivot is found
                // swap it with the greater element pointed by i
                i++;

                // swap element at i with element at j
                {
                    aux = numere[i];
                    numere[i] = numere[j];
                    numere[j] = aux;
                }

            }
        }

        // swap pivot with the greater element at i
        {aux=numere[i+1];
            numere[i+1]=numere[dr];
            numere[dr]=aux;}

        // return the partition point
        return (i + 1);

    }
    public void QuickSort(int[]  numere, int st, int dr){
        if(st<dr){
            int pivot= partitie(numere, st, dr);
            QuickSort(numere, st, pivot-1);
            QuickSort(numere, pivot+1, dr);
        }
    }
    @Override
    public void Sort(int[] numere) {
        QuickSort(numere, 0, numere.length-1);
    }

}
