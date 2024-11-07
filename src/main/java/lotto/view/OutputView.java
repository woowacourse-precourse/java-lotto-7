package lotto.view;

import lotto.message.OutputMessage;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Rank;
import lotto.model.User;

import static lotto.Constants.*;
import static lotto.utils.Utils.*;
import static lotto.message.OutputMessage.*;
public class OutputView {

    public static void printBuyLottos(User user){
        print(NEW_LINE + OUTPUT_BUY_LOTTOS.getFormatBuyLottosMessage(user.getBuyLottoCount()));
        for(Lotto lotto : user.getLottos()){
            print(lotto.getNumbers().toString());
        }
    }

    public static void printLottoResult(LottoResult lottoResult) {
        for(Rank rank : Rank.values()){
            if(rank.getCorrectCount() >= MINIMUM_WINNING_CORRECT_COUNT){
                print(getLottoResultMessage(rank, lottoResult));
            }
        }
    }

    private static String getLottoResultMessage(Rank rank, LottoResult lottoResult){
        int correctCount = rank.getCorrectCount();
        long prize = rank.getPrize();
        int winningCount = lottoResult.getLottoResultMap().get(rank);
        return getLottoStatisticOutputView(rank).
                getFormatWinningStatisticMessage(correctCount, prize, winningCount);
    }

    private static OutputMessage getLottoStatisticOutputView(Rank rank){
        if(isSecondRank(rank)){
            return OUTPUT_WINNING_STATISTIC_BONUS;
        }
        return OUTPUT_WINNING_STATISTIC;
    }

    private static boolean isSecondRank(Rank rank){
        return rank.getCorrectCount() == SECOND_RANK_CORRECT_COUNT
                && rank.getBonusCount() == SECOND_RANK_BONUS_COUNT;
    }

    public static void printReturnRate(double returnRate) {
        print(OUTPUT_RETURN_RATE.getFormatReturnRateMessage(returnRate));
    }
}
