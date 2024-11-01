package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.dto.LottoDto;

public class OutputView {
    public static void displayLottoNumbersOfCustomer(List<LottoDto> lottoDtos) {
        System.out.println(lottoDtos.size() + "개를 구매했습니다.");

        for (LottoDto lottoDto : lottoDtos) {
            List<Integer> numbers = new ArrayList<>(lottoDto.numbers());
            Collections.sort(numbers);

            String result = String.join(", ", numbers.stream().map(String::valueOf).toList());
            System.out.println("[" + result + "]");
        }
    }

    public static void displayProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }
}
