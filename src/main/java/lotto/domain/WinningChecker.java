package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.repository.LottoRepository;

public class WinningChecker {
    private LottoRepository lottoRepository;
    private List<int[]> matchingResult = new ArrayList<>();

    public Map<String, Integer> checkWinning() {
        Bonus bonus = lottoRepository.getBonusNumber();
        Lotto lotto = lottoRepository.getWinningNumbers();

        for (List<Integer> userLotto : lottoRepository.getLottoNumbers()) {
            matchingResult.add(lotto.matching(userLotto, bonus));
        }
        return new LottoRankCounter().countRanks(matchingResult);
    }

    public WinningChecker(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;

    }

}
