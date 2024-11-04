package lotto.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoRepository {

    private static final Set<List<Integer>> lottoTickets = new HashSet<>();

    public void insertNumbers(List<Integer> randomNumbers) {
        lottoTickets.add(randomNumbers);
    }

    public Set<List<Integer>> getLottoTickets() {
        return lottoTickets;
    }

}
