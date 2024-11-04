package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int TICKET_PRICE = 1_000;
    private static final String DELIMITER = ",";
    private static final int LOTTO_SIZE = 6;

    private final List<Lotto> purchasedLottos = new ArrayList<>();
    private Lotto winningLotto;
    private int bonusNumber;

    /**
     * 전체 게임 진행을 처리한다.
     */
    public void play() {
        int amount = requestPurchaseAmount();
        purchaseLottos(amount);
        printPurchasedLottos();
        requestWinningNumbers();
        requestBonusNumber();
        displayResults();
    }

    /**
     * 구매 금액을 입력받는다.
     */
    private int requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                return validatePurchaseAmount(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 입력된 구매 금액을 검증한다.
     * */
    private int validatePurchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            validateAmountRange(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    /**
     * 구매 금액이 유효한 범위인지 검증한다.
     */
    private void validateAmountRange(int amount) {
        if (amount < TICKET_PRICE) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1,000원 이상이어야 합니다.");
        }
        if (amount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1,000원 단위여야 합니다.");
        }
    }

    /**
     * 로또를 구매한다.
     */
    private void purchaseLottos(int amount) {
        int count = amount / TICKET_PRICE;
        for (int i = 0; i < count; i++) {
            purchasedLottos.add(new Lotto(createRandomNumbers()));
        }
    }

    /**
     * 무작위 로또 번호를 생성한다.
     */
    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    /**
     * 구매한 로또 목록을 출력한다.
     */
    private void printPurchasedLottos() {
        System.out.printf("\n%d개를 구매했습니다.\n", purchasedLottos.size());
        purchasedLottos.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    /**
     * 당첨 번호를 입력받는다.
     */
    private void requestWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                winningLotto = new Lotto(parseNumbers(Console.readLine()));
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 입력된 번호 문자열을 파싱한다.
     */
    private List<Integer> parseNumbers(String input) {
        try {
            return List.of(input.split(DELIMITER)).stream()
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    /**
     * 보너스 번호를 입력받는다.
     */
    private void requestBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                bonusNumber = validateBonusNumber(Console.readLine());
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 보너스 번호를 검증한다.
     */
    private int validateBonusNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            validateBonusNumberRange(number);
            validateBonusNumberDuplicate(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    /**
     * 보너스 번호의 범위를 검증한다.
     */
    private void validateBonusNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 보너스 번호가 당첨 번호와 중복되지 않는지 검증한다.
     */
    private void validateBonusNumberDuplicate(int number) {
        if (winningLotto.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
    /**
     * 당첨 결과를 출력한다.
     */
    private void displayResults() {
        WinningResult result = calculateResults();
        printWinningStatistics(result);
        printProfitRate(result);
    }

    /**
     * 당첨 결과를 계산한다.
     */
    private WinningResult calculateResults() {
        WinningResult result = new WinningResult();
        for (Lotto lotto : purchasedLottos) {
            int matchCount = lotto.matchCount(winningLotto);
            boolean bonusMatch = matchCount == 5 && lotto.contains(bonusNumber);
            result.addResult(matchCount, bonusMatch);
        }
        return result;
    }

    /**
     * 당첨 통계를 출력한다.
     */
    private void printWinningStatistics(WinningResult result) {
        System.out.println("\n당첨 통계\n---");
        result.printStatistics();
    }

    /**
     * 수익률을 출력한다.
     */
    private void printProfitRate(WinningResult result) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n",
                result.calculateProfitRate(purchasedLottos.size() * TICKET_PRICE));
    }
}