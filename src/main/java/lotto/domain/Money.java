package lotto.domain;

import lotto.util.Error;

public class Money {
    private final int amount;

    public Money(int amount) {
        validateNonZero(amount);
        validateDivisibility(amount);
        this.amount = amount;
    }

    private void validateNonZero(int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException(Error.MONEY_ZERO_ERROR.message());
        }
    }

    private void validateDivisibility(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(Error.MONEY_DIVIDE_ERROR.message());
        }
    }

    public int calculateNumberOfTickets() {
        return amount / 1000;
    }

    public double calculateRateOfReturn(int[] lottoRanks) {
        double totalWinnings = 0;
        for (int rank = 1; rank <= 5; rank++) {
            if (rank == 1) {
                totalWinnings += 200000000 * lottoRanks[rank];
            }
            if (rank == 2) {
                totalWinnings += 30000000 * lottoRanks[rank];
            }
            if (rank == 3) {
                totalWinnings += 1500000 * lottoRanks[rank];
            }
            if (rank == 4) {
                totalWinnings += 50000 * lottoRanks[rank];
            }
            if (rank == 5) {
                totalWinnings += 5000 * lottoRanks[rank];
            }
        }
        return (totalWinnings / amount) * 100;
    }
}
