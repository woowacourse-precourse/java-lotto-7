package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.Message;
import lotto.processor.InputProcessor;

public class LottoView {

    public <T> T input(InputProcessor<T> processor, Message message) {
        try {
            print(message);
            return processor.process(Console.readLine());
        } catch (Exception e) {
            print(e.getMessage());
            return input(processor, message);
        }
    }

    private void print(Message message) {
        print(message.getMessage());
    }

    private void print(String message) {
        System.out.println(message);
    }
}
