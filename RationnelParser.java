// Generated from Rationnel.g4 by ANTLR 4.9.2

    import java.util.*;
    import java.io.FileOutputStream;
    import java.io.FileWriter;
    import java.io.File;



import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RationnelParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, TYPE=31, IDENTIFIANT=32, 
		NEWLINE=33, WS=34, ENTIER=35, BOOLEAN=36, FININSTRUCTIONS=37, UNMATCH=38;
	public static final int
		RULE_calcul = 0, RULE_finInstruction = 1, RULE_decl = 2, RULE_instruction = 3, 
		RULE_exprReg = 4, RULE_op = 5, RULE_exprRegbool = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"calcul", "finInstruction", "decl", "instruction", "exprReg", "op", "exprRegbool"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "']'", "'[+'", "'+]'", "'[-'", "'-]'", "'**'", "'*'", "':'", 
			"'+'", "'-'", "'<='", "'/'", "'%'", "'num('", "')'", "'sim('", "'denum('", 
			"'pgcd('", "','", "'ppcm('", "'('", "'not'", "'and'", "'or'", "'>'", 
			"'<'", "'>='", "'=='", "'<>'", null, null, null, null, null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "TYPE", "IDENTIFIANT", "NEWLINE", 
			"WS", "ENTIER", "BOOLEAN", "FININSTRUCTIONS", "UNMATCH"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Rationnel.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	  /*HashMap<String, MonType> tablesSymboles = new HashMap<>();
	  int comtvar = 0;

	  String decla(String identifiant, String type) {
	    String code = "";
	    tablesSymboles.put(type, new MonType(identifiant, comtvar));
	    code += "PUSHI 0\n" + "STOREG " + comtvar + "\n" ;
	    comtvar++;
	    return code;
	  }*/
	  int compteur_de_label = 0;
	  String calculerPGCD(String c_code, String d_code) {
	      String code =
	                /// pgcd x,n
	                // mémoire
	                // ?, ?, ?, ?, ?, ?
	                // stocker le x et n finale
	                // entete de la pile x puis enbas n
	                c_code +
	                "STOREG 0\n" + // stocker x
	                d_code +
	                "STOREG 1\n" + // stocker n
	                // x, n, ?, ?, ?, ?
	                "LABEL 6\n" +
	                "PUSHG 1\n" + // pousser n
	                "JUMPF 7\n" + // si n est 0 pas de calcul
	                // modulo
	                "PUSHG 1\n" + // pousse n
	                "STOREG 4\n" + // ajoute l'ancien n
	                // x, n, ?, ?, n_ancier, ?
	                "PUSHG 0\n" + // pousse x
	                "PUSHG 1\n" + // pousse n
	                "DIV\n" +
	                "STOREG 2\n" + // on ajoute le résultat du quotient à l'adresse 2
	                // x, n, quotient, ?, n_ancier, ?
	                "PUSHG 2\n" + // pouusse le quotion
	                "PUSHG 1\n" + // on poussse n
	                "MUL\n" + // multiplie par n
	                "STOREG 3\n" + // stocke  produit à l'adresse 3
	                // x, n, quotient, produit, n_ancier, ?
	                "PUSHG 0\n" + // on pousse x
	                "PUSHG 3\n" + // on pousse le produit
	                "SUB\n" + // on soustrait de x le produit
	                "STOREG 1\n" +
	                // x, n_nouv, quotient, produit, n_ancier, ?
	                "PUSHG 4\n" + //  // Pousse l'ancien n
	                "STOREG 0\n" + // Stocke l'ancien n dans nouveau x à l'adresse 0
	                // x_remplacer, n_nouv, quotient, produit, n_ancier, ?
	                "JUMP 6\n" + // RECOMMENCER
	                "LABEL 7\n" +
	                "PUSHG 0\n" ; // pgcd
	      return code;
	    }

	  String calculerPPCM(String c_code, String d_code) {
	    String code =
	                c_code +
	                "STOREG 4\n" + // stocker x
	                d_code +
	                "STOREG 5\n" + // stocker n
	                /// pgcd x,n
	                // mémoire
	                // 0, 1, 2, 3, 4, 5, 6
	                // ?, ?, ?, ?, x, n, ?
	                // stocker le x et n finale
	                // entete de la pile x puis enbas n
	                "PUSHG 4\n" +
	                "STOREG 0\n" + // stocker x
	                "PUSHG 5" +
	                "STOREG 1\n" + // stocker n
	                // 0, 1, 2, 3, 4, 5, 6
	                // x, n, ?, ?, x, n, ?
	                "LABEL 8\n" +
	                "PUSHG 1\n" +
	                "JUMPF 9\n" +
	                // modulo
	                "PUSHG 1\n" + // pousse n
	                "STOREG 3\n" + // ajoute l'ancien n
	                // 0, 1, 2, 3, 4, 5, 6
	                // x, n, ?, n_ancier, x, n, ?
	                "PUSHG 0\n" + // pousse x
	                "PUSHG 1\n" + // pousse n
	                "DIV\n" +
	                "STOREG 2\n" + // on ajoute le résultat du quotient à l'adresse 2
	                // 0, 1, 2, 3, 4, 5, 6
	                // x, n, qotient, n_ancier, x, n, ?
	                "PUSHG 2\n" + // pouusse le quotion
	                "PUSHG 1\n" + // on poussse n
	                "MUL\n" + // multiplie par n
	                "STOREG 2\n" + // stocke  produit à l'adresse 3
	                // x, n, produit, n_ancier, x, n, ?
	                // x, n, quotient, produit, n_ancier, x, n
	                "PUSHG 0\n" + // on pousse x
	                "PUSHG 2\n" + // on pousse le produit
	                "SUB\n" + // on soustrait de x le produit
	                "STOREG 1\n" +
	                // x, n_nouv, produit, n_ancier, x, n, ?
	                // x, n_nouv, quotient, produit, n_ancier, x, n
	                "PUSHG 3\n" + //  // Pousse l'ancien n
	                "STOREG 0\n" + // Stocke l'ancien n dans nouveau x à l'adresse 0
	                // x_remplacer, n_nouv, produit, n_ancier, x, n, ?
	                //"PUSHI 0\n" + a voir
	                "JUMP 8\n" + // RECOMMENCER
	                "LABEL 9\n" +
	                // x_remplacer, n_nouv, produit, n_ancier, x, n, ?
	                "PUSHG 4\n" +
	                "PUSHG 5\n" +
	                "MUL\n" +
	                "PUSHG 0\n" + // le PGCD
	                "DIV\n" ;
	    return code;
	    }
	  String simplifierRationnel(String numerateur, String denominateur) {
	        String code = calculerPGCD(numerateur, denominateur);
	        // x_remplacer, n_nouv, quotient, produit, n_ancier, ?
	        // pgcd, ?, ?, ?, ?, ?
	        code +=
	          "STOREG 0\n" + // pgcd, ?, ?, ?, ?, ?  mettre le pgcd a l'addresse 0 tampon
	          "PUSHI " + numerateur + "\n" +
	          "PUSHG 0\n" + //pgcd
	          "DIV\n"+
	          "STOREG 1\n" + // pgcd, num, ?, ?, ?, ?
	          "PUSHI " + denominateur + " \n" +
	          "PUSHG 0\n" +
	          "DIV\n"+
	          "STOREG 2\n" + // pgcd, num, denum, ?, ?, ?
	          "PUSHG 1\n" + // num
	          "PUSHG 2\n"; // deno
	        return code;
	    }

	  String calcul_pourcentage(String a_code, String b_code) {
	    String code = simplifierRationnel(a_code, b_code);
	    code +=
	            "STOREG 1\n" + // mettre le denominateur a l'adress 1
	            "STOREG 0\n" + // mettre le numerateur a l'adresse 0
	            "PUSHG 0\n" +
	            "PUSHI 100\n" +
	            "MUL\n" +
	            "PUSHG 1\n" +
	            "PUSHI 2\n" +
	            "DIV\n"+
	            "ADD\n"+
	            "PUSHG 1\n"+
	            "DIV\n";
	    return code;
	  }

	  String calcul_expr_reg_bool(String e_code, String f_code, String operateur)
	  {
	    String code = "";
	    if(operateur == "and") {
	      code +=
	              e_code +
	              "JUMPF 9\n" +
	              "PUSHI 1\n" +
	              "STOREG 0\n" + // on stocke la valuer boolean de e_code
	              f_code +
	              "STOREG 1\n" +
	              "PUSHG 0\n" +
	              "PUSHG 1\n" +
	              "MUL\n" +
	              "LABEL 9\n" +
	              "PUSHI 0\n";
	    }
	    else if (operateur == "or") {
	      code +=
	              e_code +
	              "STOREG 0\n" + // on stocke la valuer boolean de e_code
	              f_code +
	              "STOREG 1\n" + // on stocke la valuer boolean de f_code
	              "PUSHG 0\n" +
	              "PUSHG 1\n" +
	              "ADD\n";
	    }
	    else {
	      code +=
	                e_code +
	                // ?, ?, ?, ?, ?, ?,
	                "STOREG 1\n" +
	                "STOREG 0\n" +
	                // num_e, deno_e, ?, ?, ?, ?,
	                f_code +
	                "STOREG 3\n" +
	                "STOREG 2\n" +
	                // num_e, deno_e, num_f, deno_f, ?, ?,
	                "PUSHG 1\n"+
	                "PUSHG 3\n"+
	                "NEQ\n"+
	                "JUMPF 10\n" +
	                "PUSHG 1\n" +
	                "PUSHG 3\n" +
	                "MUL\n" +
	                "STOREG 4\n" +
	                "PUSHG 0\n" +
	                "PUSHG 4\n" +
	                "MUL\n" +
	                "STOREG 0\n" +
	                "PUSHG 1\n" +
	                "PUSHG 4\n" +
	                "MUL\n" +
	                "STOREG 1\n" +
	                // num_e, deno_e, num_f, deno_f, ?, ?,
	                "LABEL 10\n" +
	                "PUSHG 0\n" +
	                "PUSHG 2\n" +
	                operateur  + // on compare num_e et num_f
	                "\n";
	    }
	    return code;
	  }

	public RationnelParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CalculContext extends ParserRuleContext {
		public String code;
		public DeclContext decl;
		public InstructionContext instruction;
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(RationnelParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RationnelParser.NEWLINE, i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public CalculContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calcul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RationnelListener ) ((RationnelListener)listener).enterCalcul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RationnelListener ) ((RationnelListener)listener).exitCalcul(this);
		}
	}

	public final CalculContext calcul() throws RecognitionException {
		CalculContext _localctx = new CalculContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_calcul);
		 ((CalculContext)_localctx).code =  new String() + "ALLOC 8\n"; 
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(14);
				((CalculContext)_localctx).decl = decl();
				 _localctx.code += ((CalculContext)_localctx).decl.code; 
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(25);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(22);
					match(NEWLINE);
					}
					} 
				}
				setState(27);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__4) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << NEWLINE) | (1L << ENTIER) | (1L << FININSTRUCTIONS))) != 0)) {
				{
				{
				setState(28);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.code += "FREE 8\nHALT\n"; 
			}
			_ctx.stop = _input.LT(-1);
			 System.out.println(_localctx.code); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FinInstructionContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(RationnelParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RationnelParser.NEWLINE, i);
		}
		public List<TerminalNode> FININSTRUCTIONS() { return getTokens(RationnelParser.FININSTRUCTIONS); }
		public TerminalNode FININSTRUCTIONS(int i) {
			return getToken(RationnelParser.FININSTRUCTIONS, i);
		}
		public FinInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RationnelListener ) ((RationnelListener)listener).enterFinInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RationnelListener ) ((RationnelListener)listener).exitFinInstruction(this);
		}
	}

	public final FinInstructionContext finInstruction() throws RecognitionException {
		FinInstructionContext _localctx = new FinInstructionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(39); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(38);
					_la = _input.LA(1);
					if ( !(_la==NEWLINE || _la==FININSTRUCTIONS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(41); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public String code;
		public TerminalNode TYPE() { return getToken(RationnelParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(RationnelParser.IDENTIFIANT, 0); }
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RationnelListener ) ((RationnelListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RationnelListener ) ((RationnelListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(TYPE);
			setState(44);
			match(IDENTIFIANT);
			setState(45);
			finInstruction();
			 ;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionContext extends ParserRuleContext {
		public String code;
		public ExprRegContext exprReg;
		public ExprRegboolContext exprRegbool;
		public ExprRegContext exprReg() {
			return getRuleContext(ExprRegContext.class,0);
		}
		public ExprRegboolContext exprRegbool() {
			return getRuleContext(ExprRegboolContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RationnelListener ) ((RationnelListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RationnelListener ) ((RationnelListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instruction);
		try {
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				((InstructionContext)_localctx).exprReg = exprReg(0);
				((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).exprReg.code;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				((InstructionContext)_localctx).exprRegbool = exprRegbool(0);
				((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).exprRegbool.code;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ""; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprRegContext extends ParserRuleContext {
		public String code;
		public ExprRegContext a;
		public ExprRegContext k;
		public ExprRegContext h;
		public ExprRegContext z;
		public ExprRegContext b;
		public OpContext e;
		public OpContext op;
		public OpContext f;
		public Token c;
		public Token d;
		public ExprRegContext l;
		public List<ExprRegContext> exprReg() {
			return getRuleContexts(ExprRegContext.class);
		}
		public ExprRegContext exprReg(int i) {
			return getRuleContext(ExprRegContext.class,i);
		}
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
		public List<TerminalNode> ENTIER() { return getTokens(RationnelParser.ENTIER); }
		public TerminalNode ENTIER(int i) {
			return getToken(RationnelParser.ENTIER, i);
		}
		public ExprRegContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprReg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RationnelListener ) ((RationnelListener)listener).enterExprReg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RationnelListener ) ((RationnelListener)listener).exitExprReg(this);
		}
	}

	public final ExprRegContext exprReg() throws RecognitionException {
		return exprReg(0);
	}

	private ExprRegContext exprReg(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprRegContext _localctx = new ExprRegContext(_ctx, _parentState);
		ExprRegContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_exprReg, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(60);
				match(T__0);
				setState(61);
				((ExprRegContext)_localctx).z = exprReg(0);
				setState(62);
				match(T__1);

				    ((ExprRegContext)_localctx).code = 
				            // mémoire
				            // ?, ?, ?, ?, ?, ?
				            // stocker le numérateur et le dénominateur finale
				            // entete de la pile déno puis enbas num
				            ((ExprRegContext)_localctx).z.code +
				            "STOREG 1\n" + // stocker déno dans 1
				            "STOREG 0\n" + // stocker num dans 0
				            // num, déno, ?, ?, ?, ?
				            // pousser le dénominateur et le numérateur
				            "PUSHG 0\n" +
				            "PUSHG 1\n" +
				            "SUP\n" + // Compare déno et num
				            "JUMPF 0\n" +// jump label 0  si vrai on continue sinon si num inf deno on saute a 0
				            "PUSHG 0\n" +
				            "PUSHG 1\n" +
				            "DIV\n" +
				            "JUMP 1\n" + // jump label 1 end
				            "LABEL 0\n" + // label multiplicaiton
				            "PUSHG 0\n" +
				            "PUSHI 10\n" +
				            "MUL\n" +
				            "PUSHG 1\n" + // pousser le dénominateur
				            "DIV\n" + // diviser par le dénominateur
				            "PUSHI 5\n" +
				            "SUPEQ\n" + // resultat sup a 5
				            "JUMPF 2\n" + // label 2 zero , si le résultat est inferieur on saute a 0 pour etre arrondi
				            "PUSHI 1\n" + // Si résultat stric sup à 5, on arrondi à 1 et on pousse
				            "JUMP 1\n" + // jump label 1 end
				            "LABEL 2\n" + // label 2 zero
				            "PUSHI 0\n" + // cela veut dire on arrondi a 0
				            "LABEL 1\n" + // label end
				            "WRITE\n" +
				            "POP\n" ;
				    
				}
				break;
			case 2:
				{
				setState(65);
				match(T__2);
				setState(66);
				((ExprRegContext)_localctx).b = exprReg(0);
				setState(67);
				match(T__3);

				    ((ExprRegContext)_localctx).code = 
				            // mémoire
				            // ?, ?, ?, ?, ?, ?
				            // stocker le numérateur et le dénominateur finale
				            // entete de la pile déno puis enbas num
				            ((ExprRegContext)_localctx).b.code +
				            "STOREG 1\n" + // stocker déno dans 1
				            "STOREG 0\n" + // stocker num dans 0
				            // num, déno, ?, ?, ?, ?
				            // pousser le dénominateur et le numérateur
				            // on commence par faire num mod deno
				            "PUSHG 0\n" +
				            "PUSHG 1\n" +
				            "DIV\n" +
				            "STOREG 2\n" + // on ajoute le résultat du le quotient à l'adresse 2
				            // num, déno, quotient, ?, ?, ?
				            "PUSHG 2\n" +
				            "PUSHG 1\n" + // on poussse deno
				            "MUL\n" +
				            "STOREG 3\n" + // stocke  produit à l'adresse 3
				            // num, déno, quotient, produit, ?, ?
				            "PUSHG 0\n" + // on pousse num
				            "PUSHG 3\n" + // on pousse le produit
				            "SUB\n" + // on soustrait de x le produit
				            "PUSHI 0\n" +
				            "EQUAL\n" + // si le modulo est 0 alors le résultat de la division est pair
				            "JUMPF 3\n" +
				            "PUSHG 0\n" +
				            "PUSHG 1\n" +
				            "DIV\n" +
				            "LABEL 3\n" +
				            "PUSHG 0\n" +
				            "PUSHG 1\n" +
				            "DIV\n" +
				            "PUSHI 1\n" +
				            "ADD\n" +
				            "WRITE\n" ;
				  
				}
				break;
			case 3:
				{
				setState(70);
				match(T__4);
				setState(71);
				((ExprRegContext)_localctx).b = exprReg(0);
				setState(72);
				match(T__5);

				    ((ExprRegContext)_localctx).code = 
				            // entete de la pile déno puis enbas num
				            // pas besoin de se compliquer la command DIV le fait deja pour arrondir a l'inférieur
				            ((ExprRegContext)_localctx).b.code +
				            "DIV\n" +
				            "WRITE\n" ;
				  
				}
				break;
			case 4:
				{
				setState(75);
				((ExprRegContext)_localctx).e = ((ExprRegContext)_localctx).op = op(0);
				setState(76);
				match(T__12);
				setState(77);
				((ExprRegContext)_localctx).f = ((ExprRegContext)_localctx).op = op(0);
				setState(78);
				match(T__13);
				((ExprRegContext)_localctx).code =  calcul_pourcentage(((ExprRegContext)_localctx).e.code, ((ExprRegContext)_localctx).f.code) ;
				}
				break;
			case 5:
				{
				setState(81);
				match(T__14);
				setState(82);
				((ExprRegContext)_localctx).c = match(ENTIER);
				setState(83);
				match(T__12);
				setState(84);
				((ExprRegContext)_localctx).d = match(ENTIER);
				setState(85);
				match(T__15);
				((ExprRegContext)_localctx).code =  "PUSHI " + (((ExprRegContext)_localctx).c!=null?((ExprRegContext)_localctx).c.getText():null) + "\n";
				}
				break;
			case 6:
				{
				setState(87);
				match(T__16);
				setState(88);
				((ExprRegContext)_localctx).e = ((ExprRegContext)_localctx).op = op(0);
				setState(89);
				match(T__12);
				setState(90);
				((ExprRegContext)_localctx).f = ((ExprRegContext)_localctx).op = op(0);
				setState(91);
				match(T__15);
				((ExprRegContext)_localctx).code =  simplifierRationnel(((ExprRegContext)_localctx).e.code, ((ExprRegContext)_localctx).f.code);
				}
				break;
			case 7:
				{
				setState(94);
				match(T__17);
				setState(95);
				((ExprRegContext)_localctx).c = match(ENTIER);
				setState(96);
				match(T__12);
				setState(97);
				((ExprRegContext)_localctx).d = match(ENTIER);
				setState(98);
				match(T__15);
				((ExprRegContext)_localctx).code =  "PUSHI " + (((ExprRegContext)_localctx).d!=null?((ExprRegContext)_localctx).d.getText():null) + "\n";
				}
				break;
			case 8:
				{
				setState(100);
				((ExprRegContext)_localctx).op = op(0);
				((ExprRegContext)_localctx).code =  ((ExprRegContext)_localctx).op.code;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(134);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(132);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExprRegContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exprReg);
						setState(105);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(106);
						match(T__7);
						setState(107);
						((ExprRegContext)_localctx).b = exprReg(11);

						              ((ExprRegContext)_localctx).code = 
						                    // Prépare a et c pour la multiplication
						                    ((ExprRegContext)_localctx).a.code + // a, b
						                    "STOREG 2\n" + // Stocker b
						                    "STOREG 0\n" + // stocker a
						                    ((ExprRegContext)_localctx).b.code + // c, d
						                    "STOREG 3\n" + // Stocker d
						                    "STOREG 1\n" + // Stocker c
						                    "PUSHG 0\n" +  // Pousser a
						                    "PUSHG 1\n" +  // Pousser c
						                    "MUL\n" +       // Multiplie a et c
						                    "STOREG 4\n" + // Stocker le numérateur
						                    // "a,c,b,d,num,"
						                    // Prépare b et d pour la multiplication
						                    "PUSHG 2\n" +  // Pousser b
						                    "PUSHG 3\n" +  // Pousser d
						                    "MUL\n" +       // Multiplie b et d
						                    "STOREG 5\n" + // Stocker le numérateur
						                    // "a,c,b,d,num,deno"
						                    // pousser le numerateur et le denominateur pour des éventuelle calcule
						                    "PUSHG 4\n" +  // Pousser le numérateur
						                    "PUSHG 5\n" ;  // Pousser le dénominateur
						            
						}
						break;
					case 2:
						{
						_localctx = new ExprRegContext(_parentctx, _parentState);
						_localctx.k = _prevctx;
						_localctx.k = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exprReg);
						setState(110);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(111);
						match(T__8);
						setState(112);
						((ExprRegContext)_localctx).l = exprReg(10);

						              ((ExprRegContext)_localctx).code = 
						                    // TODO si les deux nombre sont entier les divisier par 1 par defaut

						                    // Prépare a et c pour la multiplication
						                    ((ExprRegContext)_localctx).k.code + // a, b
						                    "STOREG 2\n" + // Stocker b
						                    "STOREG 0\n" + // stocker a
						                    ((ExprRegContext)_localctx).l.code + // c, d
						                    "STOREG 1\n" + // Stocker d
						                    "STOREG 3\n" + // Stocker c
						                    "PUSHG 0\n" +  // Pousser a
						                    "PUSHG 1\n" +  // Pousser d
						                    "MUL\n" +       // Multiplie a et d
						                    "STOREG 4\n" + // Stocker le numérateur
						                    // "a,d,b,c,num,"
						                    // Prépare b et c pour la multiplication
						                    "PUSHG 2\n" +  // Pousser b
						                    "PUSHG 3\n" +  // Pousser c
						                    "MUL\n" +       // Multiplie b et d
						                    "STOREG 5\n" + // Stocker le numérateur
						                    // "a,d,b,c,num,deno"
						                    // pousser le numerateur et le denominateur pour des éventuelle calcule
						                    "PUSHG 4\n" +  // Pousser le numérateur
						                    "PUSHG 5\n" ;  // Pousser le dénominateur
						            
						}
						break;
					case 3:
						{
						_localctx = new ExprRegContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exprReg);
						setState(115);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(116);
						match(T__9);
						setState(117);
						((ExprRegContext)_localctx).b = exprReg(9);

						              ((ExprRegContext)_localctx).code = 
						                    // Prépare a et d pour la multiplication
						                    ((ExprRegContext)_localctx).a.code + // a, b
						                    // ?, ?, ?, ?, ?, ?, not_used, not_used
						                    "STOREG 6\n" + // Stocker b
						                    "STOREG 7\n" + // stocker a
						                    // 0, 1, 2, 3, 4, 5, 6, 7
						                    // ?, ?, ?, ?, ?, ?, b, a
						                    // il se peut que des valeur de ((ExprRegContext)_localctx).b.code utilise de 0 a 5
						                    ((ExprRegContext)_localctx).b.code + // c, d
						                    "STOREG 2\n" + // Stocker d
						                    "STOREG 0\n" + // Stocker c
						                    // c, ?, d, ?, ?, ?, b, a
						                    "PUSHG 6\n" +  // Pousser b
						                    "PUSHG 7\n" +  // Pousser a
						                    "STOREG 3\n" + // Stocker a
						                    "STOREG 1\n" + // Stocker b
						                    // "c,b,d,a,,,,"
						                    "PUSHG 3\n" +  // Pousser a
						                    "PUSHG 2\n" +  // Pousser d
						                    "MUL\n" +       // Multiplie a et d
						                    // "c,b,d,a,,,,"
						                    // Prépare c et b pour la multiplication
						                    "PUSHG 0\n" +  // Pousser c
						                    "PUSHG 1\n" +  // Pousser b
						                    "MUL\n" +       // Multiplie c et b
						                    // "c,b,d,a,,,,"
						                    // Additionne les résultats de multiplication
						                    "ADD\n" +
						                    "STOREG 4\n" + // Stocker le numérateur
						                    // "c,b,d,a,num,"
						                    // Prépare b et d pour la multiplication dénominateur commun
						                    "PUSHG 1\n" +  // Pousser b
						                    "PUSHG 2\n" +  // Pousser d
						                    "MUL\n" +       // Multiplie b et d
						                    "STOREG 5\n" + // Stocker le dénominateur
						                    // "c,b,d,a,num,deno"
						                    // pousser le numerateur et le denominateur pour des éventuelle calcule
						                    "PUSHG 4\n" +  // Pousser le numérateur
						                    "PUSHG 5\n" ;  // Pousser le dénominateur
						            
						}
						break;
					case 4:
						{
						_localctx = new ExprRegContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exprReg);
						setState(120);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(121);
						match(T__10);
						setState(122);
						((ExprRegContext)_localctx).b = exprReg(8);

						               ((ExprRegContext)_localctx).code = 
						                    // Prépare a et d pour la multiplication
						                    ((ExprRegContext)_localctx).a.code + // a, b
						                    "STOREG 1\n" + // Stocker b
						                    "STOREG 3\n" + // stocker a
						                    ((ExprRegContext)_localctx).b.code + // c, d
						                    "STOREG 2\n" + // Stocker d
						                    "STOREG 0\n" + // Stocker c
						                    "PUSHG 3\n" +  // Pousser a
						                    "PUSHG 2\n" +  // Pousser d
						                    "MUL\n" +       // Multiplie a et d
						                    // "c,b,d,a,,"
						                    // Prépare c et b pour la multiplication
						                    "PUSHG 0\n" +  // Pousser c
						                    "PUSHG 1\n" +  // Pousser b
						                    "MUL\n" +       // Multiplie c et b
						                    // "c,b,d,a,,"
						                    // Soustraire les résultats de multiplication
						                    "SUB\n" +
						                    "STOREG 4\n" + // Stocker le numérateur
						                    // "c,b,d,a,num,"
						                    // Prépare b et d pour la multiplication dénominateur commun
						                    "PUSHG 1\n" +  // Pousser b
						                    "PUSHG 2\n" +  // Pousser d
						                    "MUL\n" +       // Multiplie b et d
						                    "STOREG 5\n" + // Stocker le dénominateur
						                    // "c,b,d,a,num,deno"
						                    // pousser le numerateur et le denominateur pour des éventuelle calcule
						                    "PUSHG 4\n" +  // Pousser le numérateur
						                    "PUSHG 5\n" ;  // Pousser le dénominateur
						            
						}
						break;
					case 5:
						{
						_localctx = new ExprRegContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exprReg);
						setState(125);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(126);
						match(T__6);
						setState(127);
						((ExprRegContext)_localctx).e = ((ExprRegContext)_localctx).op = op(0);

						              ((ExprRegContext)_localctx).code = 
						                      // mémoire
						                      // ?, ?, ?, ?, ?, ?
						                      // stocker le numérateur et le dénominateur finale
						                      // entete de la pile déno puis enbas num
						                      ((ExprRegContext)_localctx).e.code +
						                      "STOREG 2\n" +
						                      ((ExprRegContext)_localctx).a.code +
						                      // on stocke num et deno
						                      "STOREG 1\n" +
						                      "STOREG 0\n" +
						                      // num, deno, n, ?, ?, ?
						                      // intilialer des resultat tmp
						                      "PUSHI 1\n" +
						                      "STOREG 3\n" +
						                      "PUSHI 1\n" +
						                      "STOREG 4\n" +
						                      // num, deno, n, tempnum, tempdeno, ?
						                      "LABEL 4\n" +
						                      "PUSHG 2\n" + // on pousse n
						                      "PUSHI 0\n" +
						                      "NEQ\n" +
						                      "JUMPF 5\n" +
						                      // num, deno, n, tempnum, tempdeno, ?
						                      "PUSHG 3\n" +
						                      "PUSHG 0\n" +
						                      "MUL\n" +
						                      "STOREG 3\n" + // stocke le nouveau temp num
						                      "PUSHG 4\n" +
						                      "PUSHG 1\n" +
						                      "MUL\n" +
						                      "STOREG 4\n" + // stocke le nouveau temp num
						                      "PUSHG 2\n" +
						                      "PUSHI 1\n" +
						                      "SUB\n" +
						                      "STOREG 2\n" + // on stocke n - 1
						                      "JUMP 4\n" +
						                      "LABEL 5\n" +
						                      // num, deno, n, tempnum, tempdeno, ?
						                      "PUSHG 3\n" +
						                      "PUSHG 4\n" ;
						            
						}
						break;
					case 6:
						{
						_localctx = new ExprRegContext(_parentctx, _parentState);
						_localctx.h = _prevctx;
						_localctx.h = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exprReg);
						setState(130);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(131);
						match(T__11);
						}
						break;
					}
					} 
				}
				setState(136);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class OpContext extends ParserRuleContext {
		public String code;
		public OpContext e;
		public OpContext c;
		public OpContext d;
		public Token ENTIER;
		public OpContext f;
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
		public TerminalNode ENTIER() { return getToken(RationnelParser.ENTIER, 0); }
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RationnelListener ) ((RationnelListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RationnelListener ) ((RationnelListener)listener).exitOp(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		return op(0);
	}

	private OpContext op(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OpContext _localctx = new OpContext(_ctx, _parentState);
		OpContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_op, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				{
				setState(138);
				match(T__18);
				setState(139);
				((OpContext)_localctx).c = op(0);
				setState(140);
				match(T__19);
				setState(141);
				((OpContext)_localctx).d = op(0);
				setState(142);
				match(T__15);

				        ((OpContext)_localctx).code =  calculerPGCD(((OpContext)_localctx).c.code, ((OpContext)_localctx).d.code);
				      
				}
				break;
			case T__20:
				{
				setState(145);
				match(T__20);
				setState(146);
				((OpContext)_localctx).c = op(0);
				setState(147);
				match(T__19);
				setState(148);
				((OpContext)_localctx).d = op(0);
				setState(149);
				match(T__15);

				      ((OpContext)_localctx).code = 
				                ((OpContext)_localctx).c.code +
				                "STOREG 4\n" + // stocker x
				                ((OpContext)_localctx).d.code +
				                "STOREG 5\n" + // stocker n
				                /// pgcd x,n
				                // mémoire
				                // 0, 1, 2, 3, 4, 5, 6
				                // ?, ?, ?, ?, x, n, ?
				                // stocker le x et n finale
				                // entete de la pile x puis enbas n
				                "PUSHG 4\n" +
				                "STOREG 0\n" + // stocker x
				                "PUSHG 5" +
				                "STOREG 1\n" + // stocker n
				                // 0, 1, 2, 3, 4, 5, 6
				                // x, n, ?, ?, x, n, ?
				                "LABEL 8\n" +
				                "PUSHG 1\n" +
				                "JUMPF 9\n" +
				                // modulo
				                "PUSHG 1\n" + // pousse n
				                "STOREG 3\n" + // ajoute l'ancien n
				                // 0, 1, 2, 3, 4, 5, 6
				                // x, n, ?, n_ancier, x, n, ?
				                "PUSHG 0\n" + // pousse x
				                "PUSHG 1\n" + // pousse n
				                "DIV\n" +
				                "STOREG 2\n" + // on ajoute le résultat du quotient à l'adresse 2
				                // 0, 1, 2, 3, 4, 5, 6
				                // x, n, qotient, n_ancier, x, n, ?
				                "PUSHG 2\n" + // pouusse le quotion
				                "PUSHG 1\n" + // on poussse n
				                "MUL\n" + // multiplie par n
				                "STOREG 2\n" + // stocke  produit à l'adresse 3
				                // x, n, produit, n_ancier, x, n, ?
				                // x, n, quotient, produit, n_ancier, x, n
				                "PUSHG 0\n" + // on pousse x
				                "PUSHG 2\n" + // on pousse le produit
				                "SUB\n" + // on soustrait de x le produit
				                "STOREG 1\n" +
				                // x, n_nouv, produit, n_ancier, x, n, ?
				                // x, n_nouv, quotient, produit, n_ancier, x, n
				                "PUSHG 3\n" + //  // Pousse l'ancien n
				                "STOREG 0\n" + // Stocke l'ancien n dans nouveau x à l'adresse 0
				                // x_remplacer, n_nouv, produit, n_ancier, x, n, ?
				                //"PUSHI 0\n" + a voir
				                "JUMP 8\n" + // RECOMMENCER
				                "LABEL 9\n" +
				                // x_remplacer, n_nouv, produit, n_ancier, x, n, ?
				                "PUSHG 4\n" +
				                "PUSHG 5\n" +
				                "MUL\n" +
				                "PUSHG 0\n" + // le PGCD
				                "DIV\n" ;
				      
				}
				break;
			case ENTIER:
				{
				setState(152);
				((OpContext)_localctx).ENTIER = match(ENTIER);
				((OpContext)_localctx).code =  "PUSHI " + (((OpContext)_localctx).ENTIER!=null?((OpContext)_localctx).ENTIER.getText():null) + "\n";
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OpContext(_parentctx, _parentState);
					_localctx.e = _prevctx;
					_localctx.e = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_op);
					setState(156);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(157);
					match(T__12);
					setState(158);
					((OpContext)_localctx).f = op(3);
					((OpContext)_localctx).code =  ((OpContext)_localctx).e.code + ((OpContext)_localctx).f.code;
					}
					} 
				}
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExprRegboolContext extends ParserRuleContext {
		public String code;
		public ExprRegboolContext d;
		public ExprRegboolContext exprRegbool;
		public ExprRegContext e;
		public ExprRegContext f;
		public ExprRegboolContext g;
		public List<ExprRegboolContext> exprRegbool() {
			return getRuleContexts(ExprRegboolContext.class);
		}
		public ExprRegboolContext exprRegbool(int i) {
			return getRuleContext(ExprRegboolContext.class,i);
		}
		public List<ExprRegContext> exprReg() {
			return getRuleContexts(ExprRegContext.class);
		}
		public ExprRegContext exprReg(int i) {
			return getRuleContext(ExprRegContext.class,i);
		}
		public ExprRegboolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprRegbool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RationnelListener ) ((RationnelListener)listener).enterExprRegbool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RationnelListener ) ((RationnelListener)listener).exitExprRegbool(this);
		}
	}

	public final ExprRegboolContext exprRegbool() throws RecognitionException {
		return exprRegbool(0);
	}

	private ExprRegboolContext exprRegbool(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprRegboolContext _localctx = new ExprRegboolContext(_ctx, _parentState);
		ExprRegboolContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_exprRegbool, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(167);
				match(T__21);
				setState(168);
				((ExprRegboolContext)_localctx).exprRegbool = exprRegbool(0);
				setState(169);
				match(T__15);
				((ExprRegboolContext)_localctx).code =  ((ExprRegboolContext)_localctx).exprRegbool.code;
				}
				break;
			case 2:
				{
				setState(172);
				match(T__22);
				setState(173);
				((ExprRegboolContext)_localctx).d = ((ExprRegboolContext)_localctx).exprRegbool = exprRegbool(9);
				((ExprRegboolContext)_localctx).code =  "PUSHI 1\n" +  ((ExprRegboolContext)_localctx).d.code + "SUB\n";
				}
				break;
			case 3:
				{
				setState(176);
				((ExprRegboolContext)_localctx).e = exprReg(0);
				setState(177);
				match(T__25);
				setState(178);
				((ExprRegboolContext)_localctx).f = exprReg(0);
				((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).e.code, ((ExprRegboolContext)_localctx).f.code, "SUP"); 
				}
				break;
			case 4:
				{
				setState(181);
				((ExprRegboolContext)_localctx).e = exprReg(0);
				setState(182);
				match(T__26);
				setState(183);
				((ExprRegboolContext)_localctx).f = exprReg(0);
				((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).e.code, ((ExprRegboolContext)_localctx).f.code, "INF"); 
				}
				break;
			case 5:
				{
				setState(186);
				((ExprRegboolContext)_localctx).e = exprReg(0);
				setState(187);
				match(T__27);
				setState(188);
				((ExprRegboolContext)_localctx).f = exprReg(0);
				((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).e.code, ((ExprRegboolContext)_localctx).f.code, "SUPEQ"); 
				}
				break;
			case 6:
				{
				setState(191);
				((ExprRegboolContext)_localctx).e = exprReg(0);
				setState(192);
				match(T__11);
				setState(193);
				((ExprRegboolContext)_localctx).f = exprReg(0);
				((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).e.code, ((ExprRegboolContext)_localctx).f.code, "INFEQ"); 
				}
				break;
			case 7:
				{
				setState(196);
				((ExprRegboolContext)_localctx).e = exprReg(0);
				setState(197);
				match(T__28);
				setState(198);
				((ExprRegboolContext)_localctx).f = exprReg(0);
				((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).e.code, ((ExprRegboolContext)_localctx).f.code, "EQUAL");
				}
				break;
			case 8:
				{
				setState(201);
				((ExprRegboolContext)_localctx).e = exprReg(0);
				setState(202);
				match(T__29);
				setState(203);
				((ExprRegboolContext)_localctx).f = exprReg(0);
				((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).e.code, ((ExprRegboolContext)_localctx).f.code, "NEQ");
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(220);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(218);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new ExprRegboolContext(_parentctx, _parentState);
						_localctx.d = _prevctx;
						_localctx.d = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exprRegbool);
						setState(208);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(209);
						match(T__23);
						setState(210);
						((ExprRegboolContext)_localctx).g = ((ExprRegboolContext)_localctx).exprRegbool = exprRegbool(9);
						((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).d.code, ((ExprRegboolContext)_localctx).g.code, "and"); 
						}
						break;
					case 2:
						{
						_localctx = new ExprRegboolContext(_parentctx, _parentState);
						_localctx.d = _prevctx;
						_localctx.d = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exprRegbool);
						setState(213);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(214);
						match(T__24);
						setState(215);
						((ExprRegboolContext)_localctx).g = ((ExprRegboolContext)_localctx).exprRegbool = exprRegbool(8);
						((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).d.code, ((ExprRegboolContext)_localctx).g.code, "or"); 
						}
						break;
					}
					} 
				}
				setState(222);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return exprReg_sempred((ExprRegContext)_localctx, predIndex);
		case 5:
			return op_sempred((OpContext)_localctx, predIndex);
		case 6:
			return exprRegbool_sempred((ExprRegboolContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exprReg_sempred(ExprRegContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 6);
		}
		return true;
	}
	private boolean op_sempred(OpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exprRegbool_sempred(ExprRegboolContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 8);
		case 8:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u00e2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\7\2\24\n\2"+
		"\f\2\16\2\27\13\2\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\2\3\2\3\2\7\2\"\n"+
		"\2\f\2\16\2%\13\2\3\2\3\2\3\3\6\3*\n\3\r\3\16\3+\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5<\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\5\6j\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u0087\n"+
		"\6\f\6\16\6\u008a\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\5\7\u009d\n\7\3\7\3\7\3\7\3\7\3\7\7\7\u00a4\n\7\f"+
		"\7\16\7\u00a7\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00d1\n\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\7\b\u00dd\n\b\f\b\16\b\u00e0\13\b\3\b\2\5\n\f\16"+
		"\t\2\4\6\b\n\f\16\2\3\4\2##\'\'\2\u00f9\2\25\3\2\2\2\4)\3\2\2\2\6-\3\2"+
		"\2\2\b;\3\2\2\2\ni\3\2\2\2\f\u009c\3\2\2\2\16\u00d0\3\2\2\2\20\21\5\6"+
		"\4\2\21\22\b\2\1\2\22\24\3\2\2\2\23\20\3\2\2\2\24\27\3\2\2\2\25\23\3\2"+
		"\2\2\25\26\3\2\2\2\26\33\3\2\2\2\27\25\3\2\2\2\30\32\7#\2\2\31\30\3\2"+
		"\2\2\32\35\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34#\3\2\2\2\35\33\3\2\2"+
		"\2\36\37\5\b\5\2\37 \b\2\1\2 \"\3\2\2\2!\36\3\2\2\2\"%\3\2\2\2#!\3\2\2"+
		"\2#$\3\2\2\2$&\3\2\2\2%#\3\2\2\2&\'\b\2\1\2\'\3\3\2\2\2(*\t\2\2\2)(\3"+
		"\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\5\3\2\2\2-.\7!\2\2./\7\"\2\2/\60"+
		"\5\4\3\2\60\61\b\4\1\2\61\7\3\2\2\2\62\63\5\n\6\2\63\64\b\5\1\2\64<\3"+
		"\2\2\2\65\66\5\16\b\2\66\67\b\5\1\2\67<\3\2\2\289\5\4\3\29:\b\5\1\2:<"+
		"\3\2\2\2;\62\3\2\2\2;\65\3\2\2\2;8\3\2\2\2<\t\3\2\2\2=>\b\6\1\2>?\7\3"+
		"\2\2?@\5\n\6\2@A\7\4\2\2AB\b\6\1\2Bj\3\2\2\2CD\7\5\2\2DE\5\n\6\2EF\7\6"+
		"\2\2FG\b\6\1\2Gj\3\2\2\2HI\7\7\2\2IJ\5\n\6\2JK\7\b\2\2KL\b\6\1\2Lj\3\2"+
		"\2\2MN\5\f\7\2NO\7\17\2\2OP\5\f\7\2PQ\7\20\2\2QR\b\6\1\2Rj\3\2\2\2ST\7"+
		"\21\2\2TU\7%\2\2UV\7\17\2\2VW\7%\2\2WX\7\22\2\2Xj\b\6\1\2YZ\7\23\2\2Z"+
		"[\5\f\7\2[\\\7\17\2\2\\]\5\f\7\2]^\7\22\2\2^_\b\6\1\2_j\3\2\2\2`a\7\24"+
		"\2\2ab\7%\2\2bc\7\17\2\2cd\7%\2\2de\7\22\2\2ej\b\6\1\2fg\5\f\7\2gh\b\6"+
		"\1\2hj\3\2\2\2i=\3\2\2\2iC\3\2\2\2iH\3\2\2\2iM\3\2\2\2iS\3\2\2\2iY\3\2"+
		"\2\2i`\3\2\2\2if\3\2\2\2j\u0088\3\2\2\2kl\f\f\2\2lm\7\n\2\2mn\5\n\6\r"+
		"no\b\6\1\2o\u0087\3\2\2\2pq\f\13\2\2qr\7\13\2\2rs\5\n\6\fst\b\6\1\2t\u0087"+
		"\3\2\2\2uv\f\n\2\2vw\7\f\2\2wx\5\n\6\13xy\b\6\1\2y\u0087\3\2\2\2z{\f\t"+
		"\2\2{|\7\r\2\2|}\5\n\6\n}~\b\6\1\2~\u0087\3\2\2\2\177\u0080\f\r\2\2\u0080"+
		"\u0081\7\t\2\2\u0081\u0082\5\f\7\2\u0082\u0083\b\6\1\2\u0083\u0087\3\2"+
		"\2\2\u0084\u0085\f\b\2\2\u0085\u0087\7\16\2\2\u0086k\3\2\2\2\u0086p\3"+
		"\2\2\2\u0086u\3\2\2\2\u0086z\3\2\2\2\u0086\177\3\2\2\2\u0086\u0084\3\2"+
		"\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\13\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c\b\7\1\2\u008c\u008d\7\25\2"+
		"\2\u008d\u008e\5\f\7\2\u008e\u008f\7\26\2\2\u008f\u0090\5\f\7\2\u0090"+
		"\u0091\7\22\2\2\u0091\u0092\b\7\1\2\u0092\u009d\3\2\2\2\u0093\u0094\7"+
		"\27\2\2\u0094\u0095\5\f\7\2\u0095\u0096\7\26\2\2\u0096\u0097\5\f\7\2\u0097"+
		"\u0098\7\22\2\2\u0098\u0099\b\7\1\2\u0099\u009d\3\2\2\2\u009a\u009b\7"+
		"%\2\2\u009b\u009d\b\7\1\2\u009c\u008b\3\2\2\2\u009c\u0093\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009d\u00a5\3\2\2\2\u009e\u009f\f\4\2\2\u009f\u00a0\7\17"+
		"\2\2\u00a0\u00a1\5\f\7\5\u00a1\u00a2\b\7\1\2\u00a2\u00a4\3\2\2\2\u00a3"+
		"\u009e\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2"+
		"\2\2\u00a6\r\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\b\b\1\2\u00a9\u00aa"+
		"\7\30\2\2\u00aa\u00ab\5\16\b\2\u00ab\u00ac\7\22\2\2\u00ac\u00ad\b\b\1"+
		"\2\u00ad\u00d1\3\2\2\2\u00ae\u00af\7\31\2\2\u00af\u00b0\5\16\b\13\u00b0"+
		"\u00b1\b\b\1\2\u00b1\u00d1\3\2\2\2\u00b2\u00b3\5\n\6\2\u00b3\u00b4\7\34"+
		"\2\2\u00b4\u00b5\5\n\6\2\u00b5\u00b6\b\b\1\2\u00b6\u00d1\3\2\2\2\u00b7"+
		"\u00b8\5\n\6\2\u00b8\u00b9\7\35\2\2\u00b9\u00ba\5\n\6\2\u00ba\u00bb\b"+
		"\b\1\2\u00bb\u00d1\3\2\2\2\u00bc\u00bd\5\n\6\2\u00bd\u00be\7\36\2\2\u00be"+
		"\u00bf\5\n\6\2\u00bf\u00c0\b\b\1\2\u00c0\u00d1\3\2\2\2\u00c1\u00c2\5\n"+
		"\6\2\u00c2\u00c3\7\16\2\2\u00c3\u00c4\5\n\6\2\u00c4\u00c5\b\b\1\2\u00c5"+
		"\u00d1\3\2\2\2\u00c6\u00c7\5\n\6\2\u00c7\u00c8\7\37\2\2\u00c8\u00c9\5"+
		"\n\6\2\u00c9\u00ca\b\b\1\2\u00ca\u00d1\3\2\2\2\u00cb\u00cc\5\n\6\2\u00cc"+
		"\u00cd\7 \2\2\u00cd\u00ce\5\n\6\2\u00ce\u00cf\b\b\1\2\u00cf\u00d1\3\2"+
		"\2\2\u00d0\u00a8\3\2\2\2\u00d0\u00ae\3\2\2\2\u00d0\u00b2\3\2\2\2\u00d0"+
		"\u00b7\3\2\2\2\u00d0\u00bc\3\2\2\2\u00d0\u00c1\3\2\2\2\u00d0\u00c6\3\2"+
		"\2\2\u00d0\u00cb\3\2\2\2\u00d1\u00de\3\2\2\2\u00d2\u00d3\f\n\2\2\u00d3"+
		"\u00d4\7\32\2\2\u00d4\u00d5\5\16\b\13\u00d5\u00d6\b\b\1\2\u00d6\u00dd"+
		"\3\2\2\2\u00d7\u00d8\f\t\2\2\u00d8\u00d9\7\33\2\2\u00d9\u00da\5\16\b\n"+
		"\u00da\u00db\b\b\1\2\u00db\u00dd\3\2\2\2\u00dc\u00d2\3\2\2\2\u00dc\u00d7"+
		"\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\17\3\2\2\2\u00e0\u00de\3\2\2\2\17\25\33#+;i\u0086\u0088\u009c\u00a5\u00d0"+
		"\u00dc\u00de";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}