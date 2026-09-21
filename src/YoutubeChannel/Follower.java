package YoutubeChannel;


public class Follower implements Observer{
    private boolean channelState;
    private YoutubeChannel channel;
    
    Follower(YoutubeChannel channel){
        this.channel = channel;
        channelState = channel.getState();
    }
    public void update(){
        channelState = channel.getState();
    }

    public void play(){
        if(channelState){
            System.out.println("Playing Live");
        }else{
            System.out.println("Channel is not live");
        }
    }
}