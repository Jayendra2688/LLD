package songPlaylist;
import java.util.ArrayList;

public class Playlist implements IComponent {

	public String playlistName;
	public ArrayList<IComponent> playlist;
    private float speed;
	public Playlist(String playlistName) {
		this.playlistName = playlistName;
        this.playlist = new ArrayList<>();
	}

  // Your code goes here!
    public void add(IComponent icomponent){
        this.playlist.add(icomponent);
    }

    public void remove(IComponent iComponent){
        this.playlist.remove(iComponent);
    }
    
    public void play(){
        System.out.println("Play Playlist");
    }

    public String getName(){
        return this.playlistName;
    }

    public void setPlaybackSpeed(float speed){
        this.speed = speed;
    }


}