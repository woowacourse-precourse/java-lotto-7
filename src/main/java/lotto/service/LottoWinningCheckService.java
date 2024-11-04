package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.constant.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.LottoPayment;
import lotto.domain.WinningLotto;
import lotto.dto.WinningResultDto;
import lotto.dto.WinningStatisticsDto;
import lotto.vo.Money;

public class LottoWinningCheckService {

    public List<WinningResultDto> check(List<Lotto> lottos, WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::match)
                .filter(LottoRank::isWinning)
                .map(WinningResultDto::from)
                .toList();
    }

    public WinningStatisticsDto createStatistics(List<WinningResultDto> winningResults, LottoPayment lottoPayment) {
        List<WinningStatisticsDto.WinningCountDto> winningCounts = createWinningCounts(winningResults);
        Money totalPrize = Money.from(calculateTotalPrizeAmount(winningResults));
        Money initialAmount = lottoPayment.getInitialAmount();

        return WinningStatisticsDto.of(
                winningCounts,
                calculateReturnRate(totalPrize, initialAmount)
        );
    }

    private List<WinningStatisticsDto.WinningCountDto> createWinningCounts(List<WinningResultDto> results) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.MISS)
                .map(rank -> createWinningCount(rank, results))
                .toList();
    }

    private WinningStatisticsDto.WinningCountDto createWinningCount(LottoRank rank, List<WinningResultDto> results) {
        return WinningStatisticsDto.WinningCountDto.of(
                rank.getMatchCount(),
                rank.hasBonusMatch(),
                rank.getPrizeAmount(),
                countMatchingResults(rank, results)
        );
    }

    private int countMatchingResults(LottoRank rank, List<WinningResultDto> results) {
        return (int) results.stream()
                .filter(result -> result.isSameRank(rank))
                .count();
    }

    private long calculateTotalPrizeAmount(List<WinningResultDto> results) {
        return results.stream()
                .mapToLong(WinningResultDto::prizeAmount)
                .sum();
    }

    private double calculateReturnRate(Money totalPrize, Money initialAmount) {
        return (double) totalPrize.getValue() / initialAmount.getValue();
    }
}
