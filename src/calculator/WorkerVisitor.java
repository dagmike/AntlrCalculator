package calculator;

import calclang.*;

public class WorkerVisitor extends CalculatorBaseVisitor<Integer> {
    @Override
    public Integer visitProg(CalculatorParser.ProgContext ctx) {
        System.out.println("visitProg");
        Integer result = visitChildren(ctx);
        System.out.println("The result is " + result);
        return result;
    }

    @Override
    public Integer visitExprStat(CalculatorParser.ExprStatContext ctx) {
        System.out.println("visitExprStat");
        // Visit each child to add the Integers to the stack
        return visitChildren(ctx);
    }

    /**
     * ADD OPERATOR
     */
    @Override
    public Integer visitAdd(CalculatorParser.AddContext ctx) {
        System.out.println("visitAdd");
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        return  left + right;
    }

    /**
     * SUB OPERATOR
     */
    @Override
    public Integer visitSub(CalculatorParser.SubContext ctx) {
        System.out.println("visitSub");
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        return  left - right;
    }

    /**
     * MUL OPERATOR
     */
    @Override
    public Integer visitMul(CalculatorParser.MulContext ctx) {
        System.out.println("visitMul");
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        return  left * right;
    }

    /**
     * DIV OPERATOR
     */
    @Override
    public Integer visitDiv(CalculatorParser.DivContext ctx) {
        System.out.println("visitDiv");
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        return  left / right;
    }

    @Override
    public Integer visitInt(CalculatorParser.IntContext ctx) {
        System.out.println("visitInt");
        return Integer.parseInt(ctx.getText());
    }

    @Override
    public Integer visitParens(CalculatorParser.ParensContext ctx) {
        // Need to store the result of the expression
        return visit(ctx.expr());
    }
}
