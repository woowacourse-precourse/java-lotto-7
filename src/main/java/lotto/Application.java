package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGame lottoGame;

        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String money = Console.readLine();
                lottoGame = new LottoGame(money);
                break;
            } catch (IllegalArgumentException e) {
            }
        }

        System.out.println();
        lottoGame.printMyLotto();
        System.out.println();

        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String winningNumber = Console.readLine();
                lottoGame.matchNumbers(winningNumber);
                break;
            } catch (IllegalArgumentException e) {
            }
        }

    }
}
