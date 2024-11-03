package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.ArrayList;
import java.util.List;
import lotto.validator.LottoGameValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoGameValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1000", "0", "-123"})
    void checkIsNumericTure(String str) {
        // when
        boolean result = LottoGameValidator.checkIsNumeric(str);

        // then
        assertThat(result)
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000j", "asd", "^d(fd"})
    void checkIsNumericFalse(String str) {
        // when
        Throwable throwable = catchThrowable(() -> {
            LottoGameValidator.checkIsNumeric(str);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_MUST_NUMERIC.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 0, 12000})
    void checkMoneyValidateTrue(int money) {
        // when
        boolean result = LottoGameValidator.checkMoneyValid(money);

        // then
        assertThat(result)
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1500, 50, 12001})
    @DisplayName("구입 금액이 1000으로 나눠떨어지지 않음")
    void checkIsNumericFalse_notDivided1000(int money) {
        // when
        Throwable throwable = catchThrowable(() -> {
            LottoGameValidator.checkMoneyValid(money);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INSERT_MONEY_NOT_DIVIDED_1000.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, -50000, -12000})
    @DisplayName("구입 금액이 음수임")
    void checkIsNumericFalse_minusMoney(int money) {
        // when
        Throwable throwable = catchThrowable(() -> {
            LottoGameValidator.checkMoneyValid(money);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.MONEY_CAN_NOT_MINUS.getMessage());
    }

    @Test
    void checkWinNumbersValidTrue() {
        // given
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        boolean result = LottoGameValidator.checkWinNumbersValid(winNumbers);

        // then
        assertThat(result)
                .isTrue();
    }

    @Test
    @DisplayName("총 당첨 번호가 6개 미만")
    void checkWinNumbersValidFalse_under6() {
        // given
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5);

        // when
        Throwable throwable = catchThrowable(() -> {
            LottoGameValidator.checkWinNumbersValid(winNumbers);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.WIN_NUMBER_SIZE_MUST_6.getMessage());
    }

    @Test
    @DisplayName("총 당첨 번호가 6개 초과")
    void checkWinNumbersValidFalse_up6() {
        // given
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // when
        Throwable throwable = catchThrowable(() -> {
            LottoGameValidator.checkWinNumbersValid(winNumbers);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.WIN_NUMBER_SIZE_MUST_6.getMessage());
    }

    @Test
    @DisplayName("중복된 당첨 번호")
    void checkWinNumbersValidFalse_duplicate() {
        // given
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 5);

        // when
        Throwable throwable = catchThrowable(() -> {
            LottoGameValidator.checkWinNumbersValid(winNumbers);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATE_WIN_NUMBERS.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-3, 0, 47})
    @DisplayName("당첨 번호가 1~45 사이에 있지 않음")
    void checkWinNumbersValidFalse_notBetween(int errorNum) {
        // given
        List<Integer> winNumbers = new ArrayList<>();
        winNumbers.add(1);
        winNumbers.add(2);
        winNumbers.add(3);
        winNumbers.add(4);
        winNumbers.add(5);
        winNumbers.add(errorNum);

        // when
        Throwable throwable = catchThrowable(() -> {
            LottoGameValidator.checkWinNumbersValid(winNumbers);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_BETWEEN_1_AND_45.getMessage());
    }

    @Test
    void checkBonusValidTrue() {
        // given
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        // when
        boolean result = LottoGameValidator.checkBonusValid(bonus, winNumbers);

        // then
        assertThat(result)
                .isTrue();
    }

    @Test
    @DisplayName("당첨번호와 중복된 보너스 번호")
    void checkBonusValid_duplicate() {
        // given
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 6;

        // when
        Throwable throwable = catchThrowable(() -> {
            LottoGameValidator.checkBonusValid(bonus, winNumbers);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BONUS_NUMBER_DUPLICATE_WIN_NUMBERS.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-3, 0, 47})
    @DisplayName("보너스 번호가 1~45 사이에 있지 않음")
    void checkBonusValid_notBetween(int bonus) {
        // given
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        Throwable throwable = catchThrowable(() -> {
            LottoGameValidator.checkBonusValid(bonus, winNumbers);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_BETWEEN_1_AND_45.getMessage());
    }
}
