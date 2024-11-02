package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import lotto.common.LottoNumber;
import java.util.List;

public class LottoGenerator {

    public Lotto random() {
        final List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoNumber.START.getNumber(),
                LottoNumber.END.getNumber(),
                LottoNumber.SIZE.getNumber()
        );
        return new Lotto(numbers);
    }

    public LottoContainer generate(final LottoPayment lottoPayment) {
        final List<Lotto> lotteries = new ArrayList<>();
        for (int i = 0; i < lottoPayment.getLottoCount(); i++) {
            lotteries.add(random());
        }
        return new LottoContainer(lotteries);
    }
}
