package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.winningNumber.BonusNumber;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.PurchaseAmount;
import lotto.model.lotto.Lottos;
import lotto.model.lotto.RandomNumberPicker;
import lotto.model.winningNumber.WinningNumber;
import lotto.model.winningResult.WinningRank;
import lotto.model.winningResult.WinningResults;

public class LottoMachine {
    public Lottos issueLottos(PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = IntStream.range(0, purchaseAmount.calculateLottoAmount())
                .mapToObj(i -> new Lotto(RandomNumberPicker.pickAscendingNumbers()))
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    public WinningResults checkLottoWinningResult(Lottos lottos, WinningNumber winningNumber, BonusNumber bonusNumber) {
        WinningResults winningResults = new WinningResults();
        for (Lotto lotto : lottos.getLottos()) {
            int matchingWinnerNumberAmount = lotto.checkMatchingAmountWith(winningNumber.getNumbers());
            boolean matchesBonusNumber = lotto.contains(bonusNumber.getBonusNumber());
            WinningRank winningRank = WinningRank.fromMatchingAmount(matchingWinnerNumberAmount, matchesBonusNumber);
            winningResults.add(winningRank);
        }
        return winningResults;
    }

    public double calculateEarningsRate(WinningResults winningResults, int expense) {
        int earnings = 0;
        for (WinningRank winningRank : WinningRank.values()) {
            earnings += winningResults.findLottoAmountByRank(winningRank) * winningRank.getPrice();
        }
        return ((double) earnings) / expense * 100;
    }
}
