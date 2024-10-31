package lotto.repository;

import lotto.domain.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbersRepository {

    private static final WinningNumbersRepository repository = new WinningNumbersRepository();
    private final List<Integer> winningNumbers = new ArrayList<>();

    private WinningNumbersRepository() {

    }

    public static WinningNumbersRepository getInstance() {
        return repository;
    }

    public void save(final WinningNumbers winningNumbers) {
        winningNumbers.getNumbers().forEach(number -> this.winningNumbers.add(number));
    }

    public WinningNumbers find() {
        return new WinningNumbers(winningNumbers);
    }
}
