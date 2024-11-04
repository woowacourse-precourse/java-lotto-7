package lotto;

import lotto.winning.WinningController;
import lotto.winning.WinningService;
import lotto.winning.WinningServiceImpl;

import lotto.vendingmachine.VendingMachineController;
import lotto.vendingmachine.VendingMachineRepository;
import lotto.vendingmachine.VendingMachineRepositoryImpl;
import lotto.vendingmachine.VendingMachineService;
import lotto.vendingmachine.VendingMachineServiceImpl;

public class AppConfig {

    public VendingMachineController vendingMachineController() {
        return new VendingMachineController(vendingMachineService());
    }

    public VendingMachineService vendingMachineService() {
        return new VendingMachineServiceImpl(vendingMachineRepository());
    }

    public WinningController winningController() {
        return new WinningController(winningService());
    }

    public WinningService winningService() {
        return new WinningServiceImpl(vendingMachineRepository());
    }

    public VendingMachineRepository vendingMachineRepository() {
        return new VendingMachineRepositoryImpl();
    }
}

