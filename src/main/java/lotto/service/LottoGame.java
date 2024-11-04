package lotto.service;

import lotto.config.LottoConfiguration;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.MatchResult;
import lotto.utils.LottoUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class LottoGame {

    private ArrayList<MatchResult> lottoResults = new ArrayList<>();
    private final LottoConfiguration configuration;
    private final LottoUtils utils;
    public LottoGame(LottoConfiguration lottoConfiguration, LottoUtils lottoUtils) {
        this.configuration = lottoConfiguration;
        this.utils = lottoUtils;
    }

    public Map<MatchResult, Integer> run() {
        createLottoResults(configuration.winningNumbers(), configuration.lottos(), configuration.bonusNumber());
        Map<MatchResult, Integer> matchResultMap = utils.countMatchResults(lottoResults);
        utils.calculateRateOfReturn(lottoResults, configuration.lottoPrice());
        return matchResultMap;
    }

    private void createLottoResults(List<Integer> winning, List<Lotto> lottos, int bonus) {
        for (int i = 0; i < lottos.size(); i++) {
            LottoResult lottoResult = new LottoResult(winning, lottos.get(i), bonus);
            MatchResult matchResult = utils.determineMatchResult(lottoResult);
            lottoResults.add(matchResult);
        }
    }

}
