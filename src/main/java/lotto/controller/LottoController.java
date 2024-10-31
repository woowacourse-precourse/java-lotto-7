package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.InputValidator;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = readPurchaseAmount();
        List<Lotto> lottoTickets = purchaseLotto(purchaseAmount);
        displayLotto(lottoTickets);
        List<Integer> winningNumbers = readWinningNumbers();
        int bonusNumber = readBonusNumber(winningNumbers);
    }

    private int readBonusNumber(List<Integer> winningNumbers) {
        String rawInputBonusNumber = inputView.requestBonusNumber();
        validateBonusNumber(rawInputBonusNumber, winningNumbers);
        return parseBonusNumber(rawInputBonusNumber);
    }

    private void validateBonusNumber(String rawInput, List<Integer> winningNumbers) {
        InputValidator inputValidator = new InputValidator();
        inputValidator.validateRawInputBonusNumber(rawInput, winningNumbers);
    }

    private int parseBonusNumber(String rawInput) {
        try {
            return Integer.parseInt(rawInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호에 숫자가 아닌 문자가 포함되어 있어요. 다시 입력해주세요.");
        }
    }

    private List<Integer> readWinningNumbers() {
        String rawInputWinningNumbers = inputView.requestWinningNumbers();
        validateWinningNumbers(rawInputWinningNumbers);
        return parseWinningNumbers(rawInputWinningNumbers);
    }

    private void validateWinningNumbers(String rawInput) {
        InputValidator inputValidator = new InputValidator();
        inputValidator.validateRawInputWinningNumbers(rawInput);
    }

    private List<Integer> parseWinningNumbers(String rawInput) {
        String[] separatedInputs = rawInput.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String input : separatedInputs) {
            try {
                winningNumbers.add(Integer.parseInt(input.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호에 숫자가 아닌 문자가 포함되어 있어요. 다시 입력해주세요.");
            }
        }
        return winningNumbers;
    }

    private int readPurchaseAmount() {
        String rawInputPurchaseAmount = inputView.requestPurchaseAmount();
        validatePurchaseAmount(rawInputPurchaseAmount);
        return parsePurchaseAmount(rawInputPurchaseAmount);
    }

    private void validatePurchaseAmount(String rawInput) {
        InputValidator inputValidator = new InputValidator();
        inputValidator.validateRawInputPurchaseAmount(rawInput);
    }

    private int parsePurchaseAmount(String rawInput) {
        try {
            return Integer.parseInt(rawInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액에 숫자가 아닌 문자가 포함되어 있어요. 다시 입력해주세요.");
        }
    }

    private List<Lotto> purchaseLotto(int purchaseAmount) {
        LottoMachine lottoMachine = new LottoMachine();
        return lottoMachine.purchase(purchaseAmount);
    }

    private void displayLotto(List<Lotto> lottoTickets) {
        outputView.printPurchasedQuantity(lottoTickets.size());
        outputView.printLottoTickets(getLottoTickets(lottoTickets));
    }

    private List<List<Integer>> getLottoTickets(List<Lotto> lottoTickets) {
        return lottoTickets.stream()
                .map(Lotto::getNumbers)
                .toList();
    }
}
