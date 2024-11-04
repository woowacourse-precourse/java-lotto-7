package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoList;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.type.LottoRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoList lottoList;
    public LottoController(){this.lottoList = new LottoList();}

    public void createLottos(int money) {
        int count = money / 1000;
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);  // 새로운 ArrayList를 정렬
            lottoList.add(new Lotto(numbers));
        }
    }
    public List<Lotto> getLottos() {
        return lottoList.getLottoList();
    }
    public void setWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        lottoList.setWinningNumber(new Lotto(winningNumbers), bonusNumber);
    }
    public Map<LottoRank, Integer> getStatistics() {
        return lottoList.calculateWinningStat();
    }
    public double getProfitRate() {
        return lottoList.calculateProfitRate();
    }
}
