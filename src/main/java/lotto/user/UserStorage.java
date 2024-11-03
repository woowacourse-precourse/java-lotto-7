package lotto.user;

import java.util.List;
import lotto.MessageCenter;
import lotto.shop.bandingmachine.DrawnNumbers;

public class UserStorage {

    private static List<DrawnNumbers> drawnNumberPacks;

    public static void save(List<DrawnNumbers> drawnNumberPacks) {
        validateDrawnPacks(drawnNumberPacks);
        UserStorage.drawnNumberPacks = drawnNumberPacks;
    }

    public static List<DrawnNumbers> get() {
        return drawnNumberPacks;
    }

    private static void validateDrawnPacks(List<DrawnNumbers> drawnNumberPacks) {
        if (drawnNumberPacks == null || drawnNumberPacks.isEmpty()) {
            throw new IllegalArgumentException(MessageCenter.ERROR_USERSTORAGE.get());
        }
    }
}
