package lotto.model;

import static lotto.constant.core.LottoServiceConstant.*;

import lotto.model.util.RandomUtil;

public class LottoService {

    private final RandomUtil randomUtil;

    public LottoService(RandomUtil randomUtil) {
        this.randomUtil = randomUtil;
    }

    public Integer calculateLottoCount(Integer lottoPurchaseAmount) {
        return lottoPurchaseAmount / LOTTO_PRICE.getIntegerValue();
    }
}
