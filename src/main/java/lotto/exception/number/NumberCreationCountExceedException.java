package lotto.exception.number;

public class NumberCreationCountExceedException extends IllegalArgumentException {

    private static final String MESSAGE = "로또 번호는 한번에 %d개까지 생성할 수 있습니다.";

    public NumberCreationCountExceedException(int maxCount) {
        super(String.format(MESSAGE, maxCount));
    }
}
