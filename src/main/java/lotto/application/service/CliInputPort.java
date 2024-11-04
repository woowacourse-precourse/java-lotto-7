package lotto.application.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.application.port.inbound.InputPort;

public class CliInputPort implements InputPort {
    @Override
    public String get() {
        return Console.readLine();
    }
}
