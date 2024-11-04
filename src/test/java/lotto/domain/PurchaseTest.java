package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import lotto.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PurchaseTest {
    static final int NOT_THOUSAND_MULTIPLE = 1010;
    static final int MILLION = 1000000;
    static final int HUNDRED_THOUSAND = 100000;

    @DisplayName("로또 10만원 구매가 정상적인지 확인한다")
    @Test
    void purchaseHundredThousandLotto() {
        //given, when
        Purchase result = new Purchase(HUNDRED_THOUSAND);
        //then
        assertThat(result.getPriceAmount()).isEqualTo(HUNDRED_THOUSAND);
    }

    @DisplayName("""
            구매 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.
            구매 금액이 10만 이상이면 예외가 발생한다.
            """)
    @ParameterizedTest
    @MethodSource("provideErrorCases")
    void purchaseLottoErrorTest(int input, IllegalArgumentException expected) {
        assertThatThrownBy(() -> new Purchase(input))
                .isInstanceOf(expected.getClass())
                .hasMessage(expected.getMessage());
    }

    private static Stream<Arguments> provideErrorCases() {
        return Stream.of(
                Arguments.of(NOT_THOUSAND_MULTIPLE,
                        new IllegalArgumentException(ErrorMessage.NOT_ONE_THOUSAND_MULTIPLE_ERROR.getMessage())),
                Arguments.of(MILLION,
                        new IllegalArgumentException(
                                ErrorMessage.NOT_PURCHASE_MORE_HUNDRED_THOUSAND_ERROR.getMessage()))
        );
    }
}