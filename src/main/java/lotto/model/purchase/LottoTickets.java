package lotto.model.purchase;

import static lotto.enums.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.enums.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.enums.LottoConstant.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<Lotto> lottoTickets = new ArrayList<Lotto>();

    public LottoTickets(final int lottoCount) {
        purchaseLottoTickets(lottoCount);
    }

    private void purchaseLottoTickets(final int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.getNumber(),
                            MAX_LOTTO_NUMBER.getNumber(), LOTTO_NUMBER_COUNT.getNumber())
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());
            lottoTickets.add(new Lotto(lottoNumbers));
        }
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
