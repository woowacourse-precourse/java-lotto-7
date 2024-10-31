package lotto.domain;


import lotto.constant.NumberConstant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.constant.NumberConstant.*;

class PurchaseMoneyTest {

    @DisplayName("로또 가격 단위로 구매해야 한다.")
    @Test
    void 구매금액_입력_테스트() {
        Assertions.assertThatThrownBy(() -> new PurchaseMoney(LOTTO_PRICE + 1))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("금액은 로또 가격 단위로 입력해주세요.");
    }
}