package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.MainNumber;
import lotto.model.TicketManager;
import lotto.service.LottoService;
import lotto.view.OutputView;
import lotto.vo.Payment;
import lotto.vo.Ticket;

import javax.swing.*;
import java.util.List;

public class LottoController {
    private LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        Payment payment = inputPayment();
        List<Ticket> tickets = issueTickets(payment);
        MainNumber mainNumber = inputMainNumber();
        BonusNumber bonusNumber = inputBonusNumber(mainNumber);
        showResult(payment, tickets, mainNumber, bonusNumber);
    }

    private Payment inputPayment() {
        return lottoService.takePayment();
    }

    private List<Ticket> issueTickets(Payment payment) {
        TicketManager ticketManager = new TicketManager(payment);
        int ticketAmount = ticketManager.getTicketAmount();
        List<Ticket> tickets = ticketManager.getTickets();

        OutputView.printTicketAmount(ticketAmount);
        OutputView.printTickets(tickets);

        return tickets;
    }

    private MainNumber inputMainNumber() {
        return lottoService.takeMainNum();
    }
    
    private BonusNumber inputBonusNumber(MainNumber mainNumber) {
        return lottoService.takeBonusNum(mainNumber);
    }

    private void showResult(Payment payment, List<Ticket> tickets, MainNumber mainNumber, BonusNumber bonusNumber) {
        List<Integer> rankCount = lottoService.takeRankCount(tickets, mainNumber, bonusNumber);
        double profitRate = lottoService.drawProfitRate(rankCount, payment);
        OutputView.printResult(rankCount, profitRate);
    }
}
