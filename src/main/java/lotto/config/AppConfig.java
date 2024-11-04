package lotto.config;

import javax.swing.text.View;
import lotto.controller.LottoController;

public class AppConfig {
    private final View view;

    public AppConfig(){
        this.view = new CliView();
    }

    public LottoController getController(){
        return new LottoController(view);
    }

}
