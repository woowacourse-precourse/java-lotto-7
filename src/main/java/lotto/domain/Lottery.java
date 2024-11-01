package lotto.domain;

import java.util.List;

public interface Lottery {
    void sort();

    List<Integer> getNumbers();
}
