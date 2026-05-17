class Solution {
    // Method #1
    public boolean canReach(int[] arr, int start) {
        // int n = arr.length;
        // boolean[] visited = new boolean [n];
        // Queue<Integer> queue = new LinkedList<>();

        // queue.offer(start);
        // visited[start] = true;

        // while(!queue.isEmpty()){
        // int i = queue.poll();

        // if(arr[i] == 0){
        // return true;
        // }
        // int next = i + arr[i];
        // int prev = i - arr[i];

        // if(next<n && !visited[next]){
        // visited[next] = true;
        // queue.offer(next);
        // }
        // if(prev>=0 && !visited[prev]){
        // visited[prev] = true;
        // queue.offer(prev);
        // }
        // }
        // return false;
        boolean[] visisted = new boolean[arr.length];
        return isDFS(arr, start, visisted);
    }

    // Method #2

    private boolean isDFS(int[] arr, int i, boolean[] visited) {
        if (i < 0 || i >= arr.length || visited[i]) {
            return false;
        }
        if (arr[i] == 0) {
            return true;
        }

        visited[i] = true;
        return isDFS(arr, i + arr[i], visited) || isDFS(arr, i - arr[i], visited);
    }
}