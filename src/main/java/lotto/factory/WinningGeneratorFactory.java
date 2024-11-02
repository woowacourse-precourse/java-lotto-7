package lotto.factory;

import lotto.service.WinningGenerator;

public class WinningGeneratorFactory {

    public static WinningGenerator create(String winning) {
        return new WinningGenerator(winning);
    }
}
