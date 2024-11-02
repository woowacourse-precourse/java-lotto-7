package service;

import dto.LottoWinningNumbers;
import dto.lottoDto.LottoResponse;
import dto.lottoWinningResultDto.LottoWinningResult;
import dto.lottoWinningResultDto.LottoWinningResultRequest;
import dto.lottoWinningResultDto.LottoWinningResultResponse;
import java.math.BigInteger;
import java.util.List;
import lotto.Lotto;
import model.Money;

public interface LottoService {

    // About Issue Lotto
    public Money inputLottoMoney();

    public BigInteger calculatePurchasableLottoCount(Money money);

    public List<Lotto> issueLotto(BigInteger money);

    public void printIssuedLotto(LottoResponse lottoResponse);

    // About Analyze Lotto
    public LottoWinningResultRequest inputLottoWinningResult();

    public LottoWinningResult analyzeWinningResult(LottoWinningNumbers lottoWinningNumbers, List<Lotto> issuedLotto);

    public double analyzeLottoRateOfReturn(LottoWinningResult lottoWinningResult, int lottoCount);

    public void printAnalyzedLottoStatus(LottoWinningResultResponse lottoWinningResultResponse);

}
