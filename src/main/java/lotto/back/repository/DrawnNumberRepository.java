package lotto.back.repository;

import lotto.back.domain.DrawnNumbers;

public class DrawnNumberRepository {
    private DrawnNumbers drawnNumbers;

    public void save(DrawnNumbers drawnNumbers) {
        this.drawnNumbers = drawnNumbers;
    }

    public DrawnNumbers find() {
        return this.drawnNumbers;
    }
}
