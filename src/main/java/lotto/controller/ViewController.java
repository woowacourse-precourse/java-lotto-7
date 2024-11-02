package lotto.controller;

import java.util.List;

public interface ViewController {
    void validateMoney(int money);
    void validateNumberSize(List<Integer> winningNumbers);
}
