package lotto.view;

import lotto.exception.LottoGameException;
import lotto.model.Lottos;
import lotto.model.Money;

public class OutputView {

    public void commentErrorMessage(LottoGameException e) {
        System.out.println(e.getMessage());
    }

    public void commentsForPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public int commentForBuyLotto(Money money) {
        int lottoCount = money.getPossibleLottoCount();
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }

    public void commentForLottoList(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
    }

}
