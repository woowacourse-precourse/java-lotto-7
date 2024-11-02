package service;

import domain.User;
import domain.WinningLotto;
import java.util.List;

public class UserService {

    public User init(int amount) {
        return new User(amount);
    }

    public void updateRateOfReturn(User user) {
        double rateOfReturn = calculateRateOfReturn(user);
        user.updateRateOfReturn(rateOfReturn);
    }

    private double calculateRateOfReturn(User user) {
        int totalPrizeMoney = calculateTotalPrizeMoney(user);
        return (double) totalPrizeMoney / user.getAmount() * 100;
    }

    private int calculateTotalPrizeMoney(User user){
        return user.getWinningLottos().stream()
                .mapToInt(WinningLotto::getPrizeMoney)
                .sum();
    }
}
