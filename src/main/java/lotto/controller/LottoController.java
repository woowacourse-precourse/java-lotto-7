package lotto.controller;

import static lotto.exception.errorMessage.IllegalArgumentExceptionMessage.NUMBER_FORMAT;

import java.util.List;
import lotto.dto.PaperDto;
import lotto.service.paper.PaperService;
import lotto.view.View;

public class LottoController {
    private final View view;
    private final PaperService paperService;

    public LottoController(View view, PaperService paperService) {
        this.view = view;
        this.paperService = paperService;
    }

    public void start() {
        saveLotto();
        printLottoList();
    }

    private void printLottoList() {
        List<PaperDto> paperDto = paperService.getAllPaper();
        view.printPaperStatus(paperDto);
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
