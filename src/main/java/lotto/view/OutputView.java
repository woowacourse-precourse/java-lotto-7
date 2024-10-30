package lotto.view;

import lotto.Lotto;

import java.util.List;

public class OutputView {

    public void printPurchaseGuide() {
        System.out.println("로또를 구입할 금액을 입력하세요.");
    }

    public void printWinningNumbersGuide() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberGuide() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
