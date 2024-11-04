package lotto.lottoController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExceptionController {
    public void isValidCost(String cost) {
        try {
            notNumeric(cost);
            emptyInput(cost);
            blankInput(cost);
            haveBlankInput(cost);
            lowCost(cost);
            notPlus(cost);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] " + e.getMessage());
            throw e;
        }
    }

    public void isValidHitNumbers(String hitNumbers) {
        try {
            emptyInput(hitNumbers);
            blankInput(hitNumbers);
            haveBlankInput(hitNumbers);
            anotherSomething(hitNumbers);
            onlySix(hitNumbers);
            convertCheckMode(hitNumbers);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] " + e.getMessage());
            throw e;
        }
    }

    public void isValidBonusNumbers(String bonusNumbers, List<Integer> hitNumber) {
        try {
            emptyInput(bonusNumbers);
            blankInput(bonusNumbers);
            haveBlankInput(bonusNumbers);
            notNumeric(bonusNumbers);
            overLength(bonusNumbers);
            oneNumberInRange(bonusNumbers);
            forbiddenNumber(bonusNumbers, hitNumber);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] " + e.getMessage());
            throw e;
        }
    }

    private void notNumeric(String input) {
        try {
            Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
        }
    }

    private void emptyInput(String input) {
        if (input.isEmpty() || input == null) {
            throw new IllegalArgumentException("입력값은 공백일 수 없습니다.");
        }
    }

    private void blankInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값은 띄어쓰기만 있어선 안됩니다.");
        }
    }

    private void haveBlankInput(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("입력값에 공백이 포함되어 있습니다. 입력값 사이에 공백을 넣지 마세요.");
        }
    }

    private void lowCost(String input) {
        long value = Long.parseLong(input);
        if (0 != value % 1000) {
            throw new IllegalArgumentException("입력값은 1000원 단위여야 합니다.");
        }
    }

    private void notPlus(String input) {
        long value = Long.parseLong(input);
        if (value <= 0) {
            throw new IllegalArgumentException("입력값은 양수만 입력 가능합니다.");
        }
    }

    private void anotherSomething(String input) {
        if (!input.matches("^[0-9,]+$")) {
            throw new IllegalArgumentException("입력에는 숫자와 콤마만 사용할 수 있습니다.");
        }
    }

    private void onlySix(String input) {
        String[] numberStrings = input.split(",");
        if (numberStrings.length != 6) {
            throw new IllegalArgumentException("6개의 숫자를 입력해야 합니다.");
        }
    }

    private void convertCheckMode(String input) {
        String[] numberStrings = input.split(",");
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (String numStr : numberStrings) {
            int number = Integer.parseInt(numStr); // 각 숫자를 정수로 변환
            numInRange(number);
            checkUnique(uniqueNumbers, number);
        }
    }

    private void numInRange(int number) {
        if (number < 1 || number > 45) { // 1에서 45 사이의 숫자인지 확인
            throw new IllegalArgumentException("각 숫자는 1에서 45 사이여야 합니다.");
        }
    }

    private void checkUnique(Set<Integer> uniqueNumbers, int number) {
        if (!uniqueNumbers.add(number)) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    private void overLength(String input) {
        if (input.length() > 2) {
            throw new IllegalArgumentException("숫자는 최대 두 자리여야 합니다.");
        }
    }

    private void oneNumberInRange(String input) {
        int number = Integer.parseInt(input);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("숫자는 1에서 45 사이여야 합니다.");
        }
    }

    private void forbiddenNumber(String input, List<Integer> hitnumber) {
        if (hitnumber.contains(Integer.parseInt(input))) {
            throw new IllegalArgumentException("입력한 당첨 번호와 다른 숫자여야 합니다.");
        }
    }
}
