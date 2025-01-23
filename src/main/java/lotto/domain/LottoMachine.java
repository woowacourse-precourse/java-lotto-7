package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.util.NumberUtil;

public class LottoMachine {

    private final int tickets;
    private List<List<Integer>> lottoNumbers;

    public LottoMachine(int tickets) {

        this.tickets = tickets;
        generateLottoNumbers();
    }

    private void generateLottoNumbers() {
        this.lottoNumbers = new ArrayList<>();
        for (int i = 0; i < tickets; i++) {
            lottoNumbers.add(Randoms
                    .pickUniqueNumbersInRange(NumberUtil.MINIMUM_RANGE_NUMBER, NumberUtil.MAX_RANGE_NUMBER, NumberUtil.MAX_PICK_NUMBER)
                    .stream()
                    .sorted()
                    .toList());
        }
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }
}
