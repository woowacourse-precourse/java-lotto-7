package service;

import dto.LottoWinningNumbers;
import dto.lottoWinningResultDto.LottoWinningResult;
import dto.lottoWinningResultDto.LottoWinningResultRequest;
import dto.lottoWinningResultDto.LottoWinningResultResponse;
import java.math.BigInteger;
import java.util.List;
import lotto.Lotto;
import model.Money;
import view.InputView;
import view.InputViewImpl;

public class LottoServiceImpl implements LottoService {
    private final InputView inputView;

    public LottoServiceImpl() {
        this.inputView = new InputViewImpl();
    }

    @Override
    public Money inputLottoMoney() {
        String userInputMoney = inputView.inputMoney();
        return new Money(userInputMoney);
    }

    @Override
    public BigInteger calculatePurchasableLottoCount(Money _money) {
        return null;
    }

    @Override
    public List<Lotto> issueLotto(BigInteger purchasableLottoCount) {

        return null;
    }

    @Override
    public LottoWinningResultRequest inputLottoWinningResult() {
        return null;
    }


    // TODO: 로또 결과를 도출하는 메서드 : 필요한건 당첨 및 보너스 번호
    @Override
    public LottoWinningResult analyzeWinningResult(LottoWinningNumbers lottoWinningNumbers, List<Lotto> issuedLotto) {

        return null;
    }

    // TODO: 로또 결과의 수익률을 도출하는 메서드 : 필요한건 당첨 결과
    public double analyzeLottoRateOfReturn(LottoWinningResult lottoWinningResult) {

        return 0;
    }


    @Override
    public void printAnalyzedLottoStatus(LottoWinningResultResponse lottoWinningResultResponse) {

    }
}
