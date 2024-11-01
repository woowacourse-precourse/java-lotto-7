package lotto.view;

import lotto.constants.collection.ScoreSystemPrintForm;
import lotto.constants.string.OutputMessage;
import lotto.domain.Lotto;
import lotto.dto.LottosDto;
import lotto.dto.ScoreDto;

import java.util.List;

public class OutputView {

    public void printBoughtLottos(LottosDto lottosDto,int boughtAmount) {
        System.out.println();
        System.out.println(boughtAmount+ OutputMessage.BOUGHT_AMOUNT.getInstance());
        List<Lotto> lottos = lottosDto.lottos().getLottos();

        for(int i=0; i<boughtAmount; i++) {
            System.out.println(lottos.get(i));
        }
    }

    public void printScoreResult(List<Integer> scores, float rateOfReturn) {
        System.out.println();
        System.out.println(OutputMessage.RESULT_START_LINE);
        List<String> scoreSystemFormat = ScoreSystemPrintForm.DEFAULT_PRINT.getInstance();
        for(int i=0; i<scores.size();i++){
            System.out.println(String.format(scoreSystemFormat.get(i),scores.get(i)));
        }
        System.out.println(String.format(OutputMessage.RATE_OF_RETURN.getInstance(),rateOfReturn));
    }
}
