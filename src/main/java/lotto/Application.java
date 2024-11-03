package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final String PURCHASE_AMOUNT_ERROR_MESSAGE = "[ERROR] 구입금액은 1,000원 단위이며, 1,000원 이상이어야 합니다.";
    private static final String COMMA = ",";
    private final List<Lotto> purchasedLottos;
    private Lotto winningLotto;
    private int bonusNumber;

    public Application() {
        this.purchasedLottos = new ArrayList<>();
    }

    public static void main(String[] args) {
        try {
            Application app = new Application();
            app.play();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void play() {
        int amount = getPurchaseAmount();
        purchaseLottos(amount);
        setWinningNumbers();
        printResult();
    }

    private int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validatePurchaseAmount(input);
        return Integer.parseInt(input);
    }

    public void validatePurchaseAmount(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 필수입니다.");
        }
        try {
            int amount = Integer.parseInt(input);
            if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
                throw new IllegalArgumentException(PURCHASE_AMOUNT_ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로 입력해 주세요.");
        }
    }

    private void purchaseLottos(int amount) {
        int count = amount / LOTTO_PRICE;
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            Lotto lotto = Lotto.create();
            purchasedLottos.add(lotto);
            System.out.println(lotto);
        }
        System.out.println();
    }

    private void setWinningNumbers() {
        winningLotto = getWinningLotto();
        System.out.println();
        bonusNumber = getBonusNumber();
        System.out.println();
    }

    private Lotto getWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return parseWinningLotto(input);
    }

    private Lotto parseWinningLotto(String input) {
        validateWinningNumberInput(input);
        List<Integer> numbers = parseWinningNumbers(input);
        return Lotto.createWinningLotto(numbers);
    }

    public void validateWinningNumberInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 필수입니다.");
        }
        if (!input.matches("^\\s*\\d+(\\s*,\\s*\\d+){5}\\s*$")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표(,)로 구분된 6개의 숫자여야 합니다.");
        }
    }

    public List<Integer> parseWinningNumbers(String input) {
        try {
            List<Integer> numbers = Arrays.stream(input.split(COMMA))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            validateNumberRange(numbers);
            validateDuplicateNumbers(numbers);
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력 가능합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        }
    }

    private int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateBonusNumberInput(input);
        int number = Integer.parseInt(input.trim());
        validateBonusNumber(number);
        return number;
    }

    private void validateBonusNumberInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 필수입니다.");
        }
        try {
            int number = Integer.parseInt(input.trim());
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
        }
    }

    public void validateBonusNumber(int number) {
        if (winningLotto == null) {
            throw new IllegalStateException("[ERROR] 당첨 번호가 먼저 설정되어야 합니다.");
        }
        if (winningLotto.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private void printResult() {
        Result result = calculateResult();
        System.out.println("\n당첨 통계\n---");
        result.printStatistics();
    }

    private Result calculateResult() {
        Result result = new Result();
        for (Lotto lotto : purchasedLottos) {
            Rank rank = getRank(lotto);
            result.addRank(rank);
        }
        result.calculateProfitRate(purchasedLottos.size() * LOTTO_PRICE);
        return result;
    }

    private Rank getRank(Lotto lotto) {
        int matchCount = lotto.countMatches(winningLotto);
        boolean matchBonus = lotto.contains(bonusNumber);
        return Rank.valueOf(matchCount, matchBonus);
    }
}

enum Rank {
    FIRST(6, false, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, false, 1500000, "5개 일치 (1,500,000원)"),
    FOURTH(4, false, 50000, "4개 일치 (50,000원)"),
    FIFTH(3, false, 5000, "3개 일치 (5,000원)"),
    NONE(0, false, 0, "");

    private final int matchCount;
    private final boolean requireBonus;
    private final int prize;
    private final String description;

    Rank(int matchCount, boolean requireBonus, int prize, String description) {
        this.matchCount = matchCount;
        this.requireBonus = requireBonus;
        this.prize = prize;
        this.description = description;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 6)
            return FIRST;
        if (matchCount == 5 && matchBonus)
            return SECOND;
        if (matchCount == 5)
            return THIRD;
        if (matchCount == 4)
            return FOURTH;
        if (matchCount == 3)
            return FIFTH;
        return NONE;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}

class Result {
    private final Map<Rank, Integer> rankCounts;
    private double profitRate;

    public Result() {
        rankCounts = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void addRank(Rank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public void calculateProfitRate(int totalPurchaseAmount) {
        long totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : rankCounts.entrySet()) {
            totalPrize += (long) entry.getKey().getPrize() * entry.getValue();
        }
        profitRate = totalPrize * 100.0 / totalPurchaseAmount;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public void printStatistics() {
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                System.out.printf("%s - %d개\n",
                        rank.getDescription(),
                        rankCounts.getOrDefault(rank, 0));
            }
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}