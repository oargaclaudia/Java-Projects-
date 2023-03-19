package runner;

import runner.AbstractTaskRunner;
import utils.Constants;

import java.time.LocalDateTime;

public class DelayTaskRunner extends AbstractTaskRunner {
    public DelayTaskRunner(TaskRunner runner) {
        super(runner);
    }

    @Override
    public void executeOneTask() {
        runner.executeOneTask();
        decorateExecuteOneTask();
    }

    private void decorateExecuteOneTask() {
        System.out.println("Task-ul se va executa cu intarziere: ");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
