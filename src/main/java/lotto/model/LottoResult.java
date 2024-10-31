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
            int duplicateCount = getDuplicateNubers(lottoDto.numbers(), winningNumbers.getWinningNumbers());
        }
    }

    private int getDuplicateNubers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        lottoNumbers.retainAll(winningNumbers);
        return lottoNumbers.size();
    }

    private void saveLottoResult(int duplicateCount, boolean isBonusDuplicated) {

    }
}
