package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        List<List<Integer>> lottos;
        List<Integer> winLotto;
        int lottoCount = 0;
        int bonusNumber = 0;
        String winNumbers = "";
        Integer cost;
        System.out.println("구입 금액을 입력해 주세요.");
        cost = Integer.parseInt(Console.readLine());
        lotto.printLottoCount(cost);
        lottoCount = lotto.getLottoCount(cost);
        lottos = lotto.getLottos(lottoCount);
        lotto.printLottos(lottos);

        System.out.println("\n당첨 번호를 입력해 주세요.");
        winNumbers = Console.readLine();
        winLotto = lotto.splitWinNumbers(winNumbers);
        lotto = new Lotto(winLotto);

        System.out.println("\n보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());
        lotto.checkBonusNumber(bonusNumber);
        lotto.printWinStatistics(lottos, bonusNumber);
    }
}
