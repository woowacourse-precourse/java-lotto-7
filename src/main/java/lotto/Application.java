package lotto;

public class Application {

    public static void main(String[] args) {
        // 필요한 의존성을 Application에서 생성 및 주입
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoResultCalculator calculator = new LottoResultCalculator();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        // Controller에 의존성 주입
        LottoController controller = new LottoController(lottoGenerator, calculator, inputView, outputView);

        // 프로그램 실행
        controller.run();
    }
}
