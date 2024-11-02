package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoAmount;
import lotto.model.Lottos;
import lotto.model.RandomNumberPicker;
import lotto.model.WinningNumber;
import lotto.model.WinningRank;
import lotto.model.WinningResults;

public class LottoMachine {
    public Lottos issueLottos(LottoAmount lottoAmount) {
        List<Lotto> lottos = IntStream.range(0, lottoAmount.getLottoAmount())
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
}
