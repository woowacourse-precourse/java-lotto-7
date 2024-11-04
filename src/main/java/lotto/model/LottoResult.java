package lotto.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.dto.LottoDto;

public class LottoResult {
    private final Map<Rank, Integer> lottoResult = new EnumMap<>(Rank.class);

    public LottoResult(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        for (Rank rank : Rank.values()) {
            lottoResult.put(rank, 0);
        }

        calculateLottosResult(lottos, winningNumbers, bonusNumber);
    }

    public Map<Rank, Integer> getLottoResult() {
        return Collections.unmodifiableMap(lottoResult);
    }

    private void calculateLottosResult(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        List<LottoDto> lottoDtos = lottos.getLottoDtos();

        for (LottoDto lottoDto : lottoDtos) {

            List<Integer> lottoNumbers = lottoDto.numbers();

            int duplicateCount = getDuplicateNumbers(lottoNumbers, winningNumbers.getWinningNumbers());
            boolean isBonusNumberDuplicated = isBonusNumberDuplicated(lottoNumbers, bonusNumber.getBonusNumber());
            saveLottoResult(duplicateCount, isBonusNumberDuplicated);
        }
    }

    private int getDuplicateNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        lottoNumbers = new ArrayList<>(lottoNumbers);
        winningNumbers = new ArrayList<>(winningNumbers);

        lottoNumbers.retainAll(winningNumbers);
        return lottoNumbers.size();
    }

    private boolean isBonusNumberDuplicated(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    private void saveLottoResult(int duplicateCount, boolean isBonusNumberDuplicated) {
        Rank rank = Rank.from(duplicateCount, isBonusNumberDuplicated);
        lottoResult.put(rank, lottoResult.get(rank) + 1);
    }
}
