package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        playLotto();
    }

    private static void playLotto() {
        int money = inputMoney();
    }

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return Integer.parseInt(input) / 1000;
    }
}
