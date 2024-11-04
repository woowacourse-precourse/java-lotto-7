package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.factory.LottoFactory;
import lotto.generator.Generator;
import lotto.message.LottoMessage;
import lotto.parser.Parser;
import lotto.input.Receiver;
import lotto.service.LottoService;
import lotto.view.LottoPrinter;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoFactory factory = new LottoFactory();

        // 1. 구매 금액 입력
        Receiver<Money> moneyReceiver = factory.createMoneyReceiver();
        Money money = moneyReceiver.receiveWithMessage();

        // 2. 로또 티켓 생성
        Generator<Money, List<Lotto>> generator = factory.createLottoGenerator();
        List<Lotto> generateLottos = generator.generate(money);

        // 3. 로또 티켓 출력
        LottoPrinter lottoPrinter = factory.createLottoPrinter();
        lottoPrinter.printLottoAmount(generateLottos, LottoMessage.LOTTO_PURCHASE_SUCCESS);
        lottoPrinter.printLotto(generateLottos);

        // 4. 당첨 번호 입력
        Parser parser = factory.createParser();
        Receiver<WinningLotto> winningNumberReceiver = factory.createWinningLottoReceiver(parser);
        WinningLotto winningLotto = winningNumberReceiver.receiveWithMessage();

        // 5. 보너스 번호 입력
        Receiver<BonusNumber> bonusNumberReceiver = factory.createBonusNumberReceiver(winningLotto.getWinningNumber());
        BonusNumber bonusNumber = bonusNumberReceiver.receiveWithMessage();

        // 6. 결과 발표
        LottoService lottoService = factory.createLottoService(generateLottos, winningLotto, bonusNumber, lottoPrinter);
        lottoService.announceResult();
    }
}
