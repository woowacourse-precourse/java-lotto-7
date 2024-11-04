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

        Map<Rank, Integer> result = calculateResults(lottos, winningNumbers, bonusNumber);
        printResults(result, purchaseAmount);
    }

    private int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return validateAmount(Console.readLine());
    }

    private int validateAmount(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 금액을 입력해 주세요.");
        }
        try {
            int amount = Integer.parseInt(input);
            if (amount > 0 && amount % 1000 == 0) {
                return amount;
            }
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위의 양수로 입력해 주세요.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
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
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    private List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return parseWinningNumbers(Console.readLine());
    }

    private List<Integer> parseWinningNumbers(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 입력해 주세요.");
        }

        try {
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            validateWinningNumbers(numbers);
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력해 주세요.");
        }
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6 || new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 중복되지 않는 숫자여야 합니다.");
        }

        numbers.forEach(number -> {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 범위여야 합니다.");
            }
        });
    }

    private int readBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        return validateBonusNumber(Console.readLine(), winningNumbers);
    }

    private int validateBonusNumber(String input, List<Integer> winningNumbers) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력해 주세요.");
        }

        try {
            int bonusNumber = Integer.parseInt(input);
            if (bonusNumber < 1 || bonusNumber > 45 || winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 범위이며 당첨 번호와 중복되지 않아야 합니다.");
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력해 주세요.");
        }
    }

    private Map<Rank, Integer> calculateResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        for (Lotto lotto : lottos) {
            Rank rank = getRank(lotto, winningNumbers, bonusNumber);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    private Rank getRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        long matchCount = lotto.getNumbers().stream().filter(winningNumbers::contains).count();
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

        return Rank.of((int) matchCount, bonusMatch);
    }

    private void printResults(Map<Rank, Integer> result, int purchaseAmount) {
        System.out.println("당첨 통계\n---");
        int totalPrize = 0;
        for (Rank rank : Rank.values()) {
            if (rank.getMessage().isEmpty()) continue;  // MISS 등급인 경우 건너뜁니다
            int count = result.getOrDefault(rank, 0);
            totalPrize += rank.getPrize() * count;
            System.out.printf("%s - %d개%n", rank.getMessage(), count);
        }
        double profitRate = (double) totalPrize / purchaseAmount * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
