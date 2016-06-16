package jscd.treegen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import jscd.treegen.antlr.grammar.java.JavaParser;

public class Treegen {

	private static Scanner scanner;

	
	
		public String trees(File file) throws FileNotFoundException{
	    	scanner = new Scanner(file);
	  		String content = scanner.useDelimiter("\\Z").next();
	    	  

	  		ANTLRInputStream input = new ANTLRInputStream( content );
	  		
	  		JavaLexer lexer = new JavaLexer(input);
	  		
	  		CommonTokenStream tokens = new CommonTokenStream(lexer);
	  		
	  		JavaParser parser = new JavaParser(tokens);
	  		
	  		ParseTree tree = parser.compilationUnit();
	  		AST ast = new AST(tree);
	  		
	  		//System.out.println( "ParseTree:\n" + tree.toStringTree( parser ) + "\n"); 
	  		//System.out.println( "Abstract Syntax Tree / based in AST class: \n" + ast.toString( ) + "\n");
			return ast.toString(); 
	      }
	    }


