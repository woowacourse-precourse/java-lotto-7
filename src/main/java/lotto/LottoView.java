package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class LottoView {
    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputWinningNumbers() {
        return null;
    }

    public int inputBonusNumber() {
        return 0;
    }

    public void printLotto(List<Lotto> lottos) {

    }

    public void printResult(int[] resultCnt, double profitRate) {

    }
}
