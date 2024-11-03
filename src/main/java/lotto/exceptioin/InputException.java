package lotto.exceptioin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputException {

    // 로또 구매 금액을 입력받아 검증하는 메서드
    public int getValidMoney() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = System.console().readLine().trim();
                int money = Integer.parseInt(input);
                validateMoney(money);
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    // 로또 당첨 번호를 입력받아 검증하는 메서드
    public List<Integer> getValidWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = System.console().readLine().trim();
                List<Integer> winningNumbers = Stream.of(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                validateLottoNumbers(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    // 보너스 번호를 입력받아 검증하는 메서드
    public int getValidBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = System.console().readLine().trim();
                int bonusNumber = Integer.parseInt(input);
                validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    // 로또 번호 개수, 범위 및 중복 검증
    public void validateLottoNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개의 숫자로 입력되어야 합니다.");
        }
        // 중복 검사
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않는 숫자여야 합니다.");
        }
        // 각 번호 범위 검사
        for (Integer number : numbers) {
            validateLottoNumberRange(number);
        }
    }

    // 각 로또 번호 범위 검증
    private void validateLottoNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    // 보너스 번호 범위 검증
    public void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    // 구매 금액 유효성 검증
    public void validateMoney(int money) {
        if (money <= 0 || money % 1000 != 0) {
            throw new IllegalArgumentException("구매 금액은 1,000원 단위의 양수여야 합니다.");
        }
    }
}
