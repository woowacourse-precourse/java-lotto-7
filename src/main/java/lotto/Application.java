package lotto;

public class Application {

    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoResultCalculator calculator = new LottoResultCalculator();

        LottoController controller = new LottoController(lottoGenerator, calculator);

        controller.run();
    }
}
