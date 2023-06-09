package runner;

import runner.AbstractTaskRunner;
import utils.Constants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrinterTaskRunner extends AbstractTaskRunner {
    public PrinterTaskRunner(TaskRunner runner)
    {super(runner);
    }

    @Override
    public void executeOneTask()
    {runner.executeOneTask();
        decorateExecuteOneTask();
    }

    private void decorateExecuteOneTask() {
        System.out.println("Task-ul a fost executat la: "+ LocalDateTime.now().format(Constants.DATE_TIME_FORMATTER));
    }
}
