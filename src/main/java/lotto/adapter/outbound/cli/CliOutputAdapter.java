package lotto.adapter.outbound.cli;

import lotto.application.port.outbound.OutputPort;

public class CliOutputAdapter implements OutputPort {
    @Override
    public void writeMessage(String message) {
        System.out.println(message);
    }
}
