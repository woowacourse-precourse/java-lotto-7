package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoVending {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR]";
    private final InputView inputView;
    private final OutputView outputView;

    public LottoVending(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void take() {

        String errorMessage;

        // 구입 금액 입력, 검증 및 파싱
        System.out.println("구입 금액을 입력해 주세요.");
        long purchaseAmount = 0;
        boolean purchaseAmountInputFailed = true;
        while (purchaseAmountInputFailed) {
            String purchaseAmountInput = Console.readLine().strip();
            try {
                if (purchaseAmountInput.isBlank()) {
                    errorMessage = ERROR_MESSAGE_PREFIX + "구입 금액을 입력해주세요.";
                    throw new IllegalArgumentException(errorMessage);
                }
                try {
                    purchaseAmount = Long.parseLong(purchaseAmountInput);
                } catch (NumberFormatException e) {
                    errorMessage = ERROR_MESSAGE_PREFIX + "구입 금액은 양수로 입력해주세요. 입력한 금액: " + purchaseAmountInput;
                    throw new IllegalArgumentException(errorMessage);
                }
                if (purchaseAmount % 1000 != 0) {
                    errorMessage = ERROR_MESSAGE_PREFIX + "구입 금액은 1,000원 단위로 입력해주세요.";
                    throw new IllegalArgumentException(errorMessage);
                }
                if (purchaseAmount > 4611686000L) {
                    errorMessage = ERROR_MESSAGE_PREFIX + "구입 금액은 4,611,686,000원보다 클 수 없습니다. 입력한 금액: " + purchaseAmount;
                    throw new IllegalArgumentException(errorMessage);
                }
                purchaseAmountInputFailed = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();

        // 당첨 번호 입력, 검증 및 파싱
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = new ArrayList<>();
        boolean winningNumberInputFailed = true;
        while (winningNumberInputFailed) {
            try {
                String winningNumbersInput = Console.readLine().strip();
                if (winningNumbersInput.isBlank()) {
                    errorMessage = ERROR_MESSAGE_PREFIX + "당첨 번호를 입력해주세요.";
                    throw new IllegalArgumentException(errorMessage);
                }
                List<String> separatedWinningNumbersInput = List.of(winningNumbersInput.split(","));
                if (separatedWinningNumbersInput.size() != 6) {
                    errorMessage = ERROR_MESSAGE_PREFIX + "당첨 번호는 6개를 입력해야 합니다. 입력한 당첨 번호: " + winningNumbersInput;
                    throw new IllegalArgumentException(errorMessage);
                }
                for (String winningNumberInput : separatedWinningNumbersInput) {
                    try {
                        winningNumberInput = winningNumberInput.strip();
                        int winningNumber = Integer.parseInt(winningNumberInput);
                        if (winningNumber < 1 || winningNumber > 45) {
                            throw new NumberFormatException();
                        }
                        winningNumbers.add(winningNumber);
                    } catch (NumberFormatException e) {
                        errorMessage =
                            ERROR_MESSAGE_PREFIX + "당첨 번호는 1~45 사이의 정수로 입력해주세요. 잘못된 당첨 번호: " + winningNumberInput;
                        throw new IllegalArgumentException(errorMessage);
                    }
                }
                Set<Integer> noDuplicateNumbers = new HashSet<>();
                for (Integer number : winningNumbers) {
                    if (!noDuplicateNumbers.add(number)) {
                        errorMessage = ERROR_MESSAGE_PREFIX + "당첨 번호가 중복되었습니다. 중복된 당첨 번호: " + number;
                        throw new IllegalArgumentException(errorMessage);
                    }
                }
                winningNumberInputFailed = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                winningNumbers = new ArrayList<>();
            }
        }
        System.out.println();

        //보너스 번호 입력
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = 0;
        boolean bonusInputFailed = true;
        while (bonusInputFailed) {
            try {
                String bonusNumberInput = Console.readLine().strip();
                if (bonusNumberInput.isBlank()) {
                    errorMessage = ERROR_MESSAGE_PREFIX + "보너스 번호를 입력해주세요.";
                    throw new IllegalArgumentException(errorMessage);
                }
                try {
                    bonusNumber = Integer.parseInt(bonusNumberInput);
                    if (bonusNumber < 1 || bonusNumber > 45) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    errorMessage =
                        ERROR_MESSAGE_PREFIX + "보너스 번호는 1~45 사이의 정수로 입력해주세요. 잘못된 보너스 번호: " + bonusNumberInput;
                    throw new IllegalArgumentException(errorMessage);
                }
                if (winningNumbers.contains(bonusNumber)) {
                    errorMessage = ERROR_MESSAGE_PREFIX + "보너스 번호가 당첨 번호와 중복됩니다. 중복된 보너스 번호: " + bonusNumber;
                    throw new IllegalArgumentException(errorMessage);
                }
                bonusInputFailed = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();

        // 로또 발행
        List<Lotto> lottos = new ArrayList<>();
        for (int lottoCount = 0; lottoCount < (purchaseAmount / 1000); lottoCount++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(randomNumbers));
        }
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getAscendingSortNumbers()));
        System.out.println();

        // 당첨 통계
        int matchedThree = 0;
        int matchedFour = 0;
        int matchedFive = 0;
        int matchedFiveAndBonus = 0;
        int matchedSix = 0;
        for (Lotto lotto : lottos) {
            int matchedCount = lotto.getMatchedNumbers(winningNumbers).size();
            if (matchedCount == 3) {
                matchedThree++;
            }
            if (matchedCount == 4) {
                matchedFour++;
            }
            if (matchedCount == 5) {
                if (lotto.isNumbersContains(bonusNumber)) {
                    matchedFiveAndBonus++;
                } else {
                    matchedFive++;
                }
            }
            if (matchedCount == 6) {
                matchedSix++;
            }
        }
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + matchedThree + "개");
        System.out.println("4개 일치 (50,000원) - " + matchedFour + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchedFive + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchedFiveAndBonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchedSix + "개");
        int totalEarnings =
            5000 * matchedThree + 50000 * matchedFour + 1500000 * matchedFive + 30000000 * matchedFiveAndBonus
                + 2000000000 * matchedSix;
        float totalEarningsRate = (float) totalEarnings / purchaseAmount * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", totalEarningsRate) + "%입니다.");
    }
}
