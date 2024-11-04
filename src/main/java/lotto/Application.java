package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import lotto.model.Lotto;
import lotto.model.Rank;

import static lotto.view.InputView.inputAmount;
import static lotto.view.InputView.makeWinningLotto;
import static lotto.view.InputView.makeBonusNum;
import static lotto.view.OutputView.outputLottoNumbers;
import static lotto.view.OutputView.printLottoOutput;
import static lotto.controller.LogicControl.checkWinning;
import static lotto.controller.LogicControl.makeLotto;

public class Application {

    public static List<Lotto> lottos = new ArrayList<>();
    public static Lotto winningLotto;
    public static int bonusNumber;
    public static Map<Rank, Integer> rankCounter = new TreeMap<>();

    public static void buyLotto() {
        int lotto_cost = inputAmount();
        makeLotto(lotto_cost);
        outputLottoNumbers();
    }

    public static void inputWinningLotto() {
        makeWinningLotto();
        makeBonusNum();
    }

    public static void main(String[] args) {
        buyLotto();
        inputWinningLotto();
        checkWinning();
        printLottoOutput();
    }
}
