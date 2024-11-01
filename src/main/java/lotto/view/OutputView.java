package lotto.view;

import lotto.dto.BuyLottosDTO;

public class OutputView {
    public static final OutputView INSTANCE = new OutputView();
    public static final String OUTPUT_LOTTO_MESSAGE = "개를 구매했습니다.";

    public void printLotto(int quantity) {
        System.out.println(quantity + OUTPUT_LOTTO_MESSAGE);
    }

    public void printLottoDetail(BuyLottosDTO buyLottos) {
        buyLottos.buyLottos().stream().forEach(buyLottoDTO -> System.out.println(buyLottoDTO.numbers()));
    }
}
