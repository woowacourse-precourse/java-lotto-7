package lotto.View;

import static lotto.Util.Constant.IOMessage.OUTPUT_LOTTO_COUNT;
import static lotto.Util.Constant.IOMessage.OUTPUT_PRIZE_STATISTICS;
import static lotto.Util.Constant.IOMessage.OUTPUT_PRIZE_STATISTICS_MATCHED_3;
import static lotto.Util.Constant.IOMessage.OUTPUT_PRIZE_STATISTICS_MATCHED_4;
import static lotto.Util.Constant.IOMessage.OUTPUT_PRIZE_STATISTICS_MATCHED_5;
import static lotto.Util.Constant.IOMessage.OUTPUT_PRIZE_STATISTICS_MATCHED_5_WITH_BONUS;
import static lotto.Util.Constant.IOMessage.OUTPUT_PRIZE_STATISTICS_MATCHED_6;
import static lotto.Util.Constant.IOMessage.OUTPUT_TOTAL_PROFIT;

import java.util.List;
import lotto.DTO.LottoStatisticsDTO;
import lotto.DTO.RandomLottoNumberDTO;
import lotto.Domain.Lotto;
import lotto.Domain.LottoTickets;

public class OutputView {
    private LottoTickets lottoTickets;
    private List<Lotto> lottos;
    private Integer lottoPurchaseCount;

    public void outputRandomLottoNumber(RandomLottoNumberDTO randomLottoNumberDTO) {
        this.lottoTickets = randomLottoNumberDTO.getLottoTickets();
        this.lottos = lottoTickets.getTickets();
        this.lottoPurchaseCount = lottoTickets.getTicketCount();

        System.out.println(OUTPUT_LOTTO_COUNT.format(lottoPurchaseCount));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }


    public void outputLottoStatistics(LottoStatisticsDTO lottoStatisticsDTO) {
        System.out.println(OUTPUT_PRIZE_STATISTICS.getMessage());
        System.out.println(OUTPUT_PRIZE_STATISTICS_MATCHED_3.format(lottoStatisticsDTO.getMatched3Count()));
        System.out.println(OUTPUT_PRIZE_STATISTICS_MATCHED_4.format(lottoStatisticsDTO.getMatched4Count()));
        System.out.println(OUTPUT_PRIZE_STATISTICS_MATCHED_5.format(lottoStatisticsDTO.getMatched5Count()));
        System.out.println(
                OUTPUT_PRIZE_STATISTICS_MATCHED_5_WITH_BONUS.format(lottoStatisticsDTO.getMatched5WithBonusCount()));
        System.out.println(OUTPUT_PRIZE_STATISTICS_MATCHED_6.format(lottoStatisticsDTO.getMatched6Count()));
        System.out.println(OUTPUT_TOTAL_PROFIT.format(lottoStatisticsDTO.getProfitRate()));
    }


}
