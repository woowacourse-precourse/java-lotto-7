package lotto.controller;

import java.util.ArrayList;
import java.util.List;

public class InputController {
    public static List<Integer> parseIntegerList(String input) {
        List<Integer> result = new ArrayList<>();
        try {
            for (String num: input.split(",")) {
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
}
