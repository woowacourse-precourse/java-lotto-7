package lotto.service;

import java.util.List;

public interface ViewService {
    void validateMoney(int money);
    void validateNumberSize(List<Integer> winningNumbers);
}
