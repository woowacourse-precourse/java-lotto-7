package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private Lotto lotto;

    public void run(){
        String inputMoney = InputView.promptPurchaseAmount();
        int lottoCount = Integer.parseInt(inputMoney) / 1000;
        OutputView.printPurchaseCount(lottoCount);

        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(lotto.generateLotto());
        }

    }
}
