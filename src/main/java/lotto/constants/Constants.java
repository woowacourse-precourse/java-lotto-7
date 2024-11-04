package lotto.constants;

public final class Constants {
	public static final int REQUIRED_NUMBER_COUNT = 6;
	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 45;
	public static final int LOTTO_PRICE = 1000;

	public static final String LOTTO_NUMBER_SIZE_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";
	public static final String LOTTO_NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이여야 합니다.";
	public static final String LOTTO_DUPLICATE_NUMBER_ERROR = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
	public static final String LOTTO_PURCHASE_AMOUNT_ERROR = "[ERROR] 구입 금액은 1000원 단위여야 합니다.";
	public static final String BONUS_NUMBER_DUPLICATE_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

	public static final String INPUT_PROMPT_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";
	public static final String INPUT_PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요 (쉼표로 구분):";
	public static final String INPUT_PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요:";

	public static final String MATCH_THREE_MESSAGE = "3개 일치 (5,000원) - ";
	public static final String MATCH_FOUR_MESSAGE = "4개 일치 (50,000원) - ";
	public static final String MATCH_FIVE_MESSAGE = "5개 일치 (1,500,000원) - ";
	public static final String MATCH_FIVE_WITH_BONUS_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
	public static final String MATCH_SIX_MESSAGE = "6개 일치 (2,000,000,000원) - ";
	public static final String TOTAL_YIELD_MESSAGE = "총 수익률은 %.1f%%입니다.";

	public static final int FIRST_PRIZE = 2_000_000_000;
	public static final int SECOND_PRIZE = 30_000_000;
	public static final int THIRD_PRIZE = 1_500_000;
	public static final int FOURTH_PRIZE = 50_000;
	public static final int FIFTH_PRIZE = 5_000;

	private Constants() {}
}
