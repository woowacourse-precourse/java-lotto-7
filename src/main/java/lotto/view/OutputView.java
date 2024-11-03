package lotto.view;

import static lotto.view.Output.NEW_LINE;
import static lotto.view.Output.OUTPUT_COUNT_OF_PURCHASED_LOTTO;

import lotto.domain.lotto.dto.GetLottoDto;
import lotto.domain.lotto.dto.GetLottosDto;

public class OutputView {

    public void printMessage(final Output output) {
        System.out.println(output.message);
    }

    public void printLottos(GetLottosDto getLottosDto) {
        System.out.printf(NEW_LINE.message + OUTPUT_COUNT_OF_PURCHASED_LOTTO.message + NEW_LINE.message, getLottosDto.GetLottoDtos().size());
        getLottosDto.GetLottoDtos().forEach(this::printLotto);
        System.out.print(NEW_LINE.message);
    }

    private void printLotto(GetLottoDto getLottoDto) {
        System.out.println(getLottoDto.lotto());
    }
}
