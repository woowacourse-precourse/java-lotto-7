package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGame {
    public void start() {
        int purchaseAmount = readPurchaseAmount();
        List<Lotto> lottos = generateLottos(purchaseAmount);
        printLottos(lottos);

        List<Integer> winningNumbers = readWinningNumbers();
        int bonusNumber = readBonusNumber(winningNumbers);

        Map<String, Integer> result = calculateResults(lottos, winningNumbers, bonusNumber);
        printResults(result, purchaseAmount);
    }

    private int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                return validateAmount(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int validateAmount(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 금액을 입력해 주세요.");
        }

        int amount;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }

        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위의 양수로 입력해 주세요.");
        }

        return amount;
    }

    private List<Lotto> generateLottos(int purchaseAmount) {
        int count = purchaseAmount / 1000;
        System.out.println(count + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    private void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                return parseWinningNumbers(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> parseWinningNumbers(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 입력해 주세요.");
        }

        List<Integer> numbers;
        try {
            numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력해 주세요.");
        }

        validateWinningNumbers(numbers);
        return numbers;
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        }

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 범위여야 합니다.");
            }
        }
    }

    private int readBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                return validateBonusNumber(Console.readLine(), winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int validateBonusNumber(String input, List<Integer> winningNumbers) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력해 주세요.");
        }

        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력해 주세요.");
        }

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 범위여야 합니다.");
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }

        return bonusNumber;
    }

    private Map<String, Integer> calculateResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<String, Integer> result = new LinkedHashMap<>();
        result.put("3개", 0);
        result.put("4개", 0);
        result.put("5개", 0);
        result.put("5개+보너스", 0); // 이 부분은 그대로 둡니다.
        result.put("6개", 0);

        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            if (matchCount == 6) result.put("6개", result.get("6개") + 1);
            else if (matchCount == 5 && bonusMatch) result.put("5개+보너스", result.get("5개+보너스") + 1);
            else if (matchCount == 5) result.put("5개", result.get("5개") + 1);
            else if (matchCount == 4) result.put("4개", result.get("4개") + 1);
            else if (matchCount == 3) result.put("3개", result.get("3개") + 1);
        }
        return result;
    }

    private void printResults(Map<String, Integer> result, int purchaseAmount) {
        System.out.println("당첨 통계\n---");

        int totalPrize = 0;
        Map<String, Integer> prizeMoney = Map.of(
                "3개", 5000, "4개", 50000, "5개", 1500000, "5개+보너스", 30000000, "6개", 2000000000
        );

        for (String key : result.keySet()) {
            int count = result.get(key);
            int prize = prizeMoney.get(key) * count;
            totalPrize += prize;

            // 5개+보너스에 대한 출력 형식을 변경합니다.
            if (key.equals("5개+보너스")) {
                System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개%n", String.format("%,d", prizeMoney.get(key)), count);
            } else {
                System.out.printf("%s 일치 (%s원) - %d개%n", key, String.format("%,d", prizeMoney.get(key)), count);
            }
        }

        double profitRate = ((double) totalPrize / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
