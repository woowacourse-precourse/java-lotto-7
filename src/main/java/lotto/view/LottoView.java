package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.format.MessageFormatter;
import lotto.message.Message;
import lotto.processor.InputProcessor;

public class LottoView {

    public <T> T input(InputProcessor<T> processor) {
        try {
            return processor.process(Console.readLine());
        } catch (IllegalArgumentException e) {
            print(e.getMessage());
            return input(processor);
        }
    }

    public <T> void output(MessageFormatter<T> formatter, T target) {
        print(formatter.format(target));
    }

    public void print(Message message, Object... args) {
        print(message.getFormatMessage(args));
    }

    public void print(Message message) {
        print(message.getMessage());
    }

    private void print(String message) {
        System.out.println(message);
    }
}
