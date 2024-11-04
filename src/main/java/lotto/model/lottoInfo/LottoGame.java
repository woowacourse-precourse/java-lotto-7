package lotto.model.lottoInfo;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.controller.dto.LottoResult;
import lotto.controller.dto.PrizeResultInfo;
import lotto.controller.dto.PrizeResultsDto;
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

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getWinningNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber.getBonusNumber();
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
        Map<Rank, Long> rankCounting = groupByRank(lottoResult.ranks());
        return new PrizeResultsDto(generatePrizeInfo(rankCounting));
    }

    private List<PrizeResultInfo> generatePrizeInfo(Map<Rank, Long> rankCounting) {
        return rankCounting.entrySet().stream()
                .map(entry -> PrizeResultInfo.from(
                                entry.getKey(),
                                priceByRank.getByRank(entry.getKey()),
                                entry.getValue().intValue()
                        )
                )
                .toList();
    }

    private Map<Rank, Long> groupByRank(List<Rank> ranks) {
        return ranks.stream()
                .filter(rank -> !rank.isNone())
                .collect(Collectors.groupingBy(rank -> rank,
                        () -> new EnumMap<>(Rank.class),
                        Collectors.counting()));
    }
}
