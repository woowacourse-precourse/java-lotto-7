package lotto.view;

import lotto.model.domain.Lotto;
import lotto.model.domain.Lottos;

public class LottoView implements LottoViewInterface{

    @Override
    public void printTotalLottoCount(int LottoCount) {
        System.out.println("\n"+LottoCount +"개를 구매했습니다.");
    }

    @Override
    public void printCreatedLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    @Override
    public String printWinningStatus() {
        return "";
    }
}
