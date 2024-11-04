package lotto.config;

import lotto.controller.LottoController;
import lotto.view.CliView;
import lotto.view.View;

public class AppConfig {

    private final View view;

    public AppConfig() {
        this.view = new CliView();
    }

    public LottoController getController() {
        return new LottoController(view);
    }

}
