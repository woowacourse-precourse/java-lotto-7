package lotto.view;

import java.util.ArrayList;
import java.util.List;

public class View {

    // inputView Prompt
    protected final String AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    protected final String WINNING_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";
    protected final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    // OutputView Prompt
    protected final String PURCHASE_PROMPT = "개를 구매했습니다.";
    protected final String STATISTICS_PROMPT = "당첨 통계";
    protected final String THREE_DASH_PROMPT = "---";
    protected final String MATCH_THREE_PROMPT = "3개 일치 (5,000원) - ";
    protected final String MATCH_FOUR_PROMPT = "4개 일치 (50,000원) - ";
    protected final String MATCH_FIVE_PROMPT = "5개 일치 (1,500,000원) - ";
    protected final String MATCH_FIVE_AND_BONUS_PROMPT = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    protected final String MATCH_SIX_PROMPT = "6개 일치 (2,000,000,000원) - ";
    protected final String COUNT_PROMPT = "개";
    protected final String PROFIT_PROMPT = "총 수익률은 %.1f%%입니다.";
    protected final List<String> MATCH_PROMPTS = new ArrayList<>(
            List.of(MATCH_SIX_PROMPT,
                    MATCH_FIVE_AND_BONUS_PROMPT,
                    MATCH_FIVE_PROMPT,
                    MATCH_FOUR_PROMPT,
                    MATCH_THREE_PROMPT)
    );

    void br() {
        System.out.println();
    }
}
