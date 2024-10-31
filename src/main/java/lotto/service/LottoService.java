package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoFormatter;
import lotto.domain.Lottos;
import lotto.dto.LottoRequest;
import lotto.dto.LottoWinResult;
import lotto.enums.LottoCriteria;
import lotto.domain.LottoRandomNumber;

public class LottoService {

    public Lottos buyLottos(LottoRequest lottoRequest) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i< lottoRequest.buyMoney() / LottoCriteria.BUY_MONEY_UNIT.getCriteriaVal(); i++){
            lottoList.add(buyLotto());
        }
        return new Lottos(lottoList);
    }

    public String calLottoResult(Lottos lottos, LottoRequest lottoRequest) {
        List<LottoWinResult> lottoWinResultList = lottos.getWinResult(lottoRequest.winningNumbers(), lottoRequest.bonusNumber());
        double lottoWinMoneyRate = LottoCalculator.getStatisticResult(lottoWinResultList,lottoRequest.buyMoney());
        Map<Integer, List<LottoWinResult>> winLottoResultMap = LottoCalculator.getWinLottoResultMap(lottoWinResultList);
        return LottoFormatter.getLottoResultStr(lottoWinMoneyRate,winLottoResultMap);
    }

    private Lotto buyLotto(){
        List<Integer> lottoRandomNumbers = LottoRandomNumber.lottoRandomNumber();
        Lotto lotto = new Lotto(lottoRandomNumbers);
        return lotto;
    }
}