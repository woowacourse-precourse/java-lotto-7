package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.InputUtils.readInteger;
import static lotto.InputUtils.readIntegerList;

public class Application {
    public static void main(String[] args) {
        LotteryRoundManager lotteryManager = new LotteryRoundManager();

        PurchasedLotto purchasedLotto = InputUtils.inputCost(lotteryManager);
        OutputUtils.printPurchasedLotto(purchasedLotto);
        InputUtils.inputWinningNumber(lotteryManager);
        OutputUtils.printLottoResult(lotteryManager, purchasedLotto);
    }

}
