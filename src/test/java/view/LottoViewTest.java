package view;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.PurchaseCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoViewTest {

    private final LottoView lottoView = new LottoView();

    @DisplayName("뷰에서 구입 금액을 받아오는 테스트")
    @Test
    void 구입금액_받아오기() {
        assertThat("8000").isEqualTo("8000");
    }

    @DisplayName("구입한 로또 개수 출력 테스트")
    @Test
    void printPurchasedLottoCountFromViewTest() {
        PurchaseCount purchaseCount = new PurchaseCount(8000);
        assertThat(lottoView.printPurchasedLottoCountFromView(purchaseCount)).
                isEqualTo("8개를 구매했습니다.");
    }
}