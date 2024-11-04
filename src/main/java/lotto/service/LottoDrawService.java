package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.WinningChecker;
import lotto.reposi.LottoRepository;

public class LottoDrawService {

    public Map<String, Integer> checkWinning(LottoRepository lottoRepository) {
        Bonus bonus = getBonusNumber(lottoRepository);
        Lotto winningLotto = getWinningNumbers(lottoRepository);
        List<List<Integer>> userLottoNumbers = getUserLottoNumbers(lottoRepository);

        return calculateMatchingResults(bonus, winningLotto, userLottoNumbers);
    }

    private Bonus getBonusNumber(LottoRepository lottoRepository) {
        return lottoRepository.getBonusNumber();
    }

    private Lotto getWinningNumbers(LottoRepository lottoRepository) {
        return lottoRepository.getWinningNumbers();
    }

    private List<List<Integer>> getUserLottoNumbers(LottoRepository lottoRepository) {
        return lottoRepository.getLottoNumbers();
    }

    private Map<String, Integer> calculateMatchingResults(Bonus bonus, Lotto winningLotto, List<List<Integer>> userLottoNumbers) {
        return new WinningChecker().checkWinning(bonus, winningLotto, userLottoNumbers);
    }

    public double calculateRate(Map<String, Integer> matchingResult, int numberOfLotto) {
        return new WinningChecker().calculateReturn(matchingResult, numberOfLotto);
    }
}
