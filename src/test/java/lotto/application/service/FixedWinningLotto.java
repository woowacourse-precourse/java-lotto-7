package lotto.application.service;

import lotto.domain.lotto.WinningLotto;

import java.util.ArrayList;
import java.util.List;

class FixedWinningLotto implements WinningLotto {
    private final List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

    @Override
    public List<Integer> basicNumbers() {
        return numbers;
    }

    @Override
    public int bonusNumber() {
        return 7;
    }
}

