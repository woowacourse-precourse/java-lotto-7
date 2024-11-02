package lotto.service;

import lotto.domains.lotto.LottoTicket;
import lotto.domains.lotto.LottoTicketMachine;

public class LottoFactory {
	public LottoTicketMachine generateLottoTicketMachine(int ticketAmount) {
		return new LottoTicketMachine(ticketAmount);
	}

	public LottoTicket generateLottoTicketMachine(LottoTicketMachine lottoTicketMachine) {
		return lottoTicketMachine.generateLottoTickets();
	}
}
