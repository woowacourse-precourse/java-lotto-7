package view;

import common.OutputMessage;
import java.util.List;
import java.util.Map;
import model.Lotto;

public class OutputView {

    public void showPrompt(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        System.out.println(lottos.size() + OutputMessage.BUY_LOTTO_COUNT.getMessage());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void showWinResult(Map<Integer, Integer> lottoMatchs, double yield) {
        System.out.println(OutputMessage.MATCH_START_MESSAGE.getMessage());
        System.out.println(OutputMessage.THREE_MATCH.getMessage() + lottoMatchs.get(3) + OutputMessage.COUNT.getMessage());
        System.out.println(OutputMessage.FOUR_MATCH.getMessage() + lottoMatchs.get(4) + OutputMessage.COUNT.getMessage());
        System.out.println(OutputMessage.FIVE_MATCH.getMessage() + lottoMatchs.get(5) + OutputMessage.COUNT.getMessage());
        System.out.println(OutputMessage.FIVE_AND_BONUS_MATCH.getMessage() + lottoMatchs.get(-5) + OutputMessage.COUNT.getMessage());
        System.out.println(OutputMessage.SIX_MATCH.getMessage() + lottoMatchs.get(6) + OutputMessage.COUNT.getMessage());
        System.out.println(OutputMessage.MATCH_LAST_MESSAGE_LEFT.getMessage() + yield + OutputMessage.MATCH_LAST_MESSAGE_RIGHT.getMessage());
    }
}
