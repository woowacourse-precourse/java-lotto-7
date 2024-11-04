package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.domain.lotto.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {

    @DisplayName("구입금액 입력 실패 : 문자 입력")
    @Test
    void toIntTest() {
        String rawPurchaseAmount = "aaa";

        assertThatThrownBy(() -> new PurchaseAmount(rawPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액을 숫자로 입력해주세요.");
    }

    @DisplayName("구입금액 입력 실패 : 1000원으로 나눠지지 않는 수 입력")
    @Test
    void validateDivisibleByThousandTest() {
        String rawPurchaseAmount = "3030";

        assertThatThrownBy(() -> new PurchaseAmount(rawPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액을 1000원 단위로 입력해주세요.");
    }

    @DisplayName("구입금액에 따른 로또 개수를 반환한다.")
    @Test
    void calculateLottoCountTest() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("3000");

        int lottoCount = purchaseAmount.calculateLottoCount();

        assertThat(lottoCount).isEqualTo(3);
    }
}
