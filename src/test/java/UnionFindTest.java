package test.java;

import main.java.UnionFind;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author emiliogumayagay
 * @version $Id: UnionFindTest.java, v 0.1 2019-11-07 12:46 emiliogumayagay Exp $$
 */
public class UnionFindTest {
    UnionFind unionFind;
    int[] elements;

    @Before
    public void setUp(){
        elements =  new int[]{1, 2, 6, 9};
       unionFind = new UnionFind(elements);

       unionFind.union(0, 3);
       unionFind.union(1, 2);
       unionFind.union(0, 1);

    }


    @Test
    public void testConstructor(){
        assertEquals(Arrays.asList(elements),Arrays.asList(unionFind.getElements()));
    }

    @Test
    public void testFind(){
        assertEquals(9, unionFind.find(1));
    }
}