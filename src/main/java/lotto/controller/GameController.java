package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.dto.InputDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();


    public void run() {
        InputDto inputData = getInputData();
        int purchaseAmount;
        int bonusNumber;
        Lotto winningLotto;
        List<Lotto> lottos = new ArrayList<>();

        try {
            purchaseAmount = Integer.parseInt(inputData.getPurchaseAmountStr());
            bonusNumber = Integer.parseInt(inputData.getBonusNumber());

            List<Integer> winningNumbers = Arrays.stream(inputData.getWinningNumStr().split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            winningLotto = new Lotto(winningNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수로 변환이 불가능 합니다.");
        }

        if (canBuy(purchaseAmount)) {
            for (int i = 0; i < purchaseAmount/1000; i++) {
                Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
                lottos.add(lotto);
            }
        }

        Game game = new Game(lottos, winningLotto, bonusNumber);
        int[] results = game.compareNumbers(winningLotto);
        double rateOfReturn = Math.round(game.calculateRateOfReturn(purchaseAmount, results));

        outputView.printLottosNum(lottos);
        System.out.println();
        outputView.printResult(results);
        System.out.println();
        outputView.printRateOfReturn(rateOfReturn);
    }


    private InputDto getInputData() {
        InputDto inputDto = new InputDto(inputView.getPurchaseStr(),
                                         inputView.getWinningNumStr(),
                                         inputView.getBonusNumber());

        if (!inputDto.validateDto()) {
            throw new IllegalArgumentException("[ERROR] 비어있는 입력 값이 존재합니다.");
        }
        return inputDto;
    }

    private boolean canBuy(int purchaseAmount) {
        return (purchaseAmount % 1000 == 0);
    }

}
