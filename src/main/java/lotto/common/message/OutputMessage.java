package lotto.common.message;

import java.util.LinkedHashMap;
import java.util.Map;


import static lotto.service.LottoResultService.*;


public enum OutputMessage implements Message{
    PURCHASE_RESULT_MESSAGE("개를 구매했습니다."),
    STATISTICS_INFO_MESSAGE("당첨 통계\n---"),
    STATISTICS_5TH_MESSAGE("3개 일치 (5,000원) -"),
    STATISTICS_4TH_MESSAGE("4개 일치 (50,000원) -"),
    STATISTICS_3RD_MESSAGE("5개 일치 (1,500,000원) -"),
    STATISTICS_2ND_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) -"),
    STATISTICS_1ST_MESSAGE("6개 일치 (2,000,000,000원) -"),
    PROFIT_RATE_PREFIX_MESSAGE("총 수익률은"),
    PROFIT_RATE_SUFFIX_MESSAGE("입니다.");

    public static final Map<String, String> RESULT_MESSAGES;
    static {
        RESULT_MESSAGES = new LinkedHashMap<>();
        RESULT_MESSAGES.put(KEY_5TH, STATISTICS_5TH_MESSAGE.getMessage());
        RESULT_MESSAGES.put(KEY_4TH, STATISTICS_4TH_MESSAGE.getMessage());
        RESULT_MESSAGES.put(KEY_3RD, STATISTICS_3RD_MESSAGE.getMessage());
        RESULT_MESSAGES.put(KEY_2ND, STATISTICS_2ND_MESSAGE.getMessage());
        RESULT_MESSAGES.put(KEY_1ST, STATISTICS_1ST_MESSAGE.getMessage());
    }

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
