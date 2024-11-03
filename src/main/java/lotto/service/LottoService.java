package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.MatchResult;
import lotto.domain.WinningLotto;
import lotto.domain.money.Money;
import lotto.domain.rank.LottoRank;
import lotto.domain.rank.LottoRanks;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoService(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> purchaseBy(Money money) {
        List<Lotto> lottos = new ArrayList<>();

        while (money.isEnoughToBuy(LOTTO_PRICE)) {
            List<Integer> numbers = lottoNumberGenerator.generate();
            lottos.add(Lotto.of(numbers));
            money = money.deduct(LOTTO_PRICE);
        }
        return lottos;
    }

    public LottoRanks compareLottos(WinningLotto winningLotto, List<Lotto> lottos) {
        LottoRanks lottoRanks = new LottoRanks();

        for (Lotto lotto : lottos) {
            MatchResult matchResult = winningLotto.match(lotto);

            LottoRank.findBy(matchResult.sameNumberCount(), matchResult.bonusMatched())
                    .ifPresent(lottoRanks::add);
        }

        return lottoRanks;
    }

}
