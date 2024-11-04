package lotto;

import lotto.validator.NumberValidator;
import lotto.validator.WinningNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class WinnigNumberValidatorTest {
    @DisplayName("쉼표가 2개 연속되면 예외가 발생한다.")
    @Test
    void doubleComma() {
        //given
        String case1 = "1,2,,";
        String case2 = "1,,2";
        String case3 = "1,2";
        String message = "쉼표(,)가 연속";

        //when
        final Throwable thrown1 = catchThrowable(() -> {
            WinningNumberValidator.validateInputComma(case1);
        });
        final Throwable thrown2 = catchThrowable(() -> {
            WinningNumberValidator.validateInputComma(case2);
        });
        final Throwable thrown3 = catchThrowable(() -> {
            WinningNumberValidator.validateInputComma(case3);
        });

        //then
        assertThat(thrown1)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(message);
        assertThat(thrown2)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(message);
        assertThat(thrown3)
                .doesNotThrowAnyException();
    }

    @DisplayName("쉼표가 첫 문자이면 예외가 발생한다.")
    @Test
    void firstComma() {
        //given
        String case1 = ",1,2";
        String message = "쉼표(,) 앞에는 숫자";

        //when
        final Throwable thrown1 = catchThrowable(() -> {
            WinningNumberValidator.validateInputComma(case1);
        });

        //then
        assertThat(thrown1)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(message);
    }

    @DisplayName("쉼표가 마지막 문자이면 예외가 발생한다.")
    @Test
    void lastComma() {
        //given
        String case1 = "1,2,";
        String message = "쉼표(,) 뒤에는 숫자";

        //when
        final Throwable thrown1 = catchThrowable(() -> {
            WinningNumberValidator.validateInputComma(case1);
        });

        //then
        assertThat(thrown1)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(message);
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void count() {
        //given
        List<String> case1 = List.of("1", "2", "3", "4", "5", "6", "7");
        List<String> case2 = List.of("1", "2", "3", "4", "5");
        List<String> case3 = List.of("1", "2", "3", "4", "5", "6");
        String message = "로또 번호는 6개";

        //when
        final Throwable thrown1 = catchThrowable(() -> {
            WinningNumberValidator.validateInputWinningNumber(case1);
        });
        final Throwable thrown2 = catchThrowable(() -> {
            WinningNumberValidator.validateInputWinningNumber(case2);
        });
        final Throwable thrown3 = catchThrowable(() -> {
            WinningNumberValidator.validateInputWinningNumber(case3);
        });

        //then
        assertThat(thrown1)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(message);
        assertThat(thrown2)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(message);
        assertThat(thrown3)
                .doesNotThrowAnyException();
    }

    @DisplayName("중복되는 당첨 번호가 존재하면 예외가 발생한다.")
    @Test
    void winningNumberDuplication() {
        //given
        List<String> case1 = List.of("1", "2", "3", "4", "5", "5");
        String message = "중복";

        //when
        final Throwable thrown1 = catchThrowable(() -> {
            WinningNumberValidator.validateInputWinningNumber(case1);
        });

        //then
        assertThat(thrown1)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(message);
    }

    @DisplayName("문자열 리스트를 정수형 리스트로 반환한다.")
    @Test
    void inputWinningNumber() {
        //given
        List<String> case1 = List.of("1", "2", "3", "4", "5", "6");
        List<Integer> result = List.of(1, 2, 3, 4, 5, 6);

        //when
        List<Integer> test = WinningNumberValidator.validateInputWinningNumber(case1);

        //then
        assertThat(test).isEqualTo(result);
    }

    @DisplayName("중복되는 당첨 번호가 존재하면 예외가 발생한다.")
    @Test
    void bonusNumberDuplication() {
        //given
        List<Integer> mainNumber = List.of(1, 2, 3, 4, 5, 6);
        Integer case1_bonusNumber = 1;
        Integer case2_bonusNumber = 7;
        String message = "중복";

        //when
        final Throwable thrown1 = catchThrowable(() -> {
            WinningNumberValidator.validateBonusDuplication(mainNumber, case1_bonusNumber);
        });
        final Throwable thrown2 = catchThrowable(() -> {
            WinningNumberValidator.validateBonusDuplication(mainNumber, case2_bonusNumber);
        });

        //then
        assertThat(thrown1)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(message);
        assertThat(thrown2)
                .doesNotThrowAnyException();
    }

}
