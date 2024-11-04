package lotto;

import java.util.List;
import lotto.business.LottoShop;
import lotto.lotto.Lotto;
import lotto.lotto.LottoResult;

public class Application {
    public static void main(String[] args) {
        LottoShop lottoShop = IoCContainer.getLottoShop();
        List<Lotto> lotteriesBuy = lottoShop.sellLotto();
        LottoResult lottoResult = lottoShop.draw();
        lottoShop.printResult(lotteriesBuy, lottoResult);
    }
}
