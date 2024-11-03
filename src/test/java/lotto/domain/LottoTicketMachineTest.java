package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domains.lotto.domain.LottoTicket;
import lotto.domains.lotto.domain.LottoTicketMachine;

public class LottoTicketMachineTest {
	@DisplayName("LottoTicketMachine 클래스가 올바르게 생성된다.")
	@Test
	void LottoTicketMachine_클래스가_올바르게_생성된다() {
		assertThat(LottoTicketMachine.from(3)).isInstanceOf(LottoTicketMachine.class);
	}

	@DisplayName("알맞은 개수의 로또가 생성된다.")
	@Test
	void 알맞은_개수의_로또가_생성된다() {
		LottoTicketMachine lottoTicketMachine = LottoTicketMachine.from(3);
		LottoTicket lottoTicket = lottoTicketMachine.generateLottoTickets();

		assertThat(lottoTicket.getTickets().size() == 3).isTrue();
	}
}
