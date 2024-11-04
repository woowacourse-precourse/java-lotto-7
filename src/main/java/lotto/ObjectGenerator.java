package lotto;

import lotto.function.purchase.LottoPurchase;
import lotto.function.purchase.processor.LottoListPrintProcessor;
import lotto.function.purchase.processor.LottoListSaveProcessor;
import lotto.function.purchase.processor.PurchasableCountCalculateProcessor;
import lotto.function.purchase.processor.PurchaseAmountInputProcessor;
import lotto.function.winning.checker.LottoWinningDetailsChecker;
import lotto.function.winning.checker.processor.LottoWinningPlaceCalculateProcessor;
import lotto.function.winning.checker.processor.LottoWinningStatisticsPrintProcessor;
import lotto.function.winning.checker.processor.LottoWinningTotalReturnPrintProcessor;
import lotto.function.winning.register.WinningLottoRegister;
import lotto.function.winning.register.processor.BonusLottoNumberInputProcessor;
import lotto.function.winning.register.processor.WinningLottoNumbersInputProcessor;
import lotto.function.winning.register.processor.WinningLottoSaveProcessor;
import lotto.io.input.ConsoleInput;
import lotto.io.input.ConsoleInputReader;
import lotto.io.input.Input;
import lotto.io.input.InputReader;
import lotto.io.printer.ConsoleStringPrinter;
import lotto.io.printer.StringPrinter;
import lotto.io.printer.error.ConsoleErrorPrinter;
import lotto.io.printer.error.ErrorPrinter;
import lotto.io.printer.lotto.ConsoleLottoPrinter;
import lotto.io.printer.lotto.LottoPrinter;
import lotto.io.printer.prompt.ConsolePromptPrinter;
import lotto.io.printer.prompt.PromptPrinter;
import lotto.io.printer.rank.ConsoleStatisticsPrinter;
import lotto.io.printer.rank.StatisticsPrinter;
import lotto.repository.InMemoryLottoRepository;
import lotto.repository.InMemoryWinningLottoRepository;
import lotto.repository.LottoRepository;
import lotto.repository.WinningLottoRepository;
import lotto.util.StringParser;
import lotto.util.calculator.LottoMatchingCountCalculator;
import lotto.util.calculator.LottoWinningPlaceCalculator;
import lotto.util.calculator.LottoWinningTotalReturnCalculator;
import lotto.util.calculator.PurchasableCalculator;
import lotto.util.generator.LottoGenerator;
import lotto.util.generator.NumberGenerator;
import lotto.util.generator.RandomLottoGenerator;
import lotto.util.generator.RandomNumberGenerator;

public class ObjectGenerator {

    private static LottoRepository lottoRepository;
    private static WinningLottoRepository winningLottoRepository;

    public static LottoMachine getLottoMachine() {
        return new LottoMachine(
                getLottoPurchase(),
                getWinningLottoRegister(),
                getLottoWinningDetailsChecker(),
                getErrorPrinter());
    }

    public static ErrorPrinter getErrorPrinter() {
        return new ConsoleErrorPrinter(getStringPrinter());
    }

    public static LottoPurchase getLottoPurchase() {
        return new LottoPurchase(
                getPurchaseAmountInputProcessor(), getLottoListPrintProcessor(),
                getLottoListSaveProcessor(), getPurchasableCountCalculatorProcessor());
    }

    public static PurchaseAmountInputProcessor getPurchaseAmountInputProcessor() {
        return new PurchaseAmountInputProcessor(getInput(), getPromptPrinter());
    }

    public static Input getInput() {
        return new ConsoleInput(getInputReader(), getStringParser());
    }

    public static InputReader getInputReader() {
        return new ConsoleInputReader();
    }

    public static StringParser getStringParser() {
        return new StringParser();
    }

    public static PromptPrinter getPromptPrinter() {
        return new ConsolePromptPrinter(getStringPrinter());
    }

