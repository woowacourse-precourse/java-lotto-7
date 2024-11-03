package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {

    @DisplayName("구입금액 입력 실패 : 문자 입력")
    @Test
    void toIntTest() {
        String rawPurchaseAmount = "aaa";

        assertThatThrownBy(() -> new PurchaseAmount(rawPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] " + "구입금액을 숫자로 입력해주세요.");
    }
}
