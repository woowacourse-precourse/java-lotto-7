package lotto.domain;

import static lotto.constants.ErrorMessage.INVALID_PURCHASE_AMOUNT_RANGE;
import static lotto.constants.ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @Test
    void 구입_금액_범위_초과_예외가_발생한다() {
        //give
        int amount = 101000;
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(amount));
        //then
        assertEquals(INVALID_PURCHASE_AMOUNT_RANGE, exception.getMessage());
    }

    @Test
    void 구입_금액_범위_미만_예외가_발생한다() {
        //give
        int amount = 900;
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(amount));
        //then
        assertEquals(INVALID_PURCHASE_AMOUNT_RANGE, exception.getMessage());
    }

    @Test
    void 구입_금액_단위_예외가_발생한다() {
        //give
        int amount = 5900;
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(amount));
        //then
        assertEquals(INVALID_PURCHASE_AMOUNT_UNIT, exception.getMessage());
    }

    @Test
    void 숫자_변환_예외가_발생한다() {
        //give
        String amount = "String";
        //when, then
        assertThrows(NumberFormatException.class, () -> Integer.parseInt(amount));
    }

    @Test
    void 중간_공백_예외가_발생한다() {
        //give
        String amount = "1 2";
        //when, then
        assertThrows(NumberFormatException.class, () -> Integer.parseInt(amount));
    }

    @Test
    void 총_수익률_계산_테스트(){
        //give
        PurchaseAmount purchaseAmount = new PurchaseAmount(5000);

        LottoWinningResult lottoWinningResult = new LottoWinningResult();
        lottoWinningResult.increment(WinningPrize.FOURTH);
        lottoWinningResult.increment(WinningPrize.FIFTH);
        //when
        double totalProfitRate = purchaseAmount.calculateTotalProfitRate(lottoWinningResult);
        //then
        Assertions.assertThat(totalProfitRate).isEqualTo(1100.0);
    }


}