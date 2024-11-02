package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입 금액을 입력해 주세요.");
        String purchase = Console.readLine();

        Customer customer = new Customer();
        customer.buyLotto(purchase);

        LottoChecker lottoChecker = new LottoChecker();
        lottoChecker.inputWinningNumbers();
    }
}
