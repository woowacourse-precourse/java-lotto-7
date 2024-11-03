package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import lotto.domains.lotto.domain.LottoTicket;
import lotto.domains.lotto.domain.LottoTicketMachine;
import lotto.domains.lotto.type.LottoPrize;
import lotto.service.LottoResultFactory;

public class LottoTicketMachineTest {
	private LottoTicketMachine lottoTicketMachine;

	@BeforeEach()
	public void setUp() {
		lottoTicketMachine = LottoTicketMachine.from(3);
	}

	@DisplayName("LottoTicketMachine 클래스가 올바르게 생성된다.")
	@Test
	void LottoTicketMachine_클래스가_올바르게_생성된다() {
		assertThat(lottoTicketMachine).isInstanceOf(LottoTicketMachine.class);
	}

	@DisplayName("알맞은 개수의 로또가 생성된다.")
	@Test
	void 알맞은_개수의_로또가_생성된다() {
		LottoTicket lottoTicket = lottoTicketMachine.generateLottoTickets();

		assertThat(lottoTicket.getTickets().size() == 3).isTrue();
	}

	@DisplayName("올바른 로또 결과를 생성한다.")
	@Test
	void 올바른_로또_결과를_생성한다() {
		LottoResultFactory lottoResultFactory = new LottoResultFactory();
		Map<LottoPrize, Integer> winningStatus = lottoResultFactory.generateLottoResult();
		List<Map<Integer, Boolean>> lottoResults = List.of(
			Map.of(3, false),
			Map.of(5, true),
			Map.of(5, false)
		);

		String expectedOutput = """
			3개 일치 (5,000원) - 1개
			4개 일치 (50,000원) - 0개
			5개 일치 (1,500,000원) - 1개
			5개 일치, 보너스 볼 일치 (30,000,000원) - 1개
			6개 일치 (2,000,000,000원) - 0개""";

		String lottoResult = lottoTicketMachine.registerLottoResult(winningStatus, lottoResults);
		assertThat(lottoResult).isEqualTo(expectedOutput);
	}
}
