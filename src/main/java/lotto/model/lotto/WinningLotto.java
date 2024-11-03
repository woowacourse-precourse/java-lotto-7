package lotto.model.lotto;

import java.util.List;
import lotto.dto.BonusUserInput;
import lotto.service.lotto.constant.MatchBonusEnum;
import lotto.dto.MatchResult;
import lotto.dto.WinningLottoUserInput;
import lotto.service.lotto.constant.LottoConstant;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 11. 1.
 */
public class WinningLotto extends Lotto {
  private Bonus bonus;

  private WinningLotto(List<Integer> numbers) {
    super(numbers);
  }

  public static WinningLotto from(WinningLottoUserInput userInput) {
    return new WinningLotto(userInput.getNumbers());
  }

  public WinningLotto addBonus(BonusUserInput userInput) {
    this.bonus = Bonus.from(userInput);
    return this;
  }

  public MatchResult match(Lotto purchasedLotto) {
    return createMatchResult(countMatchNumbers(purchasedLotto),
        purchasedLotto);
  }

  private int countMatchNumbers(Lotto purchasedLotto) {
    return (int) this.getNumbers()
        .stream()
        .filter(purchasedLotto.getNumbers()::contains)
        .count();
  }

  private MatchResult createMatchResult(int matchCount, Lotto purchasedLotto) {
    if (matchCount == LottoConstant.SECOND_AND_THIRD_PRIZE_MATCH_COUNT) {
      return MatchResult.from(matchCount, matchBonus(purchasedLotto));
    }
    return MatchResult.from(matchCount);
  }

  private MatchBonusEnum matchBonus (Lotto purchased) {
    if (purchased.getNumbers()
        .contains(bonus.getNumber())){
      return MatchBonusEnum.MATCHED;
    }
    return MatchBonusEnum.NOT_MATCHED;
  }

  /**
   * 테스트를 위한 메서드.
   */
  public int getBonusNumber () {
    return this.bonus.getNumber();
  }
}
