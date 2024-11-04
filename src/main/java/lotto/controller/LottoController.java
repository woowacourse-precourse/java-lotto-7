package lotto.controller;

import java.util.List;
import lotto.model.Lottos;
import lotto.service.LottoGenerator;
import lotto.view.UserInput;

public class LottoController {
    private final UserInput userInput;
    private final LottoGenerator lottoGenerator;

    public LottoController() {
        this.userInput = new UserInput();
        this.lottoGenerator = new LottoGenerator();
    }

    public void process() {
        int amount = userInput.getPurchaseAmount();

        Lottos lottos = lottoGenerator.getnerateLottos(amount);
        System.out.println(lottos.getSize() + "개를 구매했습니다.");

        lottos.getLottos().forEach(lotto -> System.out.println(lotto));


        List<Integer> winNumbers = userInput.inputWinNumbers();

        int bonusNumber = userInput.inputBonusNumber(winNumbers);
    }
}
