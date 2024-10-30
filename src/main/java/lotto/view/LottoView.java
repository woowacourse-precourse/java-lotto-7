package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class LottoView {
    private static final String LOTTO_PURCHASE_PRICE_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String GENERATED_LOTTO_COUNT_MESSAGE = "\n%d개를 구매했습니다.";
    private static final String GENERATED_LOTTO_NUMBERS_MESSAGE = "[%s]";
    private static final String GENERATED_LOTTO_NUMBERS_DELIMITER = ", ";


    public String requestLottoPurchasePrice() {
        System.out.println(LOTTO_PURCHASE_PRICE_REQUEST_MESSAGE);
        return input();
    }

    public String input() {
        return Console.readLine();
    }

    public void printLottos(List<Lotto> lottos) {
        printLottosCount(lottos.size());

        lottos.stream()
                .map(this::getLottoNumbersMessage)
                .forEach(System.out::println);
    }

    private void printLottosCount(int lottoCount) {
        System.out.println(String.format(GENERATED_LOTTO_COUNT_MESSAGE, lottoCount));
    }

    private String getLottoNumbers(Lotto lotto) {
        return lotto.getNumbers().stream()
                .map(number -> String.valueOf(number))
                .collect(Collectors.joining(GENERATED_LOTTO_NUMBERS_DELIMITER));
    }

    private String getLottoNumbersMessage(Lotto lotto) {
        return String.format(GENERATED_LOTTO_NUMBERS_MESSAGE, getLottoNumbers(lotto));
    }
}
