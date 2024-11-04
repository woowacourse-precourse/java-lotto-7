package lotto.model.money;

import lotto.model.match.MatchInformation;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum LottoMoney {
    THREE(MatchInformation.THREE_MATCH, 5000),
    FOUR(MatchInformation.FOUR_MATCH, 50000),
    FIVE(MatchInformation.FIVE_MATCH, 1500000),
    FIVE_AND_BONUS(MatchInformation.FIVE_AND_BONUS_MATCH, 30000000),
    SIX(MatchInformation.SIX_MATCH, 2000000000);

    private final MatchInformation matchInformation;
    private final int value;

    LottoMoney(MatchInformation matchInformation, int value) {
        this.matchInformation = matchInformation;
        this.value = value;
    }

    public static LottoMoney from(MatchInformation matchInformation) {
        return Arrays.stream(values())
                .filter(lottoMoney -> lottoMoney.matchInformation == matchInformation)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 LottoMoney Type 입니다."));

    }

    public int getValue() {
        return value;
    }
}
