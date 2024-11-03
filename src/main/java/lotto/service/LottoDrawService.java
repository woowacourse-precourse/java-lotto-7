package lotto.service;

import java.util.Map;
import lotto.domain.LottoRank;
import lotto.domain.WinningChecker;
import lotto.repository.LottoRepository;

public class WinningManager {
    public Map<String, Integer> checkWinning(LottoRepository lottoRepository) {
        Map<String, Integer> matchingResult = new WinningChecker(lottoRepository).checkWinning();
        calculateRate(matchingResult, lottoRepository);
        return matchingResult;
    }

    public double calculateRate(Map<String, Integer> matchingResult, LottoRepository lottoRepository) {
        double sum = 0;
        for (LottoRank rank : LottoRank.values()) {
            sum += rank.getPrize() * matchingResult.get(rank.name());
        }
        double result = sum / (lottoRepository.getLottoNumbers().size() * 1000) * 100;
        return result;
    }
}
