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
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                validatePurchaseAmount(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void validatePurchaseAmount(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 필수입니다.");
        }
        try {
            int amount = Integer.parseInt(input);
            if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위이며, 1,000원 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로 입력해 주세요.");
        }
    }

    private void purchaseLottos(int amount) {
        int count = amount / LOTTO_PRICE;
        System.out.println("\n" + count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            Lotto lotto = Lotto.create();
            purchasedLottos.add(lotto);
            System.out.println(lotto);
        }
        System.out.println();
    }

    private void setWinningNumbers() {
        winningLotto = getWinningLotto();
        bonusNumber = getBonusNumber();
    }

    private Lotto getWinningLotto() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                List<Integer> numbers = parseWinningNumbers(input);
                return Lotto.createWinningLotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> parseWinningNumbers(String input) {
        validateWinningNumberInput(input);
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(this::parseNumber)
                .collect(Collectors.toList());
    }

    public void validateWinningNumberInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 필수입니다.");
        }
        if (!input.matches("^\\s*\\d+(\\s*,\\s*\\d+)*\\s*$")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 숫자여야 합니다.");
        }
    }

    private int parseNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자 형식이 아닙니다.");
        }
    }

    private int getBonusNumber() {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                int number = parseNumber(input.trim());
                validateBonusNumber(number);
                return number;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void validateBonusNumber(int number) {
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
            Rank rank = determineRank(lotto);
            result.addRank(rank);
        }
        result.calculateProfitRate(purchasedLottos.size() * LOTTO_PRICE);
        return result;
    }

    private Rank determineRank(Lotto lotto) {
        int matchCount = lotto.countMatches(winningLotto);
        boolean hasBonusNumber = lotto.contains(bonusNumber);
        return Rank.valueOf(matchCount, hasBonusNumber);
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