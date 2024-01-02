// Generated from /Users/eyosias17/bin/Projet/Rationnel.g4 by ANTLR 4.13.1

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

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class RationnelParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, TYPE=35, ID=36, NEWLINE=37, WS=38, ENTIER=39, 
		BOOLEAN=40, FININSTRUCTIONS=41, UNMATCH=42;
	public static final int
		RULE_calcul = 0, RULE_instruction = 1, RULE_finInstruction = 2, RULE_decl = 3, 
		RULE_affect = 4, RULE_affectReg = 5, RULE_affectBool = 6, RULE_afficher = 7, 
		RULE_exprReg = 8, RULE_bool = 9, RULE_op = 10, RULE_exprRegbool = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"calcul", "instruction", "finInstruction", "decl", "affect", "affectReg", 
			"affectBool", "afficher", "exprReg", "bool", "op", "exprRegbool"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'='", "'afficher('", "')'", "'['", "']'", "'[+'", "'+]'", 
			"'[-'", "'-]'", "'('", "'**'", "'*'", "':'", "'+'", "'-'", "'/'", "'%'", 
			"'num('", "'sim('", "'denum('", "'true'", "'false'", "'pgcd('", "'ppcm('", 
			"'not'", "'and'", "'or'", "'>'", "'<'", "'>='", "'<='", "'=='", "'<>'", 
			null, null, null, null, null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "TYPE", 
			"ID", "NEWLINE", "WS", "ENTIER", "BOOLEAN", "FININSTRUCTIONS", "UNMATCH"
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




	  /** La map pour mémoriser les addresses des étiquettes */
	    private HashMap<String, MonType> labels = new HashMap<String, MonType>();
	    //private HashMap<Integer, String> types = new HashMap<Integer, String>();

	    /** adresse instruction */
	    private int instrAddress = 8; //on commence à 8 car les précédentes cases sont réservées pour les calculs
	    private int cmp_decla = 8; //car déjà alloué 8


	    public class MonType {
	    		private String type;
	    		private int adresse;

	    		public MonType(String t, int adresse) {
	        		this.type = t;
	        		this.adresse = adresse;
	    		}

	    		// Getter pour le identifiant
	    		public String getType() {
	        		return type;
	    		}

	    		// Getter pour l'adresse
	    		public int getAdresse() {
	        		return adresse;
	    		}

		}

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

	@SuppressWarnings("CheckReturnValue")
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
			setState(29);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(24);
					((CalculContext)_localctx).decl = decl();
					 _localctx.code += ((CalculContext)_localctx).decl.code; 
					}
					} 
				}
				setState(31);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(35);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(32);
					match(NEWLINE);
					}
					} 
				}
				setState(37);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4088942627496L) != 0)) {
				{
				{
				setState(38);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.code += "FREE " + (cmp_decla) + "\nHALT\n"; 
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

	@SuppressWarnings("CheckReturnValue")
	public static class InstructionContext extends ParserRuleContext {
		public String code;
		public DeclContext decl;
		public AffectContext affect;
		public AffectRegContext affectReg;
		public AffectBoolContext affectBool;
		public ExprRegContext exprReg;
		public ExprRegboolContext exprRegbool;
		public BoolContext bool;
		public AfficherContext afficher;
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public AffectContext affect() {
			return getRuleContext(AffectContext.class,0);
		}
		public AffectRegContext affectReg() {
			return getRuleContext(AffectRegContext.class,0);
		}
		public AffectBoolContext affectBool() {
			return getRuleContext(AffectBoolContext.class,0);
		}
		public ExprRegContext exprReg() {
			return getRuleContext(ExprRegContext.class,0);
		}
		public ExprRegboolContext exprRegbool() {
			return getRuleContext(ExprRegboolContext.class,0);
		}
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public AfficherContext afficher() {
			return getRuleContext(AfficherContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instruction);
		try {
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				((InstructionContext)_localctx).decl = decl();
				((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).decl.code;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				((InstructionContext)_localctx).affect = affect();
				((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).affect.code;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
				((InstructionContext)_localctx).affectReg = affectReg();
				((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).affectReg.code;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(57);
				((InstructionContext)_localctx).affectBool = affectBool();
				((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).affectBool.code;
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(60);
				((InstructionContext)_localctx).exprReg = exprReg(0);
				((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).exprReg.code;
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(63);
				((InstructionContext)_localctx).exprRegbool = exprRegbool(0);
				((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).exprRegbool.code;
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(66);
				((InstructionContext)_localctx).bool = bool();
				((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).bool.code;
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(69);
				((InstructionContext)_localctx).afficher = afficher();
				((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).afficher.code;
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(72);
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

	@SuppressWarnings("CheckReturnValue")
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
	}

	public final FinInstructionContext finInstruction() throws RecognitionException {
		FinInstructionContext _localctx = new FinInstructionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(78); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(77);
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
				setState(80); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends ParserRuleContext {
		public String code;
		public Token TYPE;
		public Token ID;
		public TerminalNode TYPE() { return getToken(RationnelParser.TYPE, 0); }
		public List<TerminalNode> ID() { return getTokens(RationnelParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RationnelParser.ID, i);
		}
		public TerminalNode FININSTRUCTIONS() { return getToken(RationnelParser.FININSTRUCTIONS, 0); }
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decl);
		try {
			int _alt;
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(83);
				((DeclContext)_localctx).ID = match(ID);
				setState(84);
				match(FININSTRUCTIONS);

					if ((((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null).equals("bool")){
						((DeclContext)_localctx).code =  "PUSHI 00" + "\n";
					}
					else{
						((DeclContext)_localctx).code =  "PUSHI 0" + "\n";
					}
				        labels.put((((DeclContext)_localctx).ID!=null?((DeclContext)_localctx).ID.getText():null), new MonType((((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null), instrAddress));
				        instrAddress = instrAddress + 1;
				        cmp_decla += 1;
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(92);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(87);
						((DeclContext)_localctx).ID = match(ID);

								if ((((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null).equals("bool")){
									((DeclContext)_localctx).code =  "PUSHI 00" + "\n";
								}
								else{
									((DeclContext)_localctx).code =  "PUSHI 0" + "\n";
								}
						        	labels.put((((DeclContext)_localctx).ID!=null?((DeclContext)_localctx).ID.getText():null), new MonType((((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null), instrAddress));
						        	instrAddress = instrAddress + 1;
						          cmp_decla += 1;
							
						setState(89);
						match(T__0);
						}
						} 
					}
					setState(94);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				{
				setState(95);
				((DeclContext)_localctx).ID = match(ID);
				}
				setState(96);
				match(FININSTRUCTIONS);

						if ((((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null).equals("bool")){
							((DeclContext)_localctx).code =  "PUSHI 00" + "\n";
						}
						else{
							((DeclContext)_localctx).code =  "PUSHI 0" + "\n";
						}
						      labels.put((((DeclContext)_localctx).ID!=null?((DeclContext)_localctx).ID.getText():null), new MonType((((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null), instrAddress));
				        	instrAddress = instrAddress + 1;
				          cmp_decla += 1;
					
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

	@SuppressWarnings("CheckReturnValue")
	public static class AffectContext extends ParserRuleContext {
		public String code;
		public Token ID;
		public OpContext op;
		public TerminalNode FININSTRUCTIONS() { return getToken(RationnelParser.FININSTRUCTIONS, 0); }
		public List<TerminalNode> ID() { return getTokens(RationnelParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RationnelParser.ID, i);
		}
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
		public AffectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_affect; }
	}

	public final AffectContext affect() throws RecognitionException {
		AffectContext _localctx = new AffectContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_affect);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(100);
					((AffectContext)_localctx).ID = match(ID);
					setState(101);
					match(T__1);
					setState(102);
					((AffectContext)_localctx).op = op(0);
					setState(103);
					match(T__0);

					        if (labels.get((((AffectContext)_localctx).ID!=null?((AffectContext)_localctx).ID.getText():null)).getType().equals("int")){
								    int p = labels.get((((AffectContext)_localctx).ID!=null?((AffectContext)_localctx).ID.getText():null)).getAdresse();
					          ((AffectContext)_localctx).code =  ((AffectContext)_localctx).op.code + "\n" + "STOREG " + p + "\n";
							    }
					        else if (labels.get((((AffectContext)_localctx).ID!=null?((AffectContext)_localctx).ID.getText():null)).getType().equals("reg")){
					          int p = labels.get((((AffectContext)_localctx).ID!=null?((AffectContext)_localctx).ID.getText():null)).getAdresse();
					          ((AffectContext)_localctx).code =  ((AffectContext)_localctx).op.code + "STOREG 1" +  "\n" + "STOREG 0" + "PUSHG 1" + "\n"
					               + "STOREG " + p + "PUSHG 0" + "STOREG " + (p-1) + "\n";
					        }
					    
					}
					} 
				}
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			{
			setState(111);
			((AffectContext)_localctx).ID = match(ID);
			setState(112);
			match(T__1);
			setState(113);
			((AffectContext)_localctx).op = op(0);
			}
			setState(115);
			match(FININSTRUCTIONS);

			        if (labels.get((((AffectContext)_localctx).ID!=null?((AffectContext)_localctx).ID.getText():null)).getType().equals("int")){
						    int p = labels.get((((AffectContext)_localctx).ID!=null?((AffectContext)_localctx).ID.getText():null)).getAdresse();
			          ((AffectContext)_localctx).code =  ((AffectContext)_localctx).op.code + "\n" + "STOREG " + p + "\n";
					    }
			        else if (labels.get((((AffectContext)_localctx).ID!=null?((AffectContext)_localctx).ID.getText():null)).getType().equals("reg")){
			          int p = labels.get((((AffectContext)_localctx).ID!=null?((AffectContext)_localctx).ID.getText():null)).getAdresse();
			          ((AffectContext)_localctx).code =  ((AffectContext)_localctx).op.code + "STOREG 1" + "\n" + "STOREG 0" + "PUSHG 1" + "\n"
			                  + "STOREG " + (p) + "PUSHG 0" + "STOREG " + (p-1) + "\n";
			        }
			    
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

	@SuppressWarnings("CheckReturnValue")
	public static class AffectRegContext extends ParserRuleContext {
		public String code;
		public Token ID;
		public ExprRegContext exprReg;
		public TerminalNode FININSTRUCTIONS() { return getToken(RationnelParser.FININSTRUCTIONS, 0); }
		public List<TerminalNode> ID() { return getTokens(RationnelParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RationnelParser.ID, i);
		}
		public List<ExprRegContext> exprReg() {
			return getRuleContexts(ExprRegContext.class);
		}
		public ExprRegContext exprReg(int i) {
			return getRuleContext(ExprRegContext.class,i);
		}
		public AffectRegContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_affectReg; }
	}

	public final AffectRegContext affectReg() throws RecognitionException {
		AffectRegContext _localctx = new AffectRegContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_affectReg);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(118);
					((AffectRegContext)_localctx).ID = match(ID);
					setState(119);
					match(T__1);
					setState(120);
					((AffectRegContext)_localctx).exprReg = exprReg(0);
					setState(121);
					match(T__0);

					        int p = labels.get((((AffectRegContext)_localctx).ID!=null?((AffectRegContext)_localctx).ID.getText():null)).getAdresse();
					        ((AffectRegContext)_localctx).code =  ((AffectRegContext)_localctx).exprReg.code + "STOREG 1" + "\n" + "STOREG 0" + "PUSHG 1" + "\n"
					                  + "STOREG " + (p) + "PUSHG 0" + "STOREG " + (p-1) + "\n";
					    
					}
					} 
				}
				setState(128);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			{
			setState(129);
			((AffectRegContext)_localctx).ID = match(ID);
			setState(130);
			match(T__1);
			setState(131);
			((AffectRegContext)_localctx).exprReg = exprReg(0);
			}
			setState(133);
			match(FININSTRUCTIONS);

			        int p = labels.get((((AffectRegContext)_localctx).ID!=null?((AffectRegContext)_localctx).ID.getText():null)).getAdresse();
			        ((AffectRegContext)_localctx).code =  ((AffectRegContext)_localctx).exprReg.code + "STOREG 1" + "\n" + "STOREG 0" + "PUSHG 1" + "\n"
			                  + "STOREG " + (p) + "PUSHG 0" + "STOREG " + (p-1) + "\n";
			    
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

	@SuppressWarnings("CheckReturnValue")
	public static class AffectBoolContext extends ParserRuleContext {
		public String code;
		public Token ID;
		public BoolContext bool;
		public TerminalNode FININSTRUCTIONS() { return getToken(RationnelParser.FININSTRUCTIONS, 0); }
		public List<TerminalNode> ID() { return getTokens(RationnelParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RationnelParser.ID, i);
		}
		public List<BoolContext> bool() {
			return getRuleContexts(BoolContext.class);
		}
		public BoolContext bool(int i) {
			return getRuleContext(BoolContext.class,i);
		}
		public AffectBoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_affectBool; }
	}

	public final AffectBoolContext affectBool() throws RecognitionException {
		AffectBoolContext _localctx = new AffectBoolContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_affectBool);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(136);
					((AffectBoolContext)_localctx).ID = match(ID);
					setState(137);
					match(T__1);
					setState(138);
					((AffectBoolContext)_localctx).bool = bool();
					setState(139);
					match(T__0);

					        int p = labels.get((((AffectBoolContext)_localctx).ID!=null?((AffectBoolContext)_localctx).ID.getText():null)).getAdresse();
					        ((AffectBoolContext)_localctx).code =  ((AffectBoolContext)_localctx).bool.code + "\n" + "STOREG " + p + "\n";
					    
					}
					} 
				}
				setState(146);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			{
			setState(147);
			((AffectBoolContext)_localctx).ID = match(ID);
			setState(148);
			match(T__1);
			setState(149);
			((AffectBoolContext)_localctx).bool = bool();
			}
			setState(151);
			match(FININSTRUCTIONS);

			        int p = labels.get((((AffectBoolContext)_localctx).ID!=null?((AffectBoolContext)_localctx).ID.getText():null)).getAdresse();
			        ((AffectBoolContext)_localctx).code =  ((AffectBoolContext)_localctx).bool.code + "\n" + "STOREG " + p + "\n";
			    
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

	@SuppressWarnings("CheckReturnValue")
	public static class AfficherContext extends ParserRuleContext {
		public String code;
		public ExprRegContext exprReg;
		public ExprRegContext exprReg() {
			return getRuleContext(ExprRegContext.class,0);
		}
		public TerminalNode FININSTRUCTIONS() { return getToken(RationnelParser.FININSTRUCTIONS, 0); }
		public AfficherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_afficher; }
	}

	public final AfficherContext afficher() throws RecognitionException {
		AfficherContext _localctx = new AfficherContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_afficher);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(T__2);
			setState(155);
			((AfficherContext)_localctx).exprReg = exprReg(0);
			setState(156);
			match(T__3);
			setState(157);
			match(FININSTRUCTIONS);

			        ((AfficherContext)_localctx).code =  ((AfficherContext)_localctx).exprReg.code +
			                "STOREG 0\n" + //récupère le dénominateur en tête
			                "STOREG 1\n" + //même pour le numérateur
			                "PUSHG 1\n" + // récupère le numérateur et l'affiche
			                "WRITE\n" + //l'affiche
			                "POP\n" +
			                "PUSHG 0\n" + //pareil pour deno
			                "WRITE\n" + //l'affiche
			                "POP\n";
			    
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprRegContext extends ParserRuleContext {
		public String code;
		public int num;
		public int denum;
		public ExprRegContext a;
		public ExprRegContext k;
		public ExprRegContext z;
		public ExprRegContext exprReg;
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
	}

	public final ExprRegContext exprReg() throws RecognitionException {
		return exprReg(0);
	}

	private ExprRegContext exprReg(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprRegContext _localctx = new ExprRegContext(_ctx, _parentState);
		ExprRegContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_exprReg, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(161);
				match(T__4);
				setState(162);
				((ExprRegContext)_localctx).z = ((ExprRegContext)_localctx).exprReg = exprReg(0);
				setState(163);
				match(T__5);

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
				setState(166);
				match(T__6);
				setState(167);
				((ExprRegContext)_localctx).b = ((ExprRegContext)_localctx).exprReg = exprReg(0);
				setState(168);
				match(T__7);

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
				setState(171);
				match(T__8);
				setState(172);
				((ExprRegContext)_localctx).b = ((ExprRegContext)_localctx).exprReg = exprReg(0);
				setState(173);
				match(T__9);

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
				setState(176);
				match(T__10);
				setState(177);
				((ExprRegContext)_localctx).a = ((ExprRegContext)_localctx).exprReg = exprReg(0);
				setState(178);
				match(T__3);
				 ((ExprRegContext)_localctx).code =  ((ExprRegContext)_localctx).a.code;
				}
				break;
			case 5:
				{
				setState(181);
				match(T__15);
				setState(182);
				((ExprRegContext)_localctx).exprReg = exprReg(6);

				    ((ExprRegContext)_localctx).code = 
				            ((ExprRegContext)_localctx).exprReg.code +
				            "STOREG 1\n" +
				            "STOREG 0\n" +
				            "PUSHG 0\n" +
				            "PUSHI 0\n" +
				            "PUSHI 1\n" +
				            "SUB\n" +
				            "MUL\n" +
				            "PUSHG 1\n" ;
				      ;
				}
				break;
			case 6:
				{
				setState(185);
				((ExprRegContext)_localctx).e = ((ExprRegContext)_localctx).op = op(0);
				setState(186);
				match(T__16);
				setState(187);
				((ExprRegContext)_localctx).f = ((ExprRegContext)_localctx).op = op(0);
				setState(188);
				match(T__17);
				((ExprRegContext)_localctx).code =  calcul_pourcentage(((ExprRegContext)_localctx).e.code, ((ExprRegContext)_localctx).f.code) ;
				}
				break;
			case 7:
				{
				setState(191);
				match(T__18);
				setState(192);
				((ExprRegContext)_localctx).c = match(ENTIER);
				setState(193);
				match(T__16);
				setState(194);
				((ExprRegContext)_localctx).d = match(ENTIER);
				setState(195);
				match(T__3);
				((ExprRegContext)_localctx).code =  "PUSHI " + (((ExprRegContext)_localctx).c!=null?((ExprRegContext)_localctx).c.getText():null) + "\n"; ((ExprRegContext)_localctx).num =  (((ExprRegContext)_localctx).c!=null?Integer.valueOf(((ExprRegContext)_localctx).c.getText()):0);
				}
				break;
			case 8:
				{
				setState(197);
				match(T__19);
				setState(198);
				((ExprRegContext)_localctx).e = ((ExprRegContext)_localctx).op = op(0);
				setState(199);
				match(T__16);
				setState(200);
				((ExprRegContext)_localctx).f = ((ExprRegContext)_localctx).op = op(0);
				setState(201);
				match(T__3);
				((ExprRegContext)_localctx).code =  simplifierRationnel(((ExprRegContext)_localctx).e.code, ((ExprRegContext)_localctx).f.code);
				}
				break;
			case 9:
				{
				setState(204);
				match(T__20);
				setState(205);
				((ExprRegContext)_localctx).c = match(ENTIER);
				setState(206);
				match(T__16);
				setState(207);
				((ExprRegContext)_localctx).d = match(ENTIER);
				setState(208);
				match(T__3);
				((ExprRegContext)_localctx).code =  "PUSHI " + (((ExprRegContext)_localctx).d!=null?((ExprRegContext)_localctx).d.getText():null) + "\n"; ((ExprRegContext)_localctx).denum =  (((ExprRegContext)_localctx).d!=null?Integer.valueOf(((ExprRegContext)_localctx).d.getText()):0);
				}
				break;
			case 10:
				{
				setState(210);
				((ExprRegContext)_localctx).op = op(0);
				((ExprRegContext)_localctx).code =  ((ExprRegContext)_localctx).op.code;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(242);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(240);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new ExprRegContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exprReg);
						setState(215);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(216);
						match(T__12);
						setState(217);
						((ExprRegContext)_localctx).b = ((ExprRegContext)_localctx).exprReg = exprReg(11);

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
						                    "PUSHG 5\n" +  // Pousser le dénominateur
						                    "WRITE\n";
						            
						}
						break;
					case 2:
						{
						_localctx = new ExprRegContext(_parentctx, _parentState);
						_localctx.k = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exprReg);
						setState(220);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(221);
						match(T__13);
						setState(222);
						((ExprRegContext)_localctx).l = ((ExprRegContext)_localctx).exprReg = exprReg(10);

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
						pushNewRecursionContext(_localctx, _startState, RULE_exprReg);
						setState(225);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(226);
						match(T__14);
						setState(227);
						((ExprRegContext)_localctx).b = ((ExprRegContext)_localctx).exprReg = exprReg(9);

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
						pushNewRecursionContext(_localctx, _startState, RULE_exprReg);
						setState(230);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(231);
						match(T__15);
						setState(232);
						((ExprRegContext)_localctx).b = ((ExprRegContext)_localctx).exprReg = exprReg(8);

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
						pushNewRecursionContext(_localctx, _startState, RULE_exprReg);
						setState(235);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(236);
						match(T__11);
						setState(237);
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
					}
					} 
				}
				setState(244);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BoolContext extends ParserRuleContext {
		public String code;
		public Token BOOLEAN;
		public TerminalNode BOOLEAN() { return getToken(RationnelParser.BOOLEAN, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_bool);
		try {
			setState(251);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				enterOuterAlt(_localctx, 1);
				{
				setState(245);
				match(T__21);
				((BoolContext)_localctx).code =  "PUSHI 1" + "\n";
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				match(T__22);
				((BoolContext)_localctx).code =  "PUSHI 0" + "\n";
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(249);
				((BoolContext)_localctx).BOOLEAN = match(BOOLEAN);
				((BoolContext)_localctx).code =  "PUSHI " + (((BoolContext)_localctx).BOOLEAN!=null?((BoolContext)_localctx).BOOLEAN.getText():null) + "\n";
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class OpContext extends ParserRuleContext {
		public String code;
		public OpContext e;
		public OpContext c;
		public OpContext d;
		public Token ENTIER;
		public Token ID;
		public OpContext f;
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
		public TerminalNode ENTIER() { return getToken(RationnelParser.ENTIER, 0); }
		public TerminalNode ID() { return getToken(RationnelParser.ID, 0); }
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
	}

	public final OpContext op() throws RecognitionException {
		return op(0);
	}

	private OpContext op(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OpContext _localctx = new OpContext(_ctx, _parentState);
		OpContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_op, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				{
				setState(254);
				match(T__23);
				setState(255);
				((OpContext)_localctx).c = op(0);
				setState(256);
				match(T__0);
				setState(257);
				((OpContext)_localctx).d = op(0);
				setState(258);
				match(T__3);

				      ((OpContext)_localctx).code =  calculerPGCD(((OpContext)_localctx).c.code, ((OpContext)_localctx).d.code);
				    
				}
				break;
			case T__24:
				{
				setState(261);
				match(T__24);
				setState(262);
				((OpContext)_localctx).c = op(0);
				setState(263);
				match(T__0);
				setState(264);
				((OpContext)_localctx).d = op(0);
				setState(265);
				match(T__3);

				      ((OpContext)_localctx).code =  calculerPPCM(((OpContext)_localctx).c.code, ((OpContext)_localctx).d.code);
				    
				}
				break;
			case ENTIER:
				{
				setState(268);
				((OpContext)_localctx).ENTIER = match(ENTIER);
				((OpContext)_localctx).code =  "PUSHI " + (((OpContext)_localctx).ENTIER!=null?((OpContext)_localctx).ENTIER.getText():null) + "\n";
				}
				break;
			case ID:
				{
				setState(270);
				((OpContext)_localctx).ID = match(ID);

				    int p = labels.get((((OpContext)_localctx).ID!=null?((OpContext)_localctx).ID.getText():null)).getAdresse();
				    ((OpContext)_localctx).code =  "PUSHG " + p + "\n";
				  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(281);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OpContext(_parentctx, _parentState);
					_localctx.e = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_op);
					setState(274);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(275);
					match(T__16);
					setState(276);
					((OpContext)_localctx).f = op(4);
					((OpContext)_localctx).code =  ((OpContext)_localctx).e.code + ((OpContext)_localctx).f.code;
					}
					} 
				}
				setState(283);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
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
	}

	public final ExprRegboolContext exprRegbool() throws RecognitionException {
		return exprRegbool(0);
	}

	private ExprRegboolContext exprRegbool(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprRegboolContext _localctx = new ExprRegboolContext(_ctx, _parentState);
		ExprRegboolContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_exprRegbool, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(285);
				match(T__10);
				setState(286);
				((ExprRegboolContext)_localctx).exprRegbool = exprRegbool(0);
				setState(287);
				match(T__3);
				((ExprRegboolContext)_localctx).code =  ((ExprRegboolContext)_localctx).exprRegbool.code;
				}
				break;
			case 2:
				{
				setState(290);
				match(T__25);
				setState(291);
				((ExprRegboolContext)_localctx).d = ((ExprRegboolContext)_localctx).exprRegbool = exprRegbool(9);
				((ExprRegboolContext)_localctx).code =  "PUSHI 1\n" +  ((ExprRegboolContext)_localctx).d.code + "SUB\n";
				}
				break;
			case 3:
				{
				setState(294);
				((ExprRegboolContext)_localctx).e = exprReg(0);
				setState(295);
				match(T__28);
				setState(296);
				((ExprRegboolContext)_localctx).f = exprReg(0);
				((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).e.code, ((ExprRegboolContext)_localctx).f.code, "SUP"); 
				}
				break;
			case 4:
				{
				setState(299);
				((ExprRegboolContext)_localctx).e = exprReg(0);
				setState(300);
				match(T__29);
				setState(301);
				((ExprRegboolContext)_localctx).f = exprReg(0);
				((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).e.code, ((ExprRegboolContext)_localctx).f.code, "INF"); 
				}
				break;
			case 5:
				{
				setState(304);
				((ExprRegboolContext)_localctx).e = exprReg(0);
				setState(305);
				match(T__30);
				setState(306);
				((ExprRegboolContext)_localctx).f = exprReg(0);
				((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).e.code, ((ExprRegboolContext)_localctx).f.code, "SUPEQ"); 
				}
				break;
			case 6:
				{
				setState(309);
				((ExprRegboolContext)_localctx).e = exprReg(0);
				setState(310);
				match(T__31);
				setState(311);
				((ExprRegboolContext)_localctx).f = exprReg(0);
				((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).e.code, ((ExprRegboolContext)_localctx).f.code, "INFEQ"); 
				}
				break;
			case 7:
				{
				setState(314);
				((ExprRegboolContext)_localctx).e = exprReg(0);
				setState(315);
				match(T__32);
				setState(316);
				((ExprRegboolContext)_localctx).f = exprReg(0);
				((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).e.code, ((ExprRegboolContext)_localctx).f.code, "EQUAL");
				}
				break;
			case 8:
				{
				setState(319);
				((ExprRegboolContext)_localctx).e = exprReg(0);
				setState(320);
				match(T__33);
				setState(321);
				((ExprRegboolContext)_localctx).f = exprReg(0);
				((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).e.code, ((ExprRegboolContext)_localctx).f.code, "NEQ");
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(338);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(336);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ExprRegboolContext(_parentctx, _parentState);
						_localctx.d = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exprRegbool);
						setState(326);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(327);
						match(T__26);
						setState(328);
						((ExprRegboolContext)_localctx).g = ((ExprRegboolContext)_localctx).exprRegbool = exprRegbool(9);
						((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).d.code, ((ExprRegboolContext)_localctx).g.code, "and"); 
						}
						break;
					case 2:
						{
						_localctx = new ExprRegboolContext(_parentctx, _parentState);
						_localctx.d = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exprRegbool);
						setState(331);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(332);
						match(T__27);
						setState(333);
						((ExprRegboolContext)_localctx).g = ((ExprRegboolContext)_localctx).exprRegbool = exprRegbool(8);
						((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).d.code, ((ExprRegboolContext)_localctx).g.code, "or"); 
						}
						break;
					}
					} 
				}
				setState(340);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		case 8:
			return exprReg_sempred((ExprRegContext)_localctx, predIndex);
		case 10:
			return op_sempred((OpContext)_localctx, predIndex);
		case 11:
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
		}
		return true;
	}
	private boolean op_sempred(OpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean exprRegbool_sempred(ExprRegboolContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001*\u0156\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u001c\b\u0000\n\u0000\f\u0000"+
		"\u001f\t\u0000\u0001\u0000\u0005\u0000\"\b\u0000\n\u0000\f\u0000%\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000*\b\u0000\n\u0000\f\u0000"+
		"-\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001L\b\u0001\u0001\u0002\u0004\u0002O\b\u0002\u000b\u0002\f\u0002"+
		"P\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003[\b\u0003\n\u0003\f\u0003^\t\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003c\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"k\b\u0004\n\u0004\f\u0004n\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005}\b\u0005"+
		"\n\u0005\f\u0005\u0080\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u008f\b\u0006\n"+
		"\u0006\f\u0006\u0092\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00d6\b\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00f1\b\b\n\b\f\b\u00f4\t\b"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00fc\b\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u0111\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u0118"+
		"\b\n\n\n\f\n\u011b\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u0145\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000b\u0151\b\u000b\n\u000b\f\u000b\u0154\t\u000b\u0001\u000b\u0000"+
		"\u0003\u0010\u0014\u0016\f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0000\u0001\u0002\u0000%%))\u0177\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0002K\u0001\u0000\u0000\u0000\u0004N\u0001\u0000\u0000\u0000"+
		"\u0006b\u0001\u0000\u0000\u0000\bl\u0001\u0000\u0000\u0000\n~\u0001\u0000"+
		"\u0000\u0000\f\u0090\u0001\u0000\u0000\u0000\u000e\u009a\u0001\u0000\u0000"+
		"\u0000\u0010\u00d5\u0001\u0000\u0000\u0000\u0012\u00fb\u0001\u0000\u0000"+
		"\u0000\u0014\u0110\u0001\u0000\u0000\u0000\u0016\u0144\u0001\u0000\u0000"+
		"\u0000\u0018\u0019\u0003\u0006\u0003\u0000\u0019\u001a\u0006\u0000\uffff"+
		"\uffff\u0000\u001a\u001c\u0001\u0000\u0000\u0000\u001b\u0018\u0001\u0000"+
		"\u0000\u0000\u001c\u001f\u0001\u0000\u0000\u0000\u001d\u001b\u0001\u0000"+
		"\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e#\u0001\u0000\u0000"+
		"\u0000\u001f\u001d\u0001\u0000\u0000\u0000 \"\u0005%\u0000\u0000! \u0001"+
		"\u0000\u0000\u0000\"%\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000"+
		"#$\u0001\u0000\u0000\u0000$+\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000"+
		"\u0000&\'\u0003\u0002\u0001\u0000\'(\u0006\u0000\uffff\uffff\u0000(*\u0001"+
		"\u0000\u0000\u0000)&\u0001\u0000\u0000\u0000*-\u0001\u0000\u0000\u0000"+
		"+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,.\u0001\u0000\u0000"+
		"\u0000-+\u0001\u0000\u0000\u0000./\u0006\u0000\uffff\uffff\u0000/\u0001"+
		"\u0001\u0000\u0000\u000001\u0003\u0006\u0003\u000012\u0006\u0001\uffff"+
		"\uffff\u00002L\u0001\u0000\u0000\u000034\u0003\b\u0004\u000045\u0006\u0001"+
		"\uffff\uffff\u00005L\u0001\u0000\u0000\u000067\u0003\n\u0005\u000078\u0006"+
		"\u0001\uffff\uffff\u00008L\u0001\u0000\u0000\u00009:\u0003\f\u0006\u0000"+
		":;\u0006\u0001\uffff\uffff\u0000;L\u0001\u0000\u0000\u0000<=\u0003\u0010"+
		"\b\u0000=>\u0006\u0001\uffff\uffff\u0000>L\u0001\u0000\u0000\u0000?@\u0003"+
		"\u0016\u000b\u0000@A\u0006\u0001\uffff\uffff\u0000AL\u0001\u0000\u0000"+
		"\u0000BC\u0003\u0012\t\u0000CD\u0006\u0001\uffff\uffff\u0000DL\u0001\u0000"+
		"\u0000\u0000EF\u0003\u000e\u0007\u0000FG\u0006\u0001\uffff\uffff\u0000"+
		"GL\u0001\u0000\u0000\u0000HI\u0003\u0004\u0002\u0000IJ\u0006\u0001\uffff"+
		"\uffff\u0000JL\u0001\u0000\u0000\u0000K0\u0001\u0000\u0000\u0000K3\u0001"+
		"\u0000\u0000\u0000K6\u0001\u0000\u0000\u0000K9\u0001\u0000\u0000\u0000"+
		"K<\u0001\u0000\u0000\u0000K?\u0001\u0000\u0000\u0000KB\u0001\u0000\u0000"+
		"\u0000KE\u0001\u0000\u0000\u0000KH\u0001\u0000\u0000\u0000L\u0003\u0001"+
		"\u0000\u0000\u0000MO\u0007\u0000\u0000\u0000NM\u0001\u0000\u0000\u0000"+
		"OP\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000"+
		"\u0000Q\u0005\u0001\u0000\u0000\u0000RS\u0005#\u0000\u0000ST\u0005$\u0000"+
		"\u0000TU\u0005)\u0000\u0000Uc\u0006\u0003\uffff\uffff\u0000V\\\u0005#"+
		"\u0000\u0000WX\u0005$\u0000\u0000XY\u0006\u0003\uffff\uffff\u0000Y[\u0005"+
		"\u0001\u0000\u0000ZW\u0001\u0000\u0000\u0000[^\u0001\u0000\u0000\u0000"+
		"\\Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]_\u0001\u0000\u0000"+
		"\u0000^\\\u0001\u0000\u0000\u0000_`\u0005$\u0000\u0000`a\u0005)\u0000"+
		"\u0000ac\u0006\u0003\uffff\uffff\u0000bR\u0001\u0000\u0000\u0000bV\u0001"+
		"\u0000\u0000\u0000c\u0007\u0001\u0000\u0000\u0000de\u0005$\u0000\u0000"+
		"ef\u0005\u0002\u0000\u0000fg\u0003\u0014\n\u0000gh\u0005\u0001\u0000\u0000"+
		"hi\u0006\u0004\uffff\uffff\u0000ik\u0001\u0000\u0000\u0000jd\u0001\u0000"+
		"\u0000\u0000kn\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lm\u0001"+
		"\u0000\u0000\u0000mo\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000"+
		"op\u0005$\u0000\u0000pq\u0005\u0002\u0000\u0000qr\u0003\u0014\n\u0000"+
		"rs\u0001\u0000\u0000\u0000st\u0005)\u0000\u0000tu\u0006\u0004\uffff\uffff"+
		"\u0000u\t\u0001\u0000\u0000\u0000vw\u0005$\u0000\u0000wx\u0005\u0002\u0000"+
		"\u0000xy\u0003\u0010\b\u0000yz\u0005\u0001\u0000\u0000z{\u0006\u0005\uffff"+
		"\uffff\u0000{}\u0001\u0000\u0000\u0000|v\u0001\u0000\u0000\u0000}\u0080"+
		"\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000"+
		"\u0000\u0000\u007f\u0081\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000"+
		"\u0000\u0081\u0082\u0005$\u0000\u0000\u0082\u0083\u0005\u0002\u0000\u0000"+
		"\u0083\u0084\u0003\u0010\b\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085"+
		"\u0086\u0005)\u0000\u0000\u0086\u0087\u0006\u0005\uffff\uffff\u0000\u0087"+
		"\u000b\u0001\u0000\u0000\u0000\u0088\u0089\u0005$\u0000\u0000\u0089\u008a"+
		"\u0005\u0002\u0000\u0000\u008a\u008b\u0003\u0012\t\u0000\u008b\u008c\u0005"+
		"\u0001\u0000\u0000\u008c\u008d\u0006\u0006\uffff\uffff\u0000\u008d\u008f"+
		"\u0001\u0000\u0000\u0000\u008e\u0088\u0001\u0000\u0000\u0000\u008f\u0092"+
		"\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0090\u0091"+
		"\u0001\u0000\u0000\u0000\u0091\u0093\u0001\u0000\u0000\u0000\u0092\u0090"+
		"\u0001\u0000\u0000\u0000\u0093\u0094\u0005$\u0000\u0000\u0094\u0095\u0005"+
		"\u0002\u0000\u0000\u0095\u0096\u0003\u0012\t\u0000\u0096\u0097\u0001\u0000"+
		"\u0000\u0000\u0097\u0098\u0005)\u0000\u0000\u0098\u0099\u0006\u0006\uffff"+
		"\uffff\u0000\u0099\r\u0001\u0000\u0000\u0000\u009a\u009b\u0005\u0003\u0000"+
		"\u0000\u009b\u009c\u0003\u0010\b\u0000\u009c\u009d\u0005\u0004\u0000\u0000"+
		"\u009d\u009e\u0005)\u0000\u0000\u009e\u009f\u0006\u0007\uffff\uffff\u0000"+
		"\u009f\u000f\u0001\u0000\u0000\u0000\u00a0\u00a1\u0006\b\uffff\uffff\u0000"+
		"\u00a1\u00a2\u0005\u0005\u0000\u0000\u00a2\u00a3\u0003\u0010\b\u0000\u00a3"+
		"\u00a4\u0005\u0006\u0000\u0000\u00a4\u00a5\u0006\b\uffff\uffff\u0000\u00a5"+
		"\u00d6\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005\u0007\u0000\u0000\u00a7"+
		"\u00a8\u0003\u0010\b\u0000\u00a8\u00a9\u0005\b\u0000\u0000\u00a9\u00aa"+
		"\u0006\b\uffff\uffff\u0000\u00aa\u00d6\u0001\u0000\u0000\u0000\u00ab\u00ac"+
		"\u0005\t\u0000\u0000\u00ac\u00ad\u0003\u0010\b\u0000\u00ad\u00ae\u0005"+
		"\n\u0000\u0000\u00ae\u00af\u0006\b\uffff\uffff\u0000\u00af\u00d6\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b1\u0005\u000b\u0000\u0000\u00b1\u00b2\u0003"+
		"\u0010\b\u0000\u00b2\u00b3\u0005\u0004\u0000\u0000\u00b3\u00b4\u0006\b"+
		"\uffff\uffff\u0000\u00b4\u00d6\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005"+
		"\u0010\u0000\u0000\u00b6\u00b7\u0003\u0010\b\u0006\u00b7\u00b8\u0006\b"+
		"\uffff\uffff\u0000\u00b8\u00d6\u0001\u0000\u0000\u0000\u00b9\u00ba\u0003"+
		"\u0014\n\u0000\u00ba\u00bb\u0005\u0011\u0000\u0000\u00bb\u00bc\u0003\u0014"+
		"\n\u0000\u00bc\u00bd\u0005\u0012\u0000\u0000\u00bd\u00be\u0006\b\uffff"+
		"\uffff\u0000\u00be\u00d6\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005\u0013"+
		"\u0000\u0000\u00c0\u00c1\u0005\'\u0000\u0000\u00c1\u00c2\u0005\u0011\u0000"+
		"\u0000\u00c2\u00c3\u0005\'\u0000\u0000\u00c3\u00c4\u0005\u0004\u0000\u0000"+
		"\u00c4\u00d6\u0006\b\uffff\uffff\u0000\u00c5\u00c6\u0005\u0014\u0000\u0000"+
		"\u00c6\u00c7\u0003\u0014\n\u0000\u00c7\u00c8\u0005\u0011\u0000\u0000\u00c8"+
		"\u00c9\u0003\u0014\n\u0000\u00c9\u00ca\u0005\u0004\u0000\u0000\u00ca\u00cb"+
		"\u0006\b\uffff\uffff\u0000\u00cb\u00d6\u0001\u0000\u0000\u0000\u00cc\u00cd"+
		"\u0005\u0015\u0000\u0000\u00cd\u00ce\u0005\'\u0000\u0000\u00ce\u00cf\u0005"+
		"\u0011\u0000\u0000\u00cf\u00d0\u0005\'\u0000\u0000\u00d0\u00d1\u0005\u0004"+
		"\u0000\u0000\u00d1\u00d6\u0006\b\uffff\uffff\u0000\u00d2\u00d3\u0003\u0014"+
		"\n\u0000\u00d3\u00d4\u0006\b\uffff\uffff\u0000\u00d4\u00d6\u0001\u0000"+
		"\u0000\u0000\u00d5\u00a0\u0001\u0000\u0000\u0000\u00d5\u00a6\u0001\u0000"+
		"\u0000\u0000\u00d5\u00ab\u0001\u0000\u0000\u0000\u00d5\u00b0\u0001\u0000"+
		"\u0000\u0000\u00d5\u00b5\u0001\u0000\u0000\u0000\u00d5\u00b9\u0001\u0000"+
		"\u0000\u0000\u00d5\u00bf\u0001\u0000\u0000\u0000\u00d5\u00c5\u0001\u0000"+
		"\u0000\u0000\u00d5\u00cc\u0001\u0000\u0000\u0000\u00d5\u00d2\u0001\u0000"+
		"\u0000\u0000\u00d6\u00f2\u0001\u0000\u0000\u0000\u00d7\u00d8\n\n\u0000"+
		"\u0000\u00d8\u00d9\u0005\r\u0000\u0000\u00d9\u00da\u0003\u0010\b\u000b"+
		"\u00da\u00db\u0006\b\uffff\uffff\u0000\u00db\u00f1\u0001\u0000\u0000\u0000"+
		"\u00dc\u00dd\n\t\u0000\u0000\u00dd\u00de\u0005\u000e\u0000\u0000\u00de"+
		"\u00df\u0003\u0010\b\n\u00df\u00e0\u0006\b\uffff\uffff\u0000\u00e0\u00f1"+
		"\u0001\u0000\u0000\u0000\u00e1\u00e2\n\b\u0000\u0000\u00e2\u00e3\u0005"+
		"\u000f\u0000\u0000\u00e3\u00e4\u0003\u0010\b\t\u00e4\u00e5\u0006\b\uffff"+
		"\uffff\u0000\u00e5\u00f1\u0001\u0000\u0000\u0000\u00e6\u00e7\n\u0007\u0000"+
		"\u0000\u00e7\u00e8\u0005\u0010\u0000\u0000\u00e8\u00e9\u0003\u0010\b\b"+
		"\u00e9\u00ea\u0006\b\uffff\uffff\u0000\u00ea\u00f1\u0001\u0000\u0000\u0000"+
		"\u00eb\u00ec\n\u000b\u0000\u0000\u00ec\u00ed\u0005\f\u0000\u0000\u00ed"+
		"\u00ee\u0003\u0014\n\u0000\u00ee\u00ef\u0006\b\uffff\uffff\u0000\u00ef"+
		"\u00f1\u0001\u0000\u0000\u0000\u00f0\u00d7\u0001\u0000\u0000\u0000\u00f0"+
		"\u00dc\u0001\u0000\u0000\u0000\u00f0\u00e1\u0001\u0000\u0000\u0000\u00f0"+
		"\u00e6\u0001\u0000\u0000\u0000\u00f0\u00eb\u0001\u0000\u0000\u0000\u00f1"+
		"\u00f4\u0001\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f2"+
		"\u00f3\u0001\u0000\u0000\u0000\u00f3\u0011\u0001\u0000\u0000\u0000\u00f4"+
		"\u00f2\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005\u0016\u0000\u0000\u00f6"+
		"\u00fc\u0006\t\uffff\uffff\u0000\u00f7\u00f8\u0005\u0017\u0000\u0000\u00f8"+
		"\u00fc\u0006\t\uffff\uffff\u0000\u00f9\u00fa\u0005(\u0000\u0000\u00fa"+
		"\u00fc\u0006\t\uffff\uffff\u0000\u00fb\u00f5\u0001\u0000\u0000\u0000\u00fb"+
		"\u00f7\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fc"+
		"\u0013\u0001\u0000\u0000\u0000\u00fd\u00fe\u0006\n\uffff\uffff\u0000\u00fe"+
		"\u00ff\u0005\u0018\u0000\u0000\u00ff\u0100\u0003\u0014\n\u0000\u0100\u0101"+
		"\u0005\u0001\u0000\u0000\u0101\u0102\u0003\u0014\n\u0000\u0102\u0103\u0005"+
		"\u0004\u0000\u0000\u0103\u0104\u0006\n\uffff\uffff\u0000\u0104\u0111\u0001"+
		"\u0000\u0000\u0000\u0105\u0106\u0005\u0019\u0000\u0000\u0106\u0107\u0003"+
		"\u0014\n\u0000\u0107\u0108\u0005\u0001\u0000\u0000\u0108\u0109\u0003\u0014"+
		"\n\u0000\u0109\u010a\u0005\u0004\u0000\u0000\u010a\u010b\u0006\n\uffff"+
		"\uffff\u0000\u010b\u0111\u0001\u0000\u0000\u0000\u010c\u010d\u0005\'\u0000"+
		"\u0000\u010d\u0111\u0006\n\uffff\uffff\u0000\u010e\u010f\u0005$\u0000"+
		"\u0000\u010f\u0111\u0006\n\uffff\uffff\u0000\u0110\u00fd\u0001\u0000\u0000"+
		"\u0000\u0110\u0105\u0001\u0000\u0000\u0000\u0110\u010c\u0001\u0000\u0000"+
		"\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0111\u0119\u0001\u0000\u0000"+
		"\u0000\u0112\u0113\n\u0003\u0000\u0000\u0113\u0114\u0005\u0011\u0000\u0000"+
		"\u0114\u0115\u0003\u0014\n\u0004\u0115\u0116\u0006\n\uffff\uffff\u0000"+
		"\u0116\u0118\u0001\u0000\u0000\u0000\u0117\u0112\u0001\u0000\u0000\u0000"+
		"\u0118\u011b\u0001\u0000\u0000\u0000\u0119\u0117\u0001\u0000\u0000\u0000"+
		"\u0119\u011a\u0001\u0000\u0000\u0000\u011a\u0015\u0001\u0000\u0000\u0000"+
		"\u011b\u0119\u0001\u0000\u0000\u0000\u011c\u011d\u0006\u000b\uffff\uffff"+
		"\u0000\u011d\u011e\u0005\u000b\u0000\u0000\u011e\u011f\u0003\u0016\u000b"+
		"\u0000\u011f\u0120\u0005\u0004\u0000\u0000\u0120\u0121\u0006\u000b\uffff"+
		"\uffff\u0000\u0121\u0145\u0001\u0000\u0000\u0000\u0122\u0123\u0005\u001a"+
		"\u0000\u0000\u0123\u0124\u0003\u0016\u000b\t\u0124\u0125\u0006\u000b\uffff"+
		"\uffff\u0000\u0125\u0145\u0001\u0000\u0000\u0000\u0126\u0127\u0003\u0010"+
		"\b\u0000\u0127\u0128\u0005\u001d\u0000\u0000\u0128\u0129\u0003\u0010\b"+
		"\u0000\u0129\u012a\u0006\u000b\uffff\uffff\u0000\u012a\u0145\u0001\u0000"+
		"\u0000\u0000\u012b\u012c\u0003\u0010\b\u0000\u012c\u012d\u0005\u001e\u0000"+
		"\u0000\u012d\u012e\u0003\u0010\b\u0000\u012e\u012f\u0006\u000b\uffff\uffff"+
		"\u0000\u012f\u0145\u0001\u0000\u0000\u0000\u0130\u0131\u0003\u0010\b\u0000"+
		"\u0131\u0132\u0005\u001f\u0000\u0000\u0132\u0133\u0003\u0010\b\u0000\u0133"+
		"\u0134\u0006\u000b\uffff\uffff\u0000\u0134\u0145\u0001\u0000\u0000\u0000"+
		"\u0135\u0136\u0003\u0010\b\u0000\u0136\u0137\u0005 \u0000\u0000\u0137"+
		"\u0138\u0003\u0010\b\u0000\u0138\u0139\u0006\u000b\uffff\uffff\u0000\u0139"+
		"\u0145\u0001\u0000\u0000\u0000\u013a\u013b\u0003\u0010\b\u0000\u013b\u013c"+
		"\u0005!\u0000\u0000\u013c\u013d\u0003\u0010\b\u0000\u013d\u013e\u0006"+
		"\u000b\uffff\uffff\u0000\u013e\u0145\u0001\u0000\u0000\u0000\u013f\u0140"+
		"\u0003\u0010\b\u0000\u0140\u0141\u0005\"\u0000\u0000\u0141\u0142\u0003"+
		"\u0010\b\u0000\u0142\u0143\u0006\u000b\uffff\uffff\u0000\u0143\u0145\u0001"+
		"\u0000\u0000\u0000\u0144\u011c\u0001\u0000\u0000\u0000\u0144\u0122\u0001"+
		"\u0000\u0000\u0000\u0144\u0126\u0001\u0000\u0000\u0000\u0144\u012b\u0001"+
		"\u0000\u0000\u0000\u0144\u0130\u0001\u0000\u0000\u0000\u0144\u0135\u0001"+
		"\u0000\u0000\u0000\u0144\u013a\u0001\u0000\u0000\u0000\u0144\u013f\u0001"+
		"\u0000\u0000\u0000\u0145\u0152\u0001\u0000\u0000\u0000\u0146\u0147\n\b"+
		"\u0000\u0000\u0147\u0148\u0005\u001b\u0000\u0000\u0148\u0149\u0003\u0016"+
		"\u000b\t\u0149\u014a\u0006\u000b\uffff\uffff\u0000\u014a\u0151\u0001\u0000"+
		"\u0000\u0000\u014b\u014c\n\u0007\u0000\u0000\u014c\u014d\u0005\u001c\u0000"+
		"\u0000\u014d\u014e\u0003\u0016\u000b\b\u014e\u014f\u0006\u000b\uffff\uffff"+
		"\u0000\u014f\u0151\u0001\u0000\u0000\u0000\u0150\u0146\u0001\u0000\u0000"+
		"\u0000\u0150\u014b\u0001\u0000\u0000\u0000\u0151\u0154\u0001\u0000\u0000"+
		"\u0000\u0152\u0150\u0001\u0000\u0000\u0000\u0152\u0153\u0001\u0000\u0000"+
		"\u0000\u0153\u0017\u0001\u0000\u0000\u0000\u0154\u0152\u0001\u0000\u0000"+
		"\u0000\u0013\u001d#+KP\\bl~\u0090\u00d5\u00f0\u00f2\u00fb\u0110\u0119"+
		"\u0144\u0150\u0152";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}