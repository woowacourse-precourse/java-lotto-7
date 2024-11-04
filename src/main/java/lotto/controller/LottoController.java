package lotto.controller;

import lotto.view.InputView;

public class LottoController {

    public void run() {
        issue();
    }

    private void issue() {
        int cost = Integer.parseInt(InputView.requestCost());
        Lottos lottos = Lottos.from(getCountFrom(cost));
    }
    private int getCountFrom(int cost) {
        return cost / 1000;
    }
}
