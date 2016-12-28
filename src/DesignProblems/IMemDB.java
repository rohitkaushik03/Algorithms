package DesignProblems;

/**
 * Created by rkaushik on 11/22/16.
 */
public interface IMemDB {


    public void set(String name, Integer value);
    public int get(String name);
    public void Delete(String name);
    public int getCount(Integer value);
}
