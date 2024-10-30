package lotto;


import camp.nextstep.edu.missionutils.Console;

public class LottoGame {

    public void run() {
        purchaseLotto();
    }

    private void purchaseLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String rawMoney = Console.readLine();
    }
}
