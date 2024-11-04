package lotto.view;


import java.util.Arrays;

import static java.lang.Integer.parseInt;

public enum InputTypeWithValidation {

    MONEY("구입금액을 입력해 주세요"),
    WINNING_NUMS("\n당첨 번호를 입력해 주세요."),
    BONUS_NUM("\n보너스 번호를 입력해 주세요.");

    private final String message;

    InputTypeWithValidation(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String validate(String inputString) {
        if (this == MONEY) {
            validateMoney(inputString);
        }
        if (this == BONUS_NUM) {
            validateLottoNum(inputString);
        }
        if (this == WINNING_NUMS) {
            validateWinningNums(inputString);
        }
        return inputString;
    }


    private void validateMoney(String money) {
        checkParsing(money);
        checkBlank(money);
        checkMoneyRange(money);
        checkMoneyChange(money);
    }

    private void validateWinningNums(String winning) {
        checkBlank(winning);
        checkLength(winning);
        checkDuplicate(winning);
        Arrays.stream(winning.split(",")).toList()
                .forEach(this::validateLottoNum);
    }

    private void validateLottoNum(String bonus) {
        checkParsing(bonus);
        checkBlank(bonus);
        checkLotteryRange(bonus);
    }



    private void checkDuplicate(String winning) {
        if (Arrays.stream(winning.split(",")).distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }

    private void checkLength(String winning) {
        if (winning.split(",").length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개를 입력해주세요.");
        }
    }

    private void checkLotteryRange(String bonus) {
        if (parseInt(bonus) < 1 || parseInt(bonus) > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void checkMoneyRange(String s) {
        if (parseInt(s) < 1000) {
            throw new IllegalArgumentException("[ERROR] 최소 구입금액은 1000원입니다.");
        }
    }

    private void checkMoneyChange(String s) {
        if (parseInt(s) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }

    private void checkBlank(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입금액을 입력해주세요.");
        }
    }

    private void checkParsing(String s) {
        try {
            parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 문자열이 아닌 숫자를 입력해주세요.");
        }
    }

}
