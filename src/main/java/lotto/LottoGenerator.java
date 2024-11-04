package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.common.LottoNumber;

public class LottoGenerator {

    public Lotto random() {
        final List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoNumber.START.getNumber(),
                LottoNumber.END.getNumber(),
                LottoNumber.SIZE.getNumber()
        );
        final List<LottoNum> lottoNums = this.mapToLottoNumbers(numbers);
        return new Lotto(lottoNums);
    }

    public LottoContainer generate(final LottoPayment lottoPayment) {
        final List<Lotto> lotteries = new ArrayList<>();
        for (int i = 0; i < lottoPayment.getLottoCount(); i++) {
            lotteries.add(random());
        }
        return new LottoContainer(lotteries);
    }

    private List<LottoNum> mapToLottoNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .map(number -> new LottoNum(number))
                .collect(Collectors.toList());
    }
}
