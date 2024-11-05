package lotto.io;

import java.util.List;
import lotto.constants.OutputMessages;
import lotto.constants.StringConstants;
import lotto.domain.Lotto;
import lotto.dto.UserLotto;

public class UserLottoParser {

    public String parseUserLotto(UserLotto userLotto) {
        StringBuilder sb = new StringBuilder();

        appendLottoCount(sb, userLotto.getLottoCount());
        appendLottoNumbers(sb, userLotto.getLottos());

        return sb.toString();
    }

    private void appendLottoCount(StringBuilder sb, int lottoCount) {
        sb.append(StringConstants.NEW_LINE)
                .append(lottoCount)
                .append(OutputMessages.COUNT_UNIT)
                .append(OutputMessages.PURCHASED_MESSAGE)
                .append(StringConstants.ENDING_DOT)
                .append(StringConstants.NEW_LINE);
    }

    private void appendLottoNumbers(StringBuilder sb, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            sb.append(lotto.getNumbers()).append(StringConstants.NEW_LINE);
        }
        sb.append(StringConstants.NEW_LINE);
    }
}
