package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoCollection;
import lotto.domain.WinningNumber;
import lotto.enums.InputMessage;
import lotto.enums.OutputMessage;
import lotto.enums.WinningRanking;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    private int parsedCostToInt;
    private int purchasedLottoCount;
    private String winningNumber;
    private String bonusNumber;
    private LottoCollection lottoCollection;
    private WinningNumber winningNumberObject;
    private BonusNumber bonusNumberObject;
    Map<WinningRanking, Integer> rankingResult;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startLottoSales() {
        inputPurchaseAmount();
        printNumberOfPurchaseLotto();

        generateLottosByRandomNumber();
        printAllLottoNumbers();

        inputWinningNumber();
        validateWinningNumber();

        inputBonusNumber();
        validateBonusNumber();

        printLottoWinMessage();
        decideRanking();
        printRanking();

    }

    public void inputPurchaseAmount() {
        boolean isValidNumber = false;
        String inputCost;

        do {
            inputView.printMessage(InputMessage.INPUT_PURCHASE_AMOUNT);
            inputCost = inputView.inputPurchaseAmount();

            try {
                parsedCostToInt = lottoService.isValidNumber(inputCost);
                isValidNumber = true;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        } while (!isValidNumber);
    }

    public void printNumberOfPurchaseLotto() {
        purchasedLottoCount = lottoService.divideInputByLottoPrice(parsedCostToInt);
        String lottoCountMessage = OutputMessage.PURCHASED_LOTTO_COUNT_MESSAGE
                .getLottoCountMessage(purchasedLottoCount);
        outputView.printLottoCountMessage(lottoCountMessage);
    }

    public void generateLottosByRandomNumber() {
        this.lottoCollection = lottoService.generateLottoCollection(purchasedLottoCount);
    }

    public void printAllLottoNumbers() {
        List<Lotto> lottoNumbers = lottoService.prepareCollectionForPrint(lottoCollection);
        outputView.printLottoNumbers(lottoNumbers);
    }

    public void inputWinningNumber() {
        boolean isValidInput = false;

        do {
            inputView.printMessage(InputMessage.INPUT_WINNING_NUMBER);
            winningNumber = inputView.inputWinningNumber();
            try {
                validateWinningNumber();

                isValidInput = true;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            } catch (IllegalStateException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        } while (!isValidInput);
    }

    public void validateWinningNumber() {
        // split 전, 검증
        lottoService.validateInputWinNumber(winningNumber);

        String[] splitWinningNumber = lottoService.splitWinningNumber(winningNumber);

        // split 후, 검증
        WinningNumber validWinNumber = lottoService.validateSplitWinNumber(splitWinningNumber);
        this.winningNumberObject = validWinNumber;
    }

    public void inputBonusNumber() {
        boolean isValidInput = false;

        do {
            inputView.printMessage(InputMessage.INPUT_BONUS_NUMBER);
            bonusNumber = inputView.inputBonusNumber();
            try {
                validateBonusNumber();
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            } catch (IllegalStateException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        } while (!isValidInput);
    }

    public void validateBonusNumber() {
        int parsedBonusNumber = lottoService.validateBonusNumber(bonusNumber, winningNumberObject);
        BonusNumber bonusNumber = lottoService.addBonusNumber(parsedBonusNumber);
    }

    public void printLottoWinMessage() {
        outputView.printLottoWinningMessage();
    }

    public void decideRanking() {
        rankingResult = lottoService.decideRanking(lottoCollection,
                winningNumberObject, bonusNumberObject);
    }

    public void printRanking() {
        outputView.printRankingResult(rankingResult);
    }


}
