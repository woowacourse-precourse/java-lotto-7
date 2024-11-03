package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_MINIMUM = 1;
    private static final int LOTTO_NUMBER_SIZE = 6;

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
                    .pickUniqueNumbersInRange(LOTTO_NUMBER_MINIMUM, LOTTO_NUMBER_MAX, LOTTO_NUMBER_SIZE)
                    .stream().sorted().toList());
        }
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }
}
