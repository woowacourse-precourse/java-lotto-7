package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.factory.ValidatorFactory;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.LottoMachine;
import lotto.model.LottoRank;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static final int LOTTO_PRICE = 1000;

    private final InputView inputView;
    private final InputConverter inputConverter;
    private final ValidatorFactory validatorFactory;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoController(InputView inputView, ValidatorFactory validatorFactory, LottoMachine lottoMachine,
                           OutputView outputView) {
        this.inputView = inputView;
        this.validatorFactory = validatorFactory;
        this.lottoMachine = lottoMachine;
        this.outputView = outputView;
        this.inputConverter = new InputConverter();
    }

    public void run() {
        int purchaseAmount = getInputPurchaseAmount();
        int purchaseCount = purchaseAmount / LOTTO_PRICE;
        List<Lotto> purchasedLottoList = lottoMachine.generateLotto(purchaseCount);
        outputView.printPurchasedLotto(purchaseCount, purchasedLottoList);

        List<Integer> winningNumber = getWinningNumber();
        int bonusNumber = getBonusNumber(winningNumber);
        LottoGame lottoGame = new LottoGame(winningNumber, bonusNumber, purchasedLottoList);
        Map<LottoRank, Integer> lottoResult = lottoGame.checkLottoResult();
        double lottoResultStatistics = lottoGame.calculateStatistics(purchaseAmount);
        outputView.printLottoResult(lottoResult, lottoResultStatistics);
    }

    private int getInputPurchaseAmount() {
        String inputPurchaseAmount = inputView.inputPurchaseAmount();
        PurchaseAmountValidator purchaseAmountValidator = validatorFactory.createPurchaseAmountValidator();
        try {
            int purchaseAmount = inputConverter.convertPurchaseAmount(inputPurchaseAmount);
            purchaseAmountValidator.validate(purchaseAmount);
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputPurchaseAmount();
        }
    }

    private List<Integer> getWinningNumber() {
        String inputWinningNumber = inputView.inputWinningNumber();
        WinningNumberValidator winningNumberValidator = validatorFactory.createWinningNumberValidator();
        try {
            List<Integer> winningNumber = inputConverter.convertWinningNumber(inputWinningNumber);
            winningNumberValidator.validate(winningNumber);
            return winningNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumber();
        }
    }

    private int getBonusNumber(List<Integer> winningNumber) {
        String inputBonusNumber = inputView.inputBonusNumber();
        BonusNumberValidator bonusNumberValidator = validatorFactory.createBonusNumberValidator();
        try {
            int bonusNumber = inputConverter.convertBonusNumber(inputBonusNumber);
            bonusNumberValidator.validateDuplicate(bonusNumber, winningNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningNumber);
        }
    }
}
