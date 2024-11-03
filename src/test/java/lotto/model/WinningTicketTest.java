package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningTicketTest {

    @Test
    @DisplayName("로또 등수 반환")
    void getRank() {
        assertSimpleTest(() -> {
            WinningTicket winningTicket = WinningTicket.of("1,2,3,4,5,6", "7");
            Rank rank = winningTicket.getRank(Lotto.from("1,3,5,14,22,45"));
            assertThat(rank).isEqualTo(Rank.FIFTH);
        });
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개가 아니라면 예외가 발생한다")
    void validateSize() {
        assertThatThrownBy(() -> WinningTicket.of("1,2,3,4,5", "6"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> WinningTicket.of("1,2,3,4,5,6,7", "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다")
    void validateDuplicated() {
        assertThatThrownBy(() -> WinningTicket.of("1,2,3,4,5,5", "6"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> WinningTicket.of("1,2,3,4,5,1", "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 숫자가 아니라면 예외가 발생한다")
    void validateType() {
        assertThatThrownBy(() -> WinningTicket.of("1,2,3,4,5,a", "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 1에서 45사이의 숫자가 아니라면 예외가 발생한다")
    void validateRange() {
        assertThatThrownBy(() -> WinningTicket.of("1,2,3,4,5,46", "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
