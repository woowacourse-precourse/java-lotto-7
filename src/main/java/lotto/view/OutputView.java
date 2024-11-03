package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {
    private static final String OUTPUT_FORMAT_OF_LOTTO_COUNT = "%d개를 구매했습니다.\n";
    private static final String EMPTY_STRING = "";
    private static final String OUTPUT_FORMAT_OF_LOTTO = "%s\n";

    public void printLottoGroup(List<Lotto> purchasedLotto) {
        System.out.printf(OUTPUT_FORMAT_OF_LOTTO_COUNT, purchasedLotto.size());

        String result = EMPTY_STRING;
        for (int i = 0; i < purchasedLotto.size(); i++) {
            String lottoNumbers = purchasedLotto.get(i).toString();
            result += String.format(OUTPUT_FORMAT_OF_LOTTO, lottoNumbers);
        }
        System.out.println(result);
    }
}
