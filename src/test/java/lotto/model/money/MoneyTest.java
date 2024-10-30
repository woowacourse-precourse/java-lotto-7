package lotto.model.money;

import static lotto.error.ErrorMessage.INVALID_UNIT_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.exception.InvalidUnitAmountException;
import lotto.helper.MoneyHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    @DisplayName("8000원 구매시 로또 8장")
    void normalCase1() {
        // given
        Money money = MoneyHelper.mock(8000);

        // when
        long actual = money.calculatePurchasedLottoCount();

        // then
        long expected = 8;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("8500원 구매시 invalidUnitAmount")
    void purchaseAmountIsInvalidAmountUnit() {
        // given
        Money money = MoneyHelper.mock(8500);

        // when & then
        assertThrows(
                InvalidUnitAmountException.class,
                money::calculatePurchasedLottoCount,
                INVALID_UNIT_AMOUNT
        );
    }

}
