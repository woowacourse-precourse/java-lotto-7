package lotto.controller;

import java.util.List;
import lotto.service.input.InputService;
import lotto.service.input.InputServiceImpl;
import lotto.service.input.converter.BallEntryConverterService;
import lotto.service.input.converter.BallInputConverterService;
import lotto.service.input.validator.BallEntryValidator;
import lotto.service.input.validator.LuckyBallInputValidator;
import lotto.service.lotteryhost.HostService;
import lotto.service.lotteryhost.HostServiceImpl;
import lotto.view.UserInput;
import lotto.view.constant.InputInfo;

public class HostController {

    private static HostController instance = new HostController();

    private InputService<List<Integer>> ballEntryInputService;
    private InputService<Integer> luckyBallInputService;

    private HostController() {
    }

    private void getBallEntry() {
        ballEntryInputService = new InputServiceImpl<>(new BallEntryValidator(), new BallEntryConverterService());
        getInput(ballEntryInputService, InputInfo.WINNING_NUMBER);
    }

    private void getLuckyBall() {
        luckyBallInputService = new InputServiceImpl<>(
                new LuckyBallInputValidator(BallEntryValidator.getBallInputEntry()), new BallInputConverterService());
        getInput(luckyBallInputService, InputInfo.LUCKY_NUMBER);
    }

    private void getInput(InputService<?> inputService, InputInfo inputInfo) {
        String input = UserInput.get(inputInfo.guide());
        try {
            inputService.validate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getInput(inputService, inputInfo);
        }
    }

    public void run() {
        getBallEntry();
        getLuckyBall();
        createReport();
    }

    private void createReport() {
        HostService hostService = HostServiceImpl.getInstance(ballEntryInputService, luckyBallInputService);
        hostService.getReport();
    }

    public static HostController getController() {
        if (instance == null) {
            instance = new HostController();
        }
        return instance;
    }
}
