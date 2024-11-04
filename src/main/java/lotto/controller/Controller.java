package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
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

    public void start() {
        int price = inputPurchaseAmount();
        List<Lotto> lotto = generateLottos(price);
        Lotto winningNumbers = setWinningNumbers();
        int bonusNumber = setBonusNumber(winningNumbers);
        Map<Rank, Integer> resultCounts = compareWithWinningNumbers(winningNumbers, bonusNumber, lotto);
        displayLottoYield(resultCounts, price);
    }

    public int inputPurchaseAmount() {
        while (true) {
            try {
                String inputPrice = inputView.lottoPrice();
                validators.validateNumericInput(inputPrice);
                int price = utils.parseStringToInt(inputPrice);
                validators.validatePurchaseAmountUnit(price);
                return price;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Lotto> generateLottos(int price) {
        List<Lotto> lottos = utils.generateRandomLottoNumbers(price);
        outputView.printLottoQuantity(lottos);
        outputView.printLottoNumbers(lottos);
        return lottos;
    }

    public Lotto setWinningNumbers() {
        while (true) {
            try {
                String inputNumbers = inputView.winLottoNumber();
                validators.validateSplitNumericInput(inputNumbers);
                return new Lotto(utils.convertToIntegerList(inputNumbers));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int setBonusNumber(Lotto winningNumbers) {
        while (true) {
            try {
                String inputNumber = inputView.bonusLottoNumber();
                validators.validateNumericInput(inputNumber);
                int bonusNumber = utils.parseStringToInt(inputNumber);
                validators.validateNumberRange(bonusNumber);
                validators.validateBonusNotInWinningNumbers(winningNumbers, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Map<Rank, Integer> compareWithWinningNumbers(Lotto winningNumber, int bonusNumber, List<Lotto> lottos) {
        Map<Rank, Integer> resultCounts = utils.evaluateLottoRanks(winningNumber, bonusNumber, lottos);
        outputView.printLottoWinningDetails(resultCounts);
        return resultCounts;
    }

    public void displayLottoYield(Map<Rank, Integer> resultCounts, int price) {
        int sum = utils.totalPrize(resultCounts);
        double yieldRate = utils.calculateYieldRate(sum, price);
        outputView.printLottoYield(yieldRate);
    }
}
