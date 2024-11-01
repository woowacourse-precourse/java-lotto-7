package lotto.domain.Random;

import static lotto.resources.Constants.LOTTO_MAX_NUMBER;
import static lotto.resources.Constants.LOTTO_MIN_NUMBER;
import static lotto.resources.ErrorMessages.BIGGER_THAN_LOTTO_MAX_NUMBER;
import static lotto.resources.ErrorMessages.SMALLER_THAN_LOTTO_MIN_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {
    @DisplayName("정상 범위의 숫자를 생성해 본다.")
    @Test
    void 정상_범위의_숫자를_생성해_본다() {
        int validNumber = LOTTO_MIN_NUMBER;

        Number number = Number.createNumber(validNumber);

        assertThat(number.getNumber()).isEqualTo(validNumber);
    }

    @DisplayName("숫자가 로또번호 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 랜덤_숫자가_로또번호_범위를_벗어나면_예외가_발생한다() {
        int belowMinNumber = LOTTO_MIN_NUMBER - 1;
        int aboveMaxNumber = LOTTO_MAX_NUMBER + 1;

        Assertions.assertThatThrownBy(() -> Number.createNumber(belowMinNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(SMALLER_THAN_LOTTO_MIN_NUMBER.getMessage());

        Assertions.assertThatThrownBy(() -> Number.createNumber(aboveMaxNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BIGGER_THAN_LOTTO_MAX_NUMBER.getMessage());
    }

    @DisplayName("난수는 로또 번호의 범위 안에서 생성된다.")
    @Test
    void 난수는_로또_번호의_범위_안에서_생성된다() {
        Number randomNumber = Number.generateRandomNumber();

        assertTrue(randomNumber.getNumber() >= LOTTO_MIN_NUMBER && randomNumber.getNumber() <= LOTTO_MAX_NUMBER);
    }
}
