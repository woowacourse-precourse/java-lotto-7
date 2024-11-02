package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int purchaseAmount = Integer.parseInt(Console.readLine());
                validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식이 올바르지 않습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> inputWinningNumber() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                List<Integer> numbers = Arrays.stream(Console.readLine().split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                validateWinningNumbers(numbers);
                return numbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식이 올바르지 않습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine());
                validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식이 올바르지 않습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePurchaseAmount(int amount){
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
        }
        if(amount % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위이어야 합니다.");
        }
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자여야 합니다.");
        }
        if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }

}
