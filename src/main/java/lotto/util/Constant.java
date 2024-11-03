package lotto.util;

public class Constant {

    public static final String ERROR_PREFIX = "[ERROR] ";

    public static final String PURCHASE_AMOUNT_CHECK_REGEX = "^[0-9]+$";
    public static final String BALL_NUMBER_RANGE_CHECK_REGEX = "^(?:[1-9]|[1-3][0-9]|4[0-5])$";

    public static final String RANK_1_PROMPT = "6개 일치 (2,000,000,000원)";
    public static final String RANK_2_PROMPT = "5개 일치, 보너스 볼 일치 (30,000,000원)";
    public static final String RANK_3_PROMPT = "5개 일치 (1,500,000원)";
    public static final String RANK_4_PROMPT = "4개 일치 (50,000원)";
    public static final String RANK_5_PROMPT = "3개 일치 (5,000원)";
    public static final String RANK_LOSE_PROMPT = "낙첨 (0원)";
    public static final String RANK_PROMPT_SUFFIX = " - ";
}
