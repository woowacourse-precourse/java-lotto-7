package lotto.constants;

public class Constants {

    public static final int PURCHASE_UNIT = 1000;

    public static final int CHOICE  = 6;
    public static final int RANGE_START  = 1;
    public static final int RANGE_END = 45;

    public static final String DELIMITER = ",";

    public static final int THREE_MATCHED_PRIZE = 5000;
    public static final int FOUR_MATCHED_PRIZE = 50000;
    public static final int FIVE_MATCHED_PRIZE = 1500000;
    public static final int SIX_MATCHED_PRIZE = 2000000000;
    public static final int BONUS_MATCHED_PRIZE = 30000000;

    public static final String THREE_MATCHED_MESSAGE = "3개 일치 (5,000원) - ";
    public static final String FOUR_MATCHED_MESSAGE = "4개 일치 (50,000원) - ";
    public static final String FIVE_MATCHED_MESSAGE = "5개 일치 (1,500,000원) - ";
    public static final String SIX_MATCHED_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    public static final String BONUS_MATCHED_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";

    private Constants() {
        throw new UnsupportedOperationException("[ERROR] Constant 클래스는 인스턴스화될 수 없습니다.");
    }
}
