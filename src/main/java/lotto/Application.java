package lotto;

import lotto.controller.LottoController;
import lotto.model.User;
import lotto.service.LottoNumberGenerator;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {

        View view = new View();
        LottoNumberGenerator numberGenerator = new LottoNumberGenerator();

        User user = new User();
        LottoController controller = new LottoController(view);
        controller.run(user, numberGenerator);
    }
}
