package lotto.lottoMachine.utils;

public class StaticFinalMessages {
    // 에러 문구보다 앞에 필수적으로 오는, 자주 쓰이는 문구
    public static final String ERROR_TEXT_INFRONT_OF_DETAILS = "[ERROR] ";
    public static final String RECOMMAND_MESSAGE_FOR_ENTERING_CORRECT_LOTTO_BONUS_NUMBER = "로또 보너스 번호로 1부터 45까지, 전에 입력한 로또 당첨 번호 6개와 중복되지 않는 숫자 한개를 입력해주세요";

    public static final String RECOMMAND_MESSAGE_FOR_ENTERING_CORRECT_LOTTO_PURCHASE_AMOUNT = "1000단위의 1000이상 50000이하 로또 구입 금액을 입력해주세요 ex) 5000";

    public static final String RECOMMAND_MESSAGE_FOR_ENTERING_CORRECT_LOTTO_WINNING_NUMBER = "로또 당첨 번호로 1부터 45까지 중복되지 않는 숫자 6개를 콤마(,)를 이용해서 구별해서 입력해주세요. ex) 1,2,3,4,5,6";

    public static final int MAXIMUM_NUM_OF_LOTTO_PURCHASE_AMOUNT = 50000;
    public static final int MINIMUM_NUM_OF_LOTTO_PURCHASE_AMOUNT = 1000;
    public static final int AMOUNT_OF_LOTTO_NUMBERS = 6;
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;

}
