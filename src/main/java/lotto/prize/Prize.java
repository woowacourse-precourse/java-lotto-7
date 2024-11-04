package lotto.prize;

import java.text.DecimalFormat;

public enum Prize {
	FIFTH(3, false, 5_000),
	FOURTH(4, false, 50_000),
	THIRD(5, false, 1_500_000),
	SECOND(5, true, 30_000_000),
	FIRST(6, false, 2_000_000_000);
	
	private final int amount;
	private final int count;
	private final boolean hasBonus;
	
	Prize(int count, boolean hasBonus, int amount) {
		this.count = count;
		this.hasBonus = hasBonus;
		this.amount = amount;
	}
	
	public int getCount() {
		return count;
	}

	public boolean hasBonus() {
		return hasBonus;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		appendCount(sb);
		appendBonus(sb);
		appendAmount(sb);

		return sb.toString();
	}
	
	private void appendCount(final StringBuilder sb) {
		sb.append(count).append("개 일치");
	}
	
	private void appendBonus(final StringBuilder sb) {
		if (hasBonus) {
			sb.append(", 보너스 볼 일치");
		}
	}
	
	private void appendAmount(final StringBuilder sb) {
		DecimalFormat formatter = new DecimalFormat("###,###");
		sb.append(" (").append(formatter.format(amount)).append("원) - ");
	}
}
