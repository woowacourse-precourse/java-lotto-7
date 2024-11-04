package lotto.model;

import java.util.List;
import lotto.Lotto;
import lotto.model.strategy.FixedNumberGeneration;
import lotto.model.strategy.RandomNumberGeneration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMachineTest {

    @Test
    @DisplayName("금액이 1,000원 단위가 아닐 경우 예외가 발생한다.")
    void 구입금액이_유효하지_않을_경우_예외가_발생한다() {
        LottoMachine lottoMachine = new LottoMachine(new FixedNumberGeneration());

        assertThatThrownBy(() -> lottoMachine.issueLottoTickets(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위의 양수여야 합니다.");

        assertThatThrownBy(() -> lottoMachine.issueLottoTickets(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위의 양수여야 합니다.");

        assertThatThrownBy(() -> lottoMachine.issueLottoTickets(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위의 양수여야 합니다.");
    }

    @Test
    @DisplayName("금액에 따라 올바른 개수의 로또 티켓이 발행된다.")
    void 구입금액에_따라_올바른_개수의_로또_티켓이_발행된다() {
        LottoMachine lottoMachine = new LottoMachine(new FixedNumberGeneration());

        int amount = 5000;
        int expectedTicketCount = amount / 1000;

        List<Lotto> tickets = lottoMachine.issueLottoTickets(amount);

        assertThat(tickets).hasSize(expectedTicketCount);
        tickets.forEach(ticket -> assertThat(ticket.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("랜덤 번호 생성 전략을 사용하여 각 로또 티켓이 고유 번호로 발행된다.")
    void 랜덤번호_생성전략으로_고유_로또_티켓_발행() {
        LottoMachine lottoMachine = new LottoMachine(new RandomNumberGeneration());

        List<Lotto> tickets = lottoMachine.issueLottoTickets(5000);

        assertThat(tickets).hasSize(5);
        tickets.forEach(ticket -> {
            assertThat(ticket.getNumbers()).hasSize(6);
            assertThat(ticket.getNumbers()).doesNotHaveDuplicates();
            assertThat(ticket.getNumbers()).allMatch(number -> number >= 1 && number <= 45);
        });
    }

    @Test
    @DisplayName("금액이 1,000원 미만일 경우 티켓이 발행되지 않고 예외가 발생한다.")
    void 금액이_1000원_미만이면_예외가_발생한다() {
        LottoMachine lottoMachine = new LottoMachine(new FixedNumberGeneration());

        assertThatThrownBy(() -> lottoMachine.issueLottoTickets(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위의 양수여야 합니다.");
    }

    @Test
    @DisplayName("0원 또는 음수 입력 시 예외가 발생한다.")
    void 금액이_0원_또는_음수면_예외가_발생한다() {
        LottoMachine lottoMachine = new LottoMachine(new FixedNumberGeneration());

        assertThatThrownBy(() -> lottoMachine.issueLottoTickets(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위의 양수여야 합니다.");

        assertThatThrownBy(() -> lottoMachine.issueLottoTickets(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위의 양수여야 합니다.");
    }
}
