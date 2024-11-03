package lotto;

public class AbsoluteValue {
    public static final Integer MIN_NUMBER = 1;
    public static final Integer MAX_NUMBER = 45;
    public static final Integer LOTTO_NUMBER_COUNT = 6;
    public static Integer TICKET_COUNT (Integer pay) {
        return pay / 1000;
    }
}
