package lotto.view;

import java.util.List;
import lotto.dto.LotteriesResponse;
import lotto.dto.WinningResultResponse;
import lotto.enums.PrintMessage;

public class OutputView {
    public void printLottoList(LotteriesResponse response) {
        System.out.println();
        System.out.println(PrintMessage.OUTPUT_LOTTO_LIST.format(response.lotteriesCount()));
        for (List<Integer> lotto : response.lotteries()) {
            System.out.println(lotto);
        }
    }

    public void printLottoWinningResult(WinningResultResponse response) {
        System.out.println();
        System.out.println(PrintMessage.OUTPUT_TOTAL_RESULT.getMessage());
        System.out.println(PrintMessage.OUTPUT_FIFTH_PLACE_RESULT.format(response.fifthWinningCount()));
        System.out.println(PrintMessage.OUTPUT_FOURTH_PLACE_RESULT.format(response.fourthWinningCount()));
        System.out.println(PrintMessage.OUTPUT_THIRD_PLACE_RESULT.format(response.thirdWinningCount()));
        System.out.println(PrintMessage.OUTPUT_SECOND_PLACE_RESULT.format(response.secondWinningCount()));
        System.out.println(PrintMessage.OUTPUT_FIRST_PLACE_RESULT.format(response.firstWinningCount()));

        System.out.println(PrintMessage.OUTPUT_TOTAL_PROFIT_RATE.format(response.profitRate()));
    }
}
