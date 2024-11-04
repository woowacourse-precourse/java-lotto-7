package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriceStats {
    private final List<Integer> status;

    public PriceStats() {
        status = new ArrayList<>(5);
        Collections.fill(status, 0);
    }

    public void add(int index) {
        status.set(index, status.get(index) + 1);
    }
}
