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
                String amount = InputView.inputPurchaseAmount();
                if (amount == null) {
                    throw new IllegalArgumentException(" 올바른 숫자를 입력해 주세요.");
                }
                if (!amount.matches("[0-9]+")) {
                    throw new IllegalArgumentException(" 숫자 외의 값입니다. 올바른 숫자를 입력해 주세요.");
                }
                int intAmount=Integer.parseInt(amount);
                if (intAmount <= 0 || intAmount % 1000 != 0) {
                    throw new IllegalArgumentException(" 구입 금액은 1,000원 단위로 입력해야 합니다.");
                }
                return intAmount;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]"+ e.getMessage());
            }
        }
    }

    private List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                String input = InputView.inputWinningNumbers();
                if (input == null) {
                    throw new IllegalArgumentException(" 입력 값이 null입니다. 올바른 숫자를 입력해 주세요.");
                }
                if (!input.matches("[0-9, ]+")) {
                    throw new IllegalArgumentException(" 숫자 외의 값입니다. 올바른 숫자를 입력해 주세요.");
                }
                String[] numberStrings = input.split(",");
                List<Integer> numbers = new ArrayList<>();
                for (String numStr : numberStrings) {
                    int number = Integer.parseInt(numStr.trim());
                    numbers.add(number);
                }
                for (Integer number : numbers) {
                    if (number == null) {
                        throw new IllegalArgumentException(" 유효하지 않은 숫자가 포함되어 있습니다.");
                    }
                }
                Lotto lotto = new Lotto(numbers);
                return lotto.getNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }
    }
    private String inputBonusNumber(List<Integer> winningNumbers) {
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 45;
        while (true) {
            try {
                String number = InputView.inputBonusNumber();
                if (number == null) {
                    throw new IllegalArgumentException(" 입력 값이 null입니다. 올바른 숫자를 입력해 주세요.");
                }
                if (!number.matches("[0-9, ]+")) {
                    throw new IllegalArgumentException(" 숫자 외의 값입니다. 올바른 숫자를 입력해 주세요.");
                }
                int intNumber=Integer.parseInt(number);
                if (intNumber<MIN_NUMBER || intNumber > MAX_NUMBER) {
                    throw new IllegalArgumentException(" 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }

                if (winningNumbers.contains(intNumber)) {
                    throw new IllegalArgumentException(" 보너스 번호는 당첨 번호와 중복되지 않습니다.");
                }
                return number;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]"+ e.getMessage());
            }
        }
    }

    private LottoResult createLottoResult(List<Integer> winningNumbers, int bonusNumber) {
        while (true) {
            try {
                Lotto winningLotto = new Lotto(winningNumbers);
                return new LottoResult(winningLotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
