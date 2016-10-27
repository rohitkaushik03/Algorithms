package FactoryDesignPattern;

/**
 * Created by rkaushik on 9/30/16.
 */
public class FactoryPattern {
    public static void main(String[] args){

        ShapeFactory objSF = new ShapeFactory();

        Shape objshape = objSF.getShape("Square");
        objshape.Draw();

        Shape objshape2 = objSF.getShape("Rectangle");
        objshape2.Draw();
    }
}
