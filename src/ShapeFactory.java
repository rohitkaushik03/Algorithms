/**
 * Created by rkaushik on 9/30/16.
 */
public class ShapeFactory {

    public Shape getShape(String shapeType)
    {
        if (shapeType.equalsIgnoreCase("Square"))
        {
            return new Square();
        }
        else if(shapeType.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        }

         return null;

    }
}
