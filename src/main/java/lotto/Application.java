package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoStore store = new LottoStore();

        int amount = Source.inputAmount();  // 구입 금액 입력
        List<Lotto> tickets = store.purchase(amount);
        System.out.println("\n" + tickets.size() + "개를 구매했습니다.");
        tickets.forEach(System.out::println);

        Lotto winningNumbers = Source.inputWinningNumbers();  // 당첨 번호 입력
        int bonusNumber = Source.inputBonusNumber();  // 보너스 번호 입력

        System.out.println("\n당첨 통계\n---");
        Result result = new Result(tickets, winningNumbers, bonusNumber);
        result.print();
    }
}
