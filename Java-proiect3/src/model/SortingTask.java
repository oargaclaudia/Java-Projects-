package model;

import sort.AbstractSorter;
import sort.BubbleSorter;
import sort.QuickSorter;

public class SortingTask extends Task{
    private int[] Numbers;
    private AbstractSorter sorter;
    public SortingTask(String taskID, String description, int[] numbers) {
        super(taskID, description);  //descrierea imi va da tipul de sorter
        Numbers = numbers;
        if(description.equals("BubbleSort")) sorter= new BubbleSorter();
        else if(description.equals("QuickSort")) sorter= new QuickSorter();
    }

    @Override
    public void execute() {
        sorter.Sort(Numbers);
    }

    public static void main(String[] args){
        int[] arr= new int[]{6, 3, 9, 5,2 ,8 ,7};
       /* SortingTask s= new SortingTask("1", "BubbleSort", arr);
        s.execute();
        for(int a: arr){
            System.out.println(a);
        }*/

        SortingTask s1= new SortingTask("2", "QuickSort", arr);
        s1.execute();
        for(int a: arr){
            System.out.println(a);
        }
    }
}
