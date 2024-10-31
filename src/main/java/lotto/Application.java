package lotto;

import lotto.controller.LottoController;
import lotto.model.User;
import lotto.service.LottoNumberGenerator;
import lotto.service.LottoService;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {

        View view = new View();
        LottoNumberGenerator numberGenerator = new LottoNumberGenerator();
        LottoService lottoService = new LottoService(numberGenerator);

        User user = new User();
        LottoController controller = new LottoController(view, lottoService);
        controller.run(user);
    }
}
