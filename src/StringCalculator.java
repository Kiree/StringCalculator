import java.util.Arrays;
import java.util.List;

public class StringCalculator {

	/**
	 * add(String numbersStr)
	 *
	 * Adds the given numbers together.
	 *
	 * @param numbersStr - The numbers in a string
	 * @return The sum of the numbers
	 */
	public int add(String numbersStr) throws StringCalculatorException {

		final int[] sum = {0};
		String regex = "[0-9, /,]+";

		// Check that the string is not null or empty
		if (numbersStr != null && !numbersStr.isEmpty()) {

			// Replace whitespace with comma
			numbersStr = numbersStr.replaceAll("\\s", ",");

			// Abort execution if string contains characters other than numbers [0-9] or comma [/,].
			if (!numbersStr.matches(regex)) {
				throw new StringCalculatorException();
			}

			List<String> numbersList = Arrays.asList(numbersStr.split(",")); // Assign the expected numbers to an array

			try {
				numbersList.forEach((currentItem) -> {
					if(!currentItem.isEmpty()) {
						sum[0] = sum[0] + Integer.parseInt(currentItem);
					}
				});
				return sum[0]; // Return the sum of the items
			} catch (NumberFormatException e) {
				throw new StringCalculatorException(); // Throw an error on invalid characters.
			}
		} else {
			return sum[0]; // Return 0 for null or empty string
		}
	}
}
