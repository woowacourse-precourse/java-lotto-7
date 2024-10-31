package lotto.view;

import lotto.domain.player.Player;
import lotto.domain.player.PlayerLotto;

import java.util.List;

import static lotto.constant.InputMessage.*;
import static lotto.constant.OutputMessage.LOTTO_PURCHASED_OUTPUT_MESSAGE;

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
}
