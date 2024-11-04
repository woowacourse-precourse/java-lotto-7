package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.enums.Rank;
import lotto.enums.ViewMessages;

public class OutputView {

    public void printLottoAmount(int lottoAmount) {
        System.out.println();
        System.out.println(ViewMessages.PRINT_LOTTO_AMOUNT.getMessage(lottoAmount));
    }

    public void printErrorMessage(String error) {
        System.out.println(error);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public void printLottoResults(double rate, List<Integer> lottoResults) {
        System.out.println();
        System.out.println(ViewMessages.PRINT_RESULT_COMMENT.getMessage());
        for (int i = 1; i < lottoResults.size(); i++) {
            Rank rank = Rank.values()[i];
            int matchCount = rank.getMatchCount();
            int prize = rank.getPrize();
            int count = lottoResults.get(rank.getRank());
            String message = ViewMessages.PRINT_LOTTO_NORMAL_RESULT.getMessage(matchCount, prize, count);
            if (rank.getBonusNumberFlag()) {
                message = ViewMessages.PRINT_LOTTO_BONUS_RESULT.getMessage(matchCount, prize, count);
            }
            System.out.println(message);
        }
        System.out.println(ViewMessages.PRINT_RATE_OF_RETURN.getMessage(rate));
    }

    public void printBlank() {
        System.out.println();
    }
}
