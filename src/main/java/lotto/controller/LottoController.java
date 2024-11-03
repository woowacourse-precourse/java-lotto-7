package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Bonus;
import lotto.model.EarningRate;
import lotto.Lotto;
import lotto.model.Amount;
import lotto.model.LottoMatchEvaluator;
import lotto.model.LottoPublisher;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.ValidationManager;
import utils.TypeConverter;

public class LottoController {

    private final OutputView outputView;
    private final InputView inputView;
    private final ValidationManager validationManager;

    public LottoController(InputView inputView, OutputView outputView, ValidationManager validationManager) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.validationManager = validationManager;
    }

    public void play() {
        Amount validAmount = handleAmountInputError();
        LottoPublisher lottoPublisher = new LottoPublisher(validAmount.getPublishCount());
        List<List<Integer>> publishedLotto = lottoPublisher.getPublishedLotto();
        List<Integer> validLottoNumbers = handleLottoNumberInputError();

        outputView.printPublishedLotto(publishedLotto);
        int validBonusNumber = handleBonusInputError();
        LottoMatchEvaluator lottoMatchEvaluator = new LottoMatchEvaluator(validLottoNumbers, validBonusNumber,
                lottoPublisher);

        List<Integer> lottoWinningCounts = lottoMatchEvaluator.getLottoWinningCounts();
        outputView.printOrderdLottoResult(lottoWinningCounts);
        EarningRate earningRate = new EarningRate(lottoWinningCounts, validAmount);
        outputView.printEarningRate(earningRate.getEarningRate());
    }

    public Amount handleAmountInputError() {
        Amount amount;
        boolean valid = false;
        while (!valid) {
            try {
                String input = inputView.readInput(Amount.getRequestMessage());
                isValidAmountInput(input);
                amount = new Amount(TypeConverter.ToNumber(input)); //1000으로 나누어떨어지는 지 확인 후 생성
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public boolean isValidAmountInput(String input) {
        validationManager.isNotEmptyInput(input);
        return validationManager.isNumber(input);
    }

    public List<Integer> handleLottoNumberInputError() {
        Lotto lotto;
        boolean valid = false;
        while (!valid) {
            try {
                String lottoInput = inputView.readInput(Lotto.getRequestMessage());
                validationManager.isNumbersDividedByComma(lottoInput); //정수와 쉼표로 이루어져있는지 확인
                lotto = new Lotto(TypeConverter.ToNumberList(lottoInput));//6자 이상인지 범위는 (1-45)인지 확인후 객체 생성
                return lotto.getLottoNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public int handleBonusInputError() {
        Bonus bonus;
        boolean valid = false;
        while (!valid) {
            try {
                String input = inputView.readInput(Bonus.getRequestMessage());
                validationManager.isNotEmptyInput(input);
                validationManager.isNumber(input);
                bonus = new Bonus(TypeConverter.ToNumber(input));
                return bonus.getBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return 0;
    }
}
