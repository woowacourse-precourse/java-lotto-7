package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.utils.LottoNumberGenerator;
import lotto.utils.LottoNumberGeneratorStrategy;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    public Lottos generateLottos(int purchaseAmount, LottoNumberGeneratorStrategy strategy) {
        List<Lotto> lottoBox = new ArrayList<>();
        int count = calculateLottoTicketCount(purchaseAmount);

        while (lottoBox.size() < count) {
            List<Integer> lottoNumbers = LottoNumberGenerator.from(strategy).generate();
            lottoBox.add(Lotto.from(lottoNumbers));
        }
        return Lottos.from(lottoBox);
    }

    private int calculateLottoTicketCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
}
