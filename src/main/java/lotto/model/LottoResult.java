package lotto.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.dto.LottoDto;

public class LottoResult {
    private final Map<Rank, Integer> lottoResult = new EnumMap<>(Rank.class);

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            lottoResult.put(rank, 0);
        }
    }

    public void calculateLottosResult(Lottos lottos, WinningNumbers winningNumbers) {
        List<LottoDto> lottoDtos = lottos.getLottoDtos();

        for (LottoDto lottoDto : lottoDtos) {

            List<Integer> lottoNumbers = lottoDto.numbers();

            int duplicateCount = getDuplicateNubers(lottoNumbers, winningNumbers.getWinningNumbers());
            boolean isBonusNumberDuplicated = isBonusNumberDuplicated(lottoNumbers, winningNumbers.getBonusNumber());
            saveLottoResult(duplicateCount, isBonusNumberDuplicated);
        }
    }

    public Map<Rank, Integer> getLottoResult() {
        return Collections.unmodifiableMap(lottoResult);
    }

    private int getDuplicateNubers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
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
