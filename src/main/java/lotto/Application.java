package lotto;

import lotto.controller.LottoController;
import lotto.model.User;
import lotto.service.LottoService;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {

        View view = new View();
        LottoService service = new LottoService();
        User user = new User();
        LottoController controller = new LottoController(view, service);
        controller.run(user);
    }
}
