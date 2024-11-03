package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputPrice {
    public static int getAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        int amount = 0;
        try {
            amount = Integer.parseInt(Console.readLine());
            validateAmount(amount);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 유효한 금액을 입력해주세요.");
            return getAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getAmount();
        }
        return amount;
    }
    // 1000원 단위 오류 확인
    private static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
    //당첨 번호 입력
    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            List<Integer> winningNumbers = parseWinningNumbers(Console.readLine());
            validateWinningNumbers(winningNumbers);
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
    }

    //보너스 번호 입력
    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            int bonusNumber = Integer.parseInt(Console.readLine());
            validateBonusNumber(bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 보너스 번호는 숫자여야 합니다.");
            return getBonusNumber();
        }
    }

    //입력된 번호 변환
    private static List<Integer> parseWinningNumbers(String input) {
        String[] tokens = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token.trim()));
        }
        return numbers;
    }

    //당첨 번호가 숫자 6개인지, 1~45인지 검사 메소드
    static void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    //보너스 번호가 1~45인지 검사
    static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
