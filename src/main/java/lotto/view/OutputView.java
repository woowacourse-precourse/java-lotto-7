package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.dto.LottoDto;
import lotto.dto.StatisticDto;

public class OutputView implements ViewManager{

    private static final String NUMBER_OF_PURCHASED_LOTTO_MESSAGE = "%s개를 구매했습니다.";
    private static final String STATISTIC_RESULT_MESSAGE = "당첨 통계";
    private static final String DIVIDING_LINE = "---";
    private static final String YIELD_RATE_MESSAGE = "총 수익률은 %,.1f%%입니다.";
    private static final String FIFTH_RANK_MESSAGE = "3개 일치 (5,000원) - %s개";
    private static final String FOURTH_RANK_MESSAGE = "4개 일치 (50,000원) - %s개";
    private static final String THIRD_RANK_MESSAGE = "5개 일치 (1,500,000원) - %s개";
    private static final String SECOND_RANK_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %s개";
    private static final String FIRST_RANK_MESSAGE = "6개 일치 (2,000,000,000원) - %s개";

    protected void printTicketCountResult(final Integer ticketCount) {
        lineBreak();
        printMessage(String.format(NUMBER_OF_PURCHASED_LOTTO_MESSAGE, ticketCount));
    }

    protected void printYeildRate(final Double yieldRate) {
        printMessage(String.format(YIELD_RATE_MESSAGE, yieldRate));
    }

    protected void printLotteriesNumber(final List<LottoDto> lotteriesDto) {
        lotteriesDto.forEach(lottoDto -> {
                    printMessage(lottoDto.getLottoNumber().toString());
                });
        lineBreak();
    }

    protected void printStatistic(final StatisticDto statisticDto) {
        printStatisticResultHeader();
        printMessage(String.format(FIFTH_RANK_MESSAGE, statisticDto.getFifthRankCount()));
        printMessage(String.format(FOURTH_RANK_MESSAGE, statisticDto.getFourthRankCount()));
        printMessage(String.format(THIRD_RANK_MESSAGE, statisticDto.getThirdRankCount()));
        printMessage(String.format(SECOND_RANK_MESSAGE, statisticDto.getSecondRankCount()));
        printMessage(String.format(FIRST_RANK_MESSAGE, statisticDto.getFirstRankCount()));
    }

    private void printStatisticResultHeader() {
        lineBreak();
        printMessage(STATISTIC_RESULT_MESSAGE);
        printMessage(DIVIDING_LINE);
        Console.close();
    }
}
