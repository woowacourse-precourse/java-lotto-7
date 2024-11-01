package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_START_NUM = 1;
    private static final int LOTTO_END_NUM = 45;

    private List<Integer> lottoNums;

    public void initMachine() {
        lottoNums = new ArrayList<>();
        for (int i = LOTTO_START_NUM; i <= LOTTO_END_NUM; i++) {
            lottoNums.add(i);
        }
    }
}
