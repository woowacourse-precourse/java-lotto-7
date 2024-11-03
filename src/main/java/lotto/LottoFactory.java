package lotto;

public class LottoFactory {
    private static InputValidator inputValidator() {
        return new InputValidator();
    }

    public static Input input() {
        return new Input(inputValidator());
    }

    public static DrawStrategy drawStrategy() {
        return new RandomStrategy();
    }

    public static RevenueCalculator revenueCalculator() {
        return new RevenueCalculator();
    }

    public static LottoGenerator lottoGenerator() {
        return new LottoGenerator(drawStrategy());
    }

    public static LottoService lottoService() {
        return new LottoService(lottoGenerator(), revenueCalculator());
    }

    public static View view() {
        return new View();
    }

    public static LottoController createLottoController() {
        return new LottoController(input(), lottoService(), view());
    }
}
