package lotto;

import lotto.service.Lottos;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView inputView = new InputView();
        inputView.buyMoney();

        Lottos lottos = new Lottos(inputView.money, inputView.count);
        lottos.lottoDraw();

        OutputView outputView = new OutputView(lottos.count, lottos.lotto);

        outputView.buyCountPrint();
        outputView.lottosPrint();

        inputView.winNumber();
        inputView.bonus();


    }
}
