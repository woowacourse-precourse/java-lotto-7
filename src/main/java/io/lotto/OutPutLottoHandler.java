package io.lotto;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutPutLottoHandler {

    private static final String OUTPUT_BUY_COUNT_MESSAGE = "개를 구매했습니다.";

    public void showOutputBuyCountMessage(int count) {
        System.out.println();
        System.out.println(count + OUTPUT_BUY_COUNT_MESSAGE);
    }

    public List<String> showLottos(List<Lotto> lottos) {
        List<String> showLottos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            String lottoNumbers = lotto.getNumbers().stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
            System.out.println("[" + lottoNumbers + "]");
            showLottos.add(lottoNumbers);
        }
        return showLottos;
    }
}
