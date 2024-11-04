package lotto;

import java.util.ArrayList;
import java.util.List;

public class TestConstants {
    public static String INVALID_NUMBER = "hello";
    public static String INVALID_PURCHASE_AMOUNT_RANGE = "2147483648";
    public static String INVALID_LOTTO_PRICE_UNIT = "3001";
    public static String VALID_PURCHASE_AMOUNT = "10000";

    public static String INVALID_WINNING_NUMBERS = "k,dfjk,3,e";
    public static String UNDER_WINNING_NUMBERS_RANGE = "-1,2,-3,4,-5,6";
    public static String UP_WINNING_NUMBERS_RANGE = "41,42,43,44,45,46";
    public static String UNDER_WINNING_NUMBERS_SIZE = "1,2,3,4,5";
    public static String UP_WINNING_NUMBERS_SIZE = "1,2,3,4,5,6,7";
    public static String DUPLICATED_WINNING_NUMBERS = "1,2,1,2,1,2";
    public static String VALID_WINNING_NUMBERS = "1,2,3,4,5,6";
    public static String BONUS_NUMBER_NOT_NUMERIC = "invalid";
    public static String UNDER_BONUS_NUMBER = "0";
    public static String UP_BONUS_NUMBER = "46";
    public static String DUPLICATED_BONUS_NUMBER = "1";
    public static String VALID_BONUS_NUMBER = "7";

    public static Integer TICKET_COUNT = 10;
    public static Integer BONUS_NUMBER = 7;
    public static Integer UNDER_MATCH_COUNT = -1;
    public static Integer NO_MATCH_COUNT = 0;
    public static Integer MATCH_COUNT_3 = 3;
    public static Integer MATCH_COUNT_4 = 4;
    public static Integer MATCH_COUNT_5 = 5;
    public static Integer MATCH_COUNT_6 = 6;
    public static Integer UP_MATCH_COUNt = 7;

    public static boolean HAS_BONUS_NUMBER = true;
    public static boolean NO_BONUS_NUMBER = false;

    public static List<Integer> LOTTO_NUMBERS = new ArrayList<>(List.of(2, 1, 4, 3, 6, 5));

    public static List<Integer> LOTTO_NUMBERS_WITH_NO_MATCH = new ArrayList<>(List.of(7, 8, 9, 10, 11, 12));
    public static List<Integer> LOTTO_NUMBERS_WITH_MATCH_3 = new ArrayList<>(List.of(1, 2, 3, 7, 8, 10));
    public static List<Integer> LOTTO_NUMBERS_WITH_MATCH_4 = new ArrayList<>(List.of(1, 2, 3, 4, 8, 10));
    public static List<Integer> LOTTO_NUMBERS_WITH_MATCH_5 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 10));
    public static List<Integer> LOTTO_NUMBERS_WITH_MATCH_5_AND_BONUS_NUMBER = new ArrayList<>(List.of(1, 2, 3, 4, 5, 7));
    public static List<Integer> LOTTO_NUMBERS_WITH_MATCH_6 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
    public static final List<Integer> SORTED_LOTTO_NUMBERS = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
    public static final List<Integer> WINNING_NUMBERS = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
}
