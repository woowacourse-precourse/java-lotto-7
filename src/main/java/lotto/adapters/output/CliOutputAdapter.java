package lotto.adapters.output;

import lotto.application.dto.response.Response;
import lotto.application.port.output.OutputPort;

public class CliOutputAdapter implements OutputPort {

    @Override
    public void writeMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void writeNewline() {
        System.out.println();
    }

    @Override
    public void writeResponse(Response response) {
        System.out.println(response);
    }
}
