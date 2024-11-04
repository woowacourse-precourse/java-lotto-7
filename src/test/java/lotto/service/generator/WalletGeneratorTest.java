package lotto.service.generator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @DisplayName("로또 구입 금액을 올바르게 입력했을 경우 결과를 반환한다.")
    @Test
    void 로또_구입_금액을_올바르게_입력했을_경우_결과를_반환한다() {
        String money = "123000";
        Integer correctMoney = 123000;

        WalletGenerator walletGenerator = WalletGenerator.create(money);

        assertThat(walletGenerator.getWallet().getMoney()).isEqualTo(correctMoney);
    }
}