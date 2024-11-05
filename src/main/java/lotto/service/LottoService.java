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
    Money inputLottoMoney();

    int calculatePurchasableLottoCount(Money money);

    List<Lotto> issueLotto(int purchasableLottoCount);

    void printIssuedLotto(LottoResponse lottoResponse);

    // About Analyze Lotto
    LottoWinningResultRequest inputLottoWinningResult();

    LottoWinningResult analyzeWinningResult(LottoWinningNumbers lottoWinningNumbers, List<Lotto> issuedLotto);

    double analyzeLottoRateOfReturn(LottoWinningResult lottoWinningResult, int lottoCount);

    void printAnalyzedLottoStatus(LottoWinningResultResponse lottoWinningResultResponse);

}
