package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoTicket {
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int MAIN_NUMBER_COUNT = 6;

    private final List<Integer> lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = createLottoNumbers();
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, MAIN_NUMBER_COUNT);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}