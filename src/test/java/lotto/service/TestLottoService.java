package lotto.service;

import java.util.List;

public class TestLottoService extends LottoService {

    @Override
    protected List<Integer> pickRandomNumbers() {
        return List.of(1, 2, 3, 4, 5, 6);
    }
}
