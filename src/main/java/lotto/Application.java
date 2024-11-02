package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int budget = Integer.parseInt(Console.readLine());

        LottoGenerator lottoGenerator = new LottoGenerator();
        int lottoCount = lottoGenerator.getLottoCount(budget);
        System.out.println(lottoCount + "개를 구매했습니다.");

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = lottoGenerator.generateLotto();
            System.out.println(lotto.getSortedLottoNumbers());
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumberInput = Console.readLine();
        List<Integer> winningNumbers = WinningNumberParser.parse(winningNumberInput);


        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        System.out.println("당첨 통계");
        System.out.println("---");
        //printWinningStatistics();  // TODO : 당첨 통계 처리
    }
}
