package lotto.view;

import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.Winning;

public class OutputView {
    public void askBuyingPriceView() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void responseBuyingQuantity(int lottoNum) {
        System.out.println();
        System.out.println(lottoNum + "개를 구매했습니다.");
    }

    public void askWinningLotto() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void askBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(formatLottoNumbers(lotto.getNumbers()));
        }
    }

    private String formatLottoNumbers(List<Integer> numbers) {
        return numbers.toString()
                .replace("[", "[")
                .replace("]", "]");
    }

    public void responseRateOfReturn(String rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

}
