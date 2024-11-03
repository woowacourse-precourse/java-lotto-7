package global.io.console;

import global.io.OutputHandler;

import java.util.List;

public class ConsoleOutputHandler implements OutputHandler {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printList(List<?> list) {
        System.out.println(list);
    }
}
