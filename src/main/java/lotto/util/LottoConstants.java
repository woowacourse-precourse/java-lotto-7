package lotto.util;

import java.math.BigDecimal;

public class LottoConstants {

  public static final int LOTTO_NUMBER_COUNT = 6;
  public static final int MIN_LOTTO_NUMBER = 1;
  public static final int MAX_LOTTO_NUMBER = 45;
  public static final BigDecimal LOTTO_PRICE = BigDecimal.valueOf(1000);

  public static final String PROMPT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
  public static final String PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
  public static final String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

  public static final String MESSAGE_PURCHASED_TICKETS = "%d개를 구매했습니다.";
  public static final String MESSAGE_RESULT_STATISTICS = "당첨 통계";
  public static final String MESSAGE_DIVIDER = "---";
  public static final String MESSAGE_TOTAL_PROFIT_RATE = "총 수익률은 %.1f%%입니다.";

  public static final String FORMAT_RANK_COUNT = "%s (%s) - %d개";
  public static final String FORMAT_CURRENCY = "%,d원";

  private LottoConstants() {
  }
}
