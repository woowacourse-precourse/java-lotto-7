package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class WalletTest {
    private static final Stream<Arguments> normalWalletMoneyArguments() {
        return Stream.of(
            Arguments.arguments(1000, 1),
            Arguments.arguments(8000, 8),
            Arguments.arguments(230000, 230),
            Arguments.arguments(1000000, 1000)
        );
    }
    @ParameterizedTest(name = "구입 금액: {0}, 결과: {1}")
    @DisplayName("구입 금액에 따른 로또 구매 갯수 테스트")
    @MethodSource("normalWalletMoneyArguments")
    void 정상_테스트(Integer moneyInput, Integer purchaseAmount) {
        // given, when
        Wallet wallet = new Wallet(moneyInput);
        // then
        assertThat(wallet.getAffordableLottoAmount()).isEqualTo(purchaseAmount);
        
    }

    private static final Stream<Arguments> exceptionWalletMoneyArguments() {
        return Stream.of(
            Arguments.arguments("1000단위 숫자를 입력하지 않았을 때", 1300),
            Arguments.arguments("1000원보다 작은 값을 입력했을 때", 800),
            Arguments.arguments("너무 큰 수를 입력했을 때", 10000000),
            Arguments.arguments("음수를 입력했을 때", -10000)
        );
    }

    @ParameterizedTest(name = "구입 금액: {0}")
    @DisplayName("구입 금액 예외 테스트")
    @MethodSource("exceptionWalletMoneyArguments")
    void exceptionTest(String caseName, Integer moneyInput) {
        assertThatThrownBy(() -> new Wallet(moneyInput)).isInstanceOf(IllegalArgumentException.class);
    }
}
