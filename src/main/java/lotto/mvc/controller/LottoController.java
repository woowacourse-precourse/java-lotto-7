package lotto.mvc.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.mvc.model.Lotto;
import lotto.mvc.validation.LottoNumberValidator;
import lotto.mvc.validation.PurchaseAmountValidator;
import lotto.mvc.view.InputView;

public class LottoController {
    private InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        inputView.showPurchaseAmountMsg();

        String purchaseAmount = inputView.getUserInput();
        purchaseAmount = trimInput(purchaseAmount);
        purchaseAmount = removeDelimiter(purchaseAmount);

        PurchaseAmountValidator.isValid(purchaseAmount);

        int count = extractLottoCount(purchaseAmount);

        List<Lotto> lottos = makeLottos(count);

        inputView.showLottoWinningNumberMsg();
        String winningNumber = inputView.getUserInput();
        winningNumber = trimInput(winningNumber);

        Lotto winningLotto = new Lotto(extractLottoNumber(winningNumber));
    }

    private String trimInput(String input) {
        return input.trim();
    }

    private String removeDelimiter(String input) {
        //정규표현식으로 할 수 있을까
        StringBuilder output = new StringBuilder();

        for (String s : input.split(",", -1)) {
            output.append(s);
        }

        return output.toString();
    }

    private int extractLottoCount(String input) {
        Long count = Long.parseLong(input) / 1000;
        return count.intValue();
    }

    private List<Lotto> makeLottos(int count) {
        List<Lotto> lottos = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }

        return lottos;
    }

    private List<Integer> extractLottoNumber(String winningNumber) {
        List<Integer> numbers = new ArrayList<>();

        LottoNumberValidator.isValid(winningNumber);

        for (String number : winningNumber.split(",")) {
            number = number.trim();
            numbers.add(Integer.parseInt(number));
        }

        return numbers;
    }
}
