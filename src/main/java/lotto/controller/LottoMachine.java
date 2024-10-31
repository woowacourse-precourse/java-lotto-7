package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoHistory;
import lotto.model.LottoStatistic;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoMachine(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<Lotto> lottoList = buyLottoByPrice(1000);
        outputView.printBoughtLottoList(lottoList);

        WinningLotto winningLotto = generateWinningLotto();

        LottoStatistic lottoStatistic = generateLottoStatistic(winningLotto, lottoList);
        outputView.printLottoStatistic(lottoStatistic);
    }

    private List<Lotto> buyLottoByPrice(int price) {
        int money = inputView.inputMoney();
        int count = money / price;
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

    private LottoStatistic generateLottoStatistic(WinningLotto winningLotto, List<Lotto> lottoList) {
        LottoHistory lottoHistory = new LottoHistory(winningLotto, lottoList);

        return lottoHistory.getLottoStatistic();
    }
}
