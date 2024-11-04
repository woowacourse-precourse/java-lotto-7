package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoStore store = new LottoStore();

        System.out.println("구입금액을 입력해 주세요.");
        int amount = Source.inputAmountOrBonusNumber(Console.readLine());
        System.out.println();
        List<Lotto> tickets = store.purchase(amount);
        System.out.println(tickets.size() + "개를 구매했습니다.");
        tickets.forEach(System.out::println);

        System.out.println("당첨번호를 입력해 주세요.");
        String[] winningInput = Source.inputWinningNumber(Console.readLine());
        Lotto winningNumbers = Source.parseNumbers(winningInput);

        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Source.inputAmountOrBonusNumber(Console.readLine());
    }
}
