package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
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
        int validAmount = handleAmountInputError();
        List<Integer> validLottoNumbers = handleLottoNumberInputError();
        int validBonusNumber = handleBonusInputError();
    }

    public int handleAmountInputError() {
        boolean validInput = false;
        int amountInput = 0;

        while (!validInput) {
            try {
                outputView.printRequest(OutputView.REQUEST_AMOUNT_MESSAGE);
                String input = inputView.readInput();

                validationManager.isNotEmptyInput(input);
                validationManager.isNumber(input);
                validInput = validationManager.isDivideByThousand(input);

                amountInput = TypeConverter.ToNumber(input);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return amountInput;
    }

    public List<Integer> handleLottoNumberInputError() {
        boolean validInput = false;
        List<Integer> validLottoNumbers = new ArrayList<>();

        while (!validInput) {
            try {
                outputView.printRequest(OutputView.REQUEST_NUMBER_MESSAGE);
                String lottoInput = inputView.readInput();

                validationManager.isNumbersDividedByComma(lottoInput); //정수와 쉼표로 이루어져있는지 확인
                List<Integer> lottoNumbrs = TypeConverter.ToNumberList(lottoInput);
                validInput = validationManager.isRangeValid(lottoNumbrs);
                Lotto lotto = new Lotto(lottoNumbrs);//6자 이상인지 1-45안에 있는지 확인후 객체 생성
                validLottoNumbers = lotto.getLottoNumbers();


            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return validLottoNumbers;
    }

    public int handleBonusInputError() {
        boolean validInput = false;
        int bonusNumberInput = 0;

        while (!validInput) {
            try {
                outputView.printRequest(OutputView.REQUEST_BONUS_MESSAGE);
                String input = inputView.readInput();

                validationManager.isNotEmptyInput(input);
                validationManager.isNumber(input);
                bonusNumberInput = TypeConverter.ToNumber(input);
                validInput = validationManager.isRangeValid(bonusNumberInput);


            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return bonusNumberInput;
    }
}
