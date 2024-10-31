package lotto.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7"})
    void 숫자_검증_성공(String input) {
        List<Integer> numbers = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();

        assertThat(Validator.validateNumbers(numbers.subList(0, numbers.size() - 1))).isTrue();
        assertThat(Validator.validateBonusNumber(
                numbers.subList(0, numbers.size() - 1), numbers.get(numbers.size() - 1)
        )).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5,6", "1,1,2,3,4,5,6", "1,2,3,4,5,6,6", "1,2,3,4,5,6", "1,2,3,4,5,6,0"
            , "1,2,3,4,5,46,6"})
    void 숫자_예외_테스트(String input) {
        List<Integer> numbers = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();

        assertThatThrownBy(() -> {
                    Validator.validateNumbers(numbers.subList(0, numbers.size() - 1));
                    Validator.validateBonusNumber(
                            numbers.subList(0, numbers.size() - 1), numbers.get(numbers.size() - 1));
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 5000, 3000, 12000, 0})
    void 금액_검증_성공(Integer input) {
        assertThat(Validator.validateMoney(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, 1100})
    void 금액_예외_테스트(Integer input) {
        assertThatThrownBy(() ->
                Validator.validateMoney(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}