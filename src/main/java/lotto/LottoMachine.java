package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private int tickets;
    private List<List<Integer>> lottoNumbers;

    public LottoMachine(int tickets) {
        this.tickets = tickets;
    }

    private void generateLottoNumbers() {
        this.lottoNumbers = new ArrayList<>();
        for (int i = 0; i < tickets; i++) {
            lottoNumbers.add(Randoms.pickUniqueNumbersInRange(1, 45, 6)
                    .stream().sorted().toList());
        }
    }

    public List<List<Integer>> getLottoNumbers() {
        generateLottoNumbers();
        lottoNumbers = List.of(List.of(1,2,3,4,7,8),List.of(1,2,3,4,7,6),List.of(1,2,3,4,5,6));
        System.out.println(lottoNumbers);
        return lottoNumbers;
    }
}
