package lotto.app;

import java.io.BufferedWriter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import lotto.Lotto;
import lotto.LottoAnswer;
import lotto.LottoFactory;
import lotto.LottoResult;
import lotto.LottoStatistics;
import lotto.exception.LottoException;
import lotto.interaction.input.LottoInput;
import lotto.interaction.input.WoowaLottoInput;
import lotto.interaction.output.LottoOutput;
import lotto.interaction.output.LottoStdOutput;

public class CLILottoApp implements LottoApp{
    private final LottoOutput output;
    private final LottoInput input;

    public CLILottoApp() {
        this.output = new LottoStdOutput();
        this.input = new WoowaLottoInput();
    }

    private <T> T assertInput(Supplier<T> inputFunction) {
        while (true) {
            try {
                return inputFunction.get();
            } catch (LottoException exception) {
                output.printErrorMessage(exception.getMessage());
            }
        }
    }

    private Integer assertGetBonusNumber(Function<List<Integer>, Integer> inputFunction, List<Integer> winningNumbers) {
        while (true) {
            try {
                return inputFunction.apply(winningNumbers);
            } catch (LottoException exception) {
                output.printErrorMessage(exception.getMessage());
            }
        }
    }

    private int getMoney() {
        output.printToInputPurchaseMoney();
        return assertInput(input::inputPurchaseMoney);
    }

    private List<Lotto> generateLotto(int money) {
        List<Lotto> lottos = LottoFactory.getInstance().buyLotto(money);
        output.printPurchasedLotto(lottos);
        return lottos;
    }

    private LottoAnswer getAnswer() {
        output.printToInputWinningNumber();
        List<Integer> winningNumbers = assertInput(input::inputWinningNumbers);
        output.printToInputBonusNumber();
        Integer bonusNumber = assertGetBonusNumber(input::inputBonusNumber, winningNumbers);
        return new LottoAnswer(winningNumbers, bonusNumber);
    }

    private List<Optional<LottoResult>> collectLottoResults(List<Lotto> lottoList, LottoAnswer answer) {
        return lottoList.stream()
                .map(lotto -> lotto.getResult(answer))
                .toList();
    }

    private void outputResultSummary(List<Optional<LottoResult>> lottoResults) {
        Map<LottoResult, Integer> resultMap = LottoStatistics.countResult(lottoResults);
        double rateOfReturn = LottoStatistics.getRateOfReturn(lottoResults);
        output.printWinningStatistics(resultMap, rateOfReturn);
    }


    @Override
    public void run() {
        int money = getMoney();
        List<Lotto> lottoList = generateLotto(money);
        LottoAnswer answer = getAnswer();
        List<Optional<LottoResult>> lottoResults = collectLottoResults(lottoList, answer);
        outputResultSummary(lottoResults);
    }
}
