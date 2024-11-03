package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoService {
    private final LottoGenerator lottoGenerator;
    private final LottoResultChecker lottoResultChecker;

    private static final int LOTTO_PRICE = 1000;

    public LottoService(LottoGenerator lottoGenerator, LottoResultChecker lottoResultChecker) {
        this.lottoGenerator = lottoGenerator;
        this.lottoResultChecker = lottoResultChecker;
    }

    public List<Lotto> purchaseLottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        while (lottoCount-- > 0) {
            Lotto lotto = lottoGenerator.generateByRandom();
            lottos.add(lotto);
        }
        return lottos;
    }

    public Lotto generateWinningLotto(List<Integer> winningNums) {
        return lottoGenerator.generateByNums(winningNums);
    }
}
