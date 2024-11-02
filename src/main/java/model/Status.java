package model;

import static validator.Validator.LOTTO_COST;

import java.util.List;

public class Status {
    private List<Lotto> lottos;
    private Integer initialMoney;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

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

    private static boolean isSameNumber(Integer number, Integer winningNumber) {
        return number.equals(winningNumber);
    }

    public Integer getLottoCount() {
        return (Integer) (initialMoney / LOTTO_COST);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void calculationResult() {
        for (Lotto lotto : lottos) {
            LottoResult result = lotto.lottoCalculation(winningNumbers, bonusNumber);
        }
    }
}
