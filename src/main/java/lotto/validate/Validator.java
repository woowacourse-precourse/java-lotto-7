package lotto.validate;

import java.util.List;

public class Validator {
    private static final String ONLY_NUM = "[0-9]+";
    private static final String LIST_FORMAT = "[0-9]+(,[0-9]+)*";
    private static final int ZERO = 0;
    private static final int MIN = 1;
    private static final int MAX = 45;

    public static boolean isNum(String s) {
        return s.matches(ONLY_NUM);
    }

    public static boolean inRangeList(List<Integer> list) {
        return list.stream().allMatch(Validator::inRange);
    }

    public static boolean inRange(int n) {
        return MIN <= n && n <= MAX;
    }

    public static boolean isMulti(int n, int price) {
        return n % price == ZERO;
    }

    public static boolean isOver(int n, int price) {
        return price <= n;
    }

    public static boolean isNaturalNum(int n) {
        return n > ZERO;
    }

    public static boolean isList(String s) {
        return s.matches(LIST_FORMAT);
    }

    public static boolean isNotDistinct(List<Integer> list) {
        return list.stream().distinct().count() == list.size();
    }

    public static boolean isNotContain(int n, List<Integer> list) {
        return !list.contains(n);
    }
}
