package lotto.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.LottoStatistics;
import java.util.ArrayList;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;
    private final LottoStatistics lottoStatistics;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoGenerator = new LottoGenerator();
        this.lottoStatistics = new LottoStatistics();
    }

    public void run() {
        try {
            int purchaseAmount = getValidatedPurchaseAmount();
            List<Lotto> purchasedLottos = purchaseLottos(purchaseAmount);
            outputView.printLottos(purchasedLottos);

            List<Integer> winningNumbers = getValidatedWinningNumbers();
            int bonusNumber = getValidatedBonusNumber(winningNumbers);

            WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
            displayResults(purchasedLottos, winningLotto, purchaseAmount);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private void displayResults(List<Lotto> purchasedLottos, WinningLotto winningLotto, int purchaseAmount) {
        lottoStatistics.calculateResults(purchasedLottos, winningLotto);
        double yield = lottoStatistics.calculateYield(purchaseAmount);
        outputView.printYield(yield);
    }

    private int getValidatedPurchaseAmount() {
        String input = inputView.inputPurchaseAmountString();
        validatePurchaseAmount(input);
        return Integer.parseInt(input);
    }

    private List<Integer> getValidatedWinningNumbers() {
        List<Integer> winningNumbers = parseInputToNumbers(inputView.inputWinningNumbers());
        validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    private int getValidatedBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber = inputView.inputBonusNumber();
        validateBonusNumber(winningNumbers, bonusNumber);
        return bonusNumber;
    }

    private void validatePurchaseAmount(String amount) {
        if (!amount.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 금액만 입력해주세요.");
        }

        int numericAmount = Integer.parseInt(amount);
        if (numericAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private List<Integer> parseInputToNumbers(String input) {
        String[] tokens = input.split(",");
        List<Integer> numbers = Arrays.stream(tokens)
                .map(String::trim)
                .filter(token -> !token.isEmpty())
                .map(token -> {
                    if (!token.matches("\\d+")) {
                        throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자만 입력해야 합니다.");
                    }
                    return Integer.parseInt(token);
                })
                .collect(Collectors.toList());

        if (numbers.size() != tokens.length) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 빈 값이 포함될 수 없습니다.");
        }
        return numbers;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정확히 6개여야 합니다.");
        }
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에는 중복된 숫자가 없어야 합니다.");
        }
        winningNumbers.forEach(this::validateLottoNumberRange);
    }

    private void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        validateLottoNumberRange(bonusNumber);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private void validateLottoNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private List<Lotto> purchaseLottos(int amount) {
        int count = amount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(lottoGenerator.generate());
        }
        return lottos;
    }
}
