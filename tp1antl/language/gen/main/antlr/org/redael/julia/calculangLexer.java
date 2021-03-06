// Generated from C:/Users/Reda El Ouahabi/IdeaProjects/tp1antl/language/src/main/antlr/org/redael/julia\calculang.g4 by ANTLR 4.8
package main.antlr.org.redael.julia;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class calculangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, WS=2, DIGIT=3, INT=4, FLOAT=5, X=6, IDENTIFIER=7, MUL=8, DIV=9, 
		ADD=10, SUB=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "WS", "DIGIT", "INT", "FLOAT", "X", "IDENTIFIER", "MUL", "DIV", 
			"ADD", "SUB"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", null, "'1234'", null, null, null, null, "'*'", "'/'", "'+'", 
			"'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "WS", "DIGIT", "INT", "FLOAT", "X", "IDENTIFIER", "MUL", 
			"DIV", "ADD", "SUB"
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


	public calculangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "calculang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\r?\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\3\6\3\35\n\3\r\3\16\3\36\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\6\5)\n\5\r\5\16\5*\3\6\3\6\3\6\3\6\3\7\3\7\3\b\6\b\64\n\b\r\b"+
		"\16\b\65\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\2\2\r\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\3\2\4\5\2\13\f\16\17\"\"\5\2--C\\c|\2A"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\3\31\3\2\2\2\5\34\3\2\2\2\7\"\3\2\2\2\t(\3\2\2\2\13,\3\2\2\2\r\60\3\2"+
		"\2\2\17\63\3\2\2\2\21\67\3\2\2\2\239\3\2\2\2\25;\3\2\2\2\27=\3\2\2\2\31"+
		"\32\7?\2\2\32\4\3\2\2\2\33\35\t\2\2\2\34\33\3\2\2\2\35\36\3\2\2\2\36\34"+
		"\3\2\2\2\36\37\3\2\2\2\37 \3\2\2\2 !\b\3\2\2!\6\3\2\2\2\"#\7\63\2\2#$"+
		"\7\64\2\2$%\7\65\2\2%&\7\66\2\2&\b\3\2\2\2\')\5\7\4\2(\'\3\2\2\2)*\3\2"+
		"\2\2*(\3\2\2\2*+\3\2\2\2+\n\3\2\2\2,-\5\t\5\2-.\7\60\2\2./\5\t\5\2/\f"+
		"\3\2\2\2\60\61\t\3\2\2\61\16\3\2\2\2\62\64\5\t\5\2\63\62\3\2\2\2\64\65"+
		"\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\20\3\2\2\2\678\7,\2\28\22\3\2"+
		"\2\29:\7\61\2\2:\24\3\2\2\2;<\7-\2\2<\26\3\2\2\2=>\7/\2\2>\30\3\2\2\2"+
		"\6\2\36*\65\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}