package lotto.lottery.domain;

import static lotto.global.util.ErrorMessage.INVALID_AMOUNT;
import static lotto.global.util.ErrorMessage.INVALID_AMOUNT_RANGE;
import static lotto.global.util.LottoConst.MAX_PRICE;
import static lotto.global.util.LottoConst.MIN_PRICE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoValidatorTest {

    @Test
    @DisplayName("1000원 단위라면 정상적으로 작동한다")
    void normalLottoPrice() throws Exception {
        // given
        int amount = 5000;

        // then
        assertDoesNotThrow(() -> LottoValidator.validate(amount));
    }

    @ParameterizedTest
    @DisplayName("1000원 단위가 아니라면 에러를 반환한다")
    @MethodSource("providedInvalidAmount")
    void invalidAmountError(int amount) throws Exception {
        // then
        assertThatThrownBy(() -> LottoValidator.validate(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_AMOUNT.getMessage());
    }

    private static Stream<Arguments> providedInvalidAmount(){
        return Stream.of(
                Arguments.arguments(1500),
                Arguments.arguments(5200),
                Arguments.arguments(8900),
                Arguments.arguments(4100)
        );
    }

    @ParameterizedTest
    @DisplayName("구매 금액이 1,000 ~ 100,000 사이라면 정상적으로 작동한다")
    @MethodSource("providedPurchaseLotto")
    void purchaseLotto(int amount) throws Exception {
        // then
        assertDoesNotThrow(() -> LottoValidator.validate(amount));
    }

    private static Stream<Arguments> providedPurchaseLotto(){
        return Stream.of(
                Arguments.arguments(1000),
                Arguments.arguments(100_000),
                Arguments.arguments(99_000)
        );
    }

    @ParameterizedTest
    @DisplayName("구매 금액이 1,000 ~ 100,000가 아니라면 에러를 반환한다")
    @MethodSource("providedPurchaseOutOfRange")
    void purchaseLottoOutOfRange(int amount) throws Exception {
        // then
        assertThatThrownBy(() -> LottoValidator.validate(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(INVALID_AMOUNT_RANGE.getMessage(), MIN_PRICE,MAX_PRICE));
    }

    private static Stream<Arguments> providedPurchaseOutOfRange(){
        return Stream.of(
                Arguments.arguments(0),
                Arguments.arguments(-3000),
                Arguments.arguments(101_000)
        );
    }

}