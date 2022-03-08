import java.util.HashMap;

public class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i<phone_book.length; i++)					//String배열의 요소를 키값, 인덱스를 밸류값으로 map에 저장
            map.put(phone_book[i], i);
        for(int i = 0; i<phone_book.length; i++) {					//substring을 하나씩 만들어 값이 존재하는지 loop를 돌며 비교
            for(int j = 1; j<phone_book[i].length(); j++) { 
                if(map.containsKey(phone_book[i].substring(0,j))) { 
                    return false;
                }
            }
        }
        return true; 
    }
}
