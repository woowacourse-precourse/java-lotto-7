package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.dto.LottoDto;

public class PurchasedLottoOutputView {
    private static final String PURCHASED_LOTTO_MESSAGE_FORMAT = "\n%d개를 구매했습니다.\n";

    public void printLottoPurchaseCount(long lottoPurchaseCount) {
        System.out.printf(PURCHASED_LOTTO_MESSAGE_FORMAT, lottoPurchaseCount);
    }

    public void printPurchasedLottos(List<LottoDto> lottoDtos) {
        for (LottoDto lottoDto : lottoDtos) {
            List<Integer> numbers = new ArrayList<>(lottoDto.numbers());

            Collections.sort(numbers);

            System.out.println(numbers);
        }
    }
}
