package lotto.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.util.Calculator;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView input;
    private final OutputView output;

    public LottoController(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void proceed() {
        int lottoAmount = inputLottoAmount();
        int lottoTicketCount = Calculator.calculateLottoTicketNumber(lottoAmount);
        List<Lotto> userLottos = LottoMachineController.issueLotto(lottoTicketCount);
        output.printLottoTicket(userLottos, lottoTicketCount);

        Lotto winningLotto = new Lotto(inputWinningNumber());
        int bonusNumber = inputBonusNumber(winningLotto);

        Map<Result, Integer> results = compareLottoWithWinningNumber(userLottos, winningLotto, bonusNumber);
        output.printProfit(Calculator.calculateProfit(lottoAmount, results));
    }

    public int inputLottoAmount() {
        try {
            return input.inputLottoAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLottoAmount();
        }
    }

    public List<Integer> inputWinningNumber() {
        try {
            return input.inputWinningNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumber();
        }
    }

    public int inputBonusNumber(Lotto winningLotto) {
        try {
            int bonusNumber = input.inputBonusNumber();
            Validator.validateBonusDuplicate(winningLotto, bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(winningLotto);
        }
    }

    public Map<Result, Integer> compareLottoWithWinningNumber(List<Lotto> userLottos, Lotto winningLotto,
                                                              int bonusNumber) {
        Map<Result, Integer> results = new LinkedHashMap<>();
        for (int i = 1; i < Result.values().length; i++) {
            results.put(Result.values()[i], 0);
        }

        for (Lotto userLotto : userLottos) {
            Result result = userLotto.compareWithWinningLotto(winningLotto, bonusNumber);
            if (result == Result.NOTHING) {
                continue;
            }
            results.put(result, results.get(result) + 1);
        }
        printResults(results);
        return results;
    }

    public void printResults(Map<Result, Integer> results) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Result result : results.keySet()) {
            output.printResult(result.getMatchCount(), result.getPrizeMoney(), result.getIsBonusMatch(),
                    results.get(result));
        }
    }
}
