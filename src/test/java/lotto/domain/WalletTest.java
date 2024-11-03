package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WalletTest {

    @DisplayName("구입 금액의 단위가 1000원이 아닐 경우 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10, 100, -1, -99, -1000})
    void 구입_금액의_단위가_1000원이_아닐_경우_예외를_발생한다(Integer input) {
        assertThatThrownBy(() -> new Wallet(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}