package lotto.validator;

import java.util.List;
import lotto.entity.Lotto;
import lotto.entity.WinningNumbers;
import lotto.exception.ExceptionUtils;
import lotto.exception.ProfitReportExceptionMessage;

public class ProfitReportVaildator {

    public static void validate(List<Lotto> purchasedLottos, WinningNumbers winningNumbers) {
        if (purchasedLottos == null || purchasedLottos.isEmpty()) {
            throw ExceptionUtils.IllegalArgument(ProfitReportExceptionMessage.NULL_OR_EMPTY_LOTTOS);
        }
        if (winningNumbers == null) {
            throw ExceptionUtils.IllegalArgument(ProfitReportExceptionMessage.NULL_WINNING_NUMBERS);
        }
    }

}
