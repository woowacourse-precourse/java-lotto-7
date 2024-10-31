package lotto.model;


import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.dto.LottoDto;

public class LottoResult {

    public void calculateLottosResult(Lottos lottos, WinningNumbers winningNumbers) {
        List<LottoDto> lottoDtos = lottos.getLottoDtos();

        for (LottoDto lottoDto : lottoDtos) {

            List<Integer> lottoNumbers = lottoDto.numbers();

            int duplicateCount = getDuplicateNubers(lottoNumbers, winningNumbers.getWinningNumbers());
            boolean isBonusNumberDuplicated = isBonusNumberDuplicated(lottoNumbers, winningNumbers.getBonusNumber())
        }
    }

    private int getDuplicateNubers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        lottoNumbers.retainAll(winningNumbers);
        return lottoNumbers.size();
    }

    private boolean isBonusNumberDuplicated(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    private void saveLottoResult(int duplicateCount, boolean isBonusNumberDuplicated) {

    }
}
