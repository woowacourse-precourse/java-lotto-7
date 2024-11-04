package lotto.controller;

import lotto.model.Jackpot;
import lotto.model.Lotto;
import lotto.model.Machine;
import lotto.model.Prize;
import lotto.model.Status;
import lotto.model.Tickets;
import lotto.view.Output;

public class Controller extends Machine {
    public void startLottery() {
        Tickets tickets = createTickets();
        Output.printTickets(tickets);

        Lotto lottoNumbers = createLottoNumbers();
        Jackpot jackpot = createJackpotNumbers(lottoNumbers);

        Status status = new Status();
        status.checkNumbersHit(tickets, jackpot);
        status.checkBonusHit(tickets, jackpot);

        Prize prize = new Prize();
        prize.checkProfitResult(status);
        prize.checkProfitRate(tickets);

        Output.printProfits(prize);
    }
}