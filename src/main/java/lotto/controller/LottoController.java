package lotto.controller;

import java.util.ArrayList;
import lotto.model.Lotto;
import lotto.model.LottoList;
import lotto.model.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public void run() {
        int purchaseAmount = inputPurchaseAmount();
        LottoList lottoList = new LottoList(purchaseAmount);
        OutputView.printLottoList(lottoList);
        List<Integer> winningNumbers = inputWinningNumbers();
        String bonusNumber = inputBonusNumber(winningNumbers);

        LottoResult lottoResult = createLottoResult(winningNumbers, Integer.parseInt(bonusNumber));
        OutputView.printLottoStatistics(lottoResult.calculateResults(lottoList), purchaseAmount);
    }

    private int inputPurchaseAmount() {
        while (true) {
            try {
                return validatePurchaseAmount(InputView.inputPurchaseAmount());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }
    }

    private int validatePurchaseAmount(String amount) {
        if (amount == null || !amount.matches("[0-9]+")) {
            throw new IllegalArgumentException(" 올바른 숫자를 입력해 주세요.");
        }
        int intAmount = Integer.parseInt(amount);
        if (intAmount <= 0 || intAmount % 1000 != 0) {
            throw new IllegalArgumentException(" 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
        return intAmount;
    }

    private List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                return validateWinningNumbers(InputView.inputWinningNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }
    }

    private List<Integer> validateWinningNumbers(String input) {
        if (input == null || !input.matches("[0-9, ]+")) {
            throw new IllegalArgumentException(" 올바른 숫자를 입력해 주세요.");
        }
        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String numStr : numberStrings) {
            numbers.add(validateNumber(numStr));
        }
        return new Lotto(numbers).getNumbers();
    }

    private int validateNumber(String numStr) {
        int number = Integer.parseInt(numStr);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(" 유효하지 않은 숫자가 포함되어 있습니다.");
        }
        return number;
    }

    private String inputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                return validateBonusNumber(InputView.inputBonusNumber(), winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }
    }

    private String validateBonusNumber(String number, List<Integer> winningNumbers) {
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 45;
        if (number == null || !number.matches("[0-9]+")) {
            throw new IllegalArgumentException(" 올바른 숫자를 입력해 주세요.");
        }
        int intNumber = Integer.parseInt(number);
        if (intNumber < MIN_NUMBER || intNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(" 로또 번호는 " + MIN_NUMBER + "부터 " + MAX_NUMBER + " 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(intNumber)) {
            throw new IllegalArgumentException(" 보너스 번호는 당첨 번호와 중복되지 않습니다.");
        }
        return number;
    }

    private LottoResult createLottoResult(List<Integer> winningNumbers, int bonusNumber) {
        while (true) {
            try {
                return new LottoResult(new Lotto(winningNumbers), bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
