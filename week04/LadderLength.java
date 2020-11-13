public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        // 图的广度优先遍历，必须使用队列和表示是否访问过的 visited 哈希表
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 1; //初始化步骤，包括起点
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String currentWord = queue.poll();
                //判断改变一个char是否满足条件
                if(changeOneCharForEnd(currentWord,endWord,queue,visited,wordSet)){
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    private boolean changeOneCharForEnd(String currentWord, String endWord, Queue<String> queue,
                                        Set<String> visited, Set<String> wordSet) {
        char[] currentChars = currentWord.toCharArray();
        for(int i=0;i<currentChars.length;i++){
            char oldChar = currentChars[i];
            for(char k='a';k<='z';k++){
                if(oldChar == k)
                    continue;

                currentChars[i] = k;
                String newStr = new String(currentChars);
                if(wordSet.contains(newStr)) {
                    if (newStr.equals(endWord)) {
                        return true;
                    }
                    if (!visited.contains(newStr)) {
                        queue.add(newStr);
                        visited.add(newStr);
                    }
                }
            }
            currentChars[i] = oldChar;
        }
        return false;
    }
}