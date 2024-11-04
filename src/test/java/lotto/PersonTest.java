package lotto;

import java.util.Arrays;
import lotto.enums.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PersonTest {
    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createPersonWithInvalidAmount() {
        assertThatThrownBy(() -> new Person(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 단위");
    }
    @DisplayName("구입 금액이 1000원 미만이면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 500, 999})
    void createPersonWithLessThanMinimumAmount(int amount) {
        assertThatThrownBy(() -> new Person(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
    }

}