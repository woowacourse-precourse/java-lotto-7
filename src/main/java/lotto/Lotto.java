package lotto;

import java.util.ArrayList;
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

        checkForDuplicates(numbers);

        validate(numbers);

        return numbers;
    }

    private void checkForDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 포함되어 있습니다.");
        }
    }

    public static int bounusValidate(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로만 입력해주세요: " + input);
        }

        int result = Integer.parseInt(input);

        if (result < 0 || result > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 0~45 사이 숫자로만 입력해주세요: " + result);
        }

        bounusCheck(result);

        return result;
    }

    private static void bounusCheck(int input) {
        for (List<Integer> numbers : Numbers.getAllRandomNumbers()) {
            if (numbers.contains(input)) {
                throw new IllegalArgumentException("[ERROR] 중복된 번호입니다. 중복되지 않는 숫자를 입력해주세요: " + input);
            }
        }
    }

    public static void generateRandomNumbers(int cycle) {
        for (int i = 0; i < cycle; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Numbers.addRandomNumbers(randomNumbers);
        }
    }

    public enum Numbers {
        INSTANCE;

        private List<Integer> numbers = new ArrayList<>(); // 초기화
        private final List<List<Integer>> randomNumbersList = new ArrayList<>();

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
            INSTANCE.numbers.add(input);
        }

        public static List<Integer> showNum() {
            return INSTANCE.numbers;
        }
    }

    public enum Results {
        FIRST(2_000000000),
        SECOND(30000000),
        THIRD(15000000),
        FOURTH(50000),
        FIFTH(5000);

        private final int prize;

        Results(int prize) {
            this.prize = prize;
        }

        public int getPrize() {
            return prize;
        }
    }
}

