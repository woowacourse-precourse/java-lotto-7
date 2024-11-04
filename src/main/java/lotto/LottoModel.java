package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoModel {
    private static final int LOTTO_PRICE = 1000;
    private int totalPrice;
    private int lottoAmount;

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
        this.lottoAmount = totalPrice / LOTTO_PRICE;
    }

    public int getLottoAmount() {
        return lottoAmount;
    }

    public List<List<Integer>> generateLottoNumbers() {
        // lottoAmount가 설정되지 않은 경우, totalPrice로부터 자동으로 계산
        if (lottoAmount == 0 && totalPrice > 0) {
            lottoAmount = totalPrice / LOTTO_PRICE;
        }

        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> number = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(number);
            lottoNumbers.add(number);
        }
        return lottoNumbers;
    }

    public double calculateProfit(int[] prizeCounts) {
        double totalPrize = calculateTotalPrize(prizeCounts);
        return (totalPrize / totalPrice) * 100;
    }

    private double calculateTotalPrize(int[] prizeCounts) {
        return 2000000000 * prizeCounts[0] +
                30000000 * prizeCounts[1] +
                1500000 * prizeCounts[2] +
                50000 * prizeCounts[3] +
                5000 * prizeCounts[4];
    }
}
