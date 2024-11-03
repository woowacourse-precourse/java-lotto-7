package lotto.service.generator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WalletGeneratorTest {

    @DisplayName("로또 구입 금액이 정수가 아닐 경우 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1;2", "10-", "a", "120a1", "ganada"})
    void 로또_구입_금액이_정수가_아닐_경우_예외를_발생한다(String input) {
        assertThatThrownBy(() -> WalletGenerator.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}