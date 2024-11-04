package lotto.validate;

import java.util.List;

public class Validator {
    private static final String ONLY_NUM = "[0-9]+";
    private static final String LIST_FORMAT = "[0-9]+(,[0-9]+)*";
    private static final int ZERO = 0;
    private static final int MIN = 1;
    private static final int MAX = 45;

    /**
     * 숫자로 이루어져있는지 판별
     *
     * @param s 판별할 문자열
     * @return 숫자로 이루어지면 true
     */
    public static boolean isNum(String s) {
        return s.matches(ONLY_NUM);
    }

    /**
     * 1~45 사이의 숫자로만 이루어진 리스트인지 판별
     *
     * @param list 판별할 정수 리스트
     * @return 1~45 사이의 숫자로만 이루어지면 true
     */
    public static boolean inRangeList(List<Integer> list) {
        return list.stream().allMatch(Validator::inRange);
    }

    /**
     * 1~45 사이의 숫자인지 판별
     *
     * @param n 판별할 정수
     * @return 1~45 사이의 숫자이면 true
     */
    public static boolean inRange(int n) {
        return MIN <= n && n <= MAX;
    }

    /**
     * n이 price의 배수인지 판별
     *
     * @param a 판별할 숫자
     * @param b 배수
     * @return a % b == 0
     */
    public static boolean isMulti(int a, int b) {
        return a % b == ZERO;
    }

    /**
     * a가 b보다 큰지 판별
     *
     * @param a 큰 수
     * @param b 작은 수
     * @return a > b
     */
    public static boolean isOver(int a, int b) {
        return b < a;
    }

    /**
     * 자연수 판별
     *
     * @param n 판별할 정수
     * @return n > 0
     */
    public static boolean isNaturalNum(int n) {
        return n > ZERO;
    }

    /**
     * 숫자 리스트가 ,로 분류되어 있는 형식 판별
     *
     * @param s 판별할 문자열
     * @return 올바른 형식 여부
     */
    public static boolean isList(String s) {
        return s.matches(LIST_FORMAT);
    }

    /**
     * 리스트 요소 중복 여부 판별
     *
     * @param list 판별할 정수 리스트
     * @return 중복이 없을 시 true
     */
    public static boolean isNotDistinct(List<Integer> list) {
        return list.stream().distinct().count() == list.size();
    }

    /**
     * 정수가 해당 리스트에 존재하는지 판별
     *
     * @param n    판별할 정수
     * @param list 판별할 리스트
     * @return 해당 정수를 포함하면 true
     */
    public static boolean isContain(int n, List<Integer> list) {
        return list.contains(n);
    }
}
