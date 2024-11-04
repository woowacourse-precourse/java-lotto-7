package lotto.service;

import java.util.EnumMap;
import java.util.List;
import lotto.constant.WinningType;
import lotto.model.Lotto;
import lotto.model.PurchasePrice;
import lotto.model.WinningCriteria;
import lotto.model.WinningResult;

public class LottoCalculationService {

    public WinningResult calculateWinning(List<Lotto> issuedLotto, WinningCriteria winningCriteria) {
        List<WinningType> winningResult = issuedLotto.stream()
                .map(lotto -> calculateWinning(lotto, winningCriteria))
                .toList();
        return new WinningResult(winningResult);
    }

    private WinningType calculateWinning(Lotto issuedLotto, WinningCriteria winningCriteria) {
        List<Integer> winningNumbers = winningCriteria.getLotto().getNumbers();
        int winningBonusNumber = winningCriteria.getBonusNumber().getNumber();

        int matchedNumberCount = checkMatchedNumberCount(issuedLotto, winningNumbers);
        boolean isBonusNumberMatched = checkMatchedBonusNumber(issuedLotto, winningBonusNumber);
        return WinningType.checkType(matchedNumberCount, isBonusNumberMatched);
    }

    private int checkMatchedNumberCount(Lotto issuedLotto, List<Integer> winningNumbers) {
        return issuedLotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .toList()
                .size();
    }

    private boolean checkMatchedBonusNumber(Lotto issuedLotto, int winningBonusNumber) {
        return issuedLotto.getNumbers().stream()
                .anyMatch(number -> number == winningBonusNumber);
    }

    public double calculationRateOfReturn(PurchasePrice purchasePrice, WinningResult winningResult) {
        long allPrizeMoney = calculationAllPrizeMoney(winningResult);
        return allPrizeMoney / ((double) purchasePrice.getPrice());
    }

    public long calculationAllPrizeMoney(WinningResult winningResult) {
        EnumMap<WinningType, Integer> countPerWinningType = winningResult.getCountPerWinningType();
        List<WinningType> allWinningTypes = List.of(WinningType.values());

        return allWinningTypes.stream()
                .mapToLong(type -> calculationPrizeMoney(type, countPerWinningType.get(type)))
                .sum();
    }

    private long calculationPrizeMoney(WinningType winningType, int count) {
        return winningType.getPrizeMoney() * count;
    }
}
