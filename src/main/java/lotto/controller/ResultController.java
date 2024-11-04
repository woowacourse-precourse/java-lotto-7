package lotto.controller;

import lotto.service.ResultService;
import lotto.model.Result;

public class ResultController {
    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    public Result processResult() {
        Result result = resultService.createResult();
        return result;
    }
}
