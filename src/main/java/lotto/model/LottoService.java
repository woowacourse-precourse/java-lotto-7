package lotto.model;

import static lotto.constant.core.LottoServiceConstant.*;

import java.util.List;
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
}
