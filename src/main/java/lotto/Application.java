package lotto;
import lotto.View.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView view = new InputView();
        LottoController controller = new LottoController();

        controller.run(); //로또 번호 생성기 실행.
    }
}
