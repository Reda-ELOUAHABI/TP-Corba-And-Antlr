// Generated from C:/Users/Reda El Ouahabi/IdeaProjects/tp1antl/language/src/main/antlr/org/redael/julia\Nice.g4 by ANTLR 4.8
package main.antlr.org.redael.julia;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NiceParser}.
 */
public interface NiceListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NiceParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(NiceParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link NiceParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(NiceParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link NiceParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(NiceParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NiceParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(NiceParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NiceParser#greeting}.
	 * @param ctx the parse tree
	 */
	void enterGreeting(NiceParser.GreetingContext ctx);
	/**
	 * Exit a parse tree produced by {@link NiceParser#greeting}.
	 * @param ctx the parse tree
	 */
	void exitGreeting(NiceParser.GreetingContext ctx);
	/**
	 * Enter a parse tree produced by {@link NiceParser#introduction}.
	 * @param ctx the parse tree
	 */
	void enterIntroduction(NiceParser.IntroductionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NiceParser#introduction}.
	 * @param ctx the parse tree
	 */
	void exitIntroduction(NiceParser.IntroductionContext ctx);
}