package lotto.domain.lotto;

public class LottoConstant {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_RANGE_LEFT = 1;
    public static final int LOTTO_RANGE_RIGHT = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int LOTTO_WINNING_NUMBER_COUNT = 6;
    public static final int LOTTO_BONUS_NUMBER_COUNT = 1;
    public static final int THREE_STRIKE_PRICE = 5000;
    public static final int FOUR_STRIKE_PRICE = 50000;
    public static final int FIVE_STRIKE_PRICE = 1500000;
    public static final int FIVE_STRIKE_AND_BALL_PRICE = 30000000;
    public static final int SIX_STRIKE_PRICE = 2000000000;


    public static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";
    public static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static final String WINNING_STATISTICS_MESSAGE = "당첨 통계\n"
            + "---\n"
            + "3개 일치 ({threeStrikePrice}원) - {threeStrikeCount}개\n"
            + "4개 일치 ({fourStrikePrice}원) - {fourStrikeCount}개\n"
            + "5개 일치 ({fiveStrikePrice}원) - {fiveStrikeCount}개\n"
            + "5개 일치, 보너스 볼 일치 ({fiveStrikeAndBallPrice}원) - {fiveStrikeAndBallCount}개\n"
            + "6개 일치 ({sixStrikePrice}원) - {sixStrikeCount}개\n"
            + "총 수익률은 {rateOfReturn}%입니다.";

}
