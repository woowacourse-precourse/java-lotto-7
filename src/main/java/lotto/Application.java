package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.model.LottoResult;

public class Application {
    public static void main(String[] args) {
        List<Lotto> randomLotto = new ArrayList<>();
        List<LottoResult> lottoResult = new ArrayList<>();
        LottoController lottoController = new LottoController(randomLotto, null, lottoResult);
        lottoController.startLotto();
    }
}
