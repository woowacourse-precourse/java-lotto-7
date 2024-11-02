package lotto.model;

import static lotto.constant.core.LottoServiceConstant.*;

import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.WinningLotto;
import lotto.model.util.RandomUtil;

public class LottoService {

    private final RandomUtil randomUtil;

    public LottoService(RandomUtil randomUtil) {
        this.randomUtil = randomUtil;
    }

    public Integer calculateLottoCount(Integer lottoPurchaseAmount) {
        return lottoPurchaseAmount / LOTTO_PRICE.getIntegerValue();
    }

    public WinningLotto createWinningTicket(List<Integer> numbers, Integer bonusNumber) {
        return WinningLotto.of(numbers, bonusNumber);
    }

    public List<Lotto> createLottoTickets(Integer lottoCount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lottoTicket = createLottoTicket();
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    private Lotto createLottoTicket() {
        List<Integer> numbers = randomUtil.issueLottoTicket(
                MIN_LOTTO_NUMBER.getIntegerValue(),
                MAX_LOTTO_NUMBER.getIntegerValue(),
                LOTTO_NUMBER_COUNT.getIntegerValue());
        return Lotto.of(numbers);
    }
}
