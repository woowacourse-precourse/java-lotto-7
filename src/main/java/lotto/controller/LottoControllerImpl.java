package lotto.controller;

import java.util.List;
import lotto.dto.LottoWinningNumbers;
import lotto.dto.lottoDto.LottoResponse;
import lotto.dto.lottoWinningResultDto.LottoWinningResult;
import lotto.dto.lottoWinningResultDto.LottoWinningResultRequest;
import lotto.dto.lottoWinningResultDto.LottoWinningResultResponse;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.util.StringParser;

public class LottoControllerImpl implements LottoController {
    private final LottoService lottoService;

    public LottoControllerImpl() {
        lottoService = new LottoServiceImpl();
    }

    @Override
    public void runLottoProgram() {
        List<Lotto> issuedLotto = runIssueLotto();
        runAnalyzeLotto(issuedLotto);
    }

    @Override
    public List<Lotto> runIssueLotto() {
        Money money = issueLottoStart();
        LottoResponse lottoResponse = issueLottoProgress(money);
        issueLottoEnd(lottoResponse);

        return lottoResponse.issuedLotto();
    }

    @Override
    public Money issueLottoStart() {
        return lottoService.inputLottoMoney();
    }

    @Override
    public LottoResponse issueLottoProgress(Money money) {
        int lottoCount = lottoService.calculatePurchasableLottoCount(money);
        List<Lotto> issuedLotto = lottoService.issueLotto(lottoCount);

        return new LottoResponse(lottoCount, issuedLotto);
    }

    @Override
    public void issueLottoEnd(LottoResponse lottoResponse) {

        lottoService.printIssuedLotto(lottoResponse);
    }


    @Override
    public void runAnalyzeLotto(List<Lotto> issuedLotto) {

        LottoWinningNumbers lottoWinningNumbers = analyzeLottoStart();
        LottoWinningResultResponse lottoWinningResultResponse = analyzeLottoProgress(lottoWinningNumbers, issuedLotto);
        analyzeLottoEnd(lottoWinningResultResponse);
    }

    @Override
    public LottoWinningNumbers analyzeLottoStart() {
        LottoWinningResultRequest lottoWinningResultRequest = lottoService.inputLottoWinningResult();

        int bonusNumber = Integer.parseInt(lottoWinningResultRequest.bonusNumber());
        List<Integer> numbers = StringParser.parse(lottoWinningResultRequest.winningNumbers());
        return new LottoWinningNumbers(new Lotto(numbers), bonusNumber);
    }

    @Override
    public LottoWinningResultResponse analyzeLottoProgress(LottoWinningNumbers lottoWinningNumbers,
                                                           List<Lotto> issuedLotto) {

        LottoWinningResult lottoWinningResult = lottoService.analyzeWinningResult(lottoWinningNumbers, issuedLotto);
        int lottoCount = issuedLotto.size();
        double lottoRateOfReturn = lottoService.analyzeLottoRateOfReturn(lottoWinningResult, lottoCount);

        return new LottoWinningResultResponse(lottoWinningResult, lottoRateOfReturn);
    }

    @Override
    public void analyzeLottoEnd(LottoWinningResultResponse lottoWinningResultResponse) {
        lottoService.printAnalyzedLottoStatus(lottoWinningResultResponse);
    }
}
