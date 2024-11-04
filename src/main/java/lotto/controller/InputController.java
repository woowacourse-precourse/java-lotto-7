package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputController {
    // 구입금액의 유효성 검증
    public static int validatePurchase(int purchase) {
        try {
            if (purchase < 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 양수여야 합니다.");
            }
            if (purchase % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위여야 합니다.");
            }
            return purchase;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자값이어야 합니다.");
        }
    }

    public static List<Integer> parseIntegerList(String input) {
        List<Integer> result = new ArrayList<>();
        try {
            for (String num : input.split(",")) {
                int parsedNum = Integer.parseInt(num);
                if (parsedNum > 45 | parsedNum < 1) {
                    throw new IllegalArgumentException("[ERROR] 당첨번호는 1~45 사이여야 합니다.");
                }
                result.add(Integer.parseInt(num.trim()));
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 올바른 당첨번호 입력 형식이 아닙니다.");
            throw e;
        }
        return result;
    }

    public static int validateBonusNumber(int inputBonusNumber) {
        if (inputBonusNumber > 45 | inputBonusNumber < 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이 값이어야 합니다.");
        }
        return inputBonusNumber;
    }
}
