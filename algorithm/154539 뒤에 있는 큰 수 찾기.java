import java.util.Deque;
import java.util.LinkedList;

class Element {

    int idx, num;

    public Element(int idx, int num) {
        this.idx = idx;
        this.num = num;
    }
}

class Solution {

    int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Deque<Element> stack = new LinkedList<>();
        stack.push(new Element(0, numbers[0]));
        for (int i = 1; i < answer.length; i++) {
            while (!stack.isEmpty() && stack.peek().num < numbers[i]) {
                answer[stack.pop().idx] = numbers[i];
            }
            stack.push(new Element(i, numbers[i]));
        }
        while (!stack.isEmpty()) {
            answer[stack.pop().idx] = -1;
        }
        return answer;
    }
}