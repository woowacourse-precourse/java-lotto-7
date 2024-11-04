package lotto.model.lottoInfo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.controller.dto.LottoResult;
import lotto.controller.dto.PrizeResultInfo;
import lotto.controller.dto.PrizeResultsDto;
import lotto.model.enums.Prize;
import lotto.model.enums.Rank;

public class LottoGame {
    private WinningNumber winningNumbers;
    private BonusNumber bonusNumber;
    private final LottoPrice price;
    private final PrizeData priceByRank;

    public LottoGame(LottoPrice price, PrizeData priceByRank) {
        this.price = price;
        this.priceByRank = priceByRank;
    }

    public void enterWinningNumber(List<Integer> integers) {
        this.winningNumbers = new WinningNumber(integers);
    }

    public void enterBonusNumber(int bonusNumber) {
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public Integer getPrice() {
        return price.getPrice();
    }

    public Integer getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getWinningNumbers();
    }

    public Rank calculateRank(List<Integer> numbers) {
        long matchCount = numbers.stream()
                .filter(winningNumbers
                        .getWinningNumbers()::contains)
                .count();

        boolean hasBonus = numbers.contains(bonusNumber
                .getBonusNumber()
        );

        return Rank.checkRank(matchCount, hasBonus);
    }

    public PrizeResultsDto getPrizeResult(LottoResult lottoResult) {
        Map<Rank, Long> rankCounting = Rank.groupByRank(lottoResult.ranks());
        return new PrizeResultsDto(generatePrizeInfo(rankCounting));
    }

    private List<PrizeResultInfo> generatePrizeInfo(Map<Rank, Long> rankCounting) {
        return Arrays.stream(Rank.values())
                .filter(rank -> !rank.isNone())
                .map(rank -> {
                    int count = rankCounting.getOrDefault(rank, 0L).intValue();
                    return PrizeResultInfo.from(rank, priceByRank.getByRank(rank), count);
                })
                .toList();
    }

    public long calculateTotalPrize(List<Rank> ranks) {
        Map<Rank, Long> rankCounting = Rank.groupByRank(ranks);
        return rankCounting.entrySet().stream()
                .mapToLong(entry -> {
                    Prize prize = priceByRank.getByRank(entry.getKey());
                    return prize.getAmount() * entry.getValue();
                })
                .sum();
    }
}
