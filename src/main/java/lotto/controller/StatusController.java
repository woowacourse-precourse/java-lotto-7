package lotto.controller;

import lotto.dto.WinnerStatusDto;
import lotto.service.StatusService;
import lotto.viewer.Viewer;

public class StatusController {

    private final StatusService statusService;
    private final Viewer viewer;

    public StatusController(StatusService statusService, Viewer viewer) {
        this.statusService = statusService;
        this.viewer = viewer;
    }

    public void print() {
        WinnerStatusDto winnerStatusDto = statusService.calculate();
        viewer.printMessage(winnerStatusDto.message());
    }
}
