package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요.");
        int money = Input.validate(null, (input, unused) -> Input.parseMoney(input));
        System.out.println();

        int N = money / LottoInfo.price;

        List<Lotto> lottoes = new ArrayList<>();

        System.out.println(N + "개를 구매했습니다.");
        for (int i = 0; i < N; i++) {
            Lotto lotto = new Lotto();
            lotto.printNumbers();
            lottoes.add(lotto);
        }
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto winningLotto = Input.validate(null, (input, unused) -> Input.parseWinningLotto(input));
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Input.validate(winningLotto.getNumbers(), Input::parseBonusNumber);
        System.out.println();

        System.out.println("당첨 통계");
        System.out.println("---");

        Map<Integer, Integer> winningPrice = new HashMap<>();
        Map<Integer, Integer> bonusWinningPrice = new HashMap<>();
        winningPrice.put(3, 5000);
        winningPrice.put(4, 50000);
        winningPrice.put(5, 1500000);
        winningPrice.put(6, 2000000000);
        bonusWinningPrice.put(5, 30000000);
        LottoChecker lottoChecker = new LottoChecker(winningPrice, bonusWinningPrice);

        lottoChecker.result(winningLotto, lottoes, bonusNumber);
    }

}
