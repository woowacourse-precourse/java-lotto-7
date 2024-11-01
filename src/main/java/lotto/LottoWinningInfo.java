package lotto;

/**
 * 로또 당첨과 관련된 각종 정보를 담고 있는 클래스입니다.
 */
public class LottoWinningInfo {
    public static final int CLASS_5_AMOUNT = 3;
    public static final int CLASS_4_AMOUNT = 4;
    public static final int CLASS_2_TO_3_AMOUNT = 5;
    public static final int CLASS_1_AMOUNT = 6;

    private static final int CLASS_UNDEFINED_PRICE = 0;
    private static final int CLASS_5_PRICE = 5000;
    private static final int CLASS_4_PRICE = 50000;
    private static final int CLASS_3_PRICE = 1500000;
    private static final int CLASS_2_PRICE = 30000000;
    private static final int CLASS_1_PRICE = 2000000000;
    
    private static final String INFO_MESSAGE_FORMAT_1 = "%d개 일치 (%,d원)";
    private static final String INFO_MESSAGE_FORMAT_2 = "%d개 일치, 보너스 볼 일치 (%,d원)";
    
    public static final String CLASS_5_INFO_MESSAGE
            = String.format(INFO_MESSAGE_FORMAT_1, CLASS_5_AMOUNT, CLASS_5_PRICE);
    public static final String CLASS_4_INFO_MESSAGE
            = String.format(INFO_MESSAGE_FORMAT_1, CLASS_4_AMOUNT, CLASS_4_PRICE);
    public static final String CLASS_3_INFO_MESSAGE
            = String.format(INFO_MESSAGE_FORMAT_1, CLASS_2_TO_3_AMOUNT, CLASS_3_PRICE);
    public static final String CLASS_2_INFO_MESSAGE
            = String.format(INFO_MESSAGE_FORMAT_2, CLASS_2_TO_3_AMOUNT, CLASS_2_PRICE);
    public static final String CLASS_1_INFO_MESSAGE
            = String.format(INFO_MESSAGE_FORMAT_1, CLASS_1_AMOUNT, CLASS_1_PRICE);
    
    /**
     * 로또 당첨 종류에 따라 당첨금액을 반환합니다.
     * @param type
     * @return
     */
    public static int getReward(WinningType type) {
        if (type == WinningType.CLASS_1) {
            return CLASS_1_PRICE;
        }
        if (type == WinningType.CLASS_2) {
            return CLASS_2_PRICE;
        }
        if (type == WinningType.CLASS_3) {
            return CLASS_3_PRICE;
        }
        if (type == WinningType.CLASS_4) {
            return CLASS_4_PRICE;
        }
        if (type == WinningType.CLASS_5) {
            return CLASS_5_PRICE;
        } return CLASS_UNDEFINED_PRICE;
    }
    
    /**
     * 로또 당첨 종류에 따라 당첨 관련 정보 메세지를 반환합니다.
     * @param type
     * @return
     */
    public static String getInfoMessage(WinningType type) {
        if (type == WinningType.CLASS_1) {
            return CLASS_1_INFO_MESSAGE;
        }
        if (type == WinningType.CLASS_2) {
            return CLASS_2_INFO_MESSAGE;
        }
        if (type == WinningType.CLASS_3) {
            return CLASS_3_INFO_MESSAGE;
        }
        if (type == WinningType.CLASS_4) {
            return CLASS_4_INFO_MESSAGE;
        }
        if (type == WinningType.CLASS_5) {
            return CLASS_5_INFO_MESSAGE;
        } throw new UnsupportedOperationException("등록되지 않은 당첨 유형입니다! : " + type.toString());
    }
}
