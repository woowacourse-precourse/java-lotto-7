package lotto.view;

import java.util.List;

public class ConsoleOutput {
    public void print(String message) {
        System.out.println(message);
    }

    public void print(List<String> messages) {
        for(String message: messages) {
            print(message);
        }
    }
}
