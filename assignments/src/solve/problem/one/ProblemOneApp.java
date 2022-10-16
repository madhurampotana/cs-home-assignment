/**
 * You are given an array of n unique integers a = a[0], a[1], ... , a[n - 1] and an integer value k.
 * Find and print the number of pairs (a[i], a[j]) where i < j and a[i] + a[j] = k.
 *
 */
package solve.problem.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author MadhuRamPotana@gmail.com
 *
 */
public class ProblemOneApp {

	public static void main(String[] args) {
		int inputCriteriaSum, matchingPairCount = 0;
		Set<Integer> sortedInput = new TreeSet<Integer>();
		// Accept the input until it get's non Integer
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Please enter the matching criteria number : ");
			inputCriteriaSum = scanner.nextInt();
			System.out.println("Please enter the array values one value per line : ");
			do {
				if (scanner.hasNextInt())
					sortedInput.add(scanner.nextInt());
				else
					break;
			} while (true);
		}

		List<Integer> listInput = new ArrayList<Integer>(sortedInput);
		int inputArraySize = listInput.size();
		// Loop to match sum with criteria and break if sum exceeds as it natural sorted
		for (int i = 0; i < inputArraySize; i++) {
			for (int j = i + 1; j < inputArraySize; j++) {
				int calculatedCriteriaSum = listInput.get(i) + listInput.get(j);
				if (calculatedCriteriaSum == inputCriteriaSum)
					matchingPairCount++;
				else if (calculatedCriteriaSum > inputCriteriaSum)
					break;
			}
		}
		System.out.println("The number of matching pair's : " + matchingPairCount);
	}

}
