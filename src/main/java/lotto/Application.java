package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // 1. 로또 구입 금액 입력
        int money;
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 정수로만 입력할 수 있습니다. 다시 작성해 주세요.");
        }

        if (money % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 로또 하나를 구입하는 데에 필요한 금액은 1,000원입니다. 1,000원 단위로 다시 작성해 주세요.");
        }
    }
}
