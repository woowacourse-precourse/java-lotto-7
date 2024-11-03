package lotto.core.controller;

import lotto.core.controller.request.Request;
import lotto.core.controller.response.Response;

public interface Controller<Req extends Request, Res extends Response> {

    Res request(Req request);

}
