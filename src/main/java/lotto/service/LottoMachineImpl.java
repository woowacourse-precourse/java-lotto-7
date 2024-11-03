package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.winningNumber.BonusNumber;
import lotto.model.lotto.Lotto;
import lotto.model.purchaseAmount.PurchaseAmount;
import lotto.model.lotto.Lottos;
import lotto.model.lotto.RandomNumberPicker;
import lotto.model.winningNumber.WinningNumber;
import lotto.model.winningResult.WinningRank;
import lotto.model.winningResult.WinningResults;

public class LottoMachineImpl implements LottoMachine{
    private static final int PERCENTAGE_MULIPLIER = 100;

    @Override
    public Lottos issueLottos(PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = IntStream.range(0, purchaseAmount.calculateLottoAmount())
                .mapToObj(i -> new Lotto(RandomNumberPicker.pick()))
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    @Override
    public WinningResults checkWinningResults(Lottos lottos, WinningNumber winningNumber, BonusNumber bonusNumber) {
        WinningResults winningResults = new WinningResults();
        for (Lotto lotto : lottos.lottos()) {
            int matchingAmount = lotto.checkMatchingAmountWith(winningNumber.numbers());
            boolean matchesBonusNumber = lotto.contains(bonusNumber.number());
            WinningRank winningRank = WinningRank.determineRank(matchingAmount, matchesBonusNumber);
            winningResults.add(winningRank);
        }
        return winningResults;
    }

    @Override
    public double calculateEarningsRate(WinningResults winningResults, PurchaseAmount purchaseAmount) {
        int expense = purchaseAmount.purchaseAmount();
        int earnings = 0;
        for (WinningRank winningRank : WinningRank.values()) {
            earnings += winningResults.findLottoAmountByRank(winningRank) * winningRank.getPrice();
        }
        return ((double) earnings) / expense * PERCENTAGE_MULIPLIER;
    }
}
