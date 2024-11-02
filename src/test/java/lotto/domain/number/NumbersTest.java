package lotto.domain.number;

import static lotto.resources.Constants.LOTTO_MAX_NUMBER;
import static lotto.resources.Constants.LOTTO_MIN_NUMBER;
import static lotto.resources.ErrorMessages.INVALID_RANGE_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {
    @DisplayName("정상 범위의 숫자들을 생성해 본다.")
    @Test
    void 정상_범위의_숫자들을_생성해_본다() {
        List<Integer> validNumbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toUnmodifiableList());

        Numbers numbers = Numbers.of(validNumbers);

        assertThat(numbers).isEqualTo(Numbers.of(validNumbers));
    }

    @DisplayName("정상 범위를 벗어난 숫자들로 Numbers 를 생성하면 예외가 발생한다.")
    @Test
    void 정상_범위를_벗어난_숫자들로_Numbers를_생성하면_예외가_발생한다() {
        List<Integer> invalidNumbers = IntStream.rangeClosed(0, 45).boxed().collect(Collectors.toUnmodifiableList());

        Assertions.assertThatThrownBy(() -> Numbers.of(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RANGE_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("난수들은 로또 번호의 범위 안에서 생성된다.")
    @Test
    void 난수들은_로또_번호의_범위_안에서_생성된다() {
        Numbers numbers = Numbers.generateSixRandomNumbers();

        for (Number number : numbers.getNumbers()) {
            assertTrue(number.getNumber() >= LOTTO_MIN_NUMBER && number.getNumber() <= LOTTO_MAX_NUMBER);
        }
    }
}
