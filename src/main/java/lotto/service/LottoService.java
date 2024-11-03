package lotto.service;

import java.util.List;

public class LottoService {
    public int countMatches(List<Integer> winnerNumbers, List<Integer> numbers) {
        winnerNumbers.retainAll(numbers);
        return winnerNumbers.size();
    }

    private LottoService() {

    }

    public LottoService createLottoService() {
        return new LottoService();
    }
}
