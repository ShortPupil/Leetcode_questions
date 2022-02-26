class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        int top = -1;
        for (int i=0 ; i<len ; i++){
            if(top==-1 || asteroids[i]>0){
                asteroids[++top]=asteroids[i];
            }
            else{
                if(-asteroids[i]==asteroids[top]) top--;
                else if(-asteroids[i]<asteroids[top]) continue;
                else{
                    while(-asteroids[i]>asteroids[top]&&asteroids[top]>0){
                        top--;
                        if(top==-1) break;
                    }
                    if(top==-1)     asteroids[++top]=asteroids[i];
                    else if(-asteroids[i]<asteroids[top]&&asteroids[top]>0) continue;
                    else if(-asteroids[i]==asteroids[top])    top--;
                    else asteroids[++top]=asteroids[i];
                }
            }
        }
        return Arrays.copyOf(asteroids, top+1);
    }
}