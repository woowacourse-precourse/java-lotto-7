package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.lottoapp.business.LottoService;
import lotto.lottoapp.controller.LottoController;
import lotto.lottoapp.model.AutomaticLottoNumbersGenerator;
import lotto.lottoapp.view.LottoInput;
import lotto.lottoapp.view.LottoOutput;

public class Application {

    public static void main(String[] args) {
        try {
            LottoController lottoController = new LottoController(
                    new LottoInput(),
                    new LottoOutput(),
                    new LottoService(new AutomaticLottoNumbersGenerator()));

            lottoController.doHandleLotto();
        } catch (Error error) {
            error.printStackTrace();
            throw new IllegalArgumentException("더이상 실행할 수 없는 오류가 발생하여 어플리케이션을 종료합니다.", error);
        } finally {
            Console.close();
        }
    }

}
