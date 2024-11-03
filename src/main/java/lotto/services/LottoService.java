package lotto.services;

import lotto.models.*;
import lotto.utils.Prize;

import static lotto.validation.InputValidator.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class LottoService {
    private LottoIssuer lottoIssuer;
    private Lotto lotto;
    private Bonus bonus;
    private Statistics statistics;

    public void issue (String purchaseAmountInput) {
        int purchaseAmount = amountValidate(purchaseAmountInput);
        lottoIssuer = new LottoIssuer(purchaseAmount);
    }

    public int getIssueAmount() {
        return lottoIssuer.getAmount();
    }

    public int getIssueCount() {
        return lottoIssuer.getCount();
    }

    public List<List<Integer>> getAllIssuedLotto() {
        return lottoIssuer.getAllIssuedLotto();
    }

    public void setWinningNumbers(String winningNumberInput) {
        List<Integer> winningNumber = listValidate(winningNumberInput);
        lotto = new Lotto(winningNumber);
    }

    public List<Integer> getWinningNumber() {
        return lotto.getNumbers();
    }

    public void setBonusNumber (String bonusNumberInput) {
        int bonusNumber = bonusValidate(bonusNumberInput);
        bonus = new Bonus(bonusNumber, lotto);
    }

    public int getBonusNumber() {
        return bonus.getNumber();
    }

    public void generateStatistics () {
        statistics = new Statistics();

        List<List<Integer>> issuedLotto = getAllIssuedLotto();
        List<Integer> winningNumbers = getWinningNumber();
        int bonusNumber = getBonusNumber();

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statistics);
        statisticsCalculator.calculateStatistics(issuedLotto, winningNumbers, bonusNumber);
    }

    public Map<Prize, Integer> getStatistics() {
        return statistics.get();
    }

    public double calculateYield() {
        int totalPurchaseAmount = getIssueAmount();
        YieldCalculator yieldCalculator = new YieldCalculator(statistics);
        return yieldCalculator.calculateYield(totalPurchaseAmount);
    }

}
