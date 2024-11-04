package lotto.controller;

import static lotto.exception.errorMessage.IllegalArgumentExceptionMessage.NUMBER_FORMAT;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.PaperDto;
import lotto.service.paper.PaperService;
import lotto.service.winning.WinningService;
import lotto.view.View;

public class LottoController {
    private final View view;
    private final PaperService paperService;
    private final WinningService winningService;

    public LottoController(View view, PaperService paperService, WinningService winningService) {
        this.view = view;
        this.paperService = paperService;
        this.winningService = winningService;
    }

    public void start() {
        saveLotto();
        printLottoList();
        saveWinningLotto();
    }

    private void printLottoList() {
        List<PaperDto> paperDto = paperService.getAllPaper();
        view.printPaperStatus(paperDto);
    }


    private void saveWinningLotto() {
        try {
            List<Integer> numbers = getWinningNumber();
            winningService.saveWinning(numbers);
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
            saveWinningLotto();
        }
    }

    private List<Integer> getWinningNumber() {
        List<Integer> winningNumber;
        String numbers = view.inputWinningLotto();
        try {
            winningNumber = convertToSortedList(numbers);
            winningService.saveWinning(winningNumber);
        } catch (NumberFormatException e) {
            view.printError(NUMBER_FORMAT.getMessage());
            winningNumber = getWinningNumber();
        }
        return winningNumber;
    }

    public List<Integer> convertToSortedList(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    private void saveLotto() {
        int amount = getPurchaseAmount();
        try {
            paperService.savePaper(amount);
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
            saveLotto();
        }
    }

    private int getPurchaseAmount() {
        String purchaseAmount = view.inputPurchaseAmount();
        int cost = 0;
        try {
            cost = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            view.printError(NUMBER_FORMAT.getMessage());
            cost = getPurchaseAmount();
        }
        return cost;
    }
}
