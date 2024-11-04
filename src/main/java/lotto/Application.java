package lotto;

import controller.LottoController;
import util.DependencyFactory;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        DependencyFactory factory = new DependencyFactory();
        LottoController lottoController = new LottoController(factory);
        lottoController.run();
    }
}
