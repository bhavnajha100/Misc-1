//TC : O(log(startValue - target))
//SC : O(1)
class BrokenCalculator {
    // Iteratively
    public int brokenCalc(int startValue, int target) {
        int count = 0;
        while (startValue < target) {
            if (target % 2 == 0) {
                target = target / 2;
            } else {
                target = target + 1;
            }
            count++;
        }
        // startValue - target - when target is smaller than startValue we will add
        // (startValue - target) steps
        return count + startValue - target;
    }

}

//recursively
class BrokenCalculator {
    public int brokenCalc(int startValue, int target) {
        return dfs(startValue, target);
    }

    private int dfs(int startValue, int target) {
        //base
        if(startValue > target) {
            return startValue - target;
        }

        // logic
        // when target is even
        if(target/ 2 == 0){
            return 1 + dfs(startValue, target/2);
        }
        // when target is odd
        else {
            return 1 + dfs(startValue, target + 1);
        }
    }

}