package container;

import model.Task;

import static utils.Constants.INITIAL_QUEUE_SIZE;

public class QueueContainer extends ContainerSuperClass implements Container{
    public QueueContainer()
        {size=0;
            tasks=new Task[INITIAL_QUEUE_SIZE];
        }
    @Override
    public Task remove()
    {if (!isEmpty())
        {Task toReturn=tasks[0];
            for (int i=0;i<tasks.length-1;i++)
                tasks[i]=tasks[i+1];
            size--;
            return toReturn;

        }
    return null;
    }
     /*
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
     */
}
