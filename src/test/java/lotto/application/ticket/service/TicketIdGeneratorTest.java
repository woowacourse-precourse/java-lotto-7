package lotto.application.ticket.service;

import static org.junit.jupiter.api.Assertions.assertAll;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("TicketIdGenerator - 티켓 ID 생성기")
class TicketIdGeneratorTest {
    @Test
    @DisplayName("ID는 1부터 시작한다")
    void ID는_1부터_시작() {
        // given
        TicketIdGenerator generator = new TicketIdGenerator();

        // when
        Long id = generator.generate();

        // then
        Assertions.assertThat(id).isEqualTo(1L);
    }

    @Test
    @DisplayName("ID는 순차적으로 증가한다")
    void ID는_순차적으로_증가() {
        // given
        TicketIdGenerator generator = new TicketIdGenerator();

        // when
        Long firstId = generator.generate();
        Long secondId = generator.generate();
        Long thirdId = generator.generate();

        // then
        assertAll(
                () -> Assertions.assertThat(firstId).isEqualTo(1L),
                () -> Assertions.assertThat(secondId).isEqualTo(2L),
                () -> Assertions.assertThat(thirdId).isEqualTo(3L)
        );
    }

}
