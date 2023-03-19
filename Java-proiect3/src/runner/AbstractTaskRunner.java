package runner;

import model.Task;
import runner.TaskRunner;

public abstract class AbstractTaskRunner implements TaskRunner {

    protected TaskRunner runner;
    public AbstractTaskRunner(TaskRunner runner)
    {this.runner=runner;
    }
    public void executeAll()
    { while (runner.hasTask()) {
        this.executeOneTask();
    }
    }

    @Override
    public void addTask(Task task)
    {runner.addTask(task);
    }

    @Override
    public boolean hasTask()
    {
        return runner.hasTask();
    }

}


