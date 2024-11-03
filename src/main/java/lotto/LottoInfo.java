package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoInfo {
    List<Integer> lotteryNumbers;
    public static List<List<Integer>> AllLotteryNumbers = new ArrayList<>();
    Lotto lotto;
    int theNumberOfLotto;

    public LottoInfo() {
        printLottoInfo();
    }

    private void printLottoInfo() {
        showTheNumberOfLotto();
        showLottoNumbers();
    }

    private void showTheNumberOfLotto() {
        setTheNumberOfLotto();
        System.out.println("\n" + theNumberOfLotto + "개를 구매했습니다.");
    }

    private void setTheNumberOfLotto() {
        PayForLotto pay = new PayForLotto();
        int lottoPayout = pay.lottoPayout;
        int LOTTO_PRICE = 1000;

        theNumberOfLotto = (lottoPayout / LOTTO_PRICE);
    }

    private void showLottoNumbers() {
        for (int i = 0; i < theNumberOfLotto; i++) {
            setRandomNumbers();
        }
        System.out.println();
    }

    private void setRandomNumbers() {
        lotteryNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> lottoNumbers = new ArrayList<>(lotteryNumbers);
        Collections.sort(lottoNumbers);
        AllLotteryNumbers.add(lottoNumbers);

        lotto = new Lotto(lottoNumbers);
        System.out.println(lotto.getNumbers());
    }
}
