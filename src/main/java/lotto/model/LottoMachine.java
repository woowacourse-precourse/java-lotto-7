package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public List<Lotto> buyLottoByPrice(int money) {
        int count = money / 1000;
        ArrayList<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> pickedNumberList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(pickedNumberList));
        }

        return lottoList;
    }

    public WinningLotto generateWinningLotto(List<Integer> winningNumber, int winningBonusNumber) {
        return new WinningLotto(winningNumber, winningBonusNumber);
    }

    public LottoStatistic generateLottoStatistic(WinningLotto winningLotto, List<Lotto> lottoList) {
        LottoHistory lottoHistory = new LottoHistory(winningLotto, lottoList);

        return lottoHistory.getLottoStatistic();
    }
}
