package lotto.model.lotto;

import lotto.dto.MatchDto;
import lotto.dto.MatchResponse;
import lotto.dto.UserLotto;
import lotto.dto.WinNumberForm;
import lotto.model.match.Matches;
import lotto.model.money.Money;
import lotto.model.money.MoneyService;

import java.util.List;

public class LottoService {
    private final LottosGenerator lottosGenerator;
    private final MoneyService moneyService;

    public LottoService(LottosGenerator lottosGenerator, MoneyService moneyService) {
        this.lottosGenerator = lottosGenerator;
        this.moneyService = moneyService;
    }

    public MatchResponse matchLottos(UserLotto userLotto, WinNumberForm winNumberForm) {
        Matches matches = userLotto.lottos()
                .matchingLotto(winNumberForm.lotto(), winNumberForm.bonus());
        List<MatchDto> matchDtos = matches.getMatchDtos();

        double rateOfReturn = moneyService.getRateOfReturn(matchDtos, userLotto.money());

        return new MatchResponse(matchDtos, rateOfReturn);
    }

    public Lotto getLotto(List<Integer> numbers) {
        return Lotto.from(numbers);
    }

    public Bonus getBonus(Lotto lotto, int bonusNumber) {
        return Bonus.from(lotto, bonusNumber);
    }

    public UserLotto purchase(int moneyValue) {
        Money money = Money.from(moneyValue);
        Lottos radomLottos = lottosGenerator.getLottos(money);
        return new UserLotto(radomLottos, money);
    }
}
