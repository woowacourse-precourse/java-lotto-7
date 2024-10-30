package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.Lottos;
import lotto.dto.LottoRequest;
import lotto.dto.LottoWinResult;
import lotto.enums.LottoCriteria;
import lotto.utility.LottoNumberUtility;

public class LottoService {

    public Lottos buyLottos(LottoRequest lottoRequest) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i< lottoRequest.buyMoney() / LottoCriteria.BUY_MONEY_UNIT.getCriteriaVal(); i++){
            lottoList.add(buyLotto());
        }
        return new Lottos(lottoList);
    }

    public LottoWinResult calLottoResult(Lottos lottos, LottoRequest lottoRequest) {
        List<LottoWinResult> lottoWinResultList = lottos.getWinResult(lottoRequest.winningNumbers(), lottoRequest.bonusNumber());
        double lottoWinMoneyRate = LottoCalculator.getStatisticResult(lottoWinResultList,lottoRequest.buyMoney());
        
    }

    private Lotto buyLotto(){
        List<Integer> lottoRandomNumbers = LottoNumberUtility.lottoRandomNumber();
        Lotto lotto = new Lotto(lottoRandomNumbers);
        return lotto;
    }

}


