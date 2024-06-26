package org.mp.sesion06.evaluador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.mp.sesion05.colas.Queue;
import org.mp.sesion05.pilas.Stack;

// TODO: Auto-generated Javadoc
/**
 * The Class Evaluador.
 */
public class Evaluador {

	/** pila. */
	private Stack<Integer> pila;
	
	/** cola. */
	private Queue<String> cola;

	/**
	 * Instancia evaluador.
	 *
	 * @param pila the pila
	 * @param cola the cola
	 */
	public Evaluador(Stack<Integer> pila, Queue<String> cola) {
		this.pila = pila;
		this.cola = cola;
	}

	/**
	 * Eliminar blancos.
	 *
	 * @param expresion the expresion
	 * @return the string[]
	 */
	public String[] eliminarBlancos(String expresion) {
		String regex = "(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)|(?<=\\D)(?=\\D)";
		String[] tokens = expresion.split(regex);

		List<String> tokenList = new ArrayList<>();
		for (String token : tokens) {
			if (!token.trim().isEmpty()) {
				tokenList.add(token.trim());
				cola.enqueue(token.trim());
			}
		}
		return tokenList.toArray(new String[0]);
	}

	/**
	 * Procesar un operador.
	 *
	 * @param op the op
	 * @param operandosPila the operandos pila
	 */
	public void procesarUnOperador(char op, Stack<Integer> operandosPila) {
		int operand2 = operandosPila.pop();
		int operand1 = operandosPila.pop();
		Integer resultado = null;

		switch (op) {
		case '+':
			resultado = operand1 + operand2;
			break;
		case '-':
			resultado = operand1 - operand2;
			break;
		case '*':
			resultado = operand1 * operand2;
			break;
		case '/':
			if (operand2 == 0) {
				throw new RuntimeException("No es posible una división por cero");
			}
			resultado = operand1 / operand2;
			break;
		}
		operandosPila.push(resultado);
	}

	/**
	 * Evaluar expresion.
	 *
	 * @param expresion the expresion
	 * @return the int
	 */
	public int evaluarExpresion(String expresion) {
		String[] tokens = eliminarBlancos(expresion);

		if (Arrays.stream(tokens).allMatch(token -> !esOperador(token))) {
			StringBuilder concatenacion = new StringBuilder();
			for (String token : tokens) {
				concatenacion.append(token);
			}
			return Integer.parseInt(concatenacion.toString());
		}

		for (String token : tokens) {
			if (esOperador(token)) {
				int op2 = pila.pop();
				int op1 = pila.pop();
				switch (token) {
				case "+":
					pila.push(op1 + op2);
					break;
				case "-":
					pila.push(op1 - op2);
					break;
				case "*":
					pila.push(op1 * op2);
					break;
				case "/":
					if (op2 != 0) {
						pila.push(op1 / op2);
					} else {
						throw new ArithmeticException();
					}
					break;
				}
			} else {
				pila.push(Integer.parseInt(token));
			}
		}
		return pila.pop();
	}

	/**
	 * Solo digitos.
	 *
	 * @param expresion the expresion
	 * @return true, if successful
	 */
	private boolean soloDigitos(String expresion) {
		return expresion.matches("\\d+");
	}

	/**
	 * Es operador.
	 *
	 * @param token the token
	 * @return true, if successful
	 */
	private boolean esOperador(String token) {
		return "+-*/".contains(token);
	}

}
