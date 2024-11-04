package lotto.dto;

import lotto.service.lotto.constant.MatchBonusEnum;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 11. 1.
 */
public record MatchResult (
    int matchCount,
    MatchBonusEnum matchBonusEnum
){

  public static MatchResult from (int matchCount) {
    return new MatchResult (matchCount, MatchBonusEnum.DONT_CARE);
  }

  public static MatchResult from (int matchCount, MatchBonusEnum matchBonusEnum) {
    return new MatchResult (matchCount, matchBonusEnum);
  }
}
