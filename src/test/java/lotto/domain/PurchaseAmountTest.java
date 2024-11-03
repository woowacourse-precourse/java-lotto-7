package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseAmountTest {

    @DisplayName("입력된 로또 구매 금액이 1000원 단위가 아닐 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1001", "10100", "100100", "100110"})
    void validateDivisibleByThousand(String inputPurchaseAmount) {
        Assertions.assertThatThrownBy(() -> PurchaseAmount.from(inputPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 구매 금액은 1000원 단위로 입력해야 합니다.");
    }
}
