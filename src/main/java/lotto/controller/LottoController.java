package lotto.controller;

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
        String validAmount = handleAmountInputError();
        String validLottoNumbers = handleLottoNumberInputError();
    }

    public String handleAmountInputError() {
        boolean validInput = false;
        String amountInput = "";

        while (!validInput) {
            try {
                outputView.printRequest(OutputView.REQUEST_AMOUNT_MESSAGE);
                amountInput = inputView.readInput();

                validationManager.isNotEmptyInput(amountInput);
                validationManager.isNumber(amountInput);
                validInput = validationManager.isDivideByThousand(amountInput);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return amountInput;
    }

    public String handleLottoNumberInputError() {
        boolean validInput = false;
        String lottoInput = "";

        while (!validInput) {
            try {
                outputView.printRequest(OutputView.REQUEST_NUMBER_MESSAGE);
                lottoInput = inputView.readInput();

                validationManager.isNotEmptyInput(lottoInput);
                validInput = validationManager.isNumbersDividedByComma(lottoInput); //정수와 쉼표로 이루어져있는지 확인
                List<Integer> lottoNumbrs = TypeConverter.ToNumberList(lottoInput);
                Lotto lotto = new Lotto(lottoNumbrs); //6자 이상인지 확인후 객체 생성

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return lottoInput;
    }
}
