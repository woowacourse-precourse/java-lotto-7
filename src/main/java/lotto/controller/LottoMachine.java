package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.view.InputView;

public class LottoMachine {
    private final InputView inputView;

    public LottoMachine(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        List<Lotto> lottoList = buyLottoByPrice(1000);
        WinningLotto winningLotto = generateWinningLotto();
    }

    private List<Lotto> buyLottoByPrice(int price) {
        int money = inputView.inputMoney();
        int count = money % price;
        ArrayList<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> pickedNumberList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(pickedNumberList));
        }

        return lottoList;
    }

    private WinningLotto generateWinningLotto() {
        List<Integer> winningNumber = inputView.inputWinningNumber();
        int winningBonusNumber = inputView.inputWinningBonusNumber();

        return new WinningLotto(winningNumber, winningBonusNumber);
    }
}
