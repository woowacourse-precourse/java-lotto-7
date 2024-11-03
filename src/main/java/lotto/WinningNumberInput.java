package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class WinningNumberInput {

    public int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                return validateAmount(Console.readLine());
            } catch (NumberFormatException e) {
                printError("잘못된 형식의 숫자입니다.");
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }

    private int validateAmount(String input) {
        int amount = Integer.parseInt(input);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
        }
        return amount;
    }

    public List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                return parseWinningNumbers(Console.readLine());
            } catch (NumberFormatException e) {
                printError("잘못된 형식의 숫자입니다.");
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }

    List<Integer> parseWinningNumbers(String input) {
        List<Integer> numbers = splitAndValidate(input);
        validateWinningNumbers(numbers);
        return numbers;
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개의 숫자여야 합니다.");
        }
    }

    private List<Integer> splitAndValidate(String input) {
        String[] inputArray = input.split(",");
        validateNumberCount(inputArray);
        return convertToNumberList(inputArray);
    }

    private void validateNumberCount(String[] inputArray) {
        if (inputArray.length != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개의 숫자여야 합니다.");
        }
    }

    private List<Integer> convertToNumberList(String[] inputArray) {
        List<Integer> numbers = new ArrayList<>();
        for (String num : inputArray) {
            int number = parseAndValidateNumber(num.trim(), numbers);
            numbers.add(number);
        }
        return numbers;
    }

    private int parseAndValidateNumber(String num, List<Integer> numbers) {
        int number = Integer.parseInt(num);
        validateNumberRange(number);
        checkDuplicate(numbers, number);
        return number;
    }

    private void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void checkDuplicate(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("중복된 숫자가 입력되었습니다.");
        }
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                return validateBonusNumber(Console.readLine(), winningNumbers);
            } catch (NumberFormatException e) {
                printError("잘못된 형식의 숫자입니다.");
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }

    int validateBonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumber = Integer.parseInt(input.trim());
        validateNumberRange(bonusNumber);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        return bonusNumber;
    }

    private void printError(String message) {
        System.out.println("[ERROR] " + message + " 다시 입력해 주세요.");
    }

    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto));
    }
}
