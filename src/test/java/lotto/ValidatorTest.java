package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @Test
    void validateNumericString_정수_문자열() {
        String string = "12345";

        assertThatNoException().isThrownBy(() -> Validator.validateNumericString(string));
    }
    @Test
    void validateNumericString_정수가_아닌_문자열() {
        String string = "abcd";

        assertThatThrownBy(() -> Validator.validateNumericString(string))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validatePositiveNumber_양의_정수() {
        int number = 10;

        assertThatNoException().isThrownBy(() -> Validator.validatePositiveNumber(number));
    }
    @Test
    void validatePositiveNumber_양이_아닌_정수() {
        int number1 = -10;
        int number2 = 0;

        assertThatThrownBy(() -> Validator.validatePositiveNumber(number1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validatePositiveNumber(number2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateThousandUnit_1000으로_나누어_떨어지는_금액() {
        int amount = 12000;

        assertThatNoException().isThrownBy(() -> Validator.validateThousandUnit(amount));
    }
    @Test
    void validateThousandUnit_1000으로_나누어_떨어지지_않는_금액() {
        int amount = 12345;

        assertThatThrownBy(() -> Validator.validateThousandUnit(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNumericStrings_모두_정수로_변환_가능한_문자열() {
        String[] strings = { "1", "2", "3", "4" };

        assertThatNoException().isThrownBy(() -> Validator.validateNumericStrings(strings));
    }
    @Test
    void validateNumericStrings_정수로_변환_불가능한_문자열_포함() {
        String[] strings = { "1", "2", "c", "4" };

        assertThatThrownBy(() -> Validator.validateNumericStrings(strings))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateLottoNumberInRange_범위_내의_값() {
        int number = 20;

        assertThatNoException().isThrownBy(() -> Validator.validateLottoNumberInRange(number));
    }
    @Test
    void validateLottoNumberInRange_범위_밖의_값() {
        int number1 = -10;
        int number2 = 100;

        assertThatThrownBy(() -> Validator.validateLottoNumberInRange(number1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validateLottoNumberInRange(number2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateUniqueNumbers_모두_다른_값() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatNoException().isThrownBy(() -> Validator.validateUniqueNumbers(numbers));
    }
    @Test
    void validateUniqueNumbers_중복되는_값이_존재() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 5, 6));

        assertThatThrownBy(() -> Validator.validateUniqueNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateLottoNumbersInRange_모두_범위_내의_값() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 3, 6, 13, 25, 42));

        assertThatNoException().isThrownBy(() -> Validator.validateLottoNumbersInRange(numbers));
    }
    @Test
    void validateLottoNumbersInRange_범위_밖의_값_포함() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 3, 6, 13, 25, 47));

        assertThatThrownBy(() -> Validator.validateLottoNumbersInRange(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateWinningNumbersCount_6개인_경우() {
        String[] strings = { "1", "2", "3", "4", "5", "6" };

        assertThatNoException().isThrownBy(() -> Validator.validateWinningNumbersCount(strings));
    }
    @Test
    void validateWinningNumbersCount_6개가_아닌_경우() {
        String[] strings1 = { "1", "2", "3", "4", "5" };
        String[] strings2 = { "1", "2", "3", "4", "5", "6", "7" };

        assertThatThrownBy(() -> Validator.validateWinningNumbersCount(strings1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validateWinningNumbersCount(strings2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateLottoNumbersCount_6개인_경우() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 3, 6, 13, 25, 41));

        assertThatNoException().isThrownBy(() -> Validator.validateLottoNumbersCount(numbers));
    }
    @Test
    void validateLottoNumbersCount_6개가_아닌_경우() {
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 3, 6, 13, 25));
        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(1, 3, 6, 13, 25, 41, 43));

        assertThatThrownBy(() -> Validator.validateLottoNumbersCount(numbers1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validateLottoNumbersCount(numbers2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNewNumber_새로운_값() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 3, 6, 13, 25, 42));
        int newNumber = 7;

        assertThatNoException().isThrownBy(() -> Validator.validateNewNumber(numbers, newNumber));
    }
    @Test
    void validateNewNumber_중복되는_값() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 3, 6, 13, 25, 42));
        int newNumber = 13;

        assertThatThrownBy(() -> Validator.validateNewNumber(numbers, newNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}