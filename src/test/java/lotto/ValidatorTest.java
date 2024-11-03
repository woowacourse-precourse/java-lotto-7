package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.common.Validator;

class ValidatorTest {

    @Test
    void checkLottoNumber_1이상_45이하가_아닌_경우() {
        int[] failCases = {-1, 0, 46};

        for (int failCase : failCases) {
            assertThatThrownBy(() -> Validator.checkLottoNumber(failCase))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void checkValidPurchaseCount_1000으로_나누어_떨어지지_않는_경우() {
        int[] failCases = {1, 1999, 1050};

        for (int failCase : failCases) {
            assertThatThrownBy(() -> Validator.checkValidPurchaseCount(failCase))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void checkLottoNumbers_중복된_값이_존재하는_경우() {
        assertThatThrownBy(() -> Validator.checkLottoNumbers(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.checkLottoNumbers(List.of(1, 1, 1, 1, 1, 1)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkPositiveNumber_양수가_아닌_경우() {
        int[] failCases = {0, -1, -2};

        for (int failCase : failCases) {
            assertThatThrownBy(() -> Validator.checkPositiveNumber(failCase))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void checkWinningNumber_보너스_숫자와_당첨_숫자가_중복() {
        assertThatThrownBy(() -> Validator.checkWinningNumber(List.of(1, 2, 3, 4, 5, 6), 1))
            .isInstanceOf(IllegalArgumentException.class);
    }
}