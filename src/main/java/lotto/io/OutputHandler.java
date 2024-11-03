package lotto.io;

import lotto.LottoPool;

public class OutputHandler {

    public void askLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void showLottoQuantity(int quantity) {
        System.out.println();
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public void showLottos(LottoPool lottoPool) {
        lottoPool.display();
    }

    public void askWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}
