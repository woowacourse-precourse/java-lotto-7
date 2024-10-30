package lotto.application;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoQuantity;
import lotto.domain.Lottos;
import lotto.domain.PrizeNumber;
import lotto.domain.WinNumbers;

public class LottoApplication {

    public static Lottos buyLottos(LottoQuantity lottoQuantity, MakeNumbersStrategy makeNumbersStrategy,
                                   Printer printer) {
        Lottos lottos = Lottos.from(lottoQuantity, makeNumbersStrategy);
        printer.printPurchaseResult(lottoQuantity.value(), lottos);
        return lottos;
    }

    public static WinNumbers readWinNumbers(Printer printer, Reader reader) {
        printer.print("\n당첨 번호를 입력해 주세요.");
        String originWinNumbers = reader.read();
        WinNumbers winNumbersWithOutBonusNumber = WinNumbers.winNumbersFrom(originWinNumbers);

        printer.print("\n보너스 번호를 입력해 주세요.");
        String bonusNumber = reader.read();
        return winNumbersWithOutBonusNumber.bonusNumberFrom(bonusNumber);
    }

    public static PrizeNumber findWinningLottos(WinNumbers winNumbers, Lottos lottos) {
        PrizeNumber prizeNumber = new PrizeNumber();
        List<Lotto> allLotto = lottos.value();
        for (Lotto lotto : allLotto) {
            prizeNumber.countMatchNumber(lotto.getNumbers(), winNumbers);
        }
        return prizeNumber;
    }
}
