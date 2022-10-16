/**
 * Evaluation of arithmetic expressions written in Polish notation.
 * Expressions can contain double-precision floating point numbers and 
 * the following operations: addition, subtraction, division and multiplication.
 *
 */
package solve.problem.two;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author MadhuRamPotana@gmail.com
 *
 */
public class ProblemTwoApp {
	public static void main(String[] args) {
		List<String> listInputExpressions = new ArrayList<String>();
		boolean isReadNextLine = true;
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Please enter the arithmetic expressions : ");
			StringBuilder terminatingCheck = new StringBuilder("q");
			do {
				if (scanner.hasNext()) {
					StringBuilder sb = new StringBuilder(scanner.nextLine());
					if (sb.compareTo(terminatingCheck) == 0) {
						scanner.close();
						isReadNextLine = false;
						break;
					} else
						listInputExpressions.add(sb.toString().trim());
				}

			} while (isReadNextLine);
		}

		for (String loopEachExpLine : listInputExpressions) {
			Stack<String> stArthExp = new Stack<String>();
			List<String> splitExpBySpace = List.of(loopEachExpLine.split(" "));
			try {
				if (doValidate(splitExpBySpace)) {
					stArthExp.addAll(splitExpBySpace);
					evaluationExpression(stArthExp);
				}else {
					System.out.println("error");
				}
			} catch (Exception ex) {
				System.out.println("error");
			}
		}
	}

	private static boolean doValidate(List<String> splitExpBySpace) {
		int countNumbers = 0, countArthExp = 0;
		for (String strExp : splitExpBySpace) {
			try {
				Double.parseDouble(strExp);
				countNumbers++;
			} catch (Exception Ex) {
				if (strExp.matches("[\\-*/+]+")) {
					countArthExp++;
				} else {
					return false;
				}
			}
		}
		if (countNumbers == 1 && countArthExp > 0)
			return false;
		else if (countNumbers > 1 && countArthExp == 0)
			return false;
		return true;
	}

	private static void evaluationExpression(Stack<String> arthExp) {
		Stack<Double> calArtExpst = new Stack<Double>();

		while (!arthExp.isEmpty()) {
			String evolveExp = arthExp.pop();
			switch (evolveExp) {
			case "+" -> calArtExpst.push(calArtExpst.pop() + calArtExpst.pop());
			case "-" -> calArtExpst.push(calArtExpst.pop() - calArtExpst.pop());
			case "*" -> calArtExpst.push(calArtExpst.pop() * calArtExpst.pop());
			case "/" -> calArtExpst.push(calArtExpst.pop() / calArtExpst.pop());
			default -> calArtExpst.push(Double.valueOf(evolveExp));
			}
		}
		if (calArtExpst.size() > 1)
			System.out.println("error");
		else
			System.out.println(new BigDecimal(calArtExpst.pop()).setScale(2, RoundingMode.HALF_UP));
	}
}
