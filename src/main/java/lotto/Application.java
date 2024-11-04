package lotto;

import lotto.dto.UserInputDTO;
import lotto.dto.WinningResultDTO;
import lotto.input.BonusNumberInput;
import lotto.input.CloseInput;
import lotto.input.LottoPurchaseAmountInput;
import lotto.input.WinningNumbersInput;
import lotto.input.matcher.LottoNumbersMatcher;
import lotto.input.producer.AllLottoNumbersProducer;
import lotto.input.validator.BonusNumberValidator;
import lotto.input.validator.LottoPurchaseAmountValidator;
import lotto.input.validator.WinningNumbersValidator;
import lotto.model.Lotto;
import lotto.output.WinningStatisticsOutput;
import lotto.util.WinningCalculator;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        LottoPurchaseAmountInput lottoPurchaseAmountInput =
                new LottoPurchaseAmountInput(new LottoPurchaseAmountValidator());
        WinningNumbersInput winningNumbersInput =
                new WinningNumbersInput(new WinningNumbersValidator());
        BonusNumberInput bonusNumberInput =
                new BonusNumberInput(new BonusNumberValidator());

        LottoNumbersMatcher lottoNumbersMatcher =
                new LottoNumbersMatcher();
        AllLottoNumbersProducer allLottoNumbersProducer =
                new AllLottoNumbersProducer();
        WinningCalculator winningCalculator =
                new WinningCalculator(lottoNumbersMatcher);

        WinningStatisticsOutput winningStatisticsOutput =
                new WinningStatisticsOutput();



        Integer purchaseAmount = lottoPurchaseAmountInput.run();

        List<Lotto> allLottoNumbers = allLottoNumbersProducer.getAllLottoNumbersByCount(purchaseAmount / 1000);

        Lotto lotto = winningNumbersInput.run();
        Integer bonusNumber = bonusNumberInput.run();
        CloseInput.run();

        UserInputDTO userInputDTO = new UserInputDTO(lotto, bonusNumber);

        WinningResultDTO winningResultDTO =
                winningCalculator.getWinningResult(userInputDTO, allLottoNumbers);

        winningStatisticsOutput.run(winningResultDTO, purchaseAmount);
    }
}
