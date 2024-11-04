package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.model.LottoGenerator;

public class LottoService {

    private static final int DIVIDE_STANDARD = 1000;
    private static final String SPLITTER = ",";

    private final LottoGenerator lottoGenerator;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lottos makeLottos(int money) {
        return lottoGenerator.generateLottos(getLottoCount(money));
    }

    public Lotto makeLottoBySplitting(String winningNumbers) throws NumberFormatException {
        List<Integer> splitByComma = Arrays.stream(winningNumbers.split(SPLITTER))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .toList();

        return new Lotto(splitByComma);
    }

    private int getLottoCount(int money) {
        return money / DIVIDE_STANDARD;
    }
}
