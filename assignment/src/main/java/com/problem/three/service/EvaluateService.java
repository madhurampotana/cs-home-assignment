package com.problem.three.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EvaluateService {

	private static final Logger logger = LoggerFactory.getLogger(EvaluateService.class);

	public String doArithmeticEvaluation(String inputExpressions) {
		Stack<String> stArthExp = new Stack<String>();
		List<String> splitExpBySpace = List.of(inputExpressions.split(" "));
		if (doValidate(splitExpBySpace)) {
			stArthExp.addAll(splitExpBySpace);
			return evaluationExpression(stArthExp);
		} else {
			return "error";
		}
	}

	private boolean doValidate(List<String> splitExpBySpace) {
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

	private static String evaluationExpression(Stack<String> arthExp) {
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
			return "error";
		else
			return "" + new BigDecimal(calArtExpst.pop()).setScale(2, RoundingMode.HALF_UP);
	}

}
