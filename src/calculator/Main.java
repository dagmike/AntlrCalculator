package calculator;

import java.io.IOException;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import calclang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        CalculatorLexer lexer = new CalculatorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokens);
        ParseTree tree = parser.prog();

        System.out.println("\nVisitor...");
        // START Visitor Stuff
        WorkerVisitor worker = new WorkerVisitor();
        worker.visit(tree);
        // END Visitor Stuff


        System.out.println("\nListener...");
        // START Listener Stuff
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new WorkerListener(), tree);
        // END Listener Stuff
    }
}
