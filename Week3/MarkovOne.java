import java.util.ArrayList;
import java.util.*;
import java.util.Random;


public class MarkovOne extends AbstractMarkovModel {
  
    public MarkovOne() {
        myRandom = new Random();
    }

   

    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    public void setTraining(String s){
        myText = s.trim();
    }

    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();

        int index = myRandom.nextInt(myText.length()-1);
       
        String key = myText.substring(index, index+1);
        sb.append(key);

        for(int k=0; k < numChars-1; k++){
            List<String> list = getFollows(key);
            if(list.size() == 0){
                break;
            }
            index = myRandom.nextInt(list.size());
            key = "" + list.get(index);
            sb.append(key);
        }

        return sb.toString();
    }
    
     public String toString(){
        return "MarkovModel of order 1.";
    }
}