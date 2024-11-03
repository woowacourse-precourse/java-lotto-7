package lotto.controller;

import lotto.dto.WinningNumbersRequestDto;
import lotto.handler.WinningNumbersHandler;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbersController {
    public static List<Integer> convertWinningNumbers(String winningNumbers) {
        List<Integer> parsedWinningNumbers = new ArrayList<>();
        String[] winningNumbersList = winningNumbers.split(",");
        for(String token : winningNumbersList) {
            parsedWinningNumbers.add(Integer.parseInt(token));
        }
        return parsedWinningNumbers;
    }
    public static WinningNumbersRequestDto run() {
        String winningNumbers = InputView.requestWinningNumbers();
        WinningNumbersHandler.handle(winningNumbers);

        return new WinningNumbersRequestDto(convertWinningNumbers(winningNumbers));
    }
    public static void restart() {
        run();
    }
}

