package container;

import model.Task;

public abstract class ContainerSuperClass implements Container {
    protected Task[] tasks;
    protected int size;

    @Override
    public void add(Task task) {
        if (tasks.length == size) {
            Task[] t = new Task[tasks.length * 2];
            System.arraycopy(tasks, 0, t, 0, tasks.length);
            tasks = t;
        }
        tasks[size] = task;
        size++;
    }

    @Override
    public int size()
    {return size;}

    @Override
    public boolean isEmpty()
    {return size==0;
    }

}