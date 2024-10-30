package lotto;

import java.util.List;

public interface Observer {
    void update(int count);

    void update(List<Integer> numbers);
}
