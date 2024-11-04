package lotto;

import static lotto.constants.ErrorMessage.INVALID_PURCHASE_AMOUNT_RANGE;
import static lotto.constants.ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.domain.PurchaseAmount;
import lotto.domain.WinningPrize;
import lotto.service.LottoWinningResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @DisplayName("최대 구입가능 금액인 10만원이 초과되면 예외를 발생 시킨다")
    @Test
    void 구입_금액_범위_초과_예외() {
        //give
        int amount = 101000;
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(amount));
        //then
        assertEquals(INVALID_PURCHASE_AMOUNT_RANGE, exception.getMessage());
    }

    @DisplayName("최소 구입가능 금액인 1000원 미만이면 예외를 발생 시킨다")
    @Test
    void 구입_금액_범위_미만_예외() {
        //give
        int amount = 900;
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(amount));
        //then
        assertEquals(INVALID_PURCHASE_AMOUNT_RANGE, exception.getMessage());
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외를 발생시킨다")
    @Test
    void 구입_금액_단위_예외() {
        //give
        int amount = 5900;
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(amount));
        //then
        assertEquals(INVALID_PURCHASE_AMOUNT_UNIT, exception.getMessage());
    }

    @DisplayName("IntegerParseInt()메서드는 숫자가 아니면 NumberFormatException 을 던진다")
    @Test
    void 숫자_변환_예외() {
        //give
        String amount = "String";
        //when, then
        assertThrows(NumberFormatException.class, () -> Integer.parseInt(amount));
    }


    @DisplayName("중간에 공백이 있으면 예외를 발생시킨다")
    @Test
    void 중간_공백_예외() {
        //give
        String amount = "1 2";
        //when, then
        assertThrows(NumberFormatException.class, () -> Integer.parseInt(amount));
    }

    @Test
    void 총_수익률_계산(){
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