/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 *
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 *
 * // Set this NestedInteger to hold a nested list and adds a nested integer to
 * it.
 * public void add(NestedInteger ni);
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
// Using BFS
    //TC : O(N)
    //SC : O(N)
class NestedListWeightSum {

    public int depthSum(List<NestedInteger> nestedList) {
        int result = 0;
        int depth = 1;
        Queue<NestedInteger> q = new LinkedList<>();
        q.addAll(nestedList);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                NestedInteger curr = q.poll();
                if (curr.isInteger()) {
                    result += curr.getInteger() * depth;
                } else {
                    q.addAll(curr.getList());
                }

            }
            depth++;
        }
        return result;
    }
}

//Using DFS
//TC : O(N)
//SC : O(N)
class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> nestedList, int depth){
        int result = 0;
        // logic
        for(NestedInteger el : nestedList) {
            if(el.isInteger()) {
                result += el.getInteger() * depth;
            } else {
                result += dfs(el.getList(), depth + 1);
            }
        }
        return result;
    }
}