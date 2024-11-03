package lotto.validator;

import java.util.List;
import lotto.domain.Lotto;
import lotto.enums.LottoCriteria;
import lotto.enums.LottoErrorMessage;
import lotto.exception.LottoInputException;

public class LottosValidator {

    private static boolean isValidLottoCount(int lottoBuyMoney) {
        return lottoBuyMoney % LottoCriteria.BUY_MONEY_UNIT.getCriteriaVal() == 0;
    }

    public static boolean isValidLottosCount(List<Lotto> lottos) {
        if(lottos.size() < LottoCriteria.MIN_LOTTO_COUNT.getCriteriaVal()){
            return false;
        }
        if(lottos.size() > LottoCriteria.MAX_LOTTO_COUNT.getCriteriaVal()){
            return false;
        }
        return true;
    }
}