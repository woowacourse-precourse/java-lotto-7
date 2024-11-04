package lotto.domain;

import static lotto.message.ErrorMessage.ERROR_BONUS_NUMBER_RANGE;
import static lotto.message.ErrorMessage.ERROR_DUPLICATE_BONUS_NUMBER;
import static lotto.message.ErrorMessage.ERROR_EMPTY_BONUS_NUMBER;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    List<Integer> winningNumbers;

    @BeforeEach
    void setUp() {
        winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("보너스 번호 입력에 성공한다.")
    @Test
    void 보너스_번호_입력_성공() {
        String bonusNumber = "7";

        assertThatCode(() -> BonusNumber.createBonusNumber(winningNumbers, bonusNumber))
                .doesNotThrowAnyException();
    }

    @DisplayName("보너스 번호를 입력하지 않은 경우 예외가 발생한다.")
    @Test
    void 보너스_번호_입력_실패() {
        String bonusNumber = "";

        assertThatThrownBy(() -> BonusNumber.createBonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_EMPTY_BONUS_NUMBER);
    }

    @DisplayName("보너스 번호를 1부터 45 사이의 숫자로 입력하지 않은 경우 예외가 발생한다.")
    @Test
    void 보너스_번호_1_부터_45_사이_예외_발생() {
        String bonusNumber = "46";

        assertThatThrownBy(() -> BonusNumber.createBonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_BONUS_NUMBER_RANGE);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복된 경우 예외가 발생한다.")
    @Test
    void 당첨_번호_보너스_번호_중복_예외_발생() {
        String bonusNumber = "6";

        assertThatThrownBy(() -> BonusNumber.createBonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_DUPLICATE_BONUS_NUMBER);
    }

}