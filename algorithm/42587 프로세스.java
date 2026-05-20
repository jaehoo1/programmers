import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class Process {

    int priority;
    boolean target;

    public Process(int priority, boolean target) {
        this.priority = priority;
        this.target = target;
    }

    public int getPriority() {
        return priority;
    }

    boolean isExecutable(Queue<Process> queue) {
        return priority == queue.stream().max(Comparator.comparingInt(Process::getPriority)).get().getPriority();
    }
}

class Solution {

    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Process(priorities[i], location == i));
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            if (queue.peek().isExecutable(queue)) {
                answer++;
                Process poll = queue.poll();
                if (poll.target) {
                    return answer;
                }
            } else {
                queue.offer(queue.poll());
            }
        }
        return -1;
    }
}