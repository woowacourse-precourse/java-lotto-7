package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        int budget = InputHandler.toInt(input);
        List<Lotto> lottoResults = LottoMachine.drawResults(budget);
        int numberOfLotto = lottoResults.size();

        System.out.println();
        System.out.println(numberOfLotto + "개를 구매했습니다.");

        for (Lotto lotto : lottoResults) {
            lotto.print();
        }
    }
}
