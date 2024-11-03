package lotto.system;

import static lotto.system.lottoGetter.LottoPaymentValidator.ERROR_INSUFFICIENT_PAYMENT;
import static lotto.system.lottoGetter.LottoPaymentValidator.ERROR_INVALID_MULTIPLE_OF_TICKET_PRICE;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> LottoPaymentValidator.validate(insufficientPayment));
        assertEquals(ERROR_INSUFFICIENT_PAYMENT, exception.getMessage());
    }

    @Test
    @DisplayName("로또 구매 금액이 티켓 가격의 배수가 아닐 경우 예외 발생")
    void validate_NotMultipleOfTicketPrice_ShouldThrowException() {

        // given : 티켓 가격의 배수가 아닌 금액
        int notMultipleOfTicketPrice = 2500;

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> LottoPaymentValidator.validate(notMultipleOfTicketPrice));
        assertEquals(ERROR_INVALID_MULTIPLE_OF_TICKET_PRICE, exception.getMessage());
    }
}