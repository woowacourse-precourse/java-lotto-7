package lotto.controller;

import java.util.InputMismatchException;
import java.util.List;
import lotto.domain.Lotto;
import lotto.utils.Utils;
import lotto.validator.Validators;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Validators validators;
    private final Utils utils;


    public Controller(InputView inputView, OutputView outputView, Validators validators, Utils utils) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validators = validators;
        this.utils = utils;
    }

    public int inputPurchaseAmount() {
        while (true) {
            try {
                String inputPrice = inputView.lottoPrice();
                validators.validateNumericInput(inputPrice);
                int price = utils.parseStringToInt(inputPrice);
                validators.validatePurchaseAmountUnit(price);
                return price;
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Lotto> generateLottos(int price) {
        List<Lotto> lottos = utils.generateRandomLottoNumbers(price);
        List<Lotto> sortLottos = utils.sortLottos(lottos);
        outputView.printLottoQuantity(sortLottos);
        outputView.printLottoNumbers(sortLottos);
        return sortLottos;
    }

    public Lotto setWinningNumbers() {
        while (true) {
            try {
                String inputNumbers = inputView.winLottoNumber();
                validators.validateSplitNumericInput(inputNumbers);
                return new Lotto(utils.convertToIntegerList(inputNumbers));
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int setBonusNumber() {
        while (true) {
            try {
                String inputNumber = inputView.bonusLottoNumber();
                validators.validateNumericInput(inputNumber);
                int bonusNumber = utils.parseStringToInt(inputNumber);
                validators.validateNumberRange(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
