package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.model.LottoModel;
import lotto.view.LottoView;

public class LottoController {

    LottoView lottoView;
    LottoModel lottoModel;

    public LottoController(){
        lottoView = new LottoView();
        lottoModel = new LottoModel();
    }

    public void run(){
        int lottoCount = lottoView.readBuyingLottoCount();
        List<Lotto> lottos = lottoModel.createLotto(lottoCount);
        lottoView.printBoughtLottoInfo(lottos);

        List<Integer> winningLottoNumber = lottoView.readWinningNumbers();
        int bonusNumber = lottoView.readBonusNumber();
        lottoModel.setWinLottoWithBonusNumber(winningLottoNumber,bonusNumber);

        lottoView.printWinningInfo(lottoModel.getWinningInfo());

    }
}
