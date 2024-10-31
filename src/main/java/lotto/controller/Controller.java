package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private Lotto lotto;

    public void run() {
        String inputMoney = InputView.promptPurchaseAmount();
        int lottoCount = Integer.parseInt(inputMoney) / 1000;
        OutputView.printPurchaseCount(lottoCount);
        LottoTickets lottoTickets = LottoTickets.generateLottoTickets(lottoCount);

        List<List<Integer>> lottoNumbers = lottoTickets.getLottoTickets();
        OutputView.printLottoTickets(lottoNumbers);

        String inputWinningNumbers = InputView.promptPurchaseWinningNumber();
        String[] inputsWinningNumbers = inputWinningNumbers.split(",");

        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < inputsWinningNumbers.length; i++) {
            winningNumbers.add(Integer.parseInt(inputsWinningNumbers[i]));
        }



    }
}
