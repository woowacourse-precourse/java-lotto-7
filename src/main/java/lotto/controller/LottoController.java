package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.view.InputView;

import java.util.List;

public class LottoController {
    private static final int LOTTO_PRICE = 1_000;

    public void run() {
        int money = InputView.getMoney();
        int numberOfLottos = calculateNumberOfLottos(money);
        List<Lotto> purchasedLottos = LottoGenerator.generateLottos(numberOfLottos);
        //todo : 구매한 로또 목록 출력, 당첨 결과와 수익률 출력
    }

    private int calculateNumberOfLottos(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
        }
        return money / LOTTO_PRICE;
    }

    //todo : 수익률을 계산하는 method 구현
}
