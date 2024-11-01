package lotto.model.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.model.lotto.generator.LottoGenerator;
import lotto.model.lotto.generator.RandomLottoGenerator;

public class LottoTicket {
    private final List<Lotto> lottos = new ArrayList<>();
    private LottoGenerator lottoGenerator;

    public LottoTicket(int count) {
        this(new RandomLottoGenerator(), count);
    }

    public LottoTicket(LottoGenerator lottoGenerator, int count) {
        this.lottoGenerator = lottoGenerator;
        generateLottos(count);
    }

    public long calculateTotalPrize(Lotto winnerNumbers, int bonusNumber) {
        long totalPrize = 0;
        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(winnerNumbers);
            boolean bonusMatch = lotto.hasBonus(bonusNumber);
            LottoPrizeInfo prizeInfo = LottoPrizeInfo.getPrizeByMatch(matchCount, bonusMatch);
            totalPrize += prizeInfo.getPrizeAmount();
        }
        return totalPrize;
    }

    private void generateLottos(int count) {
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
    }

    private Lotto generateLotto() {
        return new Lotto(lottoGenerator.generateLotto());
    }
}
