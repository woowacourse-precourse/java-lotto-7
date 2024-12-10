package lotto.domain;

import java.text.DecimalFormat;
import lotto.common.ErrorMessages;

public class PurchaseAmount {
    private static final int UNIT_PRICE = 1000;
    private static final int MAX_PURCHASE_AMOUNT = 100000;
    private static final int PERCENTAGE_CONVERSION_FACTOR = 100;
    private static final int ROUNDING_DECIMAL_SCALE = 100;
    private static final String YIELD_FORMAT_PATTERN = "#,##0.0";

    private final int amount;

    public PurchaseAmount(String input) {
        this.amount = parseAndValidateAmount(input);
    }

    private int parseAndValidateAmount(String input) {
        int parsedAmount = parseAmount(input);
        validatePositiveAndUnit(parsedAmount);
        validateMaximumAmount(parsedAmount);
        return parsedAmount;
    }

    private int parseAmount(String input) {
        validateNotNull(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PURCHASE_AMOUNT_INPUT_ERROR);
        }
    }

    private void validateNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessages.NULL_PURCHASE_AMOUNT);
        }
    }

    private void validatePositiveAndUnit(int amount) {
        if (amount <= 0 || amount % UNIT_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PURCHASE_AMOUNT_UNIT);
        }
    }

    private void validateMaximumAmount(int amount) {
        if (amount > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessages.EXCEEDED_PURCHASE_AMOUNT);
        }
    }

    public int getTicketCount() {
        return amount / UNIT_PRICE;
    }

    public String calculateYield(int totalPrize) {
        double yield = calculatePercentageYield(totalPrize);
        return formatYield(yield);
    }

    private double calculatePercentageYield(int totalPrize) {
        return roundToTwoDecimalPlaces((double) totalPrize / amount * PERCENTAGE_CONVERSION_FACTOR);
    }

    private String formatYield(double yield) {
        DecimalFormat formatter = new DecimalFormat(YIELD_FORMAT_PATTERN);
        return formatter.format(yield);
    }

    private double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * ROUNDING_DECIMAL_SCALE) / (double) ROUNDING_DECIMAL_SCALE;
    }
}
