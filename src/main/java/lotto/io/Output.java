package lotto.io;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.util.Constants;

import java.util.List;

public class Output {
    public void printPurchasePriceInputPrompt() {
        System.out.println(Constants.PURCHASE_PRICE_INPUT_PROMPT.getMessage());
    }

    public void printLottoCount(int lottoCount) {
        System.out.println("\n "+ lottoCount + Constants.LOTTO_COUNT_PROMPT.getMessage());
    }

    public void printLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            printLottoNumber(lotto);
        }
    }

    private void printLottoNumber(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();

        System.out.print(Constants.LOTTO_NUMBER_START.getMessage());
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            printCommaIfNotLast(i, numbers.size());
        }
        System.out.println(Constants.LOTTO_NUMBER_END.getMessage());
    }

    private void printCommaIfNotLast(int i, int size) {
        if (i < size - 1) {
            System.out.print(Constants.COMMA.getMessage());
        }
    }
}
