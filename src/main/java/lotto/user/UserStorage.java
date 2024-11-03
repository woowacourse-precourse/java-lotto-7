package lotto.user;

import java.util.List;
import lotto.shop.bandingmachine.DrawnNumbers;

public class UserStorage {

    private static List<DrawnNumbers> drawnNumberPacks;

    public static void save(List<DrawnNumbers> drawnNumberPacks) {
        UserStorage.drawnNumberPacks = drawnNumberPacks;
    }

    public static List<DrawnNumbers> get() {
        return drawnNumberPacks;
    }
}
