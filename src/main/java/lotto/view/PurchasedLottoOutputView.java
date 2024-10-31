package lotto.view;

import java.util.Collections;
import java.util.List;
import lotto.dto.LottoDto;

public class PurchasedLottoOutputView {
    public void printLottoPurchaseCount(long lottoPurchaseCount) {
        System.out.println(lottoPurchaseCount + "개를 구매했습니다.");
    }

    public void printPurchasedLottos(List<LottoDto> lottoDtos) {
        for (LottoDto lottoDto : lottoDtos) {
            List<Integer> numbers = lottoDto.numbers();

            Collections.sort(numbers);

            System.out.println(numbers);
        }
    }
}
