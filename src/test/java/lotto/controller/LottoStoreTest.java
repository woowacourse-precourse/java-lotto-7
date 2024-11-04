package lotto.controller;

import static lotto.controller.LottoStore.purchaseLottoBundle;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.model.Wallet;

public class LottoStoreTest {

    private static final Stream<Arguments> normalPurchaseLottoBundleArguments() {
        return Stream.of(
            Arguments.arguments(1000, 1),
            Arguments.arguments(1000000, 1000),
            Arguments.arguments(9000, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("normalPurchaseLottoBundleArguments")
    @DisplayName("로또 번들 구매 정상 기능 테스트")
    void purchaseLottoBundleTest(Integer walletMoney, Integer expectedValue) {
        // When
        Wallet wallet = new Wallet(walletMoney);
        // Then
        assertThat(purchaseLottoBundle(wallet).getLottos().size()).isEqualTo(expectedValue);
    }
}
