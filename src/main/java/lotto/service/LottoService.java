package lotto.service;

import java.util.List;
import lotto.dto.LottoWinningNumbers;
import lotto.dto.lottoDto.LottoResponse;
import lotto.dto.lottoWinningResultDto.LottoWinningResult;
import lotto.dto.lottoWinningResultDto.LottoWinningResultRequest;
import lotto.dto.lottoWinningResultDto.LottoWinningResultResponse;
import lotto.model.Lotto;
import lotto.model.Money;

public interface LottoService {

    // About Issue Lotto
    public Money inputLottoMoney();

    public int calculatePurchasableLottoCount(Money money);

    public List<Lotto> issueLotto(int purchasableLottoCount);

    public void printIssuedLotto(LottoResponse lottoResponse);

    
    // About Analyze Lotto
    public LottoWinningResultRequest inputLottoWinningResult();

    public LottoWinningResult analyzeWinningResult(LottoWinningNumbers lottoWinningNumbers, List<Lotto> issuedLotto);

    public double analyzeLottoRateOfReturn(LottoWinningResult lottoWinningResult, int lottoCount);

    public void printAnalyzedLottoStatus(LottoWinningResultResponse lottoWinningResultResponse);

}
