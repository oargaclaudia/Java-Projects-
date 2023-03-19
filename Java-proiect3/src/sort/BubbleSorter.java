package sort;

public class BubbleSorter implements AbstractSorter {
    @Override
    public void Sort(int[] numere)
    {int i, ok=1, aux;
    do {
        ok = 1;
        for (i = 0; i < numere.length - 1; i++) {
            if (numere[i] > numere[i + 1]) {
                aux = numere[i];
                numere[i] = numere[i + 1];
                numere[i + 1] = aux;
                ok = 0;
            }
        }
    } while (ok==0);
    }
}
//sau o alta metoda este sa folosim doua instructiuni de tipul for
//for(i=0; i<n-1; i++)
//    {
//        for(j=0; j<n-i-1; j++)
//        {
//            if(numere[i]numere[i+1])
//            {
//                aux = numere[i];
//                numere[i]=numere[i+1];
//                numere[i+1]=aux;  }
//        }
//    }
