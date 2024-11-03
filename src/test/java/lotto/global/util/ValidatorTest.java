package lotto.global.util;

import static lotto.global.constant.ErrorMessage.DIVISION_BY_ZERO;
import static lotto.global.constant.ErrorMessage.DUPLICATE_NUMBER_EXIST;
import static lotto.global.constant.ErrorMessage.LOTTO_PRICE_DIVISIBILITY;
import static lotto.global.constant.ErrorMessage.NUMBER_FORMAT_PROBLEM;
import static lotto.global.constant.ErrorMessage.PRICE_CAN_NOT_BE_MINUS;
import static lotto.global.constant.ErrorMessage.PRICE_CAN_NOT_BE_ZERO;
import static lotto.global.util.Validator.validateBonusNumber;
import static lotto.global.util.Validator.validatePrice;
import static lotto.global.util.Validator.validateRateOfReturn;
import static lotto.global.util.Validator.validateWinningNumber;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    @Test
    void 로또_구입_금액이_숫자_형식이_아닐_때_예외_발생() {
        //given
        String input = "hello";

        //then
        Assertions.assertThatThrownBy(() -> validatePrice(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_FORMAT_PROBLEM);
    }

    @Test
    void 로또_구입_금액이_1000원으로_나누어_떨어지지_않을_때_예외_발생() {
        //given
        String input = "1100";

        //then
        Assertions.assertThatThrownBy(() -> validatePrice(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_PRICE_DIVISIBILITY);
    }

    @Test
    void 중복된_당첨번호가_있을_때_예외_발생() {
        //given
        List<String> winningNumber = Arrays.asList("1", "1", "2", "3", "4", "5");

        //then
        Assertions.assertThatThrownBy(() -> validateWinningNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_NUMBER_EXIST);
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복되었을_때_예외_발생() {
        //given
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        String bonusNumber = "6";

        //then
        Assertions.assertThatThrownBy(() -> validateBonusNumber(winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_NUMBER_EXIST);
    }

    @Test
    void 당첨_번호가_숫자형식이_아닐_때_예외_발생() {
        //given
        List<String> winningNumber = Arrays.asList("a", "1", "2", "3", "4", "5");

        //then
        Assertions.assertThatThrownBy(() -> validateWinningNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_FORMAT_PROBLEM);
    }

    @Test
    void 보너스_번호가_숫자형식이_아닐_때_예외_발생() {
        //given
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        String bonusNumber = "a";

        //then
        Assertions.assertThatThrownBy(() -> validateBonusNumber(winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_FORMAT_PROBLEM);
    }

    @Test
    void 수익률_계산시_투자_금액이_0일_때_예외_발생() {
        //given
        int investmentMoney = 0;

        //then
        Assertions.assertThatThrownBy(() -> validateRateOfReturn(investmentMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DIVISION_BY_ZERO);
    }

    @Test
    void 구매_가격이_0일_때_예외_발생() {
        //given
        String price = "0";

        //then
        Assertions.assertThatThrownBy(() -> validatePrice(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PRICE_CAN_NOT_BE_ZERO);
    }

    @Test
    void 구매_가격이_음수일_때_예외_발생() {
        //given
        String price = "-1000";

        //then
        Assertions.assertThatThrownBy(() -> validatePrice(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PRICE_CAN_NOT_BE_MINUS);
    }
}