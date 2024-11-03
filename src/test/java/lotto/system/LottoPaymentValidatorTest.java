package lotto.system;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.system.lottoGetter.LottoPaymentValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPaymentValidatorTest {

    @Test
    @DisplayName("로또 구매 금액이 배수일 경우 통과")
    void validate_ValidPayment_ShouldPass() {

        // given : 티켓 가격의 배수
        int validPayment = 3000;

        // when & then
        assertDoesNotThrow(() -> LottoPaymentValidator.validate(validPayment));
    }

    @Test
    @DisplayName("로또 구매 금액이 티켓 가격보다 적을 경우 예외 발생")
    void validate_InsufficientPayment_ShouldThrowException() {

        // given : 티켓 가격보다 적은 금액
        int insufficientPayment = 500;

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> LottoPaymentValidator.validate(insufficientPayment));
    }

    @Test
    @DisplayName("로또 구매 금액이 티켓 가격의 배수가 아닐 경우 예외 발생")
    void validate_NotMultipleOfTicketPrice_ShouldThrowException() {

        // given : 티켓 가격의 배수가 아닌 금액
        int notMultipleOfTicketPrice = 2500;

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> LottoPaymentValidator.validate(notMultipleOfTicketPrice));
    }
}