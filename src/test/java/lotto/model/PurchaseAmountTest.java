package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @DisplayName("구매 금액이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void 구매_금액이_숫자가_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.PURCHASE_AMOUNT_NOT_A_NUMBER.getMessage());
    }

    @DisplayName("구매 금액이 천 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void 구매_금액이_천_단위가_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.PURCHASE_AMOUNT_NOT_IN_UNITS_OF_THOUSAND.getMessage());
    }

    @DisplayName("구매 금액이 0 이하일 경우 예외가 발생한다.")
    @Test
    void 구매_금액이_0_이하일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.PURCHASE_AMOUNT_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("유효한 구매 금액으로 PurchaseAmount 객체를 생성한다.")
    @Test
    void 유효한_구매_금액으로_PurchaseAmount_객체를_생성한다() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("3000");
        assertThat(purchaseAmount.calculatePurchaseLottoCount()).isEqualTo("3");
    }

    @DisplayName("구매 금액이 0일 경우 로또 수량은 0이 된다.")
    @Test
    void 구매_금액이_0일경우_로또_수량은_0이_된다() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("0");
        assertThat(purchaseAmount.calculatePurchaseLottoCount()).isEqualTo("0");
    }
}
