package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.Lottos;
import lotto.domain.Money;
import lotto.dto.Result;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.util.List;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        Money money = takeMoney();
        Lottos lottos = lottoService.makeRandomLotto(money.getMoney());
        printBoughtLottoResult(lottos);

        List<Integer> winningSixNumbers = getWinningSixNumbers();
        Integer winningBonusNumber = getWinningBonusNumber();

        List<Integer> calculatedLottoResults = lottoService.calculateLottoResults(lottos, winningSixNumbers, winningBonusNumber);
        BigDecimal earningRate = lottoService.calculateEarningRate(money.getMoney(), calculatedLottoResults);
        printCalculatedResult(new Result(calculatedLottoResults, earningRate));

        Console.close();
    }

    private static Money takeMoney() {
        try {
            String inputMoney = InputView.inputMoney();
            return new Money(inputMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return takeMoney();
        }
    }

    private static void printBoughtLottoResult(Lottos lottos) {
        OutputView.outputLottoBuyCount(lottos.getLottosSize());
        OutputView.outputLottos(lottos.lottos());
    }

    private List<Integer> getWinningSixNumbers() {
        try {
            String winningNumbers = InputView.inputWinningNumbers();
            return lottoService.splitSixNumbers(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningSixNumbers();
        }
    }

    private Integer getWinningBonusNumber() {
        try {
            String BonusNumber = InputView.inputWinningBonusNumber();
            return lottoService.getBonusNumber(BonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningBonusNumber();
        }
    }

    private static void printCalculatedResult(Result calculatedResults) {
        OutputView.outputResult(calculatedResults.lottoMatchResults());
        OutputView.outputEarningRate(calculatedResults.earningRate());
    }
}
