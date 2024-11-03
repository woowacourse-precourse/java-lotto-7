package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;
import lotto.constant.LottoConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PurchasePriceTest {

    @DisplayName("올바른 금액을 통해 객체 생성을 시도")
    @Test
    void 올바른_금액을_통해_객체_생성을_시도() {
        int inputPrice = LottoConfiguration.LOTTO_PRICE * 10;

        PurchasePrice actualPurchasePrice = new PurchasePrice(inputPrice);

        assertThat(actualPurchasePrice.getPrice()).isEqualTo(inputPrice);
    }

    @DisplayName("잘못된 금액을 통해 객체 생성을 시도")
    @ParameterizedTest(name = "금액 {0}을 입력할 경우 : {1}")
    @MethodSource
    void 잘못된_금액을_통해_객체_생성을_시도(int inputPrice, String expectedExceptionMessage) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchasePrice(inputPrice))
                .withMessage(expectedExceptionMessage);
    }

    static Stream<Arguments> 잘못된_금액을_통해_객체_생성을_시도() {
        int priceWithChange = LottoConfiguration.LOTTO_PRICE + (LottoConfiguration.LOTTO_PRICE - 1);
        return Stream.of(
                Arguments.of(0, PurchasePrice.NOT_POSITIVE_PRICE_EXCEPTION_MESSAGE),
                Arguments.of(-1, PurchasePrice.NOT_POSITIVE_PRICE_EXCEPTION_MESSAGE),
                Arguments.of(-1000, PurchasePrice.NOT_POSITIVE_PRICE_EXCEPTION_MESSAGE),
                Arguments.of(priceWithChange, PurchasePrice.EXIST_CHANGE_EXCEPTION_MESSAGE)
        );
    }
}