public class PeacefulYard {
    //unrelated: in some point i forgot about Mustache and called him Mustard LOL
    public static boolean peacefulYard(String[] yard, int minDistance) {
        //we create the cats
        int[] Lou = {-1, -1};
        int[] Mustache = {-1, -1};
        int[] Raoul = {-1, -1};
        //also an identifier boolear for each cat
        boolean isLou = false, isMustache = false, isRaoul = false;
        //cat counter, if <= 1 return true as the cat will automatically have space to chill 
        int catCounter = 0;
        for(int i = 0; i < yard.length; i++){
            for(int j = 0; j < yard[i].length(); j++){
                if(yard[i].charAt(j) != '-'){
                    //we increment cat counter
                    catCounter++;
                    //we determine which cat it is (to make it cuter)
                    //after we know which cat we encountered while looping we will save i and j values respectively
                    if (yard[i].charAt(j) == 'L'){
                        Lou[0] = i;
                        Lou[1] = j;
                        //we know Lou is Alive
                        isLou = true;
                    } else if (yard[i].charAt(j) == 'M') {
                        Mustache[0] = i;
                        Mustache[1] = j;
                        //we know Mustache is Alive
                        isMustache = true;
                    } else if (yard[i].charAt(j) == 'R') {
                        Raoul[0] = i;
                        Raoul[1] = j;
                        //we know Raoul is Alive
                        isRaoul = true;
                    }
                }
            }
        }
        //now we will set the condition related to catCounter, explained before 
        if (catCounter <= 1) return true;
        
        //now we will have to check which cats are "alive" and pass them to the formula
        //as they're 3 possible pairs of cats alive
        if(catCounter == 2){
            //if Lou and Mustache are alive
            if(isLou && isMustache){
                return euclydeanDistance(Lou, Mustache) >= minDistance;
            }
            //if Lou and Raoul are alive
            else if (isLou && isRaoul){
                return euclydeanDistance(Lou, Raoul) >= minDistance;
            }
            //else - the other possible combination, Mustache and Raoul are alive
            else{
                return euclydeanDistance(Mustache, Raoul) >= minDistance;
            }
        }
        //as the max cat count should be three, this will be my default return (the euclyd dist of them three cats)
        //this last part can be recoded for sure
        return ((euclydeanDistance(Lou, Mustache) >= minDistance) && (euclydeanDistance(Lou, Raoul) >= minDistance) && (euclydeanDistance(Mustache, Raoul) >= minDistance));
    }
    
    //distance for catN to catM
    public static int euclydeanDistance(int[] cat1, int[] cat2){
        return (int) (Math.sqrt(Math.pow(cat1[0] - cat2[0], 2) + Math.pow( cat1[1] - cat2[1], 2)));
    }
}
