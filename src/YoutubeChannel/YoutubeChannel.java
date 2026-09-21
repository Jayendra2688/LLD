package YoutubeChannel;

import java.util.ArrayList;

public class YoutubeChannel implements Subject {
    private boolean isLive;
    ArrayList<Observer>observers;

    YoutubeChannel(boolean isLive,ArrayList<Observer> observers){
        this.isLive = isLive;
        this.observers = observers;
    }

    public void updateStatus(boolean isLive){
        this.isLive = isLive;
    }

    public boolean getState(){
        return isLive;
    }

    public boolean registerObserver(Observer obs){
        if (observers.contains(obs)) {
            return false;
        }
        observers.add(obs);
        return true;
    }

    public boolean removeObserver(Observer obs){
        if(!observers.contains(obs)){
            return false;
        }
        observers.remove(obs);
        return true;
    }

    public void nofiyObserver(){
        for(Observer obs : observers){
            obs.update();
        }
    }
    
}
