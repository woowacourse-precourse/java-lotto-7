package lotto.view;

import lotto.model.LottoResult;
import lotto.model.Lottos;

public class OutputView {

    public void printLottos(Lottos lottos) {
        String builtMyLottos = OutputFormatBuilder.buildMyLottos(lottos);
        System.out.println(builtMyLottos);
    }

    public void printLottoResult(LottoResult lottoResult) {
        String builtLottoResult = OutputFormatBuilder.buildLottoResult(lottoResult);
        System.out.println(builtLottoResult);
    }
}
