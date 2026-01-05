class Solution {
    public String mostCommonWord(String paragraph, String[] banned) 
    {
        String lower = paragraph.toLowerCase();

        String[] words = lower.split("[^a-z]+");

        String result="";

        Map<String, Integer> map = new HashMap<>();

        for(String word: words)
        {
            if(word.isEmpty()) continue;

            boolean isbanned=false;

            for(String banword : banned)
            {
                if(word.equals(banword))
                {
                    isbanned=true;
                    break;
                }
            }

            if(!isbanned)
              map.put(word,map.getOrDefault(word,0)+1);
        }
          int max=0;
    for(Map.Entry<String,Integer> entry : map.entrySet())
    {
        if(entry.getValue()>max)
        {
            max=entry.getValue();
            result=entry.getKey();
        }
    }
    return result;
    }
}