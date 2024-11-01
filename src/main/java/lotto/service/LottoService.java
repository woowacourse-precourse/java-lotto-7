package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoFormatter;
import lotto.domain.Lottos;
import lotto.dto.LottoBuyRequest;
import lotto.dto.LottoCalculateRequest;
import lotto.dto.LottoWinResult;
import lotto.enums.LottoCriteria;
import lotto.domain.LottoRandomNumber;

public class LottoService {

    public Lottos buyLottos(LottoBuyRequest lottoBuyRequest) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i< lottoBuyRequest.buyMoney() / LottoCriteria.BUY_MONEY_UNIT.getCriteriaVal(); i++){
            lottoList.add(buyLotto());
        }
        return new Lottos(lottoList);
    }

    public String calculateLottoResult(Lottos lottos, LottoCalculateRequest lottoCalculateRequest) {
        List<LottoWinResult> lottoWinResultList = lottos.getWinResult(lottoCalculateRequest);
        double lottoWinMoneyRate = LottoCalculator.caluateWinMoneyRate(lottoWinResultList, lottoCalculateRequest.buyMoney());
        Map<Integer, List<LottoWinResult>> winLottoResultMap = LottoCalculator.getWinLottoResultMap(lottoWinResultList);
        return LottoFormatter.getLottoResultStr(lottoWinMoneyRate,winLottoResultMap);
    }

    private Lotto buyLotto(){
        List<Integer> lottoRandomNumbers = LottoRandomNumber.lottoRandomNumber();
        return new Lotto(lottoRandomNumbers);
    }
}