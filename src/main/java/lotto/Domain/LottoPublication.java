package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoPublication {
    private static final int START_NUM = 1;
    private static final int END_NUM = 45;
    private static final int COUNT = 6;
    private static final int PRICE = 1000;
    private final int purchaseLotto;

    public LottoPublication(int purchaseLotto) {
        this.purchaseLotto = purchaseLotto;
    }

    public List<Integer> lottoNumberPublication() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, COUNT);
        return numbers;
    }

    public int theNumberOfLotto() {
        return purchaseLotto / PRICE;
    }

    public List<Integer> getSortedLottoNumbers() {
        List<Integer> numbers = lottoNumberPublication();
        Collections.sort(numbers);
        return numbers;
    }

    public List<List<Integer>> totalLotto() {
        List<List<Integer>> publicationNumbers = new ArrayList<>();
        int count = theNumberOfLotto();

        for (int i = 0; i < count; i++) {
            publicationNumbers.add(getSortedLottoNumbers());
        }

        return publicationNumbers;
    }
}
