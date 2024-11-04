package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AmountTest {

    @Test
    @DisplayName("로또 구입 금액 - 성공 테스트")
    void testValidPurchaseAmount() {
        //given
        String input = "10000";

        //when
        Amount amount = Amount.of(input);

        //then
        assertThat(amount.getAmount()).isEqualTo(10000);
    }

    @ParameterizedTest(name = "입력: ''{0}'', 메시지: {1}")
    @MethodSource("provideInvalidPurchaseAmount")
    @DisplayName("로또 구입 금액 - 실패 테스트")
    void testInvalidPurchaseAmount(String input, String errorMessage) {
        assertThatThrownBy(() -> Amount.of(input))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(errorMessage);
    }

    private static Stream<Arguments> provideInvalidPurchaseAmount() {
        return Stream.of(
                Arguments.of("", ErrorMessage.BLANK_PURCHASE_AMOUNT.getMessage()),
                Arguments.of("-", ErrorMessage.NOT_NUMERIC_PURCHASE_AMOUNT.getMessage()),
                Arguments.of("-5", ErrorMessage.NEGATIVE_PURCHASE_AMOUNT.getMessage()),
                Arguments.of("1000000000000000", ErrorMessage.TOO_BIG_INPUT.getMessage()),
                Arguments.of("900", ErrorMessage.UNDER_THOUSAND_PURCHASE_AMOUNT.getMessage()),
                Arguments.of("11111", ErrorMessage.NOT_THOUSAND_UNIT_PURCHASE_AMOUNT.getMessage())
        );
    }
}