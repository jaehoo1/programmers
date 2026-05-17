import java.util.HashMap;
import java.util.Map;

class Solution {

    boolean isValidSkillTree(Map<Character, Character> parents, String skillTree) {
        for (int i = 0; i < skillTree.length(); i++) {
            char c = skillTree.charAt(i);
            if (!parents.containsKey(c)) {
                continue;
            }
            int parentIndex = skillTree.indexOf(parents.get(c));
            if (parentIndex == -1 || parentIndex > i) {
                return false;
            }
        }
        return true;
    }

    public int solution(String skill, String[] skillTrees) {
        Map<Character, Character> parents = new HashMap<>();
        for (int i = 0; i < skill.length() - 1; i++) {
            char parent = skill.charAt(i);
            char child = skill.charAt(i + 1);
            parents.put(child, parent);
        }

        int answer = 0;
        for (String skillTree : skillTrees) {
            if (isValidSkillTree(parents, skillTree)) {
                answer++;
            }
        }
        return answer;
    }
}