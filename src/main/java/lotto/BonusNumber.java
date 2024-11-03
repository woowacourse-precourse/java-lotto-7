package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BonusNumber {
    public static int bonusNumber;

    public BonusNumber() {
        System.out.println();
        pickBonusNumber();
    }

    private void pickBonusNumber() {
        try {
            printGuideMessage();
            getBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            pickBonusNumber();
        }
    }

    private void printGuideMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    private void getBonusNumber() {
        String bonus = readLine();
        bonus = removeBlank(bonus);
        checkIsBlank(bonus);
        checkIsOnlyNumber(bonus);
        bonusNumber = castInputType(bonus);
        checkIsValidRange(bonusNumber);
    }

    private String removeBlank(String input) {
        return input.replaceAll(" ", "");
    }

    private int castInputType(String input) {
        return Integer.parseInt(input);
    }

    private void checkIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력하지 않았습니다.");
        }
    }

    private void checkIsOnlyNumber(String input) {
        try {
            castInputType(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자뿐이어야 합니다.");
        }
    }

    private void checkIsValidRange(int input) {
        int MIN = 1;
        int MAX = 45;
        if (input < MIN || input > MAX) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이여야 합니다.");
        }
    }
}
