package lotto.view.convertor;

import lotto.common.MatchSign;
import lotto.dto.MatchDto;
import lotto.dto.MatchResponse;
import lotto.dto.UserLotto;
import lotto.model.match.MatchInformation;

import static lotto.common.Instruction.BUY_LOTTO;

public class LottoConvertor implements Convertor {

    public static final String TOTAL_RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";
    public static final String COUNTING_UNIT = "개";

    public String getMatchResult(MatchResponse matchResponse) {
        StringBuilder stringBuilder = new StringBuilder();

        for (MatchDto matchDto : matchResponse.matchDtos()) {
            MatchInformation matchInformation = matchDto.matchInformation();
            int count = matchDto.count();

            MatchSign matchSign = MatchSign.of(matchInformation);

            stringBuilder.append(matchSign.getMessage())
                    .append(count).append(COUNTING_UNIT).append("\n");
        }
        appendRateOfReturn(matchResponse, stringBuilder);
        return stringBuilder.toString();
    }

    private void appendRateOfReturn(MatchResponse matchResponse, StringBuilder stringBuilder) {
        stringBuilder.append(String.format(TOTAL_RATE_OF_RETURN, matchResponse.rateOfReturn()));
    }

    public String getUserLottos(UserLotto userLotto) {
        return userLotto.lottos().toString();
    }

    public String getPurchaseSign(UserLotto userLotto) {
        return userLotto.money().getCount() + BUY_LOTTO.getMessage();
    }
}
