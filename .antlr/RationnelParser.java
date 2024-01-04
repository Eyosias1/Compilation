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
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, TYPE=38, ID=39, 
		NEWLINE=40, WS=41, ENTIER=42, BOOLEAN=43, FININSTRUCTIONS=44, UNMATCH=45;
	public static final int
		RULE_calcul = 0, RULE_instruction = 1, RULE_finInstruction = 2, RULE_decl = 3, 
		RULE_affectInt = 4, RULE_affectReg = 5, RULE_affectBool = 6, RULE_afficher = 7, 
		RULE_lireint = 8, RULE_lireReg = 9, RULE_lireBool = 10, RULE_boucle = 11, 
		RULE_repeterInstru = 12, RULE_jusqueInstru = 13, RULE_exprReg = 14, RULE_bool = 15, 
		RULE_op = 16, RULE_op2 = 17, RULE_op3 = 18, RULE_exprRegbool = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"calcul", "instruction", "finInstruction", "decl", "affectInt", "affectReg", 
			"affectBool", "afficher", "lireint", "lireReg", "lireBool", "boucle", 
			"repeterInstru", "jusqueInstru", "exprReg", "bool", "op", "op2", "op3", 
			"exprRegbool"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'='", "'afficher('", "')'", "'lire()'", "'repeter'", "'jusque'", 
			"'['", "']'", "'[+'", "'+]'", "'[-'", "'-]'", "'('", "'**'", "'*'", "':'", 
			"'+'", "'-'", "'/'", "'%'", "'num('", "'sim('", "'denum('", "'true'", 
			"'false'", "'pgcd('", "'ppcm('", "'not'", "'and'", "'or'", "'>'", "'<'", 
			"'>='", "'<='", "'=='", "'<>'", null, null, null, null, null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "TYPE", "ID", "NEWLINE", "WS", "ENTIER", "BOOLEAN", "FININSTRUCTIONS", 
			"UNMATCH"
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
	    int cmpt_label = 11;

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

	              "STOREG 0\n" + // on stocke la valuer boolean de e_code
	              f_code +
	              "STOREG 1\n" +
	              "PUSHG 0\n" +
	              "PUSHG 1\n" +
	              "MUL\n" +
	              "LABEL 9\n" +
	              "PUSHI 0\n" ;
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
	                "PUSHG 0\n" +
	                "PUSHG 3\n" +
	                "MUL\n" +
	                "STOREG 0\n" +
	                "PUSHG 1\n" +
	                "PUSHG 2\n" +
	                "MUL\n" +
	                "STOREG 2\n" +
	                "PUSHG 1\n" +
	                "PUSHG 3\n" +
	                "MUL\n" +
	                "STOREG 3\n" +
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
			setState(45);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(40);
					((CalculContext)_localctx).decl = decl();
					 _localctx.code += ((CalculContext)_localctx).decl.code; 
					}
					} 
				}
				setState(47);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(48);
					match(NEWLINE);
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 32711541020008L) != 0)) {
				{
				{
				setState(54);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(61);
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
		public AffectIntContext affectInt;
		public AffectRegContext affectReg;
		public AffectBoolContext affectBool;
		public ExprRegContext exprReg;
		public ExprRegboolContext exprRegbool;
		public BoolContext bool;
		public AfficherContext afficher;
		public BoucleContext boucle;
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public AffectIntContext affectInt() {
			return getRuleContext(AffectIntContext.class,0);
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
		public BoucleContext boucle() {
			return getRuleContext(BoucleContext.class,0);
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
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				((InstructionContext)_localctx).decl = decl();
				((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).decl.code;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				((InstructionContext)_localctx).affectInt = affectInt();
				((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).affectInt.code;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				((InstructionContext)_localctx).affectReg = affectReg();
				((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).affectReg.code;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				((InstructionContext)_localctx).affectBool = affectBool();
				((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).affectBool.code;
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(76);
				((InstructionContext)_localctx).exprReg = exprReg(0);
				((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).exprReg.code;
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(79);
				((InstructionContext)_localctx).exprRegbool = exprRegbool(0);
				((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).exprRegbool.code;
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(82);
				((InstructionContext)_localctx).bool = bool();
				((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).bool.code;
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(85);
				((InstructionContext)_localctx).afficher = afficher();
				((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).afficher.code;
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(88);
				((InstructionContext)_localctx).boucle = boucle();
				((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).boucle.code;
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(91);
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
			setState(97); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(96);
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
				setState(99); 
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
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(102);
				((DeclContext)_localctx).ID = match(ID);
				setState(103);
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
				setState(105);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(111);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(106);
						((DeclContext)_localctx).ID = match(ID);

								if ((((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null).equals("bool")){
									((DeclContext)_localctx).code =  "PUSHI 00" + "\n"; // a supprimer
								}
								else{
									((DeclContext)_localctx).code =  "PUSHI 0" + "\n";
								}
						        	labels.put((((DeclContext)_localctx).ID!=null?((DeclContext)_localctx).ID.getText():null), new MonType((((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null), instrAddress));
						        	instrAddress = instrAddress + 1;
						          cmp_decla += 1;
							
						setState(108);
						match(T__0);
						}
						} 
					}
					setState(113);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				{
				setState(114);
				((DeclContext)_localctx).ID = match(ID);
				}
				setState(115);
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
	public static class AffectIntContext extends ParserRuleContext {
		public String code;
		public Token ID;
		public Op2Context op2;
		public TerminalNode FININSTRUCTIONS() { return getToken(RationnelParser.FININSTRUCTIONS, 0); }
		public List<TerminalNode> ID() { return getTokens(RationnelParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RationnelParser.ID, i);
		}
		public List<Op2Context> op2() {
			return getRuleContexts(Op2Context.class);
		}
		public Op2Context op2(int i) {
			return getRuleContext(Op2Context.class,i);
		}
		public AffectIntContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_affectInt; }
	}

	public final AffectIntContext affectInt() throws RecognitionException {
		AffectIntContext _localctx = new AffectIntContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_affectInt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(119);
					((AffectIntContext)_localctx).ID = match(ID);
					setState(120);
					match(T__1);
					setState(121);
					((AffectIntContext)_localctx).op2 = op2();
					setState(122);
					match(T__0);

					        if (labels.get((((AffectIntContext)_localctx).ID!=null?((AffectIntContext)_localctx).ID.getText():null)).getType().equals("int")){
								    int p = labels.get((((AffectIntContext)_localctx).ID!=null?((AffectIntContext)_localctx).ID.getText():null)).getAdresse();
					          ((AffectIntContext)_localctx).code =  ((AffectIntContext)_localctx).op2.code + "\n" + "STOREG " + p + "\n";
							    }
					        else if (labels.get((((AffectIntContext)_localctx).ID!=null?((AffectIntContext)_localctx).ID.getText():null)).getType().equals("reg")){
					          int p = labels.get((((AffectIntContext)_localctx).ID!=null?((AffectIntContext)_localctx).ID.getText():null)).getAdresse();
					          ((AffectIntContext)_localctx).code =  ((AffectIntContext)_localctx).op2.code + "STOREG 1" +  "\n" + "STOREG 0" + "\n"+ "PUSHG 1" + "\n"
					               + "STOREG " + p + "\n" +"PUSHG 0" + "\n"+ "STOREG " + (p-1) + "\n";
					        }
					    
					}
					} 
				}
				setState(129);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			{
			setState(130);
			((AffectIntContext)_localctx).ID = match(ID);
			setState(131);
			match(T__1);
			setState(132);
			((AffectIntContext)_localctx).op2 = op2();
			}
			setState(134);
			match(FININSTRUCTIONS);

			        if (labels.get((((AffectIntContext)_localctx).ID!=null?((AffectIntContext)_localctx).ID.getText():null)).getType().equals("int")){
						    int p = labels.get((((AffectIntContext)_localctx).ID!=null?((AffectIntContext)_localctx).ID.getText():null)).getAdresse();
			          ((AffectIntContext)_localctx).code =  ((AffectIntContext)_localctx).op2.code + "\n" + "STOREG " + p + "\n";
					    }
			        else if (labels.get((((AffectIntContext)_localctx).ID!=null?((AffectIntContext)_localctx).ID.getText():null)).getType().equals("reg")){
			          int p = labels.get((((AffectIntContext)_localctx).ID!=null?((AffectIntContext)_localctx).ID.getText():null)).getAdresse();
			          ((AffectIntContext)_localctx).code =  ((AffectIntContext)_localctx).op2.code + "STOREG 1" + "\n" + "STOREG 0" + "\n" + "PUSHG 1" + "\n"
			                  + "STOREG " + (p) + "\n" + "PUSHG 0" + "\n" + "STOREG " + (p-1) + "\n";
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
			setState(145);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(137);
					((AffectRegContext)_localctx).ID = match(ID);
					setState(138);
					match(T__1);
					setState(139);
					((AffectRegContext)_localctx).exprReg = exprReg(0);
					setState(140);
					match(T__0);

					        MonType obj = labels.get((((AffectRegContext)_localctx).ID!=null?((AffectRegContext)_localctx).ID.getText():null));
					        int p = obj.getAdresse();
					        if (obj.getType().equals("reg")) {
					        ((AffectRegContext)_localctx).code =  ((AffectRegContext)_localctx).exprReg.code + "STOREG 1" + "\n" + "STOREG 0" + "\n" + "PUSHG 1" + "\n"
					                  + "STOREG " + (p) + "\n" + "PUSHG 0" + "\n"+ "STOREG " + (p-1) + "\n";
					        }
					        else {
					          if (obj.getType().equals("int"))
					          {
					            throw new RuntimeException("Type mismatch: cannot assign an integer  to a non-integer type for ID '" + (((AffectRegContext)_localctx).ID!=null?((AffectRegContext)_localctx).ID.getText():null) + "'");
					          }
					          if (obj.getType().equals("bool"))
					          {
					            throw new RuntimeException("Type mismatch: cannot assign a float to a non-integer type for ID '" + (((AffectRegContext)_localctx).ID!=null?((AffectRegContext)_localctx).ID.getText():null) + "'");
					          }
					        }
					    
					}
					} 
				}
				setState(147);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			{
			setState(148);
			((AffectRegContext)_localctx).ID = match(ID);
			setState(149);
			match(T__1);
			setState(150);
			((AffectRegContext)_localctx).exprReg = exprReg(0);
			}
			setState(152);
			match(FININSTRUCTIONS);

			        MonType obj = labels.get((((AffectRegContext)_localctx).ID!=null?((AffectRegContext)_localctx).ID.getText():null));
			        int p = obj.getAdresse();
			        if (obj.getType().equals("reg")) {
			        ((AffectRegContext)_localctx).code =  ((AffectRegContext)_localctx).exprReg.code + "STOREG 1" + "\n" + "STOREG 0" + "\n" + "PUSHG 1" + "\n"
			                  + "STOREG " + (p) + "\n" + "PUSHG 0" +  "\n"+ "STOREG " + (p-1) + "\n";
			        }
			        else {
			          if (obj.getType().equals("int"))
			          {
			            throw new RuntimeException("Type mismatch: cannot assign  a non-integer type for ID '" + (((AffectRegContext)_localctx).ID!=null?((AffectRegContext)_localctx).ID.getText():null) + "'");
			          }
			          if (obj.getType().equals("bool"))
			          {
			            throw new RuntimeException("Type mismatch: cannot assign a non-boolean type for ID '" + (((AffectRegContext)_localctx).ID!=null?((AffectRegContext)_localctx).ID.getText():null) + "'");
			          }
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
			setState(163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(155);
					((AffectBoolContext)_localctx).ID = match(ID);
					setState(156);
					match(T__1);
					setState(157);
					((AffectBoolContext)_localctx).bool = bool();
					setState(158);
					match(T__0);

					        int p = labels.get((((AffectBoolContext)_localctx).ID!=null?((AffectBoolContext)_localctx).ID.getText():null)).getAdresse();
					        ((AffectBoolContext)_localctx).code =  ((AffectBoolContext)_localctx).bool.code + "\n" + "STOREG " + p + "\n";
					    
					}
					} 
				}
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			{
			setState(166);
			((AffectBoolContext)_localctx).ID = match(ID);
			setState(167);
			match(T__1);
			setState(168);
			((AffectBoolContext)_localctx).bool = bool();
			}
			setState(170);
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
			setState(173);
			match(T__2);
			setState(174);
			((AfficherContext)_localctx).exprReg = exprReg(0);
			setState(175);
			match(T__3);
			setState(176);
			match(FININSTRUCTIONS);

			        ((AfficherContext)_localctx).code =  ((AfficherContext)_localctx).exprReg.code +
			                "STOREG 1\n" + //récupère le dénominateur en tête
			                "STOREG 0\n" + //même pour le numérateur
			                "PUSHG 0\n" + // récupère le numérateur et l'affiche
			                "WRITE\n" + //l'affiche
			                "POP\n" +
			                "PUSHG 1\n" + //pareil pour deno
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
	public static class LireintContext extends ParserRuleContext {
		public String code;
		public LireintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lireint; }
	}

	public final LireintContext lireint() throws RecognitionException {
		LireintContext _localctx = new LireintContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_lireint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(T__4);
			((LireintContext)_localctx).code =  "READ\n" ;
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
	public static class LireRegContext extends ParserRuleContext {
		public String code;
		public LireRegContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lireReg; }
	}

	public final LireRegContext lireReg() throws RecognitionException {
		LireRegContext _localctx = new LireRegContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_lireReg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(T__4);
			((LireRegContext)_localctx).code =  "READ\n" + "READ\n";
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
	public static class LireBoolContext extends ParserRuleContext {
		public String code;
		public LireBoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lireBool; }
	}

	public final LireBoolContext lireBool() throws RecognitionException {
		LireBoolContext _localctx = new LireBoolContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_lireBool);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__4);
			((LireBoolContext)_localctx).code =  "READ\n" ;
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
	public static class BoucleContext extends ParserRuleContext {
		public String code;
		public RepeterInstruContext a;
		public JusqueInstruContext b;
		public RepeterInstruContext repeterInstru() {
			return getRuleContext(RepeterInstruContext.class,0);
		}
		public JusqueInstruContext jusqueInstru() {
			return getRuleContext(JusqueInstruContext.class,0);
		}
		public BoucleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boucle; }
	}

	public final BoucleContext boucle() throws RecognitionException {
		BoucleContext _localctx = new BoucleContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_boucle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			((BoucleContext)_localctx).a = repeterInstru();
			setState(189);
			((BoucleContext)_localctx).b = jusqueInstru();
			((BoucleContext)_localctx).code =  ((BoucleContext)_localctx).a.code + ((BoucleContext)_localctx).b.code;
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
	public static class RepeterInstruContext extends ParserRuleContext {
		public String code;
		public InstructionContext instruction;
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public RepeterInstruContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeterInstru; }
	}

	public final RepeterInstruContext repeterInstru() throws RecognitionException {
		RepeterInstruContext _localctx = new RepeterInstruContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_repeterInstru);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(T__5);
			((RepeterInstruContext)_localctx).code =  "LABEL " + (cmpt_label) + "\n" ;
			setState(197); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(194);
				((RepeterInstruContext)_localctx).instruction = instruction();
				_localctx.code += ((RepeterInstruContext)_localctx).instruction.code ;
				}
				}
				setState(199); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 32711541020008L) != 0) );
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
	public static class JusqueInstruContext extends ParserRuleContext {
		public String code;
		public ExprRegboolContext b;
		public ExprRegboolContext exprRegbool() {
			return getRuleContext(ExprRegboolContext.class,0);
		}
		public JusqueInstruContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jusqueInstru; }
	}

	public final JusqueInstruContext jusqueInstru() throws RecognitionException {
		JusqueInstruContext _localctx = new JusqueInstruContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_jusqueInstru);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(T__6);
			setState(202);
			((JusqueInstruContext)_localctx).b = exprRegbool(0);
			((JusqueInstruContext)_localctx).code =  ((JusqueInstruContext)_localctx).b.code + "JUMPF " + cmpt_label++ + "\n";
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
		public LireRegContext lireReg;
		public Op3Context op3;
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
		public LireRegContext lireReg() {
			return getRuleContext(LireRegContext.class,0);
		}
		public Op3Context op3() {
			return getRuleContext(Op3Context.class,0);
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_exprReg, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(206);
				match(T__7);
				setState(207);
				((ExprRegContext)_localctx).z = ((ExprRegContext)_localctx).exprReg = exprReg(0);
				setState(208);
				match(T__8);

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
				setState(211);
				match(T__9);
				setState(212);
				((ExprRegContext)_localctx).b = ((ExprRegContext)_localctx).exprReg = exprReg(0);
				setState(213);
				match(T__10);

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
				setState(216);
				match(T__11);
				setState(217);
				((ExprRegContext)_localctx).b = ((ExprRegContext)_localctx).exprReg = exprReg(0);
				setState(218);
				match(T__12);

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
				setState(221);
				match(T__13);
				setState(222);
				((ExprRegContext)_localctx).a = ((ExprRegContext)_localctx).exprReg = exprReg(0);
				setState(223);
				match(T__3);
				 ((ExprRegContext)_localctx).code =  ((ExprRegContext)_localctx).a.code;
				}
				break;
			case 5:
				{
				setState(226);
				match(T__18);
				setState(227);
				((ExprRegContext)_localctx).exprReg = exprReg(8);

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
				    
				}
				break;
			case 6:
				{
				setState(230);
				((ExprRegContext)_localctx).e = ((ExprRegContext)_localctx).op = op(0);
				setState(231);
				match(T__19);
				setState(232);
				((ExprRegContext)_localctx).f = ((ExprRegContext)_localctx).op = op(0);
				setState(233);
				match(T__20);
				((ExprRegContext)_localctx).code =  calcul_pourcentage(((ExprRegContext)_localctx).e.code, ((ExprRegContext)_localctx).f.code) ;
				}
				break;
			case 7:
				{
				setState(236);
				match(T__21);
				setState(237);
				((ExprRegContext)_localctx).c = match(ENTIER);
				setState(238);
				match(T__19);
				setState(239);
				((ExprRegContext)_localctx).d = match(ENTIER);
				setState(240);
				match(T__3);
				((ExprRegContext)_localctx).code =  "PUSHI " + (((ExprRegContext)_localctx).c!=null?((ExprRegContext)_localctx).c.getText():null) + "\n"; ((ExprRegContext)_localctx).num =  (((ExprRegContext)_localctx).c!=null?Integer.valueOf(((ExprRegContext)_localctx).c.getText()):0);
				}
				break;
			case 8:
				{
				setState(242);
				match(T__22);
				setState(243);
				((ExprRegContext)_localctx).e = ((ExprRegContext)_localctx).op = op(0);
				setState(244);
				match(T__19);
				setState(245);
				((ExprRegContext)_localctx).f = ((ExprRegContext)_localctx).op = op(0);
				setState(246);
				match(T__3);
				((ExprRegContext)_localctx).code =  simplifierRationnel(((ExprRegContext)_localctx).e.code, ((ExprRegContext)_localctx).f.code);
				}
				break;
			case 9:
				{
				setState(249);
				match(T__23);
				setState(250);
				((ExprRegContext)_localctx).c = match(ENTIER);
				setState(251);
				match(T__19);
				setState(252);
				((ExprRegContext)_localctx).d = match(ENTIER);
				setState(253);
				match(T__3);
				((ExprRegContext)_localctx).code =  "PUSHI " + (((ExprRegContext)_localctx).d!=null?((ExprRegContext)_localctx).d.getText():null) + "\n"; ((ExprRegContext)_localctx).denum =  (((ExprRegContext)_localctx).d!=null?Integer.valueOf(((ExprRegContext)_localctx).d.getText()):0);
				}
				break;
			case 10:
				{
				setState(255);
				((ExprRegContext)_localctx).lireReg = lireReg();
				((ExprRegContext)_localctx).code =  ((ExprRegContext)_localctx).lireReg.code;
				}
				break;
			case 11:
				{
				setState(258);
				((ExprRegContext)_localctx).op3 = op3();
				((ExprRegContext)_localctx).code =  ((ExprRegContext)_localctx).op3.code;
				}
				break;
			case 12:
				{
				setState(261);
				((ExprRegContext)_localctx).op = op(0);
				((ExprRegContext)_localctx).code =  ((ExprRegContext)_localctx).op.code;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(293);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(291);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ExprRegContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exprReg);
						setState(266);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(267);
						match(T__15);
						setState(268);
						((ExprRegContext)_localctx).b = ((ExprRegContext)_localctx).exprReg = exprReg(13);

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
						setState(271);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(272);
						match(T__16);
						setState(273);
						((ExprRegContext)_localctx).l = ((ExprRegContext)_localctx).exprReg = exprReg(12);

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
						setState(276);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(277);
						match(T__17);
						setState(278);
						((ExprRegContext)_localctx).b = ((ExprRegContext)_localctx).exprReg = exprReg(11);

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
						setState(281);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(282);
						match(T__18);
						setState(283);
						((ExprRegContext)_localctx).b = ((ExprRegContext)_localctx).exprReg = exprReg(10);

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
						setState(286);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(287);
						match(T__14);
						setState(288);
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
				setState(295);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		public LireBoolContext lireBool;
		public Token BOOLEAN;
		public LireBoolContext lireBool() {
			return getRuleContext(LireBoolContext.class,0);
		}
		public TerminalNode BOOLEAN() { return getToken(RationnelParser.BOOLEAN, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_bool);
		try {
			setState(305);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				match(T__24);
				((BoolContext)_localctx).code =  "PUSHI 1" + "\n";
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
				match(T__25);
				((BoolContext)_localctx).code =  "PUSHI 0" + "\n";
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(300);
				((BoolContext)_localctx).lireBool = lireBool();
				((BoolContext)_localctx).code =  ((BoolContext)_localctx).lireBool.code;
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(303);
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
		public LireintContext lireint;
		public Token ENTIER;
		public Token ID;
		public OpContext f;
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
		public LireintContext lireint() {
			return getRuleContext(LireintContext.class,0);
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
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_op, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				{
				setState(308);
				match(T__26);
				setState(309);
				((OpContext)_localctx).c = op(0);
				setState(310);
				match(T__0);
				setState(311);
				((OpContext)_localctx).d = op(0);
				setState(312);
				match(T__3);

				      ((OpContext)_localctx).code =  calculerPGCD(((OpContext)_localctx).c.code, ((OpContext)_localctx).d.code);
				    
				}
				break;
			case T__27:
				{
				setState(315);
				match(T__27);
				setState(316);
				((OpContext)_localctx).c = op(0);
				setState(317);
				match(T__0);
				setState(318);
				((OpContext)_localctx).d = op(0);
				setState(319);
				match(T__3);

				      ((OpContext)_localctx).code =  calculerPPCM(((OpContext)_localctx).c.code, ((OpContext)_localctx).d.code);
				    
				}
				break;
			case T__4:
				{
				setState(322);
				((OpContext)_localctx).lireint = lireint();
				((OpContext)_localctx).code =  ((OpContext)_localctx).lireint.code;
				}
				break;
			case ENTIER:
				{
				setState(325);
				((OpContext)_localctx).ENTIER = match(ENTIER);
				((OpContext)_localctx).code =  "PUSHI " + (((OpContext)_localctx).ENTIER!=null?((OpContext)_localctx).ENTIER.getText():null) + "\n";
				}
				break;
			case ID:
				{
				setState(327);
				((OpContext)_localctx).ID = match(ID);

				    int p = labels.get((((OpContext)_localctx).ID!=null?((OpContext)_localctx).ID.getText():null)).getAdresse();
				    ((OpContext)_localctx).code =  "PUSHG " + (p-1) + "\n" +
				            "PUSHG " + p + "\n";
				  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(338);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OpContext(_parentctx, _parentState);
					_localctx.e = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_op);
					setState(331);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(332);
					match(T__19);
					setState(333);
					((OpContext)_localctx).f = op(5);
					((OpContext)_localctx).code =  ((OpContext)_localctx).e.code + ((OpContext)_localctx).f.code;
					}
					} 
				}
				setState(340);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
	public static class Op2Context extends ParserRuleContext {
		public String code;
		public Op2Context c;
		public Op2Context d;
		public Token ENTIER;
		public List<Op2Context> op2() {
			return getRuleContexts(Op2Context.class);
		}
		public Op2Context op2(int i) {
			return getRuleContext(Op2Context.class,i);
		}
		public TerminalNode ENTIER() { return getToken(RationnelParser.ENTIER, 0); }
		public Op2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op2; }
	}

	public final Op2Context op2() throws RecognitionException {
		Op2Context _localctx = new Op2Context(_ctx, getState());
		enterRule(_localctx, 34, RULE_op2);
		try {
			setState(357);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(341);
				match(T__26);
				setState(342);
				((Op2Context)_localctx).c = op2();
				setState(343);
				match(T__0);
				setState(344);
				((Op2Context)_localctx).d = op2();
				setState(345);
				match(T__3);

				      ((Op2Context)_localctx).code =  calculerPGCD(((Op2Context)_localctx).c.code, ((Op2Context)_localctx).d.code);
				    
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 2);
				{
				setState(348);
				match(T__27);
				setState(349);
				((Op2Context)_localctx).c = op2();
				setState(350);
				match(T__0);
				setState(351);
				((Op2Context)_localctx).d = op2();
				setState(352);
				match(T__3);

				      ((Op2Context)_localctx).code =  calculerPPCM(((Op2Context)_localctx).c.code, ((Op2Context)_localctx).d.code);
				    
				}
				break;
			case ENTIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(355);
				((Op2Context)_localctx).ENTIER = match(ENTIER);
				((Op2Context)_localctx).code =  "PUSHI " + (((Op2Context)_localctx).ENTIER!=null?((Op2Context)_localctx).ENTIER.getText():null) + "\n";
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
	public static class Op3Context extends ParserRuleContext {
		public String code;
		public Token ENTIER;
		public TerminalNode ENTIER() { return getToken(RationnelParser.ENTIER, 0); }
		public Op3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op3; }
	}

	public final Op3Context op3() throws RecognitionException {
		Op3Context _localctx = new Op3Context(_ctx, getState());
		enterRule(_localctx, 36, RULE_op3);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			((Op3Context)_localctx).ENTIER = match(ENTIER);
			((Op3Context)_localctx).code =  "PUSHI " + (((Op3Context)_localctx).ENTIER!=null?((Op3Context)_localctx).ENTIER.getText():null) + "\n"+ "PUSHI 1" + "\n";
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
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_exprRegbool, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(363);
				match(T__13);
				setState(364);
				((ExprRegboolContext)_localctx).exprRegbool = exprRegbool(0);
				setState(365);
				match(T__3);
				((ExprRegboolContext)_localctx).code =  ((ExprRegboolContext)_localctx).exprRegbool.code;
				}
				break;
			case 2:
				{
				setState(368);
				match(T__28);
				setState(369);
				((ExprRegboolContext)_localctx).d = ((ExprRegboolContext)_localctx).exprRegbool = exprRegbool(9);
				((ExprRegboolContext)_localctx).code =  "PUSHI 1\n" +  ((ExprRegboolContext)_localctx).d.code + "SUB\n";
				}
				break;
			case 3:
				{
				setState(372);
				((ExprRegboolContext)_localctx).e = exprReg(0);
				setState(373);
				match(T__31);
				setState(374);
				((ExprRegboolContext)_localctx).f = exprReg(0);
				((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).e.code, ((ExprRegboolContext)_localctx).f.code, "SUP"); 
				}
				break;
			case 4:
				{
				setState(377);
				((ExprRegboolContext)_localctx).e = exprReg(0);
				setState(378);
				match(T__32);
				setState(379);
				((ExprRegboolContext)_localctx).f = exprReg(0);
				((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).e.code, ((ExprRegboolContext)_localctx).f.code, "INF"); 
				}
				break;
			case 5:
				{
				setState(382);
				((ExprRegboolContext)_localctx).e = exprReg(0);
				setState(383);
				match(T__33);
				setState(384);
				((ExprRegboolContext)_localctx).f = exprReg(0);
				((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).e.code, ((ExprRegboolContext)_localctx).f.code, "SUPEQ"); 
				}
				break;
			case 6:
				{
				setState(387);
				((ExprRegboolContext)_localctx).e = exprReg(0);
				setState(388);
				match(T__34);
				setState(389);
				((ExprRegboolContext)_localctx).f = exprReg(0);
				((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).e.code, ((ExprRegboolContext)_localctx).f.code, "INFEQ"); 
				}
				break;
			case 7:
				{
				setState(392);
				((ExprRegboolContext)_localctx).e = exprReg(0);
				setState(393);
				match(T__35);
				setState(394);
				((ExprRegboolContext)_localctx).f = exprReg(0);
				((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).e.code, ((ExprRegboolContext)_localctx).f.code, "EQUAL");
				}
				break;
			case 8:
				{
				setState(397);
				((ExprRegboolContext)_localctx).e = exprReg(0);
				setState(398);
				match(T__36);
				setState(399);
				((ExprRegboolContext)_localctx).f = exprReg(0);
				((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).e.code, ((ExprRegboolContext)_localctx).f.code, "NEQ");
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(416);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(414);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new ExprRegboolContext(_parentctx, _parentState);
						_localctx.d = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exprRegbool);
						setState(404);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(405);
						match(T__29);
						setState(406);
						((ExprRegboolContext)_localctx).g = ((ExprRegboolContext)_localctx).exprRegbool = exprRegbool(9);
						((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).d.code, ((ExprRegboolContext)_localctx).g.code, "and"); 
						}
						break;
					case 2:
						{
						_localctx = new ExprRegboolContext(_parentctx, _parentState);
						_localctx.d = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exprRegbool);
						setState(409);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(410);
						match(T__30);
						setState(411);
						((ExprRegboolContext)_localctx).g = ((ExprRegboolContext)_localctx).exprRegbool = exprRegbool(8);
						((ExprRegboolContext)_localctx).code =  calcul_expr_reg_bool(((ExprRegboolContext)_localctx).d.code, ((ExprRegboolContext)_localctx).g.code, "or"); 
						}
						break;
					}
					} 
				}
				setState(418);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
		case 14:
			return exprReg_sempred((ExprRegContext)_localctx, predIndex);
		case 16:
			return op_sempred((OpContext)_localctx, predIndex);
		case 19:
			return exprRegbool_sempred((ExprRegboolContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exprReg_sempred(ExprRegContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 13);
		}
		return true;
	}
	private boolean op_sempred(OpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 4);
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
		"\u0004\u0001-\u01a4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		",\b\u0000\n\u0000\f\u0000/\t\u0000\u0001\u0000\u0005\u00002\b\u0000\n"+
		"\u0000\f\u00005\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		":\b\u0000\n\u0000\f\u0000=\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"_\b\u0001\u0001\u0002\u0004\u0002b\b\u0002\u000b\u0002\f\u0002c\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003n\b\u0003\n\u0003\f\u0003q\t\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003v\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004~\b"+
		"\u0004\n\u0004\f\u0004\u0081\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0090\b\u0005"+
		"\n\u0005\f\u0005\u0093\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00a2\b\u0006\n"+
		"\u0006\f\u0006\u00a5\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0004\f\u00c6"+
		"\b\f\u000b\f\f\f\u00c7\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0109\b\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0005\u000e\u0124\b\u000e\n\u000e\f\u000e\u0127\t\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0003\u000f\u0132\b\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0003\u0010\u014a\b\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u0151\b\u0010\n\u0010"+
		"\f\u0010\u0154\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u0166\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0193\b\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u019f\b\u0013\n\u0013"+
		"\f\u0013\u01a2\t\u0013\u0001\u0013\u0000\u0003\u001c &\u0014\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&\u0000\u0001\u0002\u0000((,,\u01c5\u0000-\u0001\u0000\u0000\u0000"+
		"\u0002^\u0001\u0000\u0000\u0000\u0004a\u0001\u0000\u0000\u0000\u0006u"+
		"\u0001\u0000\u0000\u0000\b\u007f\u0001\u0000\u0000\u0000\n\u0091\u0001"+
		"\u0000\u0000\u0000\f\u00a3\u0001\u0000\u0000\u0000\u000e\u00ad\u0001\u0000"+
		"\u0000\u0000\u0010\u00b3\u0001\u0000\u0000\u0000\u0012\u00b6\u0001\u0000"+
		"\u0000\u0000\u0014\u00b9\u0001\u0000\u0000\u0000\u0016\u00bc\u0001\u0000"+
		"\u0000\u0000\u0018\u00c0\u0001\u0000\u0000\u0000\u001a\u00c9\u0001\u0000"+
		"\u0000\u0000\u001c\u0108\u0001\u0000\u0000\u0000\u001e\u0131\u0001\u0000"+
		"\u0000\u0000 \u0149\u0001\u0000\u0000\u0000\"\u0165\u0001\u0000\u0000"+
		"\u0000$\u0167\u0001\u0000\u0000\u0000&\u0192\u0001\u0000\u0000\u0000("+
		")\u0003\u0006\u0003\u0000)*\u0006\u0000\uffff\uffff\u0000*,\u0001\u0000"+
		"\u0000\u0000+(\u0001\u0000\u0000\u0000,/\u0001\u0000\u0000\u0000-+\u0001"+
		"\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000.3\u0001\u0000\u0000\u0000"+
		"/-\u0001\u0000\u0000\u000002\u0005(\u0000\u000010\u0001\u0000\u0000\u0000"+
		"25\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u000034\u0001\u0000\u0000"+
		"\u00004;\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000067\u0003\u0002"+
		"\u0001\u000078\u0006\u0000\uffff\uffff\u00008:\u0001\u0000\u0000\u0000"+
		"96\u0001\u0000\u0000\u0000:=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000"+
		"\u0000;<\u0001\u0000\u0000\u0000<>\u0001\u0000\u0000\u0000=;\u0001\u0000"+
		"\u0000\u0000>?\u0006\u0000\uffff\uffff\u0000?\u0001\u0001\u0000\u0000"+
		"\u0000@A\u0003\u0006\u0003\u0000AB\u0006\u0001\uffff\uffff\u0000B_\u0001"+
		"\u0000\u0000\u0000CD\u0003\b\u0004\u0000DE\u0006\u0001\uffff\uffff\u0000"+
		"E_\u0001\u0000\u0000\u0000FG\u0003\n\u0005\u0000GH\u0006\u0001\uffff\uffff"+
		"\u0000H_\u0001\u0000\u0000\u0000IJ\u0003\f\u0006\u0000JK\u0006\u0001\uffff"+
		"\uffff\u0000K_\u0001\u0000\u0000\u0000LM\u0003\u001c\u000e\u0000MN\u0006"+
		"\u0001\uffff\uffff\u0000N_\u0001\u0000\u0000\u0000OP\u0003&\u0013\u0000"+
		"PQ\u0006\u0001\uffff\uffff\u0000Q_\u0001\u0000\u0000\u0000RS\u0003\u001e"+
		"\u000f\u0000ST\u0006\u0001\uffff\uffff\u0000T_\u0001\u0000\u0000\u0000"+
		"UV\u0003\u000e\u0007\u0000VW\u0006\u0001\uffff\uffff\u0000W_\u0001\u0000"+
		"\u0000\u0000XY\u0003\u0016\u000b\u0000YZ\u0006\u0001\uffff\uffff\u0000"+
		"Z_\u0001\u0000\u0000\u0000[\\\u0003\u0004\u0002\u0000\\]\u0006\u0001\uffff"+
		"\uffff\u0000]_\u0001\u0000\u0000\u0000^@\u0001\u0000\u0000\u0000^C\u0001"+
		"\u0000\u0000\u0000^F\u0001\u0000\u0000\u0000^I\u0001\u0000\u0000\u0000"+
		"^L\u0001\u0000\u0000\u0000^O\u0001\u0000\u0000\u0000^R\u0001\u0000\u0000"+
		"\u0000^U\u0001\u0000\u0000\u0000^X\u0001\u0000\u0000\u0000^[\u0001\u0000"+
		"\u0000\u0000_\u0003\u0001\u0000\u0000\u0000`b\u0007\u0000\u0000\u0000"+
		"a`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000"+
		"\u0000cd\u0001\u0000\u0000\u0000d\u0005\u0001\u0000\u0000\u0000ef\u0005"+
		"&\u0000\u0000fg\u0005\'\u0000\u0000gh\u0005,\u0000\u0000hv\u0006\u0003"+
		"\uffff\uffff\u0000io\u0005&\u0000\u0000jk\u0005\'\u0000\u0000kl\u0006"+
		"\u0003\uffff\uffff\u0000ln\u0005\u0001\u0000\u0000mj\u0001\u0000\u0000"+
		"\u0000nq\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000"+
		"\u0000\u0000pr\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000rs\u0005"+
		"\'\u0000\u0000st\u0005,\u0000\u0000tv\u0006\u0003\uffff\uffff\u0000ue"+
		"\u0001\u0000\u0000\u0000ui\u0001\u0000\u0000\u0000v\u0007\u0001\u0000"+
		"\u0000\u0000wx\u0005\'\u0000\u0000xy\u0005\u0002\u0000\u0000yz\u0003\""+
		"\u0011\u0000z{\u0005\u0001\u0000\u0000{|\u0006\u0004\uffff\uffff\u0000"+
		"|~\u0001\u0000\u0000\u0000}w\u0001\u0000\u0000\u0000~\u0081\u0001\u0000"+
		"\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000"+
		"\u0000\u0080\u0082\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000"+
		"\u0000\u0082\u0083\u0005\'\u0000\u0000\u0083\u0084\u0005\u0002\u0000\u0000"+
		"\u0084\u0085\u0003\"\u0011\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086"+
		"\u0087\u0005,\u0000\u0000\u0087\u0088\u0006\u0004\uffff\uffff\u0000\u0088"+
		"\t\u0001\u0000\u0000\u0000\u0089\u008a\u0005\'\u0000\u0000\u008a\u008b"+
		"\u0005\u0002\u0000\u0000\u008b\u008c\u0003\u001c\u000e\u0000\u008c\u008d"+
		"\u0005\u0001\u0000\u0000\u008d\u008e\u0006\u0005\uffff\uffff\u0000\u008e"+
		"\u0090\u0001\u0000\u0000\u0000\u008f\u0089\u0001\u0000\u0000\u0000\u0090"+
		"\u0093\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0001\u0000\u0000\u0000\u0092\u0094\u0001\u0000\u0000\u0000\u0093"+
		"\u0091\u0001\u0000\u0000\u0000\u0094\u0095\u0005\'\u0000\u0000\u0095\u0096"+
		"\u0005\u0002\u0000\u0000\u0096\u0097\u0003\u001c\u000e\u0000\u0097\u0098"+
		"\u0001\u0000\u0000\u0000\u0098\u0099\u0005,\u0000\u0000\u0099\u009a\u0006"+
		"\u0005\uffff\uffff\u0000\u009a\u000b\u0001\u0000\u0000\u0000\u009b\u009c"+
		"\u0005\'\u0000\u0000\u009c\u009d\u0005\u0002\u0000\u0000\u009d\u009e\u0003"+
		"\u001e\u000f\u0000\u009e\u009f\u0005\u0001\u0000\u0000\u009f\u00a0\u0006"+
		"\u0006\uffff\uffff\u0000\u00a0\u00a2\u0001\u0000\u0000\u0000\u00a1\u009b"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000\u00a3\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6\u00a7"+
		"\u0005\'\u0000\u0000\u00a7\u00a8\u0005\u0002\u0000\u0000\u00a8\u00a9\u0003"+
		"\u001e\u000f\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005"+
		",\u0000\u0000\u00ab\u00ac\u0006\u0006\uffff\uffff\u0000\u00ac\r\u0001"+
		"\u0000\u0000\u0000\u00ad\u00ae\u0005\u0003\u0000\u0000\u00ae\u00af\u0003"+
		"\u001c\u000e\u0000\u00af\u00b0\u0005\u0004\u0000\u0000\u00b0\u00b1\u0005"+
		",\u0000\u0000\u00b1\u00b2\u0006\u0007\uffff\uffff\u0000\u00b2\u000f\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b4\u0005\u0005\u0000\u0000\u00b4\u00b5\u0006"+
		"\b\uffff\uffff\u0000\u00b5\u0011\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005"+
		"\u0005\u0000\u0000\u00b7\u00b8\u0006\t\uffff\uffff\u0000\u00b8\u0013\u0001"+
		"\u0000\u0000\u0000\u00b9\u00ba\u0005\u0005\u0000\u0000\u00ba\u00bb\u0006"+
		"\n\uffff\uffff\u0000\u00bb\u0015\u0001\u0000\u0000\u0000\u00bc\u00bd\u0003"+
		"\u0018\f\u0000\u00bd\u00be\u0003\u001a\r\u0000\u00be\u00bf\u0006\u000b"+
		"\uffff\uffff\u0000\u00bf\u0017\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005"+
		"\u0006\u0000\u0000\u00c1\u00c5\u0006\f\uffff\uffff\u0000\u00c2\u00c3\u0003"+
		"\u0002\u0001\u0000\u00c3\u00c4\u0006\f\uffff\uffff\u0000\u00c4\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c2\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001"+
		"\u0000\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001"+
		"\u0000\u0000\u0000\u00c8\u0019\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005"+
		"\u0007\u0000\u0000\u00ca\u00cb\u0003&\u0013\u0000\u00cb\u00cc\u0006\r"+
		"\uffff\uffff\u0000\u00cc\u001b\u0001\u0000\u0000\u0000\u00cd\u00ce\u0006"+
		"\u000e\uffff\uffff\u0000\u00ce\u00cf\u0005\b\u0000\u0000\u00cf\u00d0\u0003"+
		"\u001c\u000e\u0000\u00d0\u00d1\u0005\t\u0000\u0000\u00d1\u00d2\u0006\u000e"+
		"\uffff\uffff\u0000\u00d2\u0109\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005"+
		"\n\u0000\u0000\u00d4\u00d5\u0003\u001c\u000e\u0000\u00d5\u00d6\u0005\u000b"+
		"\u0000\u0000\u00d6\u00d7\u0006\u000e\uffff\uffff\u0000\u00d7\u0109\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d9\u0005\f\u0000\u0000\u00d9\u00da\u0003\u001c"+
		"\u000e\u0000\u00da\u00db\u0005\r\u0000\u0000\u00db\u00dc\u0006\u000e\uffff"+
		"\uffff\u0000\u00dc\u0109\u0001\u0000\u0000\u0000\u00dd\u00de\u0005\u000e"+
		"\u0000\u0000\u00de\u00df\u0003\u001c\u000e\u0000\u00df\u00e0\u0005\u0004"+
		"\u0000\u0000\u00e0\u00e1\u0006\u000e\uffff\uffff\u0000\u00e1\u0109\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e3\u0005\u0013\u0000\u0000\u00e3\u00e4\u0003"+
		"\u001c\u000e\b\u00e4\u00e5\u0006\u000e\uffff\uffff\u0000\u00e5\u0109\u0001"+
		"\u0000\u0000\u0000\u00e6\u00e7\u0003 \u0010\u0000\u00e7\u00e8\u0005\u0014"+
		"\u0000\u0000\u00e8\u00e9\u0003 \u0010\u0000\u00e9\u00ea\u0005\u0015\u0000"+
		"\u0000\u00ea\u00eb\u0006\u000e\uffff\uffff\u0000\u00eb\u0109\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ed\u0005\u0016\u0000\u0000\u00ed\u00ee\u0005*\u0000"+
		"\u0000\u00ee\u00ef\u0005\u0014\u0000\u0000\u00ef\u00f0\u0005*\u0000\u0000"+
		"\u00f0\u00f1\u0005\u0004\u0000\u0000\u00f1\u0109\u0006\u000e\uffff\uffff"+
		"\u0000\u00f2\u00f3\u0005\u0017\u0000\u0000\u00f3\u00f4\u0003 \u0010\u0000"+
		"\u00f4\u00f5\u0005\u0014\u0000\u0000\u00f5\u00f6\u0003 \u0010\u0000\u00f6"+
		"\u00f7\u0005\u0004\u0000\u0000\u00f7\u00f8\u0006\u000e\uffff\uffff\u0000"+
		"\u00f8\u0109\u0001\u0000\u0000\u0000\u00f9\u00fa\u0005\u0018\u0000\u0000"+
		"\u00fa\u00fb\u0005*\u0000\u0000\u00fb\u00fc\u0005\u0014\u0000\u0000\u00fc"+
		"\u00fd\u0005*\u0000\u0000\u00fd\u00fe\u0005\u0004\u0000\u0000\u00fe\u0109"+
		"\u0006\u000e\uffff\uffff\u0000\u00ff\u0100\u0003\u0012\t\u0000\u0100\u0101"+
		"\u0006\u000e\uffff\uffff\u0000\u0101\u0109\u0001\u0000\u0000\u0000\u0102"+
		"\u0103\u0003$\u0012\u0000\u0103\u0104\u0006\u000e\uffff\uffff\u0000\u0104"+
		"\u0109\u0001\u0000\u0000\u0000\u0105\u0106\u0003 \u0010\u0000\u0106\u0107"+
		"\u0006\u000e\uffff\uffff\u0000\u0107\u0109\u0001\u0000\u0000\u0000\u0108"+
		"\u00cd\u0001\u0000\u0000\u0000\u0108\u00d3\u0001\u0000\u0000\u0000\u0108"+
		"\u00d8\u0001\u0000\u0000\u0000\u0108\u00dd\u0001\u0000\u0000\u0000\u0108"+
		"\u00e2\u0001\u0000\u0000\u0000\u0108\u00e6\u0001\u0000\u0000\u0000\u0108"+
		"\u00ec\u0001\u0000\u0000\u0000\u0108\u00f2\u0001\u0000\u0000\u0000\u0108"+
		"\u00f9\u0001\u0000\u0000\u0000\u0108\u00ff\u0001\u0000\u0000\u0000\u0108"+
		"\u0102\u0001\u0000\u0000\u0000\u0108\u0105\u0001\u0000\u0000\u0000\u0109"+
		"\u0125\u0001\u0000\u0000\u0000\u010a\u010b\n\f\u0000\u0000\u010b\u010c"+
		"\u0005\u0010\u0000\u0000\u010c\u010d\u0003\u001c\u000e\r\u010d\u010e\u0006"+
		"\u000e\uffff\uffff\u0000\u010e\u0124\u0001\u0000\u0000\u0000\u010f\u0110"+
		"\n\u000b\u0000\u0000\u0110\u0111\u0005\u0011\u0000\u0000\u0111\u0112\u0003"+
		"\u001c\u000e\f\u0112\u0113\u0006\u000e\uffff\uffff\u0000\u0113\u0124\u0001"+
		"\u0000\u0000\u0000\u0114\u0115\n\n\u0000\u0000\u0115\u0116\u0005\u0012"+
		"\u0000\u0000\u0116\u0117\u0003\u001c\u000e\u000b\u0117\u0118\u0006\u000e"+
		"\uffff\uffff\u0000\u0118\u0124\u0001\u0000\u0000\u0000\u0119\u011a\n\t"+
		"\u0000\u0000\u011a\u011b\u0005\u0013\u0000\u0000\u011b\u011c\u0003\u001c"+
		"\u000e\n\u011c\u011d\u0006\u000e\uffff\uffff\u0000\u011d\u0124\u0001\u0000"+
		"\u0000\u0000\u011e\u011f\n\r\u0000\u0000\u011f\u0120\u0005\u000f\u0000"+
		"\u0000\u0120\u0121\u0003 \u0010\u0000\u0121\u0122\u0006\u000e\uffff\uffff"+
		"\u0000\u0122\u0124\u0001\u0000\u0000\u0000\u0123\u010a\u0001\u0000\u0000"+
		"\u0000\u0123\u010f\u0001\u0000\u0000\u0000\u0123\u0114\u0001\u0000\u0000"+
		"\u0000\u0123\u0119\u0001\u0000\u0000\u0000\u0123\u011e\u0001\u0000\u0000"+
		"\u0000\u0124\u0127\u0001\u0000\u0000\u0000\u0125\u0123\u0001\u0000\u0000"+
		"\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126\u001d\u0001\u0000\u0000"+
		"\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0128\u0129\u0005\u0019\u0000"+
		"\u0000\u0129\u0132\u0006\u000f\uffff\uffff\u0000\u012a\u012b\u0005\u001a"+
		"\u0000\u0000\u012b\u0132\u0006\u000f\uffff\uffff\u0000\u012c\u012d\u0003"+
		"\u0014\n\u0000\u012d\u012e\u0006\u000f\uffff\uffff\u0000\u012e\u0132\u0001"+
		"\u0000\u0000\u0000\u012f\u0130\u0005+\u0000\u0000\u0130\u0132\u0006\u000f"+
		"\uffff\uffff\u0000\u0131\u0128\u0001\u0000\u0000\u0000\u0131\u012a\u0001"+
		"\u0000\u0000\u0000\u0131\u012c\u0001\u0000\u0000\u0000\u0131\u012f\u0001"+
		"\u0000\u0000\u0000\u0132\u001f\u0001\u0000\u0000\u0000\u0133\u0134\u0006"+
		"\u0010\uffff\uffff\u0000\u0134\u0135\u0005\u001b\u0000\u0000\u0135\u0136"+
		"\u0003 \u0010\u0000\u0136\u0137\u0005\u0001\u0000\u0000\u0137\u0138\u0003"+
		" \u0010\u0000\u0138\u0139\u0005\u0004\u0000\u0000\u0139\u013a\u0006\u0010"+
		"\uffff\uffff\u0000\u013a\u014a\u0001\u0000\u0000\u0000\u013b\u013c\u0005"+
		"\u001c\u0000\u0000\u013c\u013d\u0003 \u0010\u0000\u013d\u013e\u0005\u0001"+
		"\u0000\u0000\u013e\u013f\u0003 \u0010\u0000\u013f\u0140\u0005\u0004\u0000"+
		"\u0000\u0140\u0141\u0006\u0010\uffff\uffff\u0000\u0141\u014a\u0001\u0000"+
		"\u0000\u0000\u0142\u0143\u0003\u0010\b\u0000\u0143\u0144\u0006\u0010\uffff"+
		"\uffff\u0000\u0144\u014a\u0001\u0000\u0000\u0000\u0145\u0146\u0005*\u0000"+
		"\u0000\u0146\u014a\u0006\u0010\uffff\uffff\u0000\u0147\u0148\u0005\'\u0000"+
		"\u0000\u0148\u014a\u0006\u0010\uffff\uffff\u0000\u0149\u0133\u0001\u0000"+
		"\u0000\u0000\u0149\u013b\u0001\u0000\u0000\u0000\u0149\u0142\u0001\u0000"+
		"\u0000\u0000\u0149\u0145\u0001\u0000\u0000\u0000\u0149\u0147\u0001\u0000"+
		"\u0000\u0000\u014a\u0152\u0001\u0000\u0000\u0000\u014b\u014c\n\u0004\u0000"+
		"\u0000\u014c\u014d\u0005\u0014\u0000\u0000\u014d\u014e\u0003 \u0010\u0005"+
		"\u014e\u014f\u0006\u0010\uffff\uffff\u0000\u014f\u0151\u0001\u0000\u0000"+
		"\u0000\u0150\u014b\u0001\u0000\u0000\u0000\u0151\u0154\u0001\u0000\u0000"+
		"\u0000\u0152\u0150\u0001\u0000\u0000\u0000\u0152\u0153\u0001\u0000\u0000"+
		"\u0000\u0153!\u0001\u0000\u0000\u0000\u0154\u0152\u0001\u0000\u0000\u0000"+
		"\u0155\u0156\u0005\u001b\u0000\u0000\u0156\u0157\u0003\"\u0011\u0000\u0157"+
		"\u0158\u0005\u0001\u0000\u0000\u0158\u0159\u0003\"\u0011\u0000\u0159\u015a"+
		"\u0005\u0004\u0000\u0000\u015a\u015b\u0006\u0011\uffff\uffff\u0000\u015b"+
		"\u0166\u0001\u0000\u0000\u0000\u015c\u015d\u0005\u001c\u0000\u0000\u015d"+
		"\u015e\u0003\"\u0011\u0000\u015e\u015f\u0005\u0001\u0000\u0000\u015f\u0160"+
		"\u0003\"\u0011\u0000\u0160\u0161\u0005\u0004\u0000\u0000\u0161\u0162\u0006"+
		"\u0011\uffff\uffff\u0000\u0162\u0166\u0001\u0000\u0000\u0000\u0163\u0164"+
		"\u0005*\u0000\u0000\u0164\u0166\u0006\u0011\uffff\uffff\u0000\u0165\u0155"+
		"\u0001\u0000\u0000\u0000\u0165\u015c\u0001\u0000\u0000\u0000\u0165\u0163"+
		"\u0001\u0000\u0000\u0000\u0166#\u0001\u0000\u0000\u0000\u0167\u0168\u0005"+
		"*\u0000\u0000\u0168\u0169\u0006\u0012\uffff\uffff\u0000\u0169%\u0001\u0000"+
		"\u0000\u0000\u016a\u016b\u0006\u0013\uffff\uffff\u0000\u016b\u016c\u0005"+
		"\u000e\u0000\u0000\u016c\u016d\u0003&\u0013\u0000\u016d\u016e\u0005\u0004"+
		"\u0000\u0000\u016e\u016f\u0006\u0013\uffff\uffff\u0000\u016f\u0193\u0001"+
		"\u0000\u0000\u0000\u0170\u0171\u0005\u001d\u0000\u0000\u0171\u0172\u0003"+
		"&\u0013\t\u0172\u0173\u0006\u0013\uffff\uffff\u0000\u0173\u0193\u0001"+
		"\u0000\u0000\u0000\u0174\u0175\u0003\u001c\u000e\u0000\u0175\u0176\u0005"+
		" \u0000\u0000\u0176\u0177\u0003\u001c\u000e\u0000\u0177\u0178\u0006\u0013"+
		"\uffff\uffff\u0000\u0178\u0193\u0001\u0000\u0000\u0000\u0179\u017a\u0003"+
		"\u001c\u000e\u0000\u017a\u017b\u0005!\u0000\u0000\u017b\u017c\u0003\u001c"+
		"\u000e\u0000\u017c\u017d\u0006\u0013\uffff\uffff\u0000\u017d\u0193\u0001"+
		"\u0000\u0000\u0000\u017e\u017f\u0003\u001c\u000e\u0000\u017f\u0180\u0005"+
		"\"\u0000\u0000\u0180\u0181\u0003\u001c\u000e\u0000\u0181\u0182\u0006\u0013"+
		"\uffff\uffff\u0000\u0182\u0193\u0001\u0000\u0000\u0000\u0183\u0184\u0003"+
		"\u001c\u000e\u0000\u0184\u0185\u0005#\u0000\u0000\u0185\u0186\u0003\u001c"+
		"\u000e\u0000\u0186\u0187\u0006\u0013\uffff\uffff\u0000\u0187\u0193\u0001"+
		"\u0000\u0000\u0000\u0188\u0189\u0003\u001c\u000e\u0000\u0189\u018a\u0005"+
		"$\u0000\u0000\u018a\u018b\u0003\u001c\u000e\u0000\u018b\u018c\u0006\u0013"+
		"\uffff\uffff\u0000\u018c\u0193\u0001\u0000\u0000\u0000\u018d\u018e\u0003"+
		"\u001c\u000e\u0000\u018e\u018f\u0005%\u0000\u0000\u018f\u0190\u0003\u001c"+
		"\u000e\u0000\u0190\u0191\u0006\u0013\uffff\uffff\u0000\u0191\u0193\u0001"+
		"\u0000\u0000\u0000\u0192\u016a\u0001\u0000\u0000\u0000\u0192\u0170\u0001"+
		"\u0000\u0000\u0000\u0192\u0174\u0001\u0000\u0000\u0000\u0192\u0179\u0001"+
		"\u0000\u0000\u0000\u0192\u017e\u0001\u0000\u0000\u0000\u0192\u0183\u0001"+
		"\u0000\u0000\u0000\u0192\u0188\u0001\u0000\u0000\u0000\u0192\u018d\u0001"+
		"\u0000\u0000\u0000\u0193\u01a0\u0001\u0000\u0000\u0000\u0194\u0195\n\b"+
		"\u0000\u0000\u0195\u0196\u0005\u001e\u0000\u0000\u0196\u0197\u0003&\u0013"+
		"\t\u0197\u0198\u0006\u0013\uffff\uffff\u0000\u0198\u019f\u0001\u0000\u0000"+
		"\u0000\u0199\u019a\n\u0007\u0000\u0000\u019a\u019b\u0005\u001f\u0000\u0000"+
		"\u019b\u019c\u0003&\u0013\b\u019c\u019d\u0006\u0013\uffff\uffff\u0000"+
		"\u019d\u019f\u0001\u0000\u0000\u0000\u019e\u0194\u0001\u0000\u0000\u0000"+
		"\u019e\u0199\u0001\u0000\u0000\u0000\u019f\u01a2\u0001\u0000\u0000\u0000"+
		"\u01a0\u019e\u0001\u0000\u0000\u0000\u01a0\u01a1\u0001\u0000\u0000\u0000"+
		"\u01a1\'\u0001\u0000\u0000\u0000\u01a2\u01a0\u0001\u0000\u0000\u0000\u0015"+
		"-3;^cou\u007f\u0091\u00a3\u00c7\u0108\u0123\u0125\u0131\u0149\u0152\u0165"+
		"\u0192\u019e\u01a0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}