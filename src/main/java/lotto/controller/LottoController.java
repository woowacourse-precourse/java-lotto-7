package lotto.controller;

import lotto.model.Lottos;
import lotto.view.InputView;
import lotto.view.OutView;

public class LottoController {

    public void run() {
        issue();
    }

    private void issue() {
        int cost = Integer.parseInt(InputView.requestCost());
        Lottos lottos = Lottos.from(getCountFrom(cost));
        OutView.printLottos(lottos);

    }

    private int getCountFrom(int cost) {
        return cost / 1000;
    }
}
