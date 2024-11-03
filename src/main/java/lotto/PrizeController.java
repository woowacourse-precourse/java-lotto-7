package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.Validate;

public class PrizeController {

    private final InputView inputView = new InputView(new Validate());
    private final PrizeService prizeService = new PrizeService();
    private final OutputView outputView = new OutputView();

    public void lottoStart(){
        int lottoMoney=inputView.getMoneyInput();
        int count=lottoMoney/1000;

        List<Lotto> lotto=generateLotto(count);
        outputView.printLottoNumber(count);
        outputView.printLotto(lotto);

        Map<LottoRate, Integer> prizeRepository = prizeService.servicePrize(lotto,
                inputView.getLottoInput(),
                inputView.getBonusInput());

        double retunaValue=prizeService.calculateReturnValue(prizeRepository, lottoMoney);

        outputView.producePrize(prizeRepository, retunaValue);
    }


    public List<Lotto> generateLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for(int i=0; i<count; i++) {
            lottos.add(new LottoGenerator().getLottoGenerator());
        }
        return lottos;
    }


}
