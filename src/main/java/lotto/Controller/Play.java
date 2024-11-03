package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.Random;
import lotto.Model.Statistics;
import lotto.Model.Rate;
import lotto.View.Output;

import java.util.List;
import java.util.Map;

public class Play {
    private final MoneyController moneyController;
    private final LottoController lottoController;

    public Play() {
        moneyController = new MoneyController();
        lottoController = new LottoController();
    }

    public void StartGame() {
        int money = moneyController.PayMoney();
        Random random = new Random();
        List<Lotto> Lottos = random.CreateLottos(money);
        Output.LottoOutput(Lottos);

        List<Integer> Numbers = lottoController.GetNumberValidation();
        int bonus = lottoController.GetBonusValidation(Numbers);
        CalculateLottoResult(Lottos, Numbers, bonus, money);
    }

    private void CalculateLottoResult(List<Lotto> Lottos, List<Integer> Numbers, int bonus, int money) {
        Statistics statistics = new Statistics();
        Map<Integer, Integer> result = statistics.CalculateRate(Lottos, Numbers, bonus);

        Output.ResultOutput(result);

        CalculateMoneyRate(result, money);
    }

    private void CalculateMoneyRate(Map<Integer, Integer> result, int money) {
        Rate rate = new Rate();
        int Total = rate.CalculateSum(result);
        double rateOfMoney = rate.CalculateRate(Total, money);

        Output.MoneyRate(rateOfMoney);
    }
}
