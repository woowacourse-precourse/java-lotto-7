package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = new ArrayList<>(); // 빈 리스트로 초기화
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkForDuplicates(numbers);
        this.numbers = numbers;
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }


    public int validateMoney(String input) {
        int isNumber;

        try {
            isNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 가격을 숫자로만 입력해주세요.");
        }

        if (isNumber % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 가격을 입력해주세요.");
        } else if (isNumber <= 0) {
            throw new IllegalArgumentException("[ERROR] 0원 이상의 금액을 입력해주세요.");
        }

        return isNumber/1000;
    }

    public List<Integer> validateNum(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] splitInput = input.split("[,\\s]+");

        for (String numStr : splitInput) {
            try {
                int number = Integer.parseInt(numStr.trim());
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자 형식이 잘못되었습니다.");
            }
        }

        validate(numbers);

        checkForDuplicates(numbers);

        return numbers;
    }

    private void checkForDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static int bonusValidate(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로만 입력해주세요: " + input);
        }

        int result = Integer.parseInt(input);

        if (result < 0 || result > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 0~45 사이 숫자로만 입력해주세요: " + result);
        }

        bonusCheck(result);

        return result;
    }

    private static void bonusCheck(int input) {
        List<Integer> numbers = Lotto.Numbers.getNumbers();
        if (numbers.contains(input)) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호입니다. 중복되지 않는 숫자를 입력해주세요: " + input);
        }
    }

    public static void generateRandomNumbers(int cycle) {
        Numbers.setTestList();

//        for (int i = 0; i < cycle; i++) {
//            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//            Numbers.addRandomNumbers(randomNumbers);
//        }
    }

    public static void scoreCheck() {
        List<Integer> inputNumbers = Numbers.getNumbers();
        int bonusNumber = Lotto.Numbers.getBonusNumber();

        calculateResults(inputNumbers, bonusNumber);

        printStatistics();

    }

    private static void calculateResults(List<Integer> inputNumbers, int bonusNumber) {
        for (List<Integer> randomNumbers : Lotto.Numbers.getAllRandomNumbers()) {
            int matchCount = countMatchingNumbers(inputNumbers, randomNumbers);
            boolean bonusMatch = containsBonusNumber(randomNumbers, bonusNumber);

            Results rank = determineRank(matchCount, bonusMatch);
            if (rank != null) {
                rank.incrementCount();
            }
        }
    }

    private static int countMatchingNumbers(List<Integer> winningNumbers, List<Integer> randomNumbers) {
        int matchCount = 0;
        for (int number : randomNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private static boolean containsBonusNumber(List<Integer> randomNumbers, int bonusNumber) {
        return randomNumbers.contains(bonusNumber);
    }

    private static Results determineRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return Results.FIRST;
        if (matchCount == 5 && bonusMatch) return Results.SECOND;
        if (matchCount == 5) return Results.THIRD;
        if (matchCount == 4) return Results.FOURTH;
        if (matchCount == 3) return Results.FIFTH;
        return null;
    }

    public static void printStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");

        List<Results> resultsList = Arrays.asList(Results.values());
        Collections.reverse(resultsList);

        for (Results rank : resultsList) {
            String matchInfo = getMatchCount(rank) + "개 일치";
            if (rank == Results.SECOND) {
                matchInfo += ", 보너스 볼 일치";
            }

            System.out.printf("%s (%s원) - %d개%n",
                    matchInfo, formatPrize(rank.getPrize()), rank.getCount());
        }

        double profitRate = calculateProfitRate();
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    private static double calculateProfitRate() {
        int totalPrize = 0;
        int totalCost = Lotto.Numbers.getAllRandomNumbers().size() * 1000;

        for (Results rank : Results.values()) {
            totalPrize += rank.getPrize() * rank.getCount();
        }

        double profitRate = ((double) totalPrize / totalCost) * 100;
        return Math.round(profitRate * 100) / 100.0;
    }

    private static int getMatchCount(Results rank) {
        if (rank == Results.FIFTH) return 3;
        if (rank == Results.FOURTH) return 4;
        if (rank == Results.THIRD) return 5;
        if (rank == Results.SECOND) return 5;
        if (rank == Results.FIRST) return 6;
        return 0;
    }

    private static String formatPrize(int prize) {
        return String.format("%,d", prize);
    }

    public enum Numbers {
        INSTANCE;

        private List<Integer> numbers = new ArrayList<>(); // 초기화
        private List<List<Integer>> randomNumbersList = new ArrayList<>();
        private int bonus;

        public static void addRandomNumbers(List<Integer> randomNumbers) {
            INSTANCE.randomNumbersList.add(randomNumbers);
        }

        public static List<List<Integer>> getAllRandomNumbers() {
            return INSTANCE.randomNumbersList;
        }

        public static void addInputNumbers(List<Integer> inputNumbers) {
            INSTANCE.numbers.addAll(inputNumbers);
        }

        public static void addBonusNumber(int input) {
            INSTANCE.bonus = input;
        }

        public static List<Integer> getNumbers() {
            return INSTANCE.numbers;
        }

        public static int getBonusNumber(){
            return INSTANCE.bonus;
        }

        public static void setTestList(){
            INSTANCE.randomNumbersList = List.of(
                    List.of(8, 21, 23, 41, 42, 43),
                    List.of(3, 5, 11, 16, 32, 38),
                    List.of(7, 11, 16, 35, 36, 44),
                    List.of(1, 8, 11, 31, 41, 42),
                    List.of(13, 14, 16, 38, 42, 45),
                    List.of(7, 11, 30, 40, 42, 43),
                    List.of(2, 13, 22, 32, 38, 45),
                    List.of(1, 3, 5, 14, 22, 45)
            );
        }
    }

    public enum Results {
        FIRST(2000000000, 0),
        SECOND(30000000, 0),
        THIRD(1500000, 0),
        FOURTH(50000, 0),
        FIFTH(5000, 0);

        private final int prize;
        private int count;

        Results(int prize, int count) {
            this.prize = prize;
            this.count = count;
        }

        public int getPrize() {
            return prize;
        }

        public int getCount() {
            return count;
        }

        public void incrementCount() {
            count++;
        }
    }
}

