package lotto.controller;

import java.util.List;

public interface ViewController {
    Integer validateMoney(int money);

    void validateNumberSize(List<Integer> winningNumbers);
}
