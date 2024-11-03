package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.WinningChecker;
import lotto.reposi.LottoRepository;

public class LottoDrawService {

    public Map<String, Integer> checkWinning(LottoRepository lottoRepository) {
        Bonus bonus = lottoRepository.getBonusNumber();
        Lotto lotto = lottoRepository.getWinningNumbers();
        List<List<Integer>> userLotto = lottoRepository.getLottoNumbers();

        WinningChecker winningChecker = new WinningChecker();
        Map<String, Integer> matchingResult = winningChecker.checkWinning(bonus, lotto, userLotto);
        return matchingResult;
    }

    public double calculateRate(Map<String, Integer> matchingResult, int numberOfLotto) {
        return WinningChecker.calculateReturn(matchingResult, numberOfLotto);
    }
}
