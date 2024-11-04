package lotto.controller;

import lotto.model.LottoResult;
import lotto.model.LottoTickets;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        int ticketCount = purchaseAmount / 1000;

        LottoTickets lottoTickets = new LottoTickets(ticketCount);
        OutputView.printPurchaseResult(lottoTickets);

        WinningNumbers winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        LottoResult lottoResult = new LottoResult(lottoTickets, winningNumbers, bonusNumber);
        OutputView.printStatistics(lottoResult, purchaseAmount);
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                String input = InputView.readPurchaseAmount();
                int amount = parseNumber(input);
                validatePurchaseAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePurchaseAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private WinningNumbers getWinningNumbers() {
        while (true) {
            try {
                String input = InputView.readWinningNumbers();
                return new WinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                String input = InputView.readBonusNumber();
                int bonusNumber = parseNumber(input);
                validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBonusNumber(int bonusNumber, WinningNumbers winningNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    private int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }
}
