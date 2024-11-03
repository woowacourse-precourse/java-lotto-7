package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public static final String ERROR_PURCHASE_INPUT_NOT_NUMBER = "[ERROR] 구입금액 입력이 숫자가 아닙니다.";
    public static final String ERROR_PURCHASE_INPUT_NOT_POSITIVE = "[ERROR] 구입금액은 음수가 될수 없습니다.";
    public static final String ERROR_PURCHASE_INPUT_WRONG_UNIT = "[ERROR] 구입금액은 1000원 단위로 입력되어야 합니다.";
    private final List<Lotto> lottos;
    private final InputView inputView;
    private int purchase;
    private final RandomNumbersGenerator numbersGenerator;

    public LottoGame() {
        this.lottos = new ArrayList<>();
        this.numbersGenerator = new RandomNumbersGenerator();
        this.inputView = new InputView();
    }

    public void purchaseLottos(InputView inputView) {
        String input = "";
        try{
            input = inputView.getInput(InputType.PURCHASE);
            validatePurchaseInput(input);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            purchaseLottos(inputView);
        }
        this.purchase = Integer.parseInt(input) / 1000;
        lottosFactory(this.numbersGenerator);
    }

    public void validatePurchaseInput(String input) throws IllegalArgumentException {
        int amount = 0;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PURCHASE_INPUT_NOT_NUMBER);
        }
        if (amount < 0) {
            throw new IllegalArgumentException(ERROR_PURCHASE_INPUT_NOT_POSITIVE);
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_PURCHASE_INPUT_WRONG_UNIT);
        }
    }

    private void lottosFactory(RandomNumbersGenerator numbersGenerator) {
        for (int i = 0; i < this.purchase; i++) {
            this.lottos.add(new Lotto(numbersGenerator));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
