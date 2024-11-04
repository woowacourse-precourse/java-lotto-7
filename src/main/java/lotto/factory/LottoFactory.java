package lotto.factory;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.generator.Generator;
import lotto.generator.LottoAutoGenerator;
import lotto.generator.LottoRandomNumberGenerator;
import lotto.generator.RandomNumberGenerator;
import lotto.input.ConsoleInputProvider;
import lotto.input.InputProvider;
import lotto.parser.InputLottoParser;
import lotto.parser.Parser;
import lotto.parser.ParserConfig;
import lotto.proxy.ReceiverProxyFactory;
import lotto.input.BonusNumberReceiver;
import lotto.input.MoneyReceiver;
import lotto.input.Receiver;
import lotto.input.WinningLottoReceiver;
import lotto.service.LottoService;
import lotto.view.ConsoleOutputPort;
import lotto.view.LottoPrinter;

import java.util.List;

public class LottoFactory {

    public InputProvider createInputProvider() {
        return new ConsoleInputProvider();
    }

    public Receiver<Money> createMoneyReceiver() {
        InputProvider inputProvider = createInputProvider();
        Receiver<Money> receiver = new MoneyReceiver(inputProvider);
        return ReceiverProxyFactory.createProxy(receiver, Receiver.class);
    }

    public RandomNumberGenerator createRandomNumberGenerator() {
        return new LottoRandomNumberGenerator();
    }

    public Generator<Money, List<Lotto>> createLottoGenerator() {
        RandomNumberGenerator randomNumberGenerator = createRandomNumberGenerator();
        return new LottoAutoGenerator(randomNumberGenerator);
    }

    public Parser createParser() {
        return new InputLottoParser(ParserConfig.DEFAULT);
    }

    public Receiver<WinningLotto> createWinningLottoReceiver(Parser parser) {
        InputProvider inputProvider = createInputProvider();
        Receiver<WinningLotto> receiver = new WinningLottoReceiver(inputProvider, parser);
        return ReceiverProxyFactory.createProxy(receiver, Receiver.class);
    }

    public Receiver<BonusNumber> createBonusNumberReceiver(Lotto winningNumbers) {
        InputProvider inputProvider = createInputProvider();
        Receiver<BonusNumber> receiver = new BonusNumberReceiver(inputProvider, winningNumbers);
        return ReceiverProxyFactory.createProxy(receiver, Receiver.class);
    }

    public LottoService createLottoService(List<Lotto> lottos, WinningLotto winningLotto, BonusNumber bonusNumber, LottoPrinter lottoPrinter) {
        return new LottoService(lottos, winningLotto, bonusNumber, lottoPrinter);
    }

    public LottoPrinter createLottoPrinter() {
        return new LottoPrinter(new ConsoleOutputPort());
    }
}
