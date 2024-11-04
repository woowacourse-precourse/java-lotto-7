package lotto;

import java.util.*;
import java.util.stream.Collectors;

enum Messages {
    PURCHASEABLE_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    ANSWER_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_INPUT_MESSAGE("보너스 번호를 입력해 주세요."),
    ERROR_MESSAGE("[ERROR] "),
    STATISTICS_HEADER("당첨 통계\n---");

    private final String description;

    Messages(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

enum Prize {
    FIRST(6, 2_000_000_000, "6개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    FIFTH(3, 5_000, "3개 일치"),
    NONE(0, 0, "일치하는 번호 없음");

    private final int matchCount;
    private final int prizeMoney;
    private final String description;

    Prize(int matchCount, int prizeMoney, String description) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public static Prize of(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return NONE;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }
}


record WinningStatistics(
        Map<Prize, Integer> prizeCount,
        double profitRate
) {}
public class Application {
    private static final int TICKET_PRICE = 1000;

    public static void main(String[] args) {
        try {
            // 예산 입력받기 & 구입개수 산출기능
            int totalLottoCnt = getPurchaseableLottoNum(getBudgetInput());

            // 로또 추천기능
            List<List<Integer>> extractedLottoNums = extractLottoNumbers(totalLottoCnt);

            // 당첨번호 입력받기
            Lotto lotto = new Lotto(getJackpotInput());

            // 보너스 번호 입력받기
            int bonusNum = lotto.addBonusNumbers(getBonusNumber());

            // 당첨 통계 출력기능
            WinningStatistics statistics = calculateResults(extractedLottoNums, lotto.getNumbers(), bonusNum);
            printStatistics(statistics);

        } catch (IllegalArgumentException e) {
            System.out.println(Messages.ERROR_MESSAGE.getDescription() + e.getMessage());
        }
    }

    public static Integer getBudgetInput() {
        System.out.println(Messages.PURCHASEABLE_INPUT_MESSAGE.getDescription());
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        validateNumericInput(input);
        return Integer.parseInt(input);
    }

    private static void validateNumericInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    public static List<Integer> getJackpotInput() {
        System.out.println(Messages.ANSWER_INPUT_MESSAGE.getDescription());
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        return parseAndValidateNumbers(input);
    }

    private static List<Integer> parseAndValidateNumbers(String input) {
        try {
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            validateLottoNumbers(numbers);
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
        }
    }

    private static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이여야 합니다.");
        }
    }

    public static Integer getBonusNumber() {
        System.out.println(Messages.BONUS_INPUT_MESSAGE.getDescription());
        String input = camp.nextstep.edu.missionutils.Console.readLine().trim();
        validateNumericInput(input);
        int number = Integer.parseInt(input);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이여야 합니다.");
        }
        return number;
    }

    public static Integer getPurchaseableLottoNum(int budget) {
        if (budget < TICKET_PRICE) {
            throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 합니다.");
        }
        int count = budget / TICKET_PRICE;
        System.out.println(count + "개를 구매했습니다.");
        return count;
    }

    public static List<List<Integer>> extractLottoNumbers(int totalLottoCnt) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < totalLottoCnt; i++) {
            List<Integer> numbers = camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1, 45, 6);
            System.out.println(numbers);
            lottos.add(numbers);
        }
        return lottos;
    }

    private static WinningStatistics calculateResults(
            List<List<Integer>> purchasedLottos,
            List<Integer> winningNumbers,
            int bonusNumber
    ) {
        Map<Prize, Integer> prizeCount = initializePrizeCount();

        for (List<Integer> lotto : purchasedLottos) {
            int matchCount = countMatches(lotto, winningNumbers);
            boolean matchBonus = (matchCount == 5) && lotto.contains(bonusNumber);
            Prize prize = Prize.of(matchCount, matchBonus);
            prizeCount.merge(prize, 1, Integer::sum);
        }

        int totalPrize = calculateTotalPrize(prizeCount);
        double profitRate = calculateProfitRate(purchasedLottos.size() * TICKET_PRICE, totalPrize);

        return new WinningStatistics(prizeCount, profitRate);
    }

    private static int countMatches(List<Integer> lotto, List<Integer> winningNumbers) {
        return (int) lotto.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private static Map<Prize, Integer> initializePrizeCount() {
        return Arrays.stream(Prize.values())
                .collect(Collectors.toMap(
                        prize -> prize,
                        prize -> 0,
                        (prev, current) -> current,
                        HashMap::new
                ));
    }

    private static int calculateTotalPrize(Map<Prize, Integer> prizeCount) {
        return prizeCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

    private static double calculateProfitRate(int totalCost, int totalPrize) {
        return ((double) totalPrize / totalCost) * 100;
    }

    private static void printStatistics(WinningStatistics statistics) {
        System.out.println(Messages.STATISTICS_HEADER.getDescription());

        Arrays.stream(Prize.values())
                .filter(prize -> prize != Prize.NONE)
                .forEach(prize -> printPrizeResult(prize, statistics.prizeCount().get(prize)));

        System.out.printf("총 수익률은 %.1f%%입니다.%n", statistics.profitRate());
    }

    private static void printPrizeResult(Prize prize, int count) {
        System.out.printf("%s (%,d원) - %d개%n",
                prize.getDescription(),
                prize.getPrizeMoney(),
                count);
    }
}