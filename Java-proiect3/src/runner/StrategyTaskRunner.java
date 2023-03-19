package runner;

import container.Container;
import container.Strategy;
import factory.TaskContainerFactory;
import model.Task;

public class StrategyTaskRunner implements TaskRunner {
    private Container container;

    public StrategyTaskRunner(Strategy strategy) //returnez container folosind unicul obiect TaskContainerFactory
    {
        this.container = TaskContainerFactory.getInstance().createContainer(strategy);
    }

    @Override
    public void executeOneTask() {
        if (!container.isEmpty()) { //daca containerul nu este gol
            container.remove().execute(); //iau taskul din container si il execut
        }
    }
    @Override
    public void executeAll()
    { while(!container.isEmpty())
        executeOneTask();

    }

    @Override
    public void addTask(Task task)  //ii dau runnerului taskuri , iar el le adauga in container
    {container.add(task);
    }
    @Override
    public boolean hasTask()  //verific daca containerul are un task
    {return !container.isEmpty();
    }
}
