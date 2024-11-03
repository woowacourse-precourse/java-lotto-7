package lotto.service;

import java.util.List;
import lotto.domain.lottoGeneratir.LottoGenerator;
import lotto.dto.WinningLotto;

public class LottoGenerateManager {
    private LottoGenerator lottoGenerator;
    public LottoGenerateManager(LottoGenerator lottoGenerator){
        this.lottoGenerator = lottoGenerator;
    }

    public WinningLotto provideWinningLotto(List<Integer> numbers, int bonusNumber){
        return (WinningLotto) lottoGenerator.generateWinningLotto(numbers, bonusNumber);
    }
}
