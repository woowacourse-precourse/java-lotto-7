package controller;

import static content.InputMessage.INPUT_BONUS_NUMBER;
import static content.InputMessage.INPUT_BUY_AMOUNT;
import static content.InputMessage.INPUT_WINNING_NUMBERS;
import static content.Separator.WINNING_SEPARATOR;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import model.WinningNumbers;
import service.LottoService;
import validators.InputValidator;
import validators.LottoValidator;

import java.util.Arrays;

public class LottoController {
    private LottoService lottoService = new LottoService();

    public void startGame() {
        int amount = getPurchaseAmount();
        lottoService.purchaseLottos(amount);
        WinningNumbers winningNumbers = getWinningNumbers();
        lottoService.checkWinnings(winningNumbers);
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println(INPUT_BUY_AMOUNT.getMessage());
                return InputValidator.validatePurchaseAmount(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningNumbers getWinningNumbers() {
        while (true) {
            try {
                System.out.println(INPUT_WINNING_NUMBERS.getMessage());
                String[] winningNumberInput = Console.readLine().split(WINNING_SEPARATOR.getMessage());
                System.out.println(INPUT_BONUS_NUMBER.getMessage());
                int bonusNumber = Integer.parseInt(Console.readLine());

                List<Integer> winningNumbersList = Arrays.stream(winningNumberInput)
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList();

                InputValidator.validateLottoNumbers(winningNumbersList);
                InputValidator.validateBonusNumber(bonusNumber);
                LottoValidator.validateWinningNumbers(winningNumbersList, bonusNumber);

                return new WinningNumbers(winningNumberInput, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
