package lotto.service.winning;

import static lotto.constant.LottoConstant.PRICE;

import java.util.List;
import lotto.constant.Error;
import lotto.domain.LottoPurchase;
import lotto.domain.Rank;
import lotto.domain.winning.BonusNumber;
import lotto.domain.winning.Winning;
import lotto.domain.winning.WinningNumbers;

public class WinningServiceImpl implements WinningService {

    @Override
    public Winning createWinning(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        validate(winningNumbers, bonusNumber);
        return new Winning(winningNumbers, bonusNumber);
    }

    private void validate(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException(Error.DUPLICATED_WINNING_BONUS_NUMBERS);
        }
    }

    @Override
    public LottoStatistics estimate(LottoPurchase purchase, Winning winning) {
        List<Rank> ranks = purchase.getLottos()
            .stream()
            .map(winning::rank)
            .sorted()
            .toList();

        double profitRate = calculateProfitRate(ranks);

        return new LottoStatistics(ranks, profitRate);
    }

    private static double calculateProfitRate(List<Rank> ranks) {
        long totalPrize = ranks.stream()
            .mapToInt(Rank::getPrize)
            .sum();

        long totalCost = (long) ranks.size() * PRICE;

        return (double) totalPrize / totalCost * 100.0;
    }
}
