package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private int money;
    public int useMoney() {
        try {
            money = Integer.parseInt(input());
            if (money % 1000 == 0)
                throw new IllegalArgumentException("[ERROR] : 가격은 1000 단위여야 합니다");
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] : 올바른 가격 입력값이 아닙니다");
            useMoney();
        } catch (IllegalArgumentException e) {
            useMoney();
        }

        return money;
    }

    public List<Integer> checkNumber() {
        String[] numbers = input().split(",");
        List<Integer> balls = new ArrayList<>();
        for (String number : numbers) {
            balls.add(Integer.parseInt(number));
        }
        return balls;
    }

    private String input() {
        return Console.readLine();
    }
}
