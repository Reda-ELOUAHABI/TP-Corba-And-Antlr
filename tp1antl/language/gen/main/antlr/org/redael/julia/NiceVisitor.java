// Generated from C:/Users/Reda El Ouahabi/IdeaProjects/tp1antl/language/src/main/antlr/org/redael/julia\Nice.g4 by ANTLR 4.8
package main.antlr.org.redael.julia;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NiceParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NiceVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NiceParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(NiceParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link NiceParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(NiceParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link NiceParser#greeting}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreeting(NiceParser.GreetingContext ctx);
	/**
	 * Visit a parse tree produced by {@link NiceParser#introduction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntroduction(NiceParser.IntroductionContext ctx);
}