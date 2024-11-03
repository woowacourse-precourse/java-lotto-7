package lotto.view;

import java.util.List;
import lotto.message.OutputMessage;
import lotto.model.domain.Lotto;
import lotto.model.dto.LottosResponse;

public class OutputView {

    public static void printCustomerLottos(LottosResponse response) {
        List<Lotto> lottos = response.lottos();
        System.out.println();
        System.out.println(lottos.size() + OutputMessage.PURCHASE_COUNT.getMessage());
        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
        System.out.println();
    }
}
