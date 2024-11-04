package lotto.controller;

import lotto.domain.*;
import lotto.util.CalculateResult;
import lotto.util.LottoRandomGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final CalculateResult calculateResult = new CalculateResult();

    public void playLotto() {
        Money money = createMoney();
        Lottos lottos = createLottos(money);
        WinningNumbers winningNumbers = createWinningNumbers();
        Winning winning = createWinning(winningNumbers);

        WinningResult winningResult = createWinningResult(lottos, winning);
        outputView.printWinningResult(winningResult);

        double yield = calculateYield(money, winningResult);
        outputView.printYield(yield);
    }

    private Money createMoney() {
        while (true) {
            try {
                outputView.printRequestMoney();
                int money = Integer.parseInt(inputView.inputMoney());
                return new Money(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lottos createLottos(Money money) {
        int count = money.getLottoCount();
        outputView.printLottoCount(count);
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            try {
                List<Integer> randomNumbers = LottoRandomGenerator.generateRandomNumbers();
                lottoList.add(new Lotto(randomNumbers));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                i--; // 로또 생성 실패 시 재시도
            }
        }
        Lottos lottos = new Lottos(lottoList);
        outputView.printLottos(lottos);
        return lottos;
    }

    private WinningNumbers createWinningNumbers() {
        while (true) {
            try {
                outputView.printRequestWinningNumbers();
                String[] winningNumbersInput = inputView.inputWinningNumbers();

                List<WinningNumber> winningNumbers = Arrays.stream(winningNumbersInput)
                        .map(Integer::parseInt)
                        .map(WinningNumber::new)
                        .collect(Collectors.toList());

                return new WinningNumbers(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Winning createWinning(WinningNumbers winningNumbers) {
        while (true) {
            try {
                outputView.printRequestBonusNumbers();
                String bonusNumberInput = inputView.inputBonusNumber();
                BonusNumber bonusNumber = new BonusNumber(Integer.parseInt(bonusNumberInput));
                return new Winning(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningResult createWinningResult(Lottos lottos, Winning winning) {
        return calculateResult.calculateResult(lottos, winning);
    }

    private double calculateYield(Money money, WinningResult winningResult) {
        int totalPrize = winningResult.calculateTotalPrize();
        return ((double) totalPrize / money.money()) * 100;
    }
}
