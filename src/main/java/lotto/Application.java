package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());

        // 로또 구매 및 출력
        Buy buy = new Buy();
        int count = buy.countLotto(money);
        System.out.println(count + "개를 구매했습니다.");
        List<Lotto> lottos = Lotto.generateLottos(count);
        for (Lotto l : lottos) {
            System.out.println(l.getNumbers());
        }

        // 당첨 번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinNumbers = Console.readLine();
        WinNumber winNumber = new WinNumber();
        winNumber.inputWinNumber(inputWinNumbers);

        // 보너스 번호 입력
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        winNumber.inputBonusNumber(bonusNumber);

        // 당첨 결과 확인
        MatchNumber matchNumber = new MatchNumber(winNumber, bonusNumber);
        matchNumber.checkWinNumber(lottos);

        // 당첨 통계 출력
        LottoResults results = new LottoResults(matchNumber.getPrizeCount(),
            matchNumber.getTotalPrize(), money);
        results.printResults();
    }
}
