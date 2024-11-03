package lotto.user;

import java.util.List;
import lotto.shop.bandingmachine.DrawnNumbers;

public class UserStorage {

    private List<DrawnNumbers> drawnNumberPacks;

    void save(List<DrawnNumbers> drawnNumberPacks) {
        this.drawnNumberPacks = drawnNumberPacks;
    }

    List<DrawnNumbers> getDrawnNumberPacks() {
        return drawnNumberPacks;
    }
}
