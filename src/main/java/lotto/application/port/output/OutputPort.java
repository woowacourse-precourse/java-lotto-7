package lotto.application.port.output;

import lotto.application.dto.response.Response;

public interface OutputPort {

    void writeMessage(String message);

    void writeResponse(Response response);
}
