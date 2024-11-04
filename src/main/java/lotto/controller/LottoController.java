package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final int LOTTO_PRICE = 1000;

    public void start(){
        int purchaseAmount = InputView.getPurchaseAmount();
        int lottoCount = purchaseAmount / LOTTO_PRICE;

        List<Lotto> lottos = generatedLottos(lottoCount);
        OutputView.printLottoCountAndNumbers(lottoCount, lottos);;
    }

    private List<Lotto> generatedLottos(int count){
        LottoGenerator generator = new LottoGenerator();
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < count; i++){
            lottos.add(generator.generateLotto());
        }
        return lottos;
    }
}
