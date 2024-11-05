package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.common.LottoNumbers;

public class LottoGenerator {
    public Lotto random() {
        final List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoNumbers.START.get(),
                LottoNumbers.END.get(),
                LottoNumbers.SIZE.get()
        );
        final List<LottoNumber> lottoNums = this.mapToLottoNumbers(numbers);
        return new Lotto(lottoNums);
    }

    public LottoContainer generate(final LottoPayment lottoPayment) {
        final List<Lotto> lotteries = new ArrayList<>();
        for (int i = 0; i < lottoPayment.getLottoCount(); i++) {
            lotteries.add(random());
        }
        return new LottoContainer(lotteries);
    }

    private List<LottoNumber> mapToLottoNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toList());
    }
}
