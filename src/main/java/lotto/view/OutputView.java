package lotto.view;

import lotto.domain.player.Player;
import lotto.domain.player.PlayerLotto;
import lotto.domain.player.PlayerResult;

import java.util.List;

import static lotto.constant.InputMessage.*;
import static lotto.constant.OutputMessage.*;

public class OutputView {

    public void printPriceInputMessage(){
        System.out.println(PRICE_INPUT_MESSAGE.getMessage());
    }

    public void printWinningNumberInputMessage(){
        System.out.println("\n" + WINNING_NUMBER_INPUT_MESSAGE.getMessage());
    }

    public void printBonusNumberInputMessage(){
        System.out.println("\n" + BONUS_NUMBER_INPUT_MESSAGE.getMessage());
    }

    public void printLottoCountOutputMessage(Player player) {
        System.out.println("\n" + player.getLottoCount() + LOTTO_PURCHASED_OUTPUT_MESSAGE.getMessage());
    }

    public void printLottoNumbers(Player player) {
        List<PlayerLotto> lottos = player.getLottos();
        for (PlayerLotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers().toString());
        }
    }

    public void printResultMessage() {
        System.out.println(LOTTO_RESULT_OUTPUT_MESSAGE.getMessage());
    }

    public void printLottoResult(Player player) {
        PlayerResult playerResult = player.getPlayerResult();
        System.out.printf(FIFTH_PLACE_OUTPUT_MESSAGE.getMessage(), playerResult.getFifthPlace());
        System.out.printf(FOURTH_PLACE_OUTPUT_MESSAGE.getMessage(), playerResult.getFourthPlace());
        System.out.printf(THIRD_PLACE_OUTPUT_MESSAGE.getMessage(), playerResult.getThirdPlace());
        System.out.printf(SECOND_PLACE_OUTPUT_MESSAGE.getMessage(), playerResult.getSecondPlace());
        System.out.printf(FIRST_PLACE_OUTPUT_MESSAGE.getMessage(), playerResult.getFirstPlace());
        System.out.printf(PROFIT_RATE_OUTPUT_MESSAGE.getMessage(), playerResult.getProfitRate());
    }
}
