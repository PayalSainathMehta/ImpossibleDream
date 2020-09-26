public class UnionFind {
    int[] parent;
    int[] size;
    public UnionFind(int n){
        parent = new int[n + 1];
        size = new int[n + 1];

        for(int i = 0; i <= n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    //get identity
    int find(int n){ //return parent of given node
        while(n != parent[n]) { //self-loop check
            n = parent[n];
        }
        return n;
    }

    //merge
    void union(int x, int y){
        //get roots of both
        int p1 = find(x);
        int p2 = find(y);
        if(p1 == p2) //roots are same
            return;
        else if(p1 < p2){ //merge into larger component
            parent[p1] = p2;
            size[p2] += size[p1];
        }
        else{
            parent[p2] = p1;
            size[p1] += size[p2];
        }
    }
}
