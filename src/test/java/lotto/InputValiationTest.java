package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.controller.InputValidation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class InputValiationTest {
    private InputValidation inputValidation = new InputValidation();

    @ParameterizedTest
    @NullAndEmptySource
    void 금액_널_체크(String input) {
        assertThatThrownBy(() -> inputValidation.checkInputNull(input))
                .isInstanceOf(NullPointerException.class);
    }

    @ParameterizedTest
    @CsvSource({"5", "12345","0"})
    void 금액_단위_검증(Long input) {
        assertThatThrownBy(() -> inputValidation.checkUnitOfMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"한글", "123h45","-123"})
    void 금액_양식_확인(String input) {
        assertThatThrownBy(() -> inputValidation.checkNumberForm(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,0,7,8,4", "1,2,3,4,5,78"}, delimiter =';')
    void 당첨번호_범위_검증(String input) {
        List<Integer> testNumbers = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
        assertThatThrownBy(() -> inputValidation.checkNumbersRange(testNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"한글", "123h45","1,2,3,4,5,-6","3,4,5,", "2;4,5,33,8,1", "1,2,3,4,5,6,7"})
    void 당첨번호_양식_확인(String input) {
        assertThatThrownBy(() -> inputValidation.checkWinningNumbersForm(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,1,7,8,4", "1,2,3,5,5,5"}, delimiter =';')
    void 당첨번호_중복_검증(String input) {
        List<Integer> testNumbers = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
        assertThatThrownBy(() -> inputValidation.checkUniqueNumbers(testNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,13,7,8,4;4", "1,2,3,32,35,15;15"}, delimiter =';')
    void 보너스번호_중복_검증(String winningNumbers, int bonusNumber) {
        List<Integer> testWinningNumbers = Arrays.stream(winningNumbers.split(",")).map(Integer::parseInt).toList();
        assertThatThrownBy(() -> inputValidation.checkUniqueBetweenWinningAndBonus(testWinningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
