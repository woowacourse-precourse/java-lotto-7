package lotto.constants;

public final class Constants {
	public static final String LOTTO_NUMBER_SIZE_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";
	public static final String LOTTO_NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이여야 합니다.";
	public static final String LOTTO_PURCHASE_AMOUNT_ERROR = "[ERROR] 구입 금액은 1000원 단위여야 합니다.";

	public static final int FIRST_PRIZE = 2_000_000_000;
	public static final int SECOND_PRIZE = 30_000_000;
	public static final int THIRD_PRIZE = 1_500_000;
	public static final int FOURTH_PRIZE = 50_000;
	public static final int FIFTH_PRIZE = 5_000;

	public static final String INPUT_PROMPT_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";
	public static final String INPUT_PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요 (쉼표로 구분):";
	public static final String INPUT_PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요:";
}
