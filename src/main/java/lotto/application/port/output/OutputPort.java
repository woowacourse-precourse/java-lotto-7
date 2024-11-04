package lotto.application.port.output;

import lotto.application.dto.response.Response;

public interface OutputPort {

    void writeMessage(String message);
    void writeNewline();

    void writeResponse(Response response);
}
