// Generated from C:/Users/Reda El Ouahabi/IdeaProjects/tp1antl/language/src/main/antlr/org/redael/julia\calculang.g4 by ANTLR 4.8
package main.antlr.org.redael.julia;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link calculangParser}.
 */
public interface calculangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link calculangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(calculangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link calculangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(calculangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link calculangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(calculangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link calculangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(calculangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link calculangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(calculangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link calculangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(calculangParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link calculangParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void enterMathExpression(calculangParser.MathExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link calculangParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void exitMathExpression(calculangParser.MathExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link calculangParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(calculangParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link calculangParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(calculangParser.NumberContext ctx);
}