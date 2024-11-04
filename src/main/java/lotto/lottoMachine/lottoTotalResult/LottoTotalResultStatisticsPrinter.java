package lotto.lottoMachine.lottoTotalResult;

import java.util.Map;
import lotto.lottoMachine.utils.LottoResultStructure;

public class LottoTotalResultStatisticsPrinter {
    private static final String HEADER = System.lineSeparator() + "당첨 통계";
    private static final String DIVIDER = "---";
    private static final String MATCH_THREE = "3개 일치 (5,000원) - ";
    private static final String MATCH_FOUR = "4개 일치 (50,000원) - ";
    private static final String MATCH_FIVE = "5개 일치 (1,500,000원) - ";
    private static final String MATCH_FIVE_WITH_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String MATCH_SIX = "6개 일치 (2,000,000,000원) - ";
    private static final String MATCH_SUFFIX = "개";

    public void print(Map<LottoResultStructure, Integer> results) {
        System.out.println(HEADER);
        System.out.println(DIVIDER);
        System.out.println(MATCH_THREE + results.get(LottoResultStructure.FIFTH) + MATCH_SUFFIX);
        System.out.println(MATCH_FOUR + results.get(LottoResultStructure.FOURTH) + MATCH_SUFFIX);
        System.out.println(MATCH_FIVE + results.get(LottoResultStructure.THIRD) + MATCH_SUFFIX);
        System.out.println(MATCH_FIVE_WITH_BONUS + results.get(LottoResultStructure.SECOND) + MATCH_SUFFIX);
        System.out.println(MATCH_SIX + results.get(LottoResultStructure.FIRST) + MATCH_SUFFIX);
    }
}
