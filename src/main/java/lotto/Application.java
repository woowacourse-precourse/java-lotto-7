package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = purchaseLottos();
        List<Lotto> lottos = issueLottos(purchaseAmount);
        printIssuedLottos(lottos);
        Lotto winningNumbers = pickWinningNumbers();
    }

    private static int purchaseLottos() {
        try {
            String purchaseAmountInput = inputPurchaseAmount();
            int purchaseAmount = countLottoAmount(purchaseAmountInput);
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return purchaseLottos();
        }
    }

    public static List<Lotto> issueLottos(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            lottos.add(issueOneLotto(pickSortedNumbers()));
        }
        return lottos;
    }

    private static void printIssuedLottos(List<Lotto> lottos) {
        System.out.println(String.format("\n%d개를 구매했습니다.", lottos.size()));
        for (Lotto lotto : lottos) {
            StringBuilder issuedLottos = new StringBuilder("[");
            List<Integer> numbers = lotto.getNumbers();
            for (int i = 0; i < 6; i++) {
                issuedLottos.append(numbers.get(i));
                if (i == 5) {
                    issuedLottos.append("]");
                    break;
                }
                issuedLottos.append(", ");
            }
            System.out.println(issuedLottos);
        }

    }

    private static Lotto pickWinningNumbers() {
        try {
            String winningNumbersInput = inputWinningNumbers();
            return registerWinningNumbers(winningNumbersInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return pickWinningNumbers();
        }
    }

    private static String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersInput = Console.readLine();
        validateInputValue(winningNumbersInput);
        return winningNumbersInput;
    }

    public static Lotto registerWinningNumbers(String winningNumbersInput) {
        try {
            List<Integer> winningNumbers = new ArrayList<>();
            for (String winningNumber : winningNumbersInput.split(",", -1)) {
                winningNumbers.add(Integer.parseInt(winningNumber.trim()));
            }
            return new Lotto(winningNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자값만 입력해주세요.");
        }
    }

    public static Lotto issueOneLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private static String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        validateInputValue(purchaseAmount);
        validateInputInteger(purchaseAmount);
        return purchaseAmount;
    }

    public static void validateInputInteger(String inputInteger) {
        if (!inputInteger.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해주세요.");
        }
        if (inputInteger.length() > 10) {
            throw new IllegalArgumentException("[ERROR] 10자리 이하의 금액을 입력해주세요.");
        }
    }

    public static void validateInputValue(String inputValue) {
        if (inputValue == null
                || inputValue.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }

    public static int countLottoAmount(String purchaseAmountInput) {
        int purchaseAmount = Integer.parseInt(purchaseAmountInput);
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000 단위의 금액을 입력해주세요.");
        }
        return purchaseAmount / 1000;
    }

    public static List<Integer> pickSortedNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .sorted() // 오름차순 정렬
                .collect(Collectors.toList());
    }
}
