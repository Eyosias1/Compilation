// Generated from Rationnel.g4 by ANTLR 4.9.2

    import java.util.*;
    import java.io.FileOutputStream;
    import java.io.FileWriter;
    import java.io.File;



import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RationnelParser}.
 */
public interface RationnelListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RationnelParser#calcul}.
	 * @param ctx the parse tree
	 */
	void enterCalcul(RationnelParser.CalculContext ctx);
	/**
	 * Exit a parse tree produced by {@link RationnelParser#calcul}.
	 * @param ctx the parse tree
	 */
	void exitCalcul(RationnelParser.CalculContext ctx);
	/**
	 * Enter a parse tree produced by {@link RationnelParser#finInstruction}.
	 * @param ctx the parse tree
	 */
	void enterFinInstruction(RationnelParser.FinInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RationnelParser#finInstruction}.
	 * @param ctx the parse tree
	 */
	void exitFinInstruction(RationnelParser.FinInstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RationnelParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(RationnelParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link RationnelParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(RationnelParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link RationnelParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(RationnelParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RationnelParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(RationnelParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RationnelParser#exprReg}.
	 * @param ctx the parse tree
	 */
	void enterExprReg(RationnelParser.ExprRegContext ctx);
	/**
	 * Exit a parse tree produced by {@link RationnelParser#exprReg}.
	 * @param ctx the parse tree
	 */
	void exitExprReg(RationnelParser.ExprRegContext ctx);
	/**
	 * Enter a parse tree produced by {@link RationnelParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(RationnelParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link RationnelParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(RationnelParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link RationnelParser#exprRegbool}.
	 * @param ctx the parse tree
	 */
	void enterExprRegbool(RationnelParser.ExprRegboolContext ctx);
	/**
	 * Exit a parse tree produced by {@link RationnelParser#exprRegbool}.
	 * @param ctx the parse tree
	 */
	void exitExprRegbool(RationnelParser.ExprRegboolContext ctx);
}