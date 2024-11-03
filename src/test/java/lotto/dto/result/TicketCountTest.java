package lotto.dto.result;

import static lotto.exception.ErrorMessage.NEGATIVE_OR_ZERO_TICKET_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.CustomIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TicketCountTest {

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @Test
        @DisplayName("유효한 티켓 수가 주어지면 정상적으로 생성된다.")
        void 유효한_티켓_수가_주어지면_정상적으로_생성된다() {
            TicketCount ticketCount = new TicketCount(5);

            assertThat(ticketCount.count()).isEqualTo(5);
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {

        @Test
        @DisplayName("티켓 수가 0일 경우 예외를 발생시킨다.")
        void 티켓_수가_0일_경우_예외를_발생시킨다() {
            assertThatThrownBy(() -> new TicketCount(0))
                    .isInstanceOf(CustomIllegalArgumentException.class)
                    .hasMessage(NEGATIVE_OR_ZERO_TICKET_COUNT.getMessage());
        }

        @Test
        @DisplayName("티켓 수가 음수일 경우 예외를 발생시킨다.")
        void 티켓_수가_음수일_경우_예외를_발생시킨다() {
            assertThatThrownBy(() -> new TicketCount(-3))
                    .isInstanceOf(CustomIllegalArgumentException.class)
                    .hasMessage(NEGATIVE_OR_ZERO_TICKET_COUNT.getMessage());
        }
    }
}
