package service;

import camp.nextstep.edu.missionutils.Randoms;
import dto.LottoWinningNumbers;
import dto.lottoWinningResultDto.LottoWinningResult;
import dto.lottoWinningResultDto.LottoWinningResultRequest;
import dto.lottoWinningResultDto.LottoWinningResultResponse;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
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

        BigInteger money = new BigInteger(_money.getMoney());

        return money.divide(new BigInteger("1000"));
    }

    @Override
    public List<Lotto> issueLotto(BigInteger purchasableLottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        BigInteger i = new BigInteger("0");
        while (purchasableLottoCount.compareTo(i) > 0) {
            lottos.add(issueOneLotto());
            i = i.add(new BigInteger("1"));
        }

        return lottos;
    }

    public Lotto issueOneLotto() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lotto);
        return new Lotto(lotto);
    }

    @Override
    public LottoWinningResultRequest inputLottoWinningResult() {
        return inputView.inputLottoWinningResult();
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
