package lotto;

import lotto.winning.WinningController;
import lotto.winning.DrawService;
import lotto.winning.DrawServiceImpl;

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

    public WinningController drawController() {
        return new WinningController(drawService());
    }

    public DrawService drawService() {
        return new DrawServiceImpl(vendingMachineRepository());
    }

    public VendingMachineRepository vendingMachineRepository() {
        return new VendingMachineRepositoryImpl();
    }
}

