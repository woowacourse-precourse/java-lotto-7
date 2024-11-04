package lotto.user;

import java.util.List;
import lotto.MessageCenter;
import lotto.shop.bandingmachine.DrawnNumbers;

public class UserStorage {

    private static List<DrawnNumbers> drawnNumberPacks;
    private static Integer totalPaid;

    public static void saveNumbers(List<DrawnNumbers> drawnNumberPacks) {
        validateDrawnPacks(drawnNumberPacks);
        UserStorage.drawnNumberPacks = drawnNumberPacks;
    }

    public static List<DrawnNumbers> getNumbers() {
        validateDrawnPacks(drawnNumberPacks);
        return drawnNumberPacks;
    }

    public static void savePayment(Integer payment) {
        UserStorage.totalPaid = payment;
    }

    public static Integer getTotalPaid() {
        return totalPaid;
    }

    public static List<DrawnNumbers> clean() {
        return UserStorage.drawnNumberPacks = null;
    }

    private static void validateDrawnPacks(List<DrawnNumbers> drawnNumberPacks) {
        if (drawnNumberPacks == null || drawnNumberPacks.isEmpty()) {
            throw new IllegalArgumentException(MessageCenter.ERROR_USERSTORAGE.get());
        }
    }
}
