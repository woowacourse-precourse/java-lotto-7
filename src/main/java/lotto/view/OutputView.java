package lotto.view;

import lotto.dto.LottoDTO;
import lotto.dto.LottoResultDTO;
import lotto.dto.LottoStatisticsDTO;
import java.util.List;

public class OutputView {

    public void printLottoNumbers(List<LottoDTO> lottoDTOs, int budget) {
        int LottoCount = budget / 1000;
        System.out.printf("Message.PURCHASED_NUMBERS.getMessage()", LottoCount);
        for (LottoDTO lottoDTO : lottoDTOs) {
            System.out.println(lottoDTO.getNumbers());
        }
    }

    public void printWinningResults(LottoResultDTO resultDTO) {
        System.out.println(Message.WINNING_STATISTICS.getMessage());
        List<Integer> winningCounts = resultDTO.getWinningCounts();

        System.out.println(Message.MATCH_3.getMessage() + winningCounts.get(4) + Message.PIECES.getMessage());
        System.out.println(Message.MATCH_4.getMessage() + winningCounts.get(3) + Message.PIECES.getMessage());
        System.out.println(Message.MATCH_5.getMessage() + winningCounts.get(2) + Message.PIECES.getMessage());
        System.out.println(Message.MATCH_5_BONUS.getMessage() + winningCounts.get(1) + Message.PIECES.getMessage());
        System.out.println(Message.MATCH_6.getMessage() + winningCounts.get(0) + Message.PIECES.getMessage());
    }

    public void printProfitRate(LottoStatisticsDTO statisticsDTO) {
        System.out.printf(Message.PROFIT_RATE.getMessage(), statisticsDTO.getProfitRate());
    }
}
