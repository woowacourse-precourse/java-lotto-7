package lotto.domain;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.dto.LottoWinResult;
import lotto.enums.LottoCalEnum;
import lotto.enums.LottoCriteria;

public class LottoFormatter {

    private static final String PRINT_NUMBERS_PREFIX = "[";
    private static final String PRINT_NUMBERS_POSTFIX = "]" + System.lineSeparator();
    private final static String LOTTOS_NUM_BUY_MESSAGE = System.lineSeparator() + "%d개를 구매했습니다." + System.lineSeparator();
    private final static String WIN_LOTTO_RESULT_START_MSG = System.lineSeparator() + "당첨 통계" + System.lineSeparator() + "---" + System.lineSeparator();
    private final static String WIN_LOTTO_WIN_COUNT = "%d개 일치 (%s원) - %d개" + System.lineSeparator();
    private final static String BONUS_CASE_LOTTO_WIN = "%d개 일치, 보너스 볼 일치 (%s원) - %d개" + System.lineSeparator();
    private final static String WIN_MONEY_RATE_FORMAT = "총 수익률은 %.1f%%입니다." + System.lineSeparator();

    public static String getLottoResultStr(double lottoWinMoneyRate, Map<Integer, List<LottoWinResult>> winLottoResultMap) {
        StringBuilder lottoResultStringBuilder = new StringBuilder(WIN_LOTTO_RESULT_START_MSG);
        for(LottoCalEnum lottoCalEnum : LottoCalEnum.values()){
            lottoResultStringBuilder.append(formattingLottoWinResult(lottoCalEnum,winLottoResultMap));
        }
        String formattedWinRate = String.format(WIN_MONEY_RATE_FORMAT,lottoWinMoneyRate);
        lottoResultStringBuilder.append(formattedWinRate);
        return lottoResultStringBuilder.toString();
    }

    private static String formattingLottoWinResult(LottoCalEnum lottoCalEnum, Map<Integer, List<LottoWinResult>> winLottoResultMap) {
        int winCount = lottoCalEnum.getWinCount();
        int winMoney = lottoCalEnum.getWinMoney();
        int winLottoCount = winLottoResultMap.getOrDefault(winCount,new ArrayList<>()).size();
        int bonusCaseNum = LottoCriteria.BONUS_CASE_SPECIAL_LOTTO_NUM.getCriteriaVal();
        String localeWinMoney = getLocaleNumber(winMoney);
        if(winCount == bonusCaseNum){
            return String.format(BONUS_CASE_LOTTO_WIN,LottoCriteria.BONUS_LOTTO_NUM.getCriteriaVal()
                    ,localeWinMoney,winLottoCount);
        }
        return String.format(WIN_LOTTO_WIN_COUNT,winCount,localeWinMoney,winLottoCount);
    }

    private static String getLocaleNumber(int number){
        return NumberFormat.getNumberInstance(Locale.KOREA).format(number);
    }

    public static String getFormattedLottos(Lottos lottos) {
        return lottos.getLottosNumbersStr();
    }

    public static String getFormattedLottosSize(int buyMoney) {
        int lottosSize = buyMoney / LottoCriteria.BUY_MONEY_UNIT.getCriteriaVal();
        return String.format(LOTTOS_NUM_BUY_MESSAGE,lottosSize);
    }

    public static String lottoNumbersToStr(List<Integer> numbers) {
        String numbersStr=  numbers.stream()
                .map((number) -> number + "")
                .collect(Collectors.joining(", "));
        return PRINT_NUMBERS_PREFIX + numbersStr + PRINT_NUMBERS_POSTFIX;
    }
}