package lotto;

import static lotto.RANK.FIFTH;
import static lotto.RANK.FIRST;
import static lotto.RANK.FOURTH;
import static lotto.RANK.SECOND;
import static lotto.RANK.THIRD;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();

        LottoGenerator lottoGenerator = new LottoGenerator(userInput);

        System.out.println("당첨 번호를 입력해 주세요.");
        String userWinningNumbers = Console.readLine();
        System.out.println("보너스 번호를 입력해 주세요.");
        String userBonusNumber = Console.readLine();
        WinningNumber winningNumber = new WinningNumber(userWinningNumbers, userBonusNumber);

        // 검증
        LottoChecker lottoChecker = new LottoChecker(winningNumber, lottoGenerator.getLottos());
        Result result = new Result(lottoChecker.checkAll(), lottoGenerator.getCost());

        // 결과 반환
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n",result.get(FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개%n",result.get(FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n",result.get(THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n",result.get(SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", result.get(FIRST));
        System.out.printf("총 수익률은 %.1f%%입니다.%n", result.getRate());

    }
}
