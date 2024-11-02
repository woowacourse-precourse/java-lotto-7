package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        int budget = InputHandler.toInt(input);
        List<Lotto> lottos = LottoMachine.generateLotto(budget);
        int numberOfLotto = lottos.size();

        System.out.println();
        System.out.println(numberOfLotto + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            lotto.print();
        }
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        String numbersInput = Console.readLine();

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusBallInput = Console.readLine();

        Lotto lotto = new Lotto(InputHandler.toNumbers(numbersInput));
        int bonusBall = InputHandler.toInt(bonusBallInput);

        LottoResult result = LottoMachine.match(new WinningNumbers(lotto, bonusBall), lottos);

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        Arrays.stream(LottoPrize.values())
                .forEach(prize -> {
                    List<LottoPrize> prizes = result.getPrizeFor(prize);

                    System.out.print(prize.getMatchCount() + "개 일치");

                    if (prize.isBonusBallMatched()) {
                        System.out.print(", 보너스 볼 일치 ");
                    }
                    String money = String.format("%,d", prize.getMoney());
                    System.out.println(" (" + money + "원) - " + prizes.size() + "개");
                });
    }
}
