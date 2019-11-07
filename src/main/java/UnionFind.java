package main.java;

/**
 * @author emiliogumayagay
 * @version $Id: UnionFind.java, v 0.1 2019-11-07 12:47 emiliogumayagay Exp $$
 */
public class UnionFind {

    private int[] elements;
    private int[] id;
    private int[] size;
    private int[] largest;

    public UnionFind(int[] elements) {
        this.elements = elements;

        id = new int[elements.length];
        size = new int[elements.length];
        largest =  new int[elements.length];


        //set all size to 1
        for(int i = 0; i < size.length; i++){
            size[i] = 1;
        }

        //set all largest to self
        for(int i = 0; i < id.length; i++){
            largest[i] = i;
            id[i] =i;
        }
    }

    /**
     * Getter method for property <tt>elements</tt>.
     *
     * @return property value of elements
     */
    public int[] getElements() {
        return elements;
    }

    public int root(int i){ //
        while(i !=  id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int j){
        return root(p) == root(j);
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q);

        if(i == j){
            return;
        }
        if(size[i] < size[j]){
            id[i] = j;
            size[j] += size[i];
        }else{
            id[j] = i;
            size[i] += size[j];
        }

        if(elements[largest[i]] > elements[largest[j]]){
            largest[j] = largest[i];
        }else{
            largest[i] = largest[j];
        }
    }

    public int find(int i) {
        return elements[largest[i]];
    }


}