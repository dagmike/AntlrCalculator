package calculator;

import java.util.Stack;

import calclang.*;

public class WorkerListener extends CalculatorBaseListener {
    Stack<Integer> stack = new Stack<Integer>();

    @Override
    public void enterProg(CalculatorParser.ProgContext ctx) {
        System.out.println("enterProg");
    }

    @Override
    public void exitProg(CalculatorParser.ProgContext ctx) {
        System.out.println("exitProg");
        System.out.println("The result is " + stack.pop());
    }

    @Override
    public void enterExprStat(CalculatorParser.ExprStatContext ctx) {
        System.out.println("enterStatExpr");
    }

    @Override
    public void exitExprStat(CalculatorParser.ExprStatContext ctx) {
        System.out.println("exitStatExpr");
    }

    /*
     * ADDITION
     */
    @Override
    public void enterAdd(CalculatorParser.AddContext ctx) {
        System.out.println("enterAdd");
    }

    @Override
    public void exitAdd(CalculatorParser.AddContext ctx) {
        System.out.println("exitAdd");
        int rhs = stack.pop();
        int lhs = stack.pop();
        int result = rhs + lhs;
        stack.push(result);
    }

    /*
     * SUBTRACTION
     */
    @Override
    public void enterSub(CalculatorParser.SubContext ctx) {
        System.out.println("enterSub");
    }

    @Override
    public void exitSub(CalculatorParser.SubContext ctx) {
        System.out.println("exitSub");
        int rhs = stack.pop();
        int lhs = stack.pop();
        int result = lhs - rhs;
        stack.push(result);
    }

    /*
     * MULTIPLICATION
     */
    @Override
    public void enterMul(CalculatorParser.MulContext ctx) {
        System.out.println("enterMul");
    }

    @Override
    public void exitMul(CalculatorParser.MulContext ctx) {
        System.out.println("exitMul");
        int rhs = stack.pop();
        int lhs = stack.pop();
        int result = lhs * rhs;
        stack.push(result);
    }

    /*
     * DIVISION (INTEGER ONLY)
     */
    @Override
    public void enterDiv(CalculatorParser.DivContext ctx) {
        System.out.println("enterDiv");
    }

    @Override
    public void exitDiv(CalculatorParser.DivContext ctx) {
        System.out.println("exitDiv");
        int rhs = stack.pop();
        int lhs = stack.pop();
        int result = lhs / rhs;
        stack.push(result);
    }

    @Override
    public void enterInt(CalculatorParser.IntContext ctx) {
        System.out.println("enterInt");
        int value = Integer.parseInt(ctx.getChild(0).getText());
        System.out.println("has value " + value);
        stack.push(value);
    }

    @Override
    public void exitInt(CalculatorParser.IntContext ctx) {
        System.out.println("exitInt");
    }

    /*
     * PARENTHESIS
     */
    @Override
    public void enterParens(CalculatorParser.ParensContext ctx) {
        System.out.println("enterParens");
    }

    @Override
    public void exitParens(CalculatorParser.ParensContext ctx) {
        System.out.println("exitParens");
    }
}
