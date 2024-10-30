package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();

        System.out.println("로또 구입 금액을 입력해주세요.");
        int amount = Integer.parseInt(Console.readLine());
        game.BuyLotto(amount);
    }
}
