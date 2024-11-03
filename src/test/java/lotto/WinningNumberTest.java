package lotto;

import lotto.domain.winning.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WinningNumberTest {

    @Test
    @DisplayName("당첨번호가 숫자가 아니면 예외를 발생시킨다.")
    void validateInputTest() {
        assertThatThrownBy(() -> new WinningNumber("1,2,?,4,5,6","3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호가 1~45 사이 숫자가 아니면 예외를 발생시킨다.")
    void validateRangeTest() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,46","5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호가 중복이되면 예외를 발생시킨다.")
    void validateDuplicateNumberTest() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,5","6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호가 6개가 아니라면 예외를 발생시킨다.")
    void validateSixNumberTest() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5","6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아니면 예외를 발생시킨다.")
    void validateBonusInputTest() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6","6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 1~45 사이 숫자가 아니면 예외를 발생시킨다.")
    void validateBonusRangeTest() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6","46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호가 중복이되면 예외를 발생시킨다.")
    void validateDuplicateBonusNumberTest() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6","6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
