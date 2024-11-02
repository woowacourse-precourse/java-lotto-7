package lotto.model;

import lotto.enums.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersTest {
    private WinningNumbers winningNumbers;

    @BeforeEach
    void setup() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        winningNumbers = new WinningNumbers(lotto);
    }

    @DisplayName("이미 가지고 있는 로또 번호를 보너스 번호로 입력할 시 예외가 발생한다.")
    @Test
    void setBonusNumber_throwsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> winningNumbers.setBonusNumber(6));
        assertEquals(ExceptionMessage.INVALID_BONUS_NUMBER.getMessage(), exception.getMessage());
    }

}