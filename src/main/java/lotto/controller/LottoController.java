package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.util.LottoRandomGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

public class LottoController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final LottoRandomGenerator randomGenerator = new LottoRandomGenerator();

    public void playLotto(){

    }

    private Money createMoney(){
        outputView.printRequestMoney();
        int money = Integer.parseInt(inputView.inputMoney());
        return new Money(money);
    }

    private Lottos createLottos(Money money) {
        int count = money.getLottoCount();
        outputView.printLottoCount(count);
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> randomNumbers = LottoRandomGenerator.generateRandomNumbers();
            lottoList.add(new Lotto(randomNumbers));
        }

        return new Lottos(lottoList);
    }
}
