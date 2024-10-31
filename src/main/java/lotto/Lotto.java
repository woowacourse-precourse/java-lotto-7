package lotto;

import exception.Message;
import java.util.List;
import java.util.stream.Stream;

public class Lotto {
    private final Price price;

    public int getPrice() {
        return Price.PRICE;
    }

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        this.price = new Price();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            exception.Message message = new exception.Message(Stream.of(numbers).toString());
            String exceptionMessage = message.getMessage(Message.INVALID_CHOICE);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    class Price {
        final static int PRICE = 1000;
    }// TODO: 추가 기능 구현
}
