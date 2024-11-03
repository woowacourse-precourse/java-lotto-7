package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {

    public static int moneyToBuyLotto() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                inputIsEmpty(input);
                inputIsNumeric(input);
                int moneyToBuyLotto = Integer.parseInt(input);
                moneyUnderZero(moneyToBuyLotto);
                return moneyToBuyLotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void inputIsEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입금액을 입력해주셔야 합니다.");
        }
    }

    public static void moneyUnderZero(int moneyToBuyLotto) {
        if (moneyToBuyLotto <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 0원 초과이어야 합니다.");
        }
    }

    private static void inputIsNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 입력에 숫자가 아닌 문자가 입력되었습니다.");
        }
    }

    public static String winningNumber() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String winningNumber = Console.readLine();
                validateWinningNumber(winningNumber);
                return winningNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateWinningNumber(String winningNumber) {
        inputWinningNumberIsEmpty(winningNumber);
        inputIsEmpty(winningNumber);
        List<Integer> winningNumberCollection = convertStringToList(winningNumber);
        validateWinningNumberCollection(winningNumberCollection);
    }

    private static void validateWinningNumberCollection(List<Integer> winningNumberCollection) {
        outOfRangeNumber(winningNumberCollection);
        findSameNumber(winningNumberCollection);
        countWinningNumber(winningNumberCollection);
    }

    public static void inputWinningNumberIsEmpty(String winningNumber) {
        if (winningNumber.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 문자열이 입력되었습니다.");
        }
    }

    public static List<Integer> convertStringToList(String winningNumber) {
        String[] numbers = winningNumber.split(",");
        List<Integer> numberList = new ArrayList<>();

        for (String number : numbers) {
            numberList.add(Integer.parseInt(number.trim()));
        }
        return numberList;
    }

    public static void outOfRangeNumber(List<Integer> winningNumberCollection) {
        for (int number : winningNumberCollection) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자로 이루어져 있습니다.");
            }
        }
    }

    public static void findSameNumber(List<Integer> winningNumberCollection) {
        Set<Integer> numberSet = new HashSet<>(winningNumberCollection);
        if (numberSet.size() < winningNumberCollection.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 입력되었습니다.");
        }
    }

    public static void countWinningNumber(List<Integer> winningNumberCollection) {
        if (winningNumberCollection.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자 6개가 입력되지 않았습니다.");
        }
    }

    public static int bonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                validateBonusNumber(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateBonusNumber(String input) {
        inputIsEmpty(input);
        inputIsNumeric(input);
        int bonusNumber = Integer.parseInt(input);
        checkBonusNumberRange(bonusNumber);
    }

    public static void checkBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자로 이루어져야 합니다.");
        }
    }
}
