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
	 * Enter a parse tree produced by {@link RationnelParser#affect}.
	 * @param ctx the parse tree
	 */
	void enterAffect(RationnelParser.AffectContext ctx);
	/**
	 * Exit a parse tree produced by {@link RationnelParser#affect}.
	 * @param ctx the parse tree
	 */
	void exitAffect(RationnelParser.AffectContext ctx);
	/**
	 * Enter a parse tree produced by {@link RationnelParser#affectReg}.
	 * @param ctx the parse tree
	 */
	void enterAffectReg(RationnelParser.AffectRegContext ctx);
	/**
	 * Exit a parse tree produced by {@link RationnelParser#affectReg}.
	 * @param ctx the parse tree
	 */
	void exitAffectReg(RationnelParser.AffectRegContext ctx);
	/**
	 * Enter a parse tree produced by {@link RationnelParser#affectBool}.
	 * @param ctx the parse tree
	 */
	void enterAffectBool(RationnelParser.AffectBoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link RationnelParser#affectBool}.
	 * @param ctx the parse tree
	 */
	void exitAffectBool(RationnelParser.AffectBoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link RationnelParser#afficher}.
	 * @param ctx the parse tree
	 */
	void enterAfficher(RationnelParser.AfficherContext ctx);
	/**
	 * Exit a parse tree produced by {@link RationnelParser#afficher}.
	 * @param ctx the parse tree
	 */
	void exitAfficher(RationnelParser.AfficherContext ctx);
	/**
	 * Enter a parse tree produced by {@link RationnelParser#lireint}.
	 * @param ctx the parse tree
	 */
	void enterLireint(RationnelParser.LireintContext ctx);
	/**
	 * Exit a parse tree produced by {@link RationnelParser#lireint}.
	 * @param ctx the parse tree
	 */
	void exitLireint(RationnelParser.LireintContext ctx);
	/**
	 * Enter a parse tree produced by {@link RationnelParser#lireReg}.
	 * @param ctx the parse tree
	 */
	void enterLireReg(RationnelParser.LireRegContext ctx);
	/**
	 * Exit a parse tree produced by {@link RationnelParser#lireReg}.
	 * @param ctx the parse tree
	 */
	void exitLireReg(RationnelParser.LireRegContext ctx);
	/**
	 * Enter a parse tree produced by {@link RationnelParser#lireBool}.
	 * @param ctx the parse tree
	 */
	void enterLireBool(RationnelParser.LireBoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link RationnelParser#lireBool}.
	 * @param ctx the parse tree
	 */
	void exitLireBool(RationnelParser.LireBoolContext ctx);
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
	 * Enter a parse tree produced by {@link RationnelParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(RationnelParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link RationnelParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(RationnelParser.BoolContext ctx);
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