package lotto;

import static lotto.ErrorMessage.NOT_ENOUGH_PURCHASE_AMOUNT;
import static lotto.ErrorMessage.PURCHASE_AMOUNT_EXCEED_LIMIT;
import static lotto.ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_LOTTO_PRICE;
import static lotto.LottoMachine.LOTTO_PRICE;
import static lotto.LottoMachine.MAX_PURCHASE_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @DisplayName("PurchaseAmount는_구입_금액이_로또_한_장의_가격보다_적으면_예외를_발생한다")
    @Test
    public void should_ThrowException_WhenAmountIsLessThanLottoPrice() {
        //given
        int purchaseAmount = LOTTO_PRICE - 50;

        //when
        //then
        assertThatThrownBy(() -> PurchaseAmount.of(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ENOUGH_PURCHASE_AMOUNT.getMessage());
    }

    @DisplayName("PurchaseAmount는_구입_금액이_로또_가격의_배수가_아니면_예외를_발생한다")
    @Test
    public void should_ThrowException_WhenAmountIsNotMultipleLottoPrice() {
        //given
        int purchaseAmount = LOTTO_PRICE + 1234;

        //when
        //then
        assertThatThrownBy(() -> PurchaseAmount.of(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_AMOUNT_NOT_MULTIPLE_LOTTO_PRICE.getMessage());
    }

    @DisplayName("PurchaseAmount는_구입_금액이_최대_구입금액을_초과한_경우_예외를_발생한다")
    @Test
    public void should_ThrowException_WhenAmountExceedLimit() {
        //given
        int purchaseAmount = MAX_PURCHASE_AMOUNT + 1000;

        //when
        //then
        assertThatThrownBy(() -> PurchaseAmount.of(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_AMOUNT_EXCEED_LIMIT.getMessage());
    }

    @DisplayName("PurchaseAmount는_구입_금액에_따른_로또_구입_개수를_반환할_수_있다")
    @Test
    public void calculateTotalLottoCount() {
        //given
        PurchaseAmount purchaseAmount = PurchaseAmount.of(LOTTO_PRICE * 2);

        //when
        int result = purchaseAmount.calculateTotalLottoCount();

        //then
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("PurchaseAmount는_당첨_금액을_받아_수익률을_계산하고_반환할_수_있다")
    @Test
    public void calculateReturnRate() {
        //given
        PurchaseAmount purchaseAmount = PurchaseAmount.of(LOTTO_PRICE);

        //when
        double result = purchaseAmount.calculateReturnRate(LOTTO_PRICE * 4);

        //then
        assertThat(result).isEqualTo(400.0);
    }
}