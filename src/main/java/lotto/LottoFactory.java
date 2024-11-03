package lotto;

public class LottoFactory {
    private static InputValidator inputValidator() {
        return new InputValidator();
    }

    private static InputHandler inputHandler() {
        return new InputHandler(input());
    }

    private static Input input() {
        return new Input(inputValidator());
    }

    private static DrawStrategy drawStrategy() {
        return new RandomStrategy();
    }

    private static RevenueCalculator revenueCalculator() {
        return new RevenueCalculator();
    }

    private static LottoGenerator lottoGenerator() {
        return new LottoGenerator(drawStrategy());
    }

    private static LottoService lottoService() {
        return new LottoService(lottoGenerator(), revenueCalculator());
    }

    private static View view() {
        return new View();
    }

    public static LottoController createLottoController() {
        return new LottoController(inputHandler(), lottoService(), view());
    }
}
