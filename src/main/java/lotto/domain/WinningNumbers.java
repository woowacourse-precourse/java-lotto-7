package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.exception.ExceptionHandler;

import java.util.Set;

public class WinningNumbers {

    private final Set<Integer> numbers;
    private Integer bonusNumber;

    public WinningNumbers(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public void setBonusNumber(int bonusNumber) {
        if (numbers.stream()
                .anyMatch(number -> number == bonusNumber)) {
            ExceptionHandler.inputException(ErrorMessage.DUPLICATED_NUMBER);
        }
        this.bonusNumber = bonusNumber;
    }

}
