package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputHandler {
    private List<Integer> validatedNumbers;
    public InputHandler() {
    }

    public int getBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                return validateBuyAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getInputNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                return validateInputNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                return validateBonusNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int validateBonusNumber(String input) {
        validateNumeric(input);
        int bonusNumber = Integer.parseInt(input);
        validateRange(bonusNumber);
        checkDuplicate(bonusNumber);
        return bonusNumber;
    }

    public int validateBuyAmount(String input) {
        validateNumeric(input);
        int amount = Integer.parseInt(input);
        validateUnit(amount);
        return amount;
    }

    public List<Integer> validateInputNumber(String input) {
        String[] splitNumbers = input.split(",");
        validateLength(splitNumbers);
        Set<Integer> uniqueNumbers = new HashSet<>();
        validatedNumbers = Arrays.stream(splitNumbers)
                .map(String::trim) // 공백 제거
                .map(value -> {
                    validateNumeric(value);
                    int number = Integer.parseInt(value);
                    validateRange(number);
                    checkDuplicate(uniqueNumbers, number);
                    return number;
                }).collect(Collectors.toList());
        return validatedNumbers;
    }
    public void validateLength(String[] splitNumbers){
        if (splitNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개를 입력해주세요.");
        }
    }
    public void validateNumeric(String value){
        if (!value.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 양수를 입력해주세요.");
        }
    }
    public void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 숫자 범위를 확인 해 주세요.");
        }
    }
    public void checkDuplicate(Set<Integer> uniqueNumbers, int number) {
        if (!uniqueNumbers.add(number)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }
    public void checkDuplicate(int bonusNumber) {
        if (this.validatedNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    public void validateUnit(int amount) {
        if (amount % 1000 != 0 || amount == 0) {   //0원 구입?
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

}
