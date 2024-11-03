package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoInfo {
    List<Integer> lotteryNumbers;
    int theNumberOfLotto;
    String lottoNumbers = "";

    public void printLottoInfo() {
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
        System.out.println(lottoNumbers);
    }

    private void setRandomNumbers() {
        lotteryNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lotteryNumbers);
        lottoNumbers = lottoNumbers + lotteryNumbers.toString() + "\n";
    }
}
