package lotto.service;

import static lotto.eunm.LottoConstants.*;
import static lotto.eunm.WinningResult.*;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.dto.LottoDto;
import lotto.dto.WinningDto;

public class LottoService {

    public WinningDto statisticsNumbers(LottoDto lottoDto) {
        List<Integer> matchStatistics = calculateLottoNumber(lottoDto, lottoDto.getLottos(),
                lottoDto.getWinningNumbers());
        WinningDto winningDto = WinningDto.of(matchStatistics);
        winningDto.setPrice(totalPrice(winningDto, lottoDto.getLottosSize() * TICKET_PRICE_UNIT.value));
        return winningDto;
    }

    private List<Integer> calculateLottoNumber(LottoDto lottoDto, List<Lotto> lottos, List<Integer> winningNumbers) {
        List<Integer> matchStatistics = initializeMatchStatistics();

        for (Lotto lotto : lottos) {
            processLotto(lottoDto, winningNumbers, matchStatistics, lotto);
        }

        return matchStatistics;
    }

    private List<Integer> initializeMatchStatistics() {
        return new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0));
    }

    private void processLotto(LottoDto lottoDto, List<Integer> winningNumbers, List<Integer> matchStatistics,
                              Lotto lotto) {
        int matchedCount = countMatchedNumbers(lotto.getSortNumbers(), winningNumbers);
        updateMatchStatistics(lottoDto, lotto, matchedCount, matchStatistics);
    }

    private static void updateMatchStatistics(LottoDto lottoDto, Lotto lotto, int matchedCount,
                                              List<Integer> matchStatistics) {
        if (isBonusMatch(lottoDto, lotto, matchedCount)) {
            matchStatistics.set(FIVE_AND_BONUS.winningCount, matchStatistics.get(FIVE_AND_BONUS.winningCount) + 1);
            return;
        }

        if (isValidMatchCount(matchedCount, matchStatistics)) {
            if (matchedCount == 6) {
                matchStatistics.set(SIX.winningCount, matchStatistics.get(SIX.winningCount) + 1);
                return;
            }
            matchStatistics.set(matchedCount, matchStatistics.get(matchedCount) + 1);
        }
    }

    private int countMatchedNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    private static boolean isValidMatchCount(int matchedCount, List<Integer> matchStatistics) {
        return matchedCount > MINIMUM_NUMBER.value && matchedCount < matchStatistics.size();
    }

    private static boolean isBonusMatch(LottoDto lottoDto, Lotto lotto, int matchedCount) {
        return matchedCount == FOUR.winningCount && matchedBonusNumber(lottoDto, lotto);
    }

    private static boolean matchedBonusNumber(LottoDto lottoDto, Lotto lotto) {
        return lotto.getSortNumbers().contains(lottoDto.getBonusNumber());
    }

    private double totalPrice(WinningDto winningDto, int buyPrice) {
        return calculateProfit(getTotalPrize(winningDto), buyPrice);
    }

    private static int getTotalPrize(WinningDto winningDto) {
        return winningDto.getWinningCount().entrySet().stream()
                .filter(entry -> entry.getValue() != MINIMUM_NUMBER.value)
                .mapToInt(entry -> entry.getKey().prizeMoney * entry.getValue())
                .sum();
    }

    private double calculateProfit(int totalPrize, int buyPrice) {
        return ((double) totalPrize / buyPrice) * PERCENTAGE_BASE.value;    // 수익률 계산: (당첨금 / 구매금액) * 100
    }

}
