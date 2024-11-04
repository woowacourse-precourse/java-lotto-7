package lotto.controller;

import static lotto.Application.winningLotto;

public class Validater {
    public static int stringToNum(String input) {
        try {
            int num = Integer.parseInt(input);
            return num;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능합니다.");
        }
    }

    public static void checkLottoCost(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원으로 나누어 떨어지지 않습니다.");
        }
    }

    public static void checkRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지만 입력가능합니다.");
        }
    }

    public static void checkBounsVaild(int bonus) {
        if (winningLotto.checkNumber(bonus) == 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 로또 번호와 중복입니다.");
        }
    }
}
