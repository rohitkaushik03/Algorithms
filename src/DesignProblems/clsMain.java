package DesignProblems;

/**
 * Created by rkaushik on 11/23/16.
 */
public class clsMain {

    public static void main(String args[])
    {
        clsMemDB objclsMemDB = new clsMemDB();
        objclsMemDB.set("a",10);
        objclsMemDB.set("b",15);
        objclsMemDB.set("a",15);
        objclsMemDB.set("c",15);

        System.out.println("Value of a - " + objclsMemDB.get("a"));

        System.out.println("15 count - " + objclsMemDB.getCount(15));
        System.out.println("10 count - " + objclsMemDB.getCount(10));

        objclsMemDB.Delete("a");
        System.out.println("15 count after Delete a - " + objclsMemDB.getCount(15));
        System.out.println("10 count after Delete a - " + objclsMemDB.getCount(10));

        //objclsMemDB.set("c",15);
        objclsMemDB.set("d",15);

        System.out.println("15 count - " + objclsMemDB.getCount(15));

    }

}
