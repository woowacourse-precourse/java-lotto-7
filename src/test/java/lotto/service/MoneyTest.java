package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @DisplayName("구매금액 1000원 단위로 입력하지 않으면 예외가 발생한다.")
    @Test
    void 구매금액_1000원_단위로_입력하지_않으면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> new Money(3300)).isInstanceOf(IllegalArgumentException.class);
    }

}