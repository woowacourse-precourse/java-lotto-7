package lotto;

import InputOutput.InputView;
import InputOutput.OutputView;
import Rank.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        List<List<Integer>> lottoTickets = new ArrayList<>();
        List<Integer> winNumber = new ArrayList<>();
        int bonusNumber = 0;
        OutputView.firstMessage();
        int price = Integer.parseInt(InputView.insert());

        int ticket = OutputView.calculateNumberOfSheetsFromAmount(price);
        lottoTickets = Lotto.createLottoTickets(ticket);
        OutputView.printLottoTickets(lottoTickets);

        OutputView.promptWinningNumbers();
        winNumber = InputView.winNumbers();

        OutputView.bonusNumberMessage();
        bonusNumber = Integer.parseInt(InputView.insert());

        Map<Rank, Integer> rankCount = new HashMap<>();
        rankCount = Lotto.calculateWinningResults(lottoTickets,winNumber,bonusNumber);

        int totalPrize = OutputView.printWinningStatistics(rankCount);

        OutputView.outputReturnRate(totalPrize, price);
    }
}

