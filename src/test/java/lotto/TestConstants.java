package lotto;

import java.util.ArrayList;
import java.util.List;

public class TestConstants {
    public static String INVALID_NUMBER = "hello";
    public static String INVALID_PURCHASE_AMOUNT_RANGE = "2147483648";
    public static String INVALID_LOTTO_PRICE_UNIT = "3001";
    public static String VALID_PURCHASE_AMOUNT = "10000";

    public static Integer TICKET_COUNT = 10;

    public static List<Integer> LOTTO_NUMBERS = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
    public static final List<Integer> SORTED_LOTTO_NUMBERS = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
}
