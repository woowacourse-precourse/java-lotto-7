package lotto.service.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.dto.MatchingResultDto;
import lotto.model.lotto.lottoNumber.NumberPicker;
import lotto.model.lotto.winningResult.rank.RankDeterminer;
import lotto.model.winningNumber.BonusNumber;
import lotto.model.lotto.lottoNumber.Lotto;
import lotto.model.lotto.purchaseAmount.PurchaseAmount;
import lotto.model.lotto.lottoNumber.Lottos;
import lotto.model.winningNumber.MainNumber;
import lotto.model.lotto.winningResult.rank.Rank;
import lotto.model.lotto.winningResult.WinningResults;

public class DefaultLottoMachine implements LottoMachine {
    private static final int PERCENTAGE_MULIPLIER = 100;

    private final RankDeterminer rankDeterminer;
    private final NumberPicker numberPicker;

    public DefaultLottoMachine(RankDeterminer rankDeterminer, NumberPicker numberPicker) {
        this.rankDeterminer = rankDeterminer;
        this.numberPicker = numberPicker;
    }

    @Override
    public Lottos issueLottos(PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = IntStream.range(0, purchaseAmount.calculateLottoAmount())
                .mapToObj(i -> new Lotto(numberPicker.pick()))
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    @Override
    public WinningResults checkWinningResults(Lottos lottos, MainNumber mainNumber, BonusNumber bonusNumber) {
        WinningResults winningResults = new WinningResults();
        for (Lotto lotto : lottos.lottos()) {
            int matchingAmount = lotto.checkMatchingAmountWith(mainNumber.numbers());
            boolean matchesBonusNumber = lotto.contains(bonusNumber.number());
            Rank rank = rankDeterminer.determine(new MatchingResultDto(matchingAmount, matchesBonusNumber));
            winningResults.add(rank);
        }
        return winningResults;
    }

    @Override
    public double calculateEarningsRate(WinningResults winningResults, PurchaseAmount purchaseAmount) {
        int expense = purchaseAmount.purchaseAmount();
        int earnings = 0;
        for (Rank rank : Rank.values()) {
            earnings += winningResults.findLottoAmountByRank(rank) * rank.getPrice();
        }
        return ((double) earnings) / expense * PERCENTAGE_MULIPLIER;
    }
}
