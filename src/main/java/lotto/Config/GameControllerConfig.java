package lotto.Config;

import lotto.controller.GameController;
import lotto.controller.IOController;
import lotto.controller.LottoFactory;
import lotto.View.Input.Input;
import lotto.View.Output.Output;

import static lotto.Config.ValidatorFactory.getInputValidator;

public class GameControllerConfig {
    private static GameControllerConfig instance;

    private GameControllerConfig() {
    }

    public static GameControllerConfig getInstance() {
        if (instance == null) {
            instance = new GameControllerConfig();
        }
        return instance;
    }

    private IOController getIoController(){
        return new IOController(getInput(), getOutPut());
    }

    private Input getInput() {
        return new Input(getInputValidator());
    }

    private Output getOutPut() {
        return new Output();
    }

    private LottoFactory getLottoFactory() {
        return LottoFactoryConfig.getInstance().getLottoFactory();
    }

    public GameController getGameController() {
        IOController ioController = getIoController();
        LottoFactory lottoFactory = getLottoFactory();

        return new GameController(ioController, lottoFactory);
    }

}
