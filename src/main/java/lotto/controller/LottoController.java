package lotto.controller;

import java.util.*;
import java.util.stream.Collectors;
import lotto.model.*;
import lotto.view.*;

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

            WinningLotto winningLotto = createWinningLotto();
            displayResults(purchasedLottos, winningLotto, purchaseAmount);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private int getValidatedPurchaseAmount() {
        String input = inputView.inputPurchaseAmount();
        validatePurchaseAmount(input);
        return Integer.parseInt(input);
    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumbers = getValidatedWinningNumbers();
        int bonusNumber = getValidatedBonusNumber(winningNumbers);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private List<Lotto> purchaseLottos(int amount) {
        int count = calculateLottoCount(amount);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(lottoGenerator.generate());
        }
        return lottos;
    }

    private void displayResults(List<Lotto> purchasedLottos, WinningLotto winningLotto, int purchaseAmount) {
        lottoStatistics.calculateResults(purchasedLottos, winningLotto);
        double yield = lottoStatistics.calculateYield(purchaseAmount);
        outputView.printYield(yield);
    }

    private int calculateLottoCount(int amount) {
        return amount / 1000;
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
        validateAmountIsMultipleOfThousand(numericAmount);
    }

    private void validateAmountIsMultipleOfThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private List<Integer> parseInputToNumbers(String input) {
        String[] tokens = input.split(",");
        List<Integer> numbers = Arrays.stream(tokens)
                .map(String::trim)
                .map(this::parseAndValidateNumber)
                .collect(Collectors.toList());

        validateNoEmptyValues(numbers, tokens.length);
        return numbers;
    }

    private Integer parseAndValidateNumber(String token) {
        if (!token.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자만 입력해야 합니다.");
        }
        return Integer.parseInt(token);
    }

    private void validateNoEmptyValues(List<Integer> numbers, int originalLength) {
        if (numbers.size() != originalLength) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 빈 값이 포함될 수 없습니다.");
        }
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        validateSize(winningNumbers);
        validateUniqueNumbers(winningNumbers);
        winningNumbers.forEach(this::validateLottoNumberRange);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정확히 6개여야 합니다.");
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에는 중복된 숫자가 없어야 합니다.");
        }
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
}
