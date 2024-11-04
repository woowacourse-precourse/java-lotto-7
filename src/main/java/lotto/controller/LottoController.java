package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.util.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        int purchaseAmount = inputPurchaseAmount();
        List<Lotto> purchasedLottos = purchaseLottos(purchaseAmount);
        WinningLotto winningLotto = inputWinningLotto();
        LottoResult lottoResult = calculateResult(purchasedLottos, winningLotto);
        OutputView.printResult(lottoResult, purchaseAmount);
        // 추후 기능 추가 예정
    }

    private LottoResult calculateResult(List<Lotto> lottos, WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottos) {
            Rank rank = lotto.match(winningLotto);
            lottoResult.addRank(rank);
        }
        return lottoResult;
    }

    private WinningLotto inputWinningLotto() {
        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                String input = InputView.inputWinningNumbers();
                List<Integer> numbers = InputValidator.parseNumbers(input);
                InputValidator.validateWinningNumbers(numbers);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputBonusNumber() {
        while (true) {
            try {
                String input = InputView.inputBonusNumber();
                int bonusNumber = Integer.parseInt(input);
                InputValidator.validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> purchaseLottos(int amount) {
        int count = amount / Lotto.PRICE;
        OutputView.printPurchaseCount(count);
        List<Lotto> lottos = Lotto.generateLottos(count);
        OutputView.printLottos(lottos);
        return lottos;
    }

    private int inputPurchaseAmount() {
        while (true) {
            try {
                String input = InputView.inputPurchaseAmount();
                int amount = parsePurchaseAmount(input);
                InputValidator.validatePurchaseAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parsePurchaseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }
}
