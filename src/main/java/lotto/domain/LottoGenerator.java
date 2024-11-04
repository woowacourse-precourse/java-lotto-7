package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LottoGenerator {
    private static final int LOTTO_STANDARD_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int price;
    private final LottoTicket lottoTicket;

    public LottoGenerator(String price) {
        this.price = Integer.parseInt(price);
        this.lottoTicket = new LottoTicket();
    }


    public LottoTicket generateLottoTicket() {
        int lottoCount = calculateLottoCount();

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = createLotto();
            lottoTicket.addLotto(lotto);
        }
        return lottoTicket;
    }

    private int calculateLottoCount() {
        return price / LOTTO_STANDARD_PRICE;
    }

    private Lotto createLotto() {
        List<Integer> numbers = generateLottoNumbers();
        return new Lotto(sortLottoNumbers(numbers));
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_COUNT);
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        List<Integer> sortableList = new ArrayList<>(numbers);
        Collections.sort(sortableList);
        return sortableList;
    }
}