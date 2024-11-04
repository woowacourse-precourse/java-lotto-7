package lotto;

import lotto.common.LottoGrade;
import lotto.common.MessageGenerator;
import lotto.domain.EarningReteCalculator;
import lotto.domain.LottoFactory;
import lotto.helper.LottoParser;
import lotto.domain.WinningStrategy;
import lotto.helper.InputValidator;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class LottoApp {

    private final ConsoleInput consoleInput;
    private final ConsoleOutput consoleOutput;

    public LottoApp() {
        this.consoleInput = new ConsoleInput();
        this.consoleOutput = new ConsoleOutput();
    }

    public void run() {
        LottoFactory lottoFactory = createLottoFactory();
        List<Lotto> generatedLots = lottoFactory.generate();
        printLottoGeneratedMessages(generatedLots);

        Lotto winningLotto = inputWinningLotto();
        int bonus = inputBonusNumber();
        WinningStrategy winningStrategy = new WinningStrategy(winningLotto, bonus);

        Map<LottoGrade, Integer> drawingResult = winningStrategy.drawLots(generatedLots);
        printDrawingLotsResult(drawingResult);

        EarningReteCalculator calculator = new EarningReteCalculator(generatedLots, drawingResult);
        float earningRate = calculator.calculate();
        printEarningRate(earningRate);
    }

    private void printEarningRate(float earningRate) {
        String message = MessageGenerator.generateEarningRateMessage(earningRate);
        consoleOutput.print(message);
    }

    private void printDrawingLotsResult(Map<LottoGrade, Integer> drawingResult) {
        List<String> messages = MessageGenerator.generateDrawingResult(drawingResult);
        consoleOutput.print(messages);
    }

    private int inputBonusNumber() {
        return read(() -> {
            consoleOutput.print(MessageGenerator.inputBonusNumber);
            String input = consoleInput.inputString();
            InputValidator.validateNumeric(input);
            return Integer.parseInt(input);
        });
    }

    private Lotto inputWinningLotto() {
        return read(() -> {
            consoleOutput.print(MessageGenerator.inputWinningNumber);
            String input = consoleInput.inputString();
            return LottoParser.parse(input);
        });
    }

    private void printLottoGeneratedMessages(List<Lotto> lots) {
        List<String> generatedLottoMessages = MessageGenerator.lottoGenerateResult(lots);
        consoleOutput.print(generatedLottoMessages);
    }

    private LottoFactory createLottoFactory() {
        return read(() -> {
            consoleOutput.print(MessageGenerator.inputCost);
            String cost = consoleInput.inputString();
            InputValidator.validateNumeric(cost);
            return new LottoFactory(cost);
        });
    }

    private <T> T read(final Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (final IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
