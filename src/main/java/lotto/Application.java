package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            // 1. 로또 구입 금액 입력 받기
            int amount = LottoGame.getLottoAmount();
            int lottoCount = amount / 1000;
            System.out.println(lottoCount + "개를 구매했습니다.");

            // 2. 로또 발행
            List<Lotto> lottos = new ArrayList<>();
            for (int i = 0; i < lottoCount; i++) {
                lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            }

            // 3. 발행된 로또 번호 출력
            for (Lotto lotto : lottos) {
                System.out.println(lotto.getNumbers());
            }

            // 4. 당첨 번호 입력 받기
            List<Integer> winningNumbers = LottoGame.getWinningNumbers();

            // 5. 보너스 번호 입력 받기
            int bonusNumber = LottoGame.getBonusNumber();

            // 6. 당첨 결과 확인 및 출력
//            Result result = new Result(winningNumbers, bonusNumber, lottos);
//            result.printResult();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
