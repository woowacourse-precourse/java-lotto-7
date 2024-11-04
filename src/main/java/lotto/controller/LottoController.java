package lotto.controller;

import lotto.domain.*;
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
    private final LottoRandomGenerator randomGenerator = new LottoRandomGenerator();

    public void playLotto(){
        Money money = createMoney();
        Lottos lottos = createLottos(money);
        WinningNumbers winningNumbers = createWinningNumbers();
        Winning winning = createWinning(winningNumbers);

    }

    private Money createMoney(){
        outputView.printRequestMoney();
        int money = Integer.parseInt(inputView.inputMoney());
        return new Money(money);
    }

    private Lottos createLottos(Money money) {
        int count = money.getLottoCount();
        outputView.printLottoCount(count);
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> randomNumbers = LottoRandomGenerator.generateRandomNumbers();
            lottoList.add(new Lotto(randomNumbers));
        }
        Lottos lottos = new Lottos(lottoList);
        outputView.printLottos(lottos);
        return lottos;
    }

    private WinningNumbers createWinningNumbers(){
        outputView.printRequestWinningNumbers();
        String[] winningNumbersInput = inputView.inputWinningNumbers();

        List<WinningNumber> winningNumbers = Arrays.stream(winningNumbersInput)
                .map(Integer::parseInt)
                .map(WinningNumber::new)
                .collect(Collectors.toList());

        return new WinningNumbers(winningNumbers);
    }

    private Winning createWinning(WinningNumbers winningNumbers){
        outputView.printRequestBonusNumbers();
        String bonusNumberInput = inputView.inputBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(Integer.parseInt(bonusNumberInput));
        return new Winning(winningNumbers, bonusNumber);
    }


}
