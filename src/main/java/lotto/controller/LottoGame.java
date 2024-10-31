package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Collections;
import java.util.List;

public class LottoGame {

    public void initLottoGame() {
        int money = InputView.getMoney();
        issuedLotto(money);

        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber();

    }

    public void issuedLotto(int money) {
        for (int i=0; i<money/1000; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto issuedLotto = new Lotto(numbers);
            OutputView.displayIssuedLotto(numbers);
        }
    }
}
