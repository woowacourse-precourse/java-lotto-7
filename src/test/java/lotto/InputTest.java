package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.Input.validateAmount;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
class InputTest {

    @DisplayName("1000원 단위가 아닐 시 Error가 발생한다.")
    @Test
    void testInvalidAmountNotMultipleOfThousand() {

        assertThatThrownBy(() -> validateAmount("14234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 단위여야 합니다."); // 예외 메시지 확인
        // Arrange
    }
  
}