package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String money = Console.readLine();
                LottoGame lottoGame = new LottoGame(money);
                break;
            } catch (IllegalArgumentException e) {
            }
        }
    }
}
