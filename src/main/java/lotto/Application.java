package lotto;

import InputOutput.InputView;
import InputOutput.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<List<Integer>> lottoTickets = new ArrayList<>();
        OutputView.firstMessage();
        int ticket = Integer.parseInt(InputView.insert());

        ticket = OutputView.calculateNumberOfSheetsFromAmount(ticket);
        lottoTickets = Lotto.createLottoTickets(ticket);
        OutputView.printLottoTickets(lottoTickets);
    }
}

