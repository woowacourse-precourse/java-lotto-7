package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.constant.LottoRank;
import lotto.dto.LottoResultResponse;
import lotto.dto.PurchaseResultResponse;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Machine;
import lotto.model.WinningLotto;

public class LottoService {
    private WinningLotto winningLotto;
    private Machine machine;
    private LottoResult result;

    public LottoService() {
    }

    public void saveWinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        Lotto lotto = new Lotto(winningNumbers);
        this.winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    public void purchaseLotto(int money) {
        this.machine = new Machine(money);
        for (int i = 0; i < machine.getPurchaseCount(); i++) {
            this.machine.pickLotto(generateLottoNumbers());
        }
    }

    private Lotto generateLottoNumbers() {
        List<Integer> generatedNumbers =
                new ArrayList<>(
                        Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.LOTTO_NUMBER_COUNT));
        generatedNumbers.sort(Integer::compareTo);
        return new Lotto(generatedNumbers);
    }

    public Integer countMatchNumbers(Lotto lotto, WinningLotto winningLotto) {
        Set<Integer> lottoNumbers = new HashSet<>(lotto.getNumbers());
        Set<Integer> wingingNumbers = new HashSet<>(winningLotto.getWinningNumbers().getNumbers());
        lottoNumbers.retainAll(wingingNumbers);
        return lottoNumbers.size();
    }

    public Boolean checkBonusNumberMatch(Lotto lotto, WinningLotto winningLotto) {
        return lotto.getNumbers().contains(winningLotto.getBonusNumber());
    }

    private Map<LottoRank, Integer> initRankResult() {
        Map<LottoRank, Integer> rankResult = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            rankResult.put(rank, 0);
        }
        return rankResult;
    }

    public LottoResult getLottoResult() {
        Map<LottoRank, Integer> rankResult = initRankResult();
        for (int i = 0; i < this.machine.getPurchaseCount(); i++) {
            Lotto lotto = this.machine.getLottos().get(i);
            int matchCount = countMatchNumbers(lotto, this.winningLotto);
            boolean bonusNumberMatch = checkBonusNumberMatch(lotto, this.winningLotto);
            LottoRank lottoRank = LottoRank.getLottoRank(matchCount, bonusNumberMatch);
            rankResult.put(lottoRank, rankResult.getOrDefault(lottoRank, 0) + 1);
        }
        Double earningRate = calculateEarningRate(rankResult);
        this.result = new LottoResult(rankResult, earningRate);
        return this.result;
    }

    private Double calculateEarningRate(Map<LottoRank, Integer> rankResult) {
        int earningSum = 0;
        int initialMoney = this.machine.getMoney();
        for (Map.Entry<LottoRank, Integer> entry : rankResult.entrySet()) {
            int prizeMoney = entry.getKey().getPrizeMoney();
            int winCount = entry.getValue();
            earningSum += (prizeMoney * winCount);
        }
        double rawRate = (earningSum / (double) initialMoney) * 100;
        return Math.round(rawRate * 10) / 10.0;
    }

    public PurchaseResultResponse getPurchasedResult() {
        List<List<Integer>> purchasedLotto = new ArrayList<>();
        for (Lotto lotto : this.machine.getLottos()) {
            purchasedLotto.add(lotto.getNumbers());
        }
        return new PurchaseResultResponse(
                this.machine.getPurchaseCount(),
                purchasedLotto
        );
    }

    public LottoResultResponse getLottoResultResponse() {
        return new LottoResultResponse(
                this.result.getResults(),
                this.result.getEarningRate()
        );
    }
}
