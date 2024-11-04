package lotto.util;

import lotto.constants.PurchaseAmountErrorMessage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constants.LottoErrorMessage.*;
import static lotto.constants.PurchaseAmountErrorMessage.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ValidatorTest {

    @Test
    void zeroTest() {
        //given
        int input = 0;
        // when & then
        assertThatThrownBy(() -> Validator.validateTotalAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BELOW_MINIMUM_AMOUNT.getMessage());
    }

    @Test
    void hasMinimumTest() {
        // given
        int input = 999;
        // when & then
        assertThatThrownBy(() -> Validator.validateTotalAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BELOW_MINIMUM_AMOUNT.getMessage());
    }

    @Test
    void isDivisibleByMinimumAmountTest() {
        // given
        int input = 1999;
        // when & then
        assertThatThrownBy(() -> Validator.validateTotalAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_DIVISIBLE_BY_MINIMUM.getMessage());
    }

    @Test
    void sizeTest() {
        // given
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // when & then
        assertThatThrownBy(() -> Validator.validateIntList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER_SIZE.getMessage());
    }

    @Test
    void duplicateTest() {
        // given
        List<Integer> input = List.of(1, 2, 3, 4, 5, 5);
        // when & then
        assertThatThrownBy(() -> Validator.validateIntList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_INPUT_NUMBER.getMessage());
    }

    @Test
    void rangeTest() {
        // given
        List<Integer> input = List.of(1,12,3,4,5,46);
        // when & then
        assertThatThrownBy(() -> Validator.validateIntList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_OUT_OF_RANGE.getMessage());
    }
}