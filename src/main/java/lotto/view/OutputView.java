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
        print(NEW_LINE);
        print(OUTPUT_BUY_LOTTOS.getFormatBuyLottosMessage(user.getBuyLottoCount()));
        for(Lotto lotto : user.getLottos()){
            print(lotto.getNumbers().toString());
        }
    }

    public static void printLottoResult(LottoResult lottoResult) {
        for(Rank rank : Rank.values()){
            if(rank.getCorrectCount() >= MINIMUM_WINNING_CORRECT_COUNT){
                String resultMessage = getLottoStatisticMessage(rank).getFormatWinningStatisticMessage(rank.getCorrectCount(), rank.getPrize(), lottoResult.getLottoResultMap().get(rank));
                print(resultMessage);
            }
        }
    }

    private static OutputMessage getLottoStatisticMessage(Rank rank){
        if(rank.getCorrectCount() == SECOND_RANK_CORRECT_COUNT && rank.getBonusCount() == SECOND_RANK_BONUS_COUNT){
            return OUTPUT_WINNING_STATISTIC_BONUS;
        }
        return OUTPUT_WINNING_STATISTIC;
    }

    public static void printReturnRate(LottoResult lottoResult) {

    }
}
