package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;
    private final int bonusNumber;

    public Lotto(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public static Lotto generateRandomLotto() {
        List<Integer> generatedNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
        int bonusNumber = generateBonusNumber(generatedNumbers);
        return new Lotto(generatedNumbers, bonusNumber);
    }

    private static int generateBonusNumber(List<Integer> generatedNumbers) {
        int bonusNumber;
        do {
            bonusNumber = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, 1).get(0);
        } while (generatedNumbers.contains(bonusNumber));
        return bonusNumber;
    }

    // 로또 번호와 보너스 번호에 대한 유효성 검사
    private void validate(List<Integer> numbers, int bonusNumber) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (new HashSet<>(numbers).size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1과 45 사이의 숫자여야 합니다.");
            }
        }
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이의 숫자여야 합니다.");
        }
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public static Set<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요 (쉼표로 구분).");
        String[] winningInput = Console.readLine().split(",");
        return parseWinningNumbers(winningInput);
    }

    private static Set<Integer> parseWinningNumbers(String[] winningInput) {
        Set<Integer> winningNumbers = new HashSet<>();
        for (String number : winningInput) {
            int parsedNumber = Integer.parseInt(number.trim());
            if (parsedNumber < MIN_NUMBER || parsedNumber > MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1과 45 사이의 숫자여야 합니다.");
            }
            winningNumbers.add(parsedNumber);
        }
        if (winningNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복 없이 6개여야 합니다.");
        }
        return winningNumbers;
    }

    public static int getBonusNumberInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine().trim());
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이의 숫자여야 합니다.");
        }
        return bonusNumber;
    }
}
