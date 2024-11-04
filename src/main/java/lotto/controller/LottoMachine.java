package lotto.controller;

import lotto.domain.*;
import lotto.service.ProfitCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class LottoMachine {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoFactory lottoFactory = new LottoFactory(RandomNumberGenerator::generate);

    public void run() {
        Lottos lottos = prepareLottos();
        TargetLotto targetLotto = prepareTargetLotto();

        Map<LottoGrade, Integer> lottoCountMap = lottos.convertGrades(targetLotto);
        outputView.printResult(lottoCountMap);

        ProfitCalculator profitCalculator = new ProfitCalculator(lottos, targetLotto);
        double profitRate = profitCalculator.calculateProfit();
        outputView.printProfit(profitRate);
    }

    private Lottos prepareLottos() {
        Lottos lottos = repeatOnIllegalArgument(() -> {
            Long payment = inputView.readPayment();
            return lottoFactory.generateLottos(payment);
        });
        outputView.printLottos(lottos);

        return lottos;
    }

    private <T> T repeatOnIllegalArgument (Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private TargetLotto prepareTargetLotto() {
        TargetLotto targetLotto = repeatOnIllegalArgument(() -> {
            List<Integer> targetNumbers = inputView.readTargetNumber();
            Lotto target = new Lotto(targetNumbers);
            int bonusNumber = inputView.readBonusNumber();
            return new TargetLotto(target, bonusNumber);
        });

        return targetLotto;
    }
}
