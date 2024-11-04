package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class InputManager {

    public static int purchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int purchase = checkPurchaseAmount(Console.readLine());
                return purchase / 1000;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int checkPurchaseAmount(String input) {
        int purchase;
        try {
            purchase = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 형식이 잘못되었습니다.");
        }
        if (purchase == 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 0보다 큰 값이어야 합니다.");
        }
        if (purchase % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1,000원 단위로 구매 가능합니다.");
        }
        return purchase;
    }

    public static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                StringTokenizer input = new StringTokenizer(Console.readLine(), ",");
                List<Integer> winningNumbers = splitWinningNumbers(input);
                checkWinningNumbers(winningNumbers);
                duplicateWinningNumbers(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //사용자 입력을 "," 기준으로 잘라서 반환
    private static List<Integer> splitWinningNumbers(StringTokenizer input) {
        List<Integer> winningNumbers = new ArrayList<>();
        try {
            while (input.hasMoreTokens()) {
                winningNumbers.add(Integer.parseInt(input.nextToken()));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 입력 형식이 잘못되었습니다.");
        }
        return winningNumbers;
    }

    //입력 받은 winningNumbers의 번호 개수와 각각의 번호에 대한 validate
    private static void checkWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
        }
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber < 1 || winningNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    //전체 winningNumbers에 대해서 중복된 번호 validate
    private static void duplicateWinningNumbers(List<Integer> winningNumbers) {
        Set<Integer> set = new HashSet<>(winningNumbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 당첨 번호를 입력할 수 없습니다.");
        }
    }

    public static int getBonusNumber() {
        int bonusNumber = 0;
        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            bonusNumber = checkBonusNumber(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return bonusNumber;
    }

    private static int checkBonusNumber(String input) {
        int bonusNumber = 0;
        try {
            bonusNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호 입력 형식이 잘못되었습니다.");
        }
        if (bonusNumber < 0 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return bonusNumber;
    }
}
