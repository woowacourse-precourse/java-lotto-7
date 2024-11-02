package lotto.repository;

import lotto.domain.WinningNumber;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberRepository {

    List<WinningNumber> winningNumbers = new ArrayList<>();

    public void save(WinningNumber winningNumber) {
        winningNumbers.add(winningNumber);
    }

    public void deleteByIndex(int index) {
        winningNumbers.remove(index);
    }

    public void delete(WinningNumber winningNumber) {
        winningNumbers.remove(winningNumber);
    }

    public void deleteAll() {
        winningNumbers.clear();
    }

    public void findByIndex(int index) {
        winningNumbers.get(index);
    }

    public WinningNumber findOne() {
        return winningNumbers.getLast();
    }

}
