package lotto;

import static lotto.view.input.readTotalAmount;

import lotto.controller.lottoController;
import lotto.model.Lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int totalCount = readTotalAmount();
        // buy lottos
        Lotto winningLotto = lottoController.winningLotto();
        int bonusNumber = lottoController.bonusNumber();
    }
}
