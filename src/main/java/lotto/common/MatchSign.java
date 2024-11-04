package lotto.common;

import lotto.model.match.MatchInformation;
import lotto.model.money.LottoMoney;
import lotto.util.Parser;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum MatchSign {
    THREE_MATCH_SIGN(MatchInformation.THREE_MATCH,
            "3개 일치 ("
                    + Parser.formatMoney(LottoMoney.THREE.getValue()) + "원) - "),
    FOUR_MATCH_SIGN(MatchInformation.FOUR_MATCH,
            "4개 일치 ("
                    + Parser.formatMoney(LottoMoney.FOUR.getValue()) + "원) - "),
    FIVE_MATCH_SIGN(MatchInformation.FIVE_MATCH,
            "5개 일치 ("
                    + Parser.formatMoney(LottoMoney.FIVE.getValue()) + "원) - "),
    FIVE_AND_BONUS_MATCH_SIGN(MatchInformation.FIVE_AND_BONUS_MATCH,
            "5개 일치, 보너스 볼 일치 ("
                    + Parser.formatMoney(LottoMoney.FIVE_AND_BONUS.getValue()) + "원) - "),
    SIX_MATCH_SIGN(MatchInformation.SIX_MATCH,
            "6개 일치 ("
                    + Parser.formatMoney(LottoMoney.SIX.getValue()) + "원) - ");

    private final MatchInformation matchInformation;
    private final String message;

    MatchSign(MatchInformation matchInformation, String message) {
        this.matchInformation = matchInformation;
        this.message = message;
    }

    public static MatchSign of(MatchInformation matchInformation) {
        return Arrays.stream(values())
                .filter(matchSign -> matchSign.matchInformation == matchInformation)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 ShowBoard Type 입니다."));
    }

    public String getMessage() {
        return message;
    }
}
