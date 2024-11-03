package service;

import camp.nextstep.edu.missionutils.Randoms;
import dto.LottoWinningNumbers;
import dto.lottoDto.LottoResponse;
import dto.lottoWinningResultDto.LottoWinningResult;
import dto.lottoWinningResultDto.LottoWinningResultRequest;
import dto.lottoWinningResultDto.LottoWinningResultResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Lotto;
import model.Money;
import view.InputView;
import view.InputViewImpl;
import view.OutputView;
import view.OutputViewImpl;

public class LottoServiceImpl implements LottoService {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoServiceImpl() {
        this.inputView = new InputViewImpl();
        this.outputView = new OutputViewImpl();
    }

    @Override
    public Money inputLottoMoney() {
        String userInputMoney = inputView.inputMoney();
        try {
            return new Money(userInputMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLottoMoney();
        }
    }

    @Override
    public int calculatePurchasableLottoCount(Money _money) {

        int money = Integer.parseInt(_money.getMoney());

        return money / 1000;
    }

    @Override
    public List<Lotto> issueLotto(int purchasableLottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchasableLottoCount; i++) {
            lottos.add(issueOneLotto());
        }

        return lottos;
    }

    public Lotto issueOneLotto() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lotto);
        return new Lotto(lotto);
    }

    @Override
    public void printIssuedLotto(LottoResponse lottoResponse) {
        outputView.printIssuedLotto(lottoResponse);
    }


    @Override
    public LottoWinningResultRequest inputLottoWinningResult() {
        return inputView.inputLottoWinningResult();
    }

    // TODO: 리팩토링 하기
    @Override
    public LottoWinningResult analyzeWinningResult(LottoWinningNumbers lottoWinningNumbers,
                                                   List<Lotto> issuedLotto) {

        List<Integer> lottoResult = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        for (Lotto lotto : issuedLotto) {
            int lottoRank = getRank(lottoWinningNumbers, lotto);
            if (lottoRank == 1) {
                lottoResult.set(0, lottoResult.get(0) + 1); // 1등 자리에 +1
            }
            if (lottoRank == 2) {
                lottoResult.set(1, lottoResult.get(1) + 1); // 1등 자리에 +1
            }
            if (lottoRank == 3) {
                lottoResult.set(2, lottoResult.get(2) + 1); // 1등 자리에 +1
            }
            if (lottoRank == 4) {
                lottoResult.set(3, lottoResult.get(3) + 1); // 1등 자리에 +1
            }
            if (lottoRank == 5) {
                lottoResult.set(4, lottoResult.get(4) + 1); // 1등 자리에 +1
            }
        }

        return new LottoWinningResult(lottoResult.get(0), lottoResult.get(1), lottoResult.get(2), lottoResult.get(3),
                lottoResult.get(4));
    }

    // TODO: 리팩토링 하기
    public int getRank(LottoWinningNumbers lottoWinningNumbers, Lotto lotto) {
        Lotto winningLotto = lottoWinningNumbers.winningLotto();

        int result = 0;
        for (Integer number : winningLotto.getNumbers()) {
            if (lotto.getNumbers().contains(number)) {
                result++;
            }
        }

        if (result == 6) {
            return 1;
        }

        if (lotto.getNumbers().contains(lottoWinningNumbers.bonusNumber())) {
            if (result == 5) {
                return 2;
            }
        }

        if (!lotto.getNumbers().contains(lottoWinningNumbers.bonusNumber()) && result == 5) {
            return 3;
        }

        if (result == 4) {
            return 4;
        }

        if (result == 3) {
            return 5;
        }

        return 0;
    }

    @Override
    public double analyzeLottoRateOfReturn(LottoWinningResult lottoWinningResult, int lottoCount) {
        double money = lottoCount * 1000;
        double lottoWinningAmount
                = lottoWinningResult.firstPlaceNumber() * 2000000000 + lottoWinningResult.secondPlaceNumber() * 30000000
                + lottoWinningResult.thirdPlaceNumber() * 1500000 + lottoWinningResult.fourthPlaceNumber() * 50000
                + lottoWinningResult.fifthPlaceNumber() * 5000;

        return lottoWinningAmount / money * 100;
    }


    @Override
    public void printAnalyzedLottoStatus(LottoWinningResultResponse lottoWinningResultResponse) {
        outputView.printLottoResult(lottoWinningResultResponse);
    }
}
