package antlr_syntax_analyzer;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

import antlr_syntax_analyzer.c_grammar.CGrammarLexer;
import antlr_syntax_analyzer.c_grammar.CGrammarParser;
import antlr_syntax_analyzer.c_grammar.CGrammarParser.CompilationUnitContext;

public class Main
{
	public static void main(String[] args)
	{
		if (args.length == 0)
		{
			System.out.println("Please, specify the path to the source file.");
			return;
		}

		try
		{
			ANTLRFileStream stream = new ANTLRFileStream(args[0], "UTF8");

			// Get the lexer
			CGrammarLexer lexer = new CGrammarLexer(stream);

			// Get a list of matched tokens
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			// Pass the tokens to the parser
			CGrammarParser parser = new CGrammarParser(tokens);

			// Specify the entry point
			CompilationUnitContext context = parser.compilationUnit();

			System.out.println(context.toStringTree(parser));
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
