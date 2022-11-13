package lotto.domain;

import java.util.regex.Pattern;

public class LottoStore {
	private static final Pattern numberPattern = Pattern.compile(Regex.UNIT.getExpression());

	private final int purchaseAmount;
	private final int numberOfTickets;

	public LottoStore(String scanPurchaseAmount) {
		validateUnit(scanPurchaseAmount);
		int purchaseAmount = Integer.parseInt(scanPurchaseAmount);
		validateZero(purchaseAmount);

		this.purchaseAmount = purchaseAmount;
		this.numberOfTickets = purchaseAmount / Number.UNIT.getValue();
	}

	public int getPurchaseAmount() {
		return purchaseAmount;
	}

	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	private void validateUnit(String userInput) {
		if (!numberPattern.matcher(userInput).matches()) {
			throw new IllegalArgumentException(String.format(Error.UNIT.getMessage(), Number.UNIT.getValue()));
		}
	}

	private void validateZero(int purchaseAmount) {
		if (purchaseAmount == 0) {
			throw new IllegalArgumentException(String.format(Error.ZERO.getMessage(), Number.UNIT.getValue()));
		}
	}
}
