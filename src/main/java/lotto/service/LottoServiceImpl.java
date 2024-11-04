package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.Constant;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class LottoServiceImpl implements LottoService {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoServiceImpl(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int calculateLottoCount(int purchasePrice) {
        return purchasePrice / Constant.WON_UNIT;
    }

    private Lotto drawALotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(Constant.MIN_NUMBER, Constant.MAX_NUMBER,
                Constant.LOTTO_SIZE);
        Collections.sort(randomNumbers);
        return new Lotto(randomNumbers);
    }

    @Override
    public List<Lotto> createLottos(int purchasePrice) {
        int lottoCount = calculateLottoCount(purchasePrice);
        List<Lotto> lottos = new ArrayList<>(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(drawALotto());
        }
        return lottos;
    }

    @Override
    public Map<LottoRank, Integer> calculateTotalWinnings(List<Lotto> lottos) {
        Map<LottoRank, Integer> winningResults = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            winningResults.put(rank, 0);
        }
        for (Lotto lotto : lottos) {
            LottoRank resultRank = compareWithWinningNumbers(lotto);
            winningResults.put(resultRank, winningResults.get(resultRank) + 1);
        }
        return winningResults;
    }

    @Override
    public double calculateRateOfReturn(Map<LottoRank, Integer> winningResults, int purchasePrice) {
        long winningPrice = 0L;
        for (LottoRank lottoRank : winningResults.keySet()) {
            winningPrice += (long) lottoRank.getWinningPrice() * winningResults.get(lottoRank);
        }
        return (double) winningPrice / purchasePrice * 100;
    }

    private LottoRank compareWithWinningNumbers(Lotto lotto) {
        List<Integer> myNumbers = lotto.getNumbers();
        int lottoNumberSameCount = (int) myNumbers.stream().filter(winningNumbers::contains).count();
        boolean bonusSame = myNumbers.contains(bonusNumber);
        return checkWithLottoRank(lottoNumberSameCount, bonusSame);
    }

    private LottoRank checkWithLottoRank(int lottoNumberSameCount, boolean bonusSame) {
        if (lottoNumberSameCount == LottoRank.FIFTH.getSameNumberCount()) {
            return LottoRank.FIFTH;
        }
        if (lottoNumberSameCount == LottoRank.FOURTH.getSameNumberCount()) {
            return LottoRank.FOURTH;
        }
        if (lottoNumberSameCount == LottoRank.THIRD.getSameNumberCount()) {
            return LottoRank.THIRD;
        }
        if (lottoNumberSameCount == LottoRank.SECOND.getSameNumberCount() && bonusSame) {
            return LottoRank.SECOND;
        }
        if(lottoNumberSameCount == LottoRank.FIRST.getSameNumberCount()) {
            return LottoRank.FIRST;
        }
        return LottoRank.NO_WINNING;
    }
}
