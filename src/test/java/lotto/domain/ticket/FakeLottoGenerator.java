package lotto.domain.ticket;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCreator;
import lotto.domain.lotto.LottoGenerator;

public class FakeLottoGenerator implements LottoGenerator {

    private final LottoCreator lottoCreator;

    public FakeLottoGenerator(LottoCreator lottoCreator) {
        this.lottoCreator = lottoCreator;
    }

    @Override
    public Lotto generateLotto() {
        List<Integer> uniqueNumbers = makeUniqueNumber();
        return lottoCreator.createLotto(uniqueNumbers);
    }

    private List<Integer> makeUniqueNumber() {
        return List.of(1, 2, 3, 4, 5, 6);
    }


}
