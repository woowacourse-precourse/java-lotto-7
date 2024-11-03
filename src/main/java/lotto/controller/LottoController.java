package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Bonus;
import lotto.model.EarningRate;
import lotto.model.Lotto;
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
    //private final LottoPublisher lottoPublisher;

    public LottoController(InputView inputView, OutputView outputView, ValidationManager validationManager) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.validationManager = validationManager;
    }

    public void play() {
        Amount validAmount = handleAmountInputError();
        List<Integer> validLottoNumbers = handleLottoNumberInputError();
        LottoPublisher lottoPublisher = new LottoPublisher(validAmount.getPublishCount());
        List<List<Integer>> publishedLotto = lottoPublisher.getPublishedLotto();
        outputView.printPublishedLotto(publishedLotto);
        int validBonusNumber = handleBonusInputError();
        LottoMatchEvaluator lottoMatchEvaluator = new LottoMatchEvaluator(validLottoNumbers,validBonusNumber,lottoPublisher);

        List<Integer> lottoWinningCounts = lottoMatchEvaluator.getLottoWinningCounts();
        outputView.printOrderdLottoResult(lottoWinningCounts);
        EarningRate earningRate = new EarningRate(lottoWinningCounts,validAmount);
        outputView.printEarningRate(earningRate.getEarningRate());
    }

    public Amount handleAmountInputError() { //얘네들이 15줄을 넘는 이유는 기능이 3가지임 인풋 아웃풋 컨트롤 , 타당성 체크, 형변환
        boolean validInput = false;
        Amount amount ;

        while (!validInput) {
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
        boolean validInput = false;
        Lotto lotto;

        while (!validInput) {
            try {
                String lottoInput = inputView.readInput(Lotto.getRequestMessage());
                validationManager.isNumbersDividedByComma(lottoInput); //정수와 쉼표로 이루어져있는지 확인
                lotto = new Lotto(TypeConverter.ToNumberList(lottoInput));//6자 이상인지 범위는 (1-45)인지 확인후 객체 생성
                return lotto.getLottoNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return new ArrayList<>();
    }

    public int handleBonusInputError() {
        boolean validInput = false;
        Bonus bonus;

        while (!validInput) {
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
