package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final String INPUT_NUMBER_ERROR_MESSAGE = "[ERROR] 구입 금액은 숫자여야 합니다.";
    private static final String PURCHASE_AMOUNT_ERROR_MESSAGE = "[ERROR] 구입 금액은 %d원 단위여야 합니다.";
    private static final Integer LOTTO_PURCHASE_COST = 1000;

    public void run() {
        Integer lottoCount = buyLotto();

        List<Lotto> createLottos = createLotto(lottoCount);

        printLottos(createLottos, lottoCount);


    }

    private void printLottos(List<Lotto> createLottos, Integer lottoCount){
        String lottosString = getLottosString(createLottos);

        OutputView.getInstance().printLottos(lottoCount, lottosString);
    }

    private String getLottosString(List<Lotto> lottos){
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto.toPrintList()).append("\n");
        }

        return stringBuilder.toString();
    }

    private List<Lotto> createLotto(Integer lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(Lotto.LOTTO_MIN_NUMBER,
                    Lotto.LOTTO_MAX_NUMBER, Lotto.LOTTO_NUMBER_COUNT);

            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }


    private Integer buyLotto() {
        Integer totalCost = getUserPurchaseCost();
        return getLottoAmount(totalCost);
    }

    private Integer getLottoAmount(Integer cost) {
        if (cost % LOTTO_PURCHASE_COST != 0) {
            throw new IllegalArgumentException(String.format(PURCHASE_AMOUNT_ERROR_MESSAGE, LOTTO_PURCHASE_COST));
        }

        return cost / LOTTO_PURCHASE_COST;
    }

    private Integer getUserPurchaseCost() {
        OutputView.getInstance().printPurchaseInput();
        try{
            return Integer.parseInt(InputView.getInstance().readUserInput());
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(INPUT_NUMBER_ERROR_MESSAGE);
        }
    }


}
