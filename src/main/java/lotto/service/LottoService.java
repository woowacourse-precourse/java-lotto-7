package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoRank;
import lotto.domain.LottoRanks;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoService(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> purchaseBy(int money) {
        List<Lotto> lottos = new ArrayList<>();

        while (money >= LOTTO_PRICE) {
            List<Integer> numbers = lottoNumberGenerator.generate();
            lottos.add(Lotto.of(numbers));
            money -= LOTTO_PRICE;
        }
        return lottos;
    }

    public Map<LottoRank, Integer> evaluateLottos(Lotto winninglotto, LottoNumber bonusNumber, List<Lotto> lottos) {
        LottoRanks lottoRanks = new LottoRanks();

        for (Lotto lotto : lottos) {
            int matchingNumberCount = getMatchingNumberCount(winninglotto, lotto);
            boolean bonusMatched = isBonusNumberMatched(lotto, bonusNumber);
            LottoRank.findBy(matchingNumberCount, bonusMatched)
                    .ifPresent(lottoRanks::add);
        }
        return lottoRanks.getRanks();
    }

    private int getMatchingNumberCount(Lotto winninglotto, Lotto lotto) {
        return winninglotto.countMatchingNumbers(lotto);
    }

    private boolean isBonusNumberMatched(Lotto lotto, LottoNumber bonusNumber) {
        return lotto.contains(bonusNumber);
    }

}
