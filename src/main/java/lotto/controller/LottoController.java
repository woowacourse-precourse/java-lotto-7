package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.model.Amount;
import lotto.model.LottoPublisher;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.ValidationManager;
import utils.TypeConverter;

public class LottoController {

    private final OutputView outputView;
    private final InputView inputView;
    private final ValidationManager validationManager;
    private final LottoPublisher lottoPublisher;

    public LottoController(InputView inputView, OutputView outputView, ValidationManager validationManager, LottoPublisher lottoPublisher) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.validationManager = validationManager;
        this.lottoPublisher = lottoPublisher;
    }

    public void play() {
        int validAmount = handleAmountInputError();
        List<Integer> validLottoNumbers = handleLottoNumberInputError();
        int validBonusNumber = handleBonusInputError();

    }

    public int handleAmountInputError() { //얘네들이 15줄을 넘는 이유는 기능이 3가지임 인풋 아웃풋 컨트롤 , 타당성 체크, 형변환
        boolean validInput = false;
        Amount amount ;

        while (!validInput) {
            try {
                String input = inputView.readInput(Amount.getRequestMessage());
                validInput = isValidAmountInput(input);
                amount = new Amount(TypeConverter.ToNumber(input));
                return amount.getAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return 0;
    }
    public boolean isValidAmountInput(String input) {
        validationManager.isNotEmptyInput(input);
        validationManager.isNumber(input);
        return validationManager.isDivideByThousand(input);
    }

    public List<Integer> handleLottoNumberInputError() {
        boolean validInput = false;
        List<Integer> validLottoNumbers = new ArrayList<>();

        while (!validInput) {
            try {
                outputView.printRequest(OutputView.REQUEST_NUMBER_MESSAGE);
                String lottoInput = inputView.readInput("");

                validationManager.isNumbersDividedByComma(lottoInput); //정수와 쉼표로 이루어져있는지 확인
                List<Integer> lottoNumbrs = TypeConverter.ToNumberList(lottoInput);
                Lotto lotto = new Lotto(lottoNumbrs);//6자 이상인지 1-45안에 있는지 확인후 객체 생성
                validLottoNumbers = lotto.getLottoNumbers();
                validInput = validationManager.isRangeValid(validLottoNumbers); //범위 확인

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
                String input = inputView.readInput("");

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
