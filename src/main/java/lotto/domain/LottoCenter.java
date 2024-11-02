package lotto.domain;

import lotto.domain.lottoGeneratir.LottoGenerator;
import lotto.dto.LottoDto;
import lotto.dto.WinningLotto;

public class LottoCenter {
    private WinningLotto winningLotto;
    private LottoGenerator lottoGenerator;
    public LottoCenter(LottoGenerator lottoGenerator){
        this.lottoGenerator = lottoGenerator;
    }
    public void drawWinningNumbers(LottoDto lottoDto){
        winningLotto = lottoGenerator.generateWinningLotto(lottoDto.getNumbers(), lottoDto.getBonus());
    }
    public WinningLotto getWinningLotto(){
        return winningLotto;
    }
}
