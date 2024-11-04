package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSimulator {

    private User user;
    private List<Lotto> lottos;

    public void run() {
        init();
        getCorrectInput(() -> user.setPrice(InputView.inputPurchasePrice()));
    }

    private void init() {
        user = new User();
        lottos = new ArrayList<>();
    }

    private void getCorrectInput(Runnable function) {
        while (true) {
            try {
                function.run();
                break;
            } catch (IllegalArgumentException e) {
                OutputView.outputMessage(e.getMessage());
            }
        }
    }
}
