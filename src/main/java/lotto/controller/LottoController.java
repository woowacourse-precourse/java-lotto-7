package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run(){
        int buyPrice = InputView.buyPrice();
        Money money = new Money(buyPrice);
        List<Lotto> lottos = lottoService.purchaseLotto(money);

        List<String> formattedLottos = lottos.stream()
            .map(lotto -> lotto.getNumbers().toString())
            .collect(Collectors.toList());

        OutputView.showBuyLottos(lottos.size(), formattedLottos);

        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersInput = InputView.readLine();
        Set<Integer> winningNumbers = Arrays.stream(winningNumbersInput.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toSet());

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(InputView.readLine());



    }


}
