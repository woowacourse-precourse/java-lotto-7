package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.common.Winning;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        lottoService = new LottoService();

        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        String inputPayment = inputView.readPayment();
        int payment = 0;

        try {
            payment = Integer.parseInt(inputPayment);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주십시오.");
        }

        validatePayment(payment);

        int lottoCount = payment / 1000;

        List<Lotto> lottos = lottoService.initLotto(lottoCount);
        outputView.printLotto(lottoCount, lottos);

        String inputWinningNumbers = inputView.readWinningNumbers();
        String[] rawWinningNumbers = inputWinningNumbers.split(",");

        List<Integer> winningNumbers;

        try {
            winningNumbers = Arrays.stream(rawWinningNumbers)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주십시오.");
        }

        validateWinningNumbers(winningNumbers);

        String inputBonus = inputView.readBonus();

        int bonus;
        try {
            bonus = Integer.parseInt(inputBonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주십시오.");
        }

        validateLottoNumber(bonus);

        Map<Winning, Integer> winnings = lottoService.getWinnings(lottos, winningNumbers, bonus);
        double yield = lottoService.getYield(payment, winnings);

        outputView.printResult(winnings, yield);
    }

    private void validatePayment(int value) {
        validatePositive(value);

        if (value % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어지도록 입력해주십시오.");
        }
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        List<Integer> after = winningNumbers.stream().distinct().toList();

        if (winningNumbers.size() != after.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력하지 말아주십시오.");
        }

        for (Integer winningNumber : winningNumbers) {
            validateLottoNumber(winningNumber);
        }
    }

    private void validateLottoNumber(int value) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException("[ERROR] 1과 45 사이의 수를 입력해주십시오.");
        }
    }

    private void validatePositive(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("[ERROR] 양수를 입력해주십시오.");
        }
    }
}
