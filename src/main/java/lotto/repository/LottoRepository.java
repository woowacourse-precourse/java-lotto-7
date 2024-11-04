package lotto.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoRepository {

    private static final Set<List<Integer>> tickets = new HashSet<>();

    public void insertNumbers(List<Integer> randomNumbers) {
        tickets.add(randomNumbers);
    }

}
