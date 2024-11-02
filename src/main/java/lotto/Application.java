package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Long money = inputMoney();
        Long countLotto = availableLotto(money);

    }

    public static Long inputMoney() {
        System.out.println("구입금액을 입력해주세요.");
        Long money = Long.parseLong(Console.readLine());
        if (validMoney(money)) {
            return money;
        }
        return inputMoney();
    }

    public static boolean validMoney(Long money) {
        return money % 1000 == 0;
    }

    public static Long availableLotto(Long money) {
        Long countLotto = money / 1000;
        System.out.println(countLotto + "개를 구매했습니다.");
        return countLotto;
    }
}
