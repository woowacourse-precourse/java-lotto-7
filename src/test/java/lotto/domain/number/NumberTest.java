package lotto.domain.number;

import static lotto.resources.Constants.LOTTO_MAX_NUMBER;
import static lotto.resources.Constants.LOTTO_MIN_NUMBER;
import static lotto.resources.ErrorMessages.INVALID_RANGE_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {
    @DisplayName("정상 범위의 숫자를 생성해 본다.")
    @Test
    void 정상_범위의_숫자를_생성해_본다() {
        int validNumber = LOTTO_MIN_NUMBER;

        Number number = NumberFactory.from(validNumber);

        assertThat(number).isEqualTo(NumberFactory.from(validNumber));
    }

    @DisplayName("숫자가 로또번호 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest(name = "입력값: \"{0}\"")
    @ValueSource(ints = {LOTTO_MIN_NUMBER - 1, LOTTO_MAX_NUMBER + 1})
    void 랜덤_숫자가_로또번호_범위를_벗어나면_예외가_발생한다(int number) {
        Assertions.assertThatThrownBy(() -> NumberFactory.from(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RANGE_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("난수는 로또 번호의 범위 안에서 생성된다.")
    @Test
    void 난수는_로또_번호의_범위_안에서_생성된다() {
        Number randomNumber = NumberFactory.generateRandomNumber();

        assertTrue(randomNumber.getNumber() >= LOTTO_MIN_NUMBER && randomNumber.getNumber() <= LOTTO_MAX_NUMBER);
    }
}
