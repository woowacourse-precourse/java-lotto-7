package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> purchasedLottos = new ArrayList<>();
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        generateLottos(purchaseAmount / LOTTO_PRICE);
        getWinningNumbers();
        calculateAndDisplayResults();
    }
    private int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int amount = Integer.parseInt(Console.readLine().trim());
                if (amount % LOTTO_PRICE != 0) throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위여야 합니다.");
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void generateLottos(int count) {
        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                    .sorted()
                    .collect(Collectors.toList());
            Lotto lotto = new Lotto(numbers);
            purchasedLottos.add(lotto);
            System.out.println(lotto);
        }
    }

    private void getWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                winningNumbers = parseNumbers(Console.readLine().trim(), 6);
                System.out.println("보너스 번호를 입력해 주세요.");
                bonusNumber = Integer.parseInt(Console.readLine().trim());
                if (bonusNumber < 1 || bonusNumber > 45 || winningNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1-45 범위의 고유 값이어야 합니다.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> parseNumbers(String input, int expectedCount) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        if (numbers.size() != expectedCount || numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1-45 사이의 고유 숫자 6개여야 합니다.");
        }
        return numbers;
    }

    private void calculateAndDisplayResults() {
        LottoResult result = new LottoResult(purchasedLottos, winningNumbers, bonusNumber);
        result.display();
    }
}
