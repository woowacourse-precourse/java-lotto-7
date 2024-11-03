package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import lotto.exception.IllegalPriceDivideException;
import lotto.exception.IllegalPriceNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("구매 가격에 관한 기능을 확인한다.")
class PurchasePriceTest {

    @ParameterizedTest
    @DisplayName("금액 입력의 예외를 확인한다.")
    @MethodSource("providePrice")
    void validatePriceException(String price, IllegalArgumentException exception) {
        assertThatThrownBy(() -> PurchasePrice.validatePrice(price))
                .isInstanceOf(exception.getClass());
    }

    private static Stream<Arguments> providePrice() {
        return Stream.of(
                Arguments.of("1000j", new IllegalPriceNumberException()),
                Arguments.of("1200", new IllegalPriceDivideException())
        );
    }

    @Test
    @DisplayName("정상적인 입력을 받았을 때 동작을 확인한다.")
    void validatePrice() {
        //when
        PurchasePrice purchasePrice = PurchasePrice.validatePrice("1000");

        //then
        assertThat(purchasePrice.value()).isEqualTo(1000);
    }
}