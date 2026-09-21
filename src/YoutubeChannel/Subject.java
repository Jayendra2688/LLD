package YoutubeChannel;

public interface Subject {
    public boolean registerObserver(Observer obs);
    
    public boolean removeObserver(Observer obs);

    public void nofiyObserver();
    //uses Observer Update Method
}
