package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @Test
    @DisplayName("머니가 빈 공백이면 예외를 던진다.")
    void testBlankInputThrowsException() {
        assertThatThrownBy(() -> new LottoTickets("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_MONEY);
    }

    @Test
    @DisplayName("머니가 특수문자이면 예외를 던진다.")
    void testSpecialCharacterInputThrowsException() {
        assertThatThrownBy(() -> new LottoTickets("#@"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_MONEY);
    }

    @Test
    @DisplayName("머니가 음수이면 예외를 던진다.")
    void testNegativeNumberThrowsException() {
        assertThatThrownBy(() -> new LottoTickets("-12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_MONEY);
    }

    @Test
    @DisplayName("머니가 0이면 예외를 던진다.")
    void testZeroNumberThrowsException() {
        assertThatThrownBy(() -> new LottoTickets("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_MONEY);
    }
}