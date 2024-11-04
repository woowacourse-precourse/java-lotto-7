package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, 6);
    }

    public static List<List<Integer>> generateLottoTickets(int purchaseAmount) {
        int count = calculateLottoCount(purchaseAmount);
        List<List<Integer>> lottoTickets = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoTickets.add(generateLottoNumbers());
        }

        return lottoTickets;
    }
}
