package lotto.application.ticket.domain.ticket;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Ticket - 발행")
class TicketTest {
    private Lottos createLottos() {

        return Lottos.of(List.of(
                Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.of(List.of(7, 8, 9, 10, 11, 12))
        ));
    }

    @Nested
    @DisplayName("티켓 발행")
    class Issue {
        @Test
        @DisplayName("티켓 발행 성공")
        void 티켓_발행_성공() {
            // given
            Long id = 1L;
            Lottos lottos = createLottos();

            // when
            Ticket ticket = Ticket.issue(id, lottos);

            // then
            Assertions.assertThat(ticket).isNotNull();
        }

        @Test
        @DisplayName("id가 null이면 예외 발생")
        void id가_null이면_예외발생() {
            // given
            Lottos lottos = createLottos();

            // expect
            Assertions.assertThatThrownBy(() -> Ticket.issue(null, lottos))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 티켓 ID는 null일 수 없습니다.");
        }

        @Test
        @DisplayName("lottos가 null이면 예외 발생")
        void lottos가_null이면_예외발생() {

            // expect
            Assertions.assertThatThrownBy(() -> Ticket.issue(1L, null))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 로또 목록은 null일 수 없습니다.");
        }
    }

    @Nested
    @DisplayName("티켓 정보 조회")
    class GetInfo {
        @Test
        @DisplayName("발행된 티켓의 ID 조회")
        void 발행된_티켓의_ID_조회() {
            // given
            Long expectedId = 1L;
            Ticket ticket = Ticket.issue(expectedId, createLottos());

            // when
            Long actualId = ticket.getId();

            // then
            Assertions.assertThat(actualId).isEqualTo(expectedId);
        }

        @Test
        @DisplayName("발행된 티켓의 로또 목록 조회")
        void 발행된_티켓의_로또목록_조회() {
            // given
            Lottos expectedLottos = createLottos();
            Ticket ticket = Ticket.issue(1L, expectedLottos);

            // when
            Lottos actualLottos = ticket.getLottos();

            // then
            Assertions.assertThat(actualLottos).isEqualTo(expectedLottos);
        }
    }

}
