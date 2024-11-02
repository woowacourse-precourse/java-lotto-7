package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입 금액을 입력해 주세요.");
        String purchase = Console.readLine();

        Customer customer = new Customer();
        customer.buyLotto(purchase);

        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
    }
}
