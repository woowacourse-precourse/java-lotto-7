package model;

import static validator.Validator.LOTTO_COST;

import java.util.HashMap;
import java.util.List;

public class Status {
    private List<Lotto> lottos;
    private Integer initialMoney;
    private Long earnMoney = 0L;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;
    private HashMap<LottoResult, Integer> lottoResults = new HashMap<>();

    public Status(Integer initialMoney) {
        this.initialMoney = initialMoney;
    }

    public boolean compareToWinningNumber(Integer number) {
        for (Integer winningNumber : winningNumbers) {
            if (isSameNumber(number, winningNumber)) {
                return false;
            }
        }
        return true;
    }

    public Integer getLottoCount() {
        return (Integer) (initialMoney / LOTTO_COST);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Double getEarnRate() {
        return earnMoney.doubleValue() * 100 / initialMoney;
    }

    public void setLottos(List<Lotto> lottos) {
        if (this.lottos == null) {
            this.lottos = lottos;
        }
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        if (this.winningNumbers == null) {
            this.winningNumbers = winningNumbers;
        }
    }

    public void setBonusNumber(Integer bonusNumber) {
        if (this.bonusNumber == null) {
            this.bonusNumber = bonusNumber;
        }
    }

    private static boolean isSameNumber(Integer number, Integer winningNumber) {
        return number.equals(winningNumber);
    }

    public HashMap<LottoResult, Integer> calculationResult() {
        for (Lotto lotto : lottos) {
            LottoResult result = lotto.lottoCalculation(winningNumbers, bonusNumber);
            updateResult(result);
            updateMoney(result);
        }
        return lottoResults;
    }

    public void updateResult(LottoResult result) {
        if (lottoResults.containsKey(result)) {
            lottoResults.replace(result, lottoResults.get(result) + 1);
            return;
        }
        lottoResults.put(result, 1);
    }

    public void updateMoney(LottoResult result) {
        earnMoney += result.getReward();
    }
}
