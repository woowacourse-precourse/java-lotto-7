package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

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
            lottoNumbers.add(Randoms.pickUniqueNumbersInRange(1, 45, 6)
                    .stream().sorted().toList());
        }
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }
}
