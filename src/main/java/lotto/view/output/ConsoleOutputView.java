package lotto.view.output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.dto.FinalResultDto;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;

public class ConsoleOutputView implements OutputView {

    @Override
    public void outputPurchaseLottoList(LottosDto lottosDto) {
        int lottoCount = lottosDto.lottoDtos().size();
        System.out.printf("\n%d개를 구매했습니다%n",lottoCount);

        for (LottoDto lottoDto : lottosDto.lottoDtos()) {
            List<Integer> lottoNumbers = new ArrayList<> (lottoDto.lottoNumbers());

            Collections.sort(lottoNumbers);
            System.out.println(lottoNumbers);
        }
    }


    @Override
    public void outputFinalResult(FinalResultDto finalResultDto) {

    }

    @Override
    public void outputErrorMessage(String errorMessage) {
        System.out.println("\n[ERROR] " + errorMessage);
    }
}
