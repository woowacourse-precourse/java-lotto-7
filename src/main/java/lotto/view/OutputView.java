package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.dto.LottoDto;
import lotto.model.dto.ResultDto;
import lotto.model.dto.ResultDto.RankDto;

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

    public static void displayResult(ResultDto resultDto) {
        List<RankDto> rankDtos = resultDto.rankDtos();

        for (RankDto rankDto : rankDtos) {
            System.out.println(rankDto.description() + " - " + rankDto.count() + "개");
        }

        System.out.printf("총 수익률은 %.1f%%입니다.", Math.round(resultDto.profitRate() * 10) / 10.0);
    }
}
