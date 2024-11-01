package lotto.view;

import static lotto.constant.category.Rank.*;
import static lotto.constant.message.OutputMessage.*;

import java.util.List;
import lotto.model.RankCounter;

public class OutputView {

    public static void printLottoCount(Integer lottoCount) {
        System.out.println(PURCHASE_NUMBER_OUTPUT_MESSAGE.getMessage(lottoCount));
    }

    public static void printLottoTicketsDetails(List<String> lottoTickets) {
        for (String lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    public static void printWinningStatistics(RankCounter rankCounter) {
        System.out.println(WINNING_STATISTICS_OUTPUT_START_MESSAGE.getMessage());
        System.out.println(FIFTH_PLACE_OUTPUT_MESSAGE.getMessage(
                FIFTH_PLACE.getMatchCount(), FIFTH_PLACE.getPrizeAmount(), rankCounter.getRankCount(FIFTH_PLACE)));
        System.out.println(FOURTH_PLACE_OUTPUT_MESSAGE.getMessage(
                FOURTH_PLACE.getMatchCount(), FOURTH_PLACE.getPrizeAmount(), rankCounter.getRankCount(FOURTH_PLACE)));
        System.out.println(THIRD_PLACE_OUTPUT_MESSAGE.getMessage(
                THIRD_PLACE.getMatchCount(), THIRD_PLACE.getPrizeAmount(), rankCounter.getRankCount(THIRD_PLACE)));
        System.out.println(SECOND_PLACE_OUTPUT_MESSAGE.getMessage(
                SECOND_PLACE.getMatchCount(), SECOND_PLACE.getPrizeAmount(), rankCounter.getRankCount(SECOND_PLACE)));
        System.out.println(FIRST_PLACE_OUTPUT_MESSAGE.getMessage(
                FIRST_PLACE.getMatchCount(), FIRST_PLACE.getPrizeAmount(), rankCounter.getRankCount(FIRST_PLACE)));
    }
}
