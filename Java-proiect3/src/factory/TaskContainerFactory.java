package factory;

import container.Container;
import container.QueueContainer;
import container.StackContainer;
import container.Strategy;

public class TaskContainerFactory implements Factory{
    private static TaskContainerFactory factory=new TaskContainerFactory();
    private TaskContainerFactory(){}

    public static TaskContainerFactory getInstance()
    {return factory;
    }
    @Override
    public Container createContainer(Strategy strategy)
    { if (strategy==Strategy.LIFO)
        return new StackContainer();
      else if (strategy == Strategy.FIFO)
          return new QueueContainer();
      return null;
    }











}
