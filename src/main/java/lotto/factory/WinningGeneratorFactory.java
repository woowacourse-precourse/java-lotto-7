package lotto.factory;

import lotto.service.generator.WinningGenerator;

public class WinningGeneratorFactory {

    public static WinningGenerator create(String winning) {
        return new WinningGenerator(winning);
    }
}
