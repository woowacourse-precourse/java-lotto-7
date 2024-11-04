package view;

import static common.OutputMessage.BUY_LOTTO_COUNT;
import static common.OutputMessage.COUNT;
import static common.OutputMessage.FIVE_AND_BONUS_MATCH;
import static common.OutputMessage.FIVE_MATCH;
import static common.OutputMessage.FOUR_MATCH;
import static common.OutputMessage.MATCH_LAST_MESSAGE_LEFT;
import static common.OutputMessage.MATCH_LAST_MESSAGE_RIGHT;
import static common.OutputMessage.MATCH_START_MESSAGE;
import static common.OutputMessage.SIX_MATCH;
import static common.OutputMessage.THREE_MATCH;

import common.InputMessage;
import java.util.List;
import java.util.Map;
import model.Lotto;

public class OutputView {

    public void showPrompt(InputMessage message) {
        System.out.println(message);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printLottoNumbers(List<Lotto> lottoList) {
        System.out.println(String.valueOf(lottoList.size()) + BUY_LOTTO_COUNT);
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void showWinResult(Map<Integer, Integer> lottoMatches, double yield) {
        String printResult = MATCH_START_MESSAGE + "\n"
                + THREE_MATCH + lottoMatches.get(3) + COUNT + "\n"
                + FOUR_MATCH + lottoMatches.get(4) + COUNT + "\n"
                + FIVE_MATCH + lottoMatches.get(5) + COUNT + "\n"
                + FIVE_AND_BONUS_MATCH + lottoMatches.get(-5) + COUNT + "\n"
                + SIX_MATCH + lottoMatches.get(6) + COUNT + "\n"
                + MATCH_LAST_MESSAGE_LEFT + yield + MATCH_LAST_MESSAGE_RIGHT;
        System.out.println(printResult);
    }
}
