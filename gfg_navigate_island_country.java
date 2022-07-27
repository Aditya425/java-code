// User function Template for Java
class Pair implements Comparable<Pair> {
    int node;
    long cost;
    
    Pair(int n, long c) {
        this.node = n;
        this.cost = c;
    }
    
    @Override
    public int compareTo(Pair p2) {
        if (this.cost < p2.cost) {
            return -1;
        } else if (this.cost > p2.cost) {
            return 1;
        } else {
            if (this.node < p2.node) {
                return -1;
            } else if (this.node > p2.node) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
class Solution {
    static long minimumCost(int n, int m, int x, int A[], int B[][]) {
        
        long cost = A[0] + A[n - 1] + x;
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < B.length; i++) {
            int p = B[i][0];
            int c = B[i][1];
            
            if (!map.containsKey(p)) {
                List<Integer> l = new ArrayList<>();
                map.put(p, l);
            }
            
            if (!map.containsKey(c)) {
                List<Integer> l = new ArrayList<>();
                map.put(c, l);
            }
            if (!map.get(p).contains(c)) {
                map.get(p).add(c);
            }
            
            if (!map.get(c).contains(p)) {
                map.get(c).add(p);
            }
        }
        
        Set<Integer> visited = new HashSet<>();
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        pq.add(new Pair(1, 0));
        long tc = Integer.MAX_VALUE;
        long[] dist = new long[A.length];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (visited.contains(p.node)) {
                continue;
            }
            
            visited.add(p.node);
            
            if (p.node == n) {
                tc = p.cost;
                break;
            }
            
            if (map.containsKey(p.node)) {
                for (Integer neighbor : map.get(p.node)) {
                    if (p.cost + A[p.node - 1] + A[neighbor - 1] < dist[neighbor - 1]) {
                        dist[neighbor] = p.cost + A[p.node - 1] + A[neighbor - 1];
                        pq.add(new Pair(neighbor, p.cost + A[p.node - 1] + A[neighbor - 1]));
                    }
                }
            }
        }
        // System.out.println(cost);
        // System.out.println(tc);
        //System.out.println(map);
        cost = Math.min(cost, tc);
        
        return cost;
    }
}
