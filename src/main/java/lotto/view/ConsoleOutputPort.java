package lotto.view;

public class ConsoleOutputPort implements OutputPort {

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