    public static StringPrinter getStringPrinter() {
        return new ConsoleStringPrinter();
    }

    public static LottoListPrintProcessor getLottoListPrintProcessor() {
        return new LottoListPrintProcessor(getPromptPrinter(), getLottoPrinter());
    }

    public static LottoPrinter getLottoPrinter() {
        return new ConsoleLottoPrinter(getStringPrinter());
    }

    public static LottoListSaveProcessor getLottoListSaveProcessor() {
        return new LottoListSaveProcessor(getLottoGenerator(), getLottoRepository());
    }

    public static LottoGenerator getLottoGenerator() {
        return new RandomLottoGenerator(getNumberGenerator());
    }

    public static NumberGenerator getNumberGenerator() {
        return new RandomNumberGenerator();
    }

    public static LottoRepository getLottoRepository() {
        if (lottoRepository == null) {
            lottoRepository = new InMemoryLottoRepository();
        }
        return lottoRepository;
    }

    public static PurchasableCountCalculateProcessor getPurchasableCountCalculatorProcessor() {
        return new PurchasableCountCalculateProcessor(getPurchasableCalculator());
    }

    public static PurchasableCalculator getPurchasableCalculator() {
        return new PurchasableCalculator();
    }

    public static WinningLottoRegister getWinningLottoRegister() {
        return new WinningLottoRegister(
                getWinningLottoNumbersInputProcessor(),
                getBonusLottoNumberInputProcessor(),
                getWinningLottoSaveProcessor());
    }

    public static WinningLottoNumbersInputProcessor getWinningLottoNumbersInputProcessor() {
        return new WinningLottoNumbersInputProcessor(getPromptPrinter(), getInput());
    }

    public static BonusLottoNumberInputProcessor getBonusLottoNumberInputProcessor() {
        return new BonusLottoNumberInputProcessor(getPromptPrinter(), getInput());
    }

    public static WinningLottoSaveProcessor getWinningLottoSaveProcessor() {
        return new WinningLottoSaveProcessor(getWinningLottoRepository());
    }

    public static WinningLottoRepository getWinningLottoRepository() {
        if (winningLottoRepository == null) {
            winningLottoRepository = new InMemoryWinningLottoRepository();
        }
        return winningLottoRepository;
    }

    public static LottoWinningDetailsChecker getLottoWinningDetailsChecker() {
        return new LottoWinningDetailsChecker(
                getWinningLottoRepository(),
                getLottoRepository(),
                getLottoWinningPlaceCalculatorProcessor(),
                getLottoWinningStatisticsPrintProcessor(),
                getLottoWinningTotalReturnPrintProcessor());
    }

    public static LottoWinningPlaceCalculateProcessor getLottoWinningPlaceCalculatorProcessor() {
        return new LottoWinningPlaceCalculateProcessor(
                getWinningPlaceCalculator(),
                getLottoMatchingCountCalculator());
    }

    public static LottoWinningPlaceCalculator getWinningPlaceCalculator() {
        return new LottoWinningPlaceCalculator();
    }

    public static LottoMatchingCountCalculator getLottoMatchingCountCalculator() {
        return new LottoMatchingCountCalculator();
    }

    public static LottoWinningStatisticsPrintProcessor getLottoWinningStatisticsPrintProcessor() {
        return new LottoWinningStatisticsPrintProcessor(getPromptPrinter(), getStatisticsPrinter());
    }

    public static StatisticsPrinter getStatisticsPrinter() {
        return new ConsoleStatisticsPrinter(getStringPrinter());
    }

    public static LottoWinningTotalReturnPrintProcessor getLottoWinningTotalReturnPrintProcessor() {
        return new LottoWinningTotalReturnPrintProcessor(
                getPromptPrinter(),
                getLottoWinningTotalReturnCalculator());
    }

    public static LottoWinningTotalReturnCalculator getLottoWinningTotalReturnCalculator() {
        return new LottoWinningTotalReturnCalculator();
    }

}
