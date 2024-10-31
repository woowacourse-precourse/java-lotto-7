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
            calculateLottoResult(lottoDto, winningNumbers);
        }
    }

    private void calculateLottoResult(LottoDto lottoDto, WinningNumbers winningNumbers) {

    }

    private void saveLottoResult(int duplicateCount) {

    }
}
