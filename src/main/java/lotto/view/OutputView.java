package lotto.view;

import lotto.constants.string.OutputMessage;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.dto.LottosDto;

import java.util.List;

public class OutputView {

    public void printBoughtLottos(LottosDto lottosDto,int boughtAmount) {
        System.out.println("/n");
        System.out.println(boughtAmount+ OutputMessage.BoughtAmount.getInstance());
        List<Lotto> lottos = lottosDto.lottos().getLottos();

        for(int i=0; i<boughtAmount; i++) {
            System.out.println(lottos.get(i));
        }
    }
}
