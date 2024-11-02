package lotto.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class WalletTest {
    private static Stream<Arguments> normalWalletMoneyArguments() {
        return Stream.of(
            Arguments.arguments("1000", 1),
            Arguments.arguments("8000", 8),
            Arguments.arguments("230000", 230),
            Arguments.arguments("0001000", 1)
        );
    }
    @ParameterizedTest(name = "구입 금액: {0}, 결과: {1}")
    @MethodSource("normalWalletMoneyArguments")
    void 정상_테스트(String moneyInput, Integer purchaseAmount) {
        // given, when
        Wallet wallet = new Wallet(moneyInput);
        // then
        assertThat(wallet.getAffordableLottoAmount()).isEqualTo(purchaseAmount);
        
    }
}
