package lotto.view;

import static lotto.constants.Constants.UNIT_PRICE;
import static lotto.constants.Constants.ZERO;

import java.util.Map;
import lotto.domain.LottoGroup;
import lotto.domain.Winning;

public class OutputView {
    public void printBuyingRequest() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void responseQuantity(int amount) {
        System.out.println();
        System.out.println(getQuantity(amount) + "개를 구매했습니다.");
    }

    public int getQuantity(int amount) {
        return amount / UNIT_PRICE;
    }

    public void askLottoNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void responseUserLottoNumber(LottoGroup lottoGroup) {
        lottoGroup.getLottos().forEach(lotto -> {
            System.out.println(lotto.getNumbers());
        });
    }

    public void askBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void responseWinningHistory(Map<Winning, Integer> countOfWinning) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + countOfWinning.getOrDefault(Winning.THIRD, ZERO) + "개");
        System.out.println("4개 일치 (50,000원) - " + countOfWinning.getOrDefault(Winning.FOURTH, ZERO) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + countOfWinning.getOrDefault(Winning.FIFTH, ZERO) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countOfWinning.getOrDefault(Winning.FIFTH_WITH_BONUS, ZERO) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + countOfWinning.getOrDefault(Winning.SIXTH, ZERO) + "개");
    }

    public void responseYieldOfLotto(String yieldOfLotto) {
        System.out.println("총 수익률은 " + yieldOfLotto + "%입니다.");
    }
}
