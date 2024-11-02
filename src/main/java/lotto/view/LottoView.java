package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.format.MessageFormatter;
import lotto.message.Message;
import lotto.processor.InputProcessor;

import static lotto.message.SymbolMessage.NEW_LINE;

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

    public void println(Message message, Object... args) {
        print(NEW_LINE.message() + message.format(args));
    }

    public void println(Message message) {
        print(NEW_LINE.message() + message.message());
    }

    public void print(Message message, Object... args) {
        print(message.format(args));
    }

    public void print(Message message) {
        print(message.message());
    }

    private void print(String message) {
        System.out.println(message);
    }
}
