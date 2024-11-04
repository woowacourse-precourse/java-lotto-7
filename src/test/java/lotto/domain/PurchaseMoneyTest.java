package lotto.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.constant.NumberConstant.*;

class PurchaseMoneyTest {

    @DisplayName("로또 가격 단위로 구매해야 한다.")
    @Test
    void 구매금액_입력_테스트1() {
        Assertions.assertThatThrownBy(() -> new PurchaseMoney(LOTTO_PRICE + 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 로또 가격 단위로 입력해주세요.");
    }

    @DisplayName("구매 금액은 양수를 입력해야 한다.")
    @Test
    void 구매금액_입력_테스트2() {
        Assertions.assertThatThrownBy(() -> new PurchaseMoney(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수");
    }

    @DisplayName("구매 금액은 10만원 이하로 입력해야 한다.")
    @Test
    void 구매금액_입력_테스트3() {
        Assertions.assertThatThrownBy(() -> new PurchaseMoney(101_000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("재미");
    }
}