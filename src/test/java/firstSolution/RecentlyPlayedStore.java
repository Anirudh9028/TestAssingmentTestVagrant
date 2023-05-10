package firstSolution;

import java.util.*;

public class RecentlyPlayedStore {

	// Initialize capacity and store to hold recently played songs
    private int capacity;
    private Map<String, LinkedList<String>> store;

    public RecentlyPlayedStore(int capacity)
    {
    	// Constructor to initialize capacity and store
        this.capacity = capacity;
        this.store = new HashMap<>();
    }

 // Method to get recently played songs for a user
    public List<String> getRecentlyPlayedSongs(String user)
    {
        if (!store.containsKey(user))
        {
        	// If the user has not played any songs, return an empty list
            return Collections.emptyList();
        }
        
     // Get the recently played songs for the user from the store
        LinkedList<String> playlist = store.getOrDefault(user, new LinkedList<String>());
     // Return the recently played songs as a new ArrayList
        return new ArrayList<>(playlist);
    }
 
    // Method to get the recently played songs for a user as an ArrayList
   public ArrayList<? extends Object> getRecentlyPlayed(String user) 
    {
	   // Get the recently played songs for the user from the store
        LinkedList<String> playlist = store.get(user);
        
        // Return an empty ArrayList if the user has not played any songs
        if (playlist == null) {
            return new ArrayList<>();
        }
        // Otherwise, return the recently played songs as a new ArrayList
        return new ArrayList<>(playlist);
    }
    
// Method to add a song to a user's recently played list
    public void addSong(String user, String song) 
    {
    	// Get the user's recently played list from the store, or create a new one if it doesn't exist
        LinkedList<String> playlist = store.getOrDefault(user, new LinkedList<String>());
        if (playlist.contains(song))
        {
        	// If the song is already in the recently played list, remove it
            playlist.remove(song);
        }
     // Add the new song to the beginning of the recently played list
        playlist.addFirst(song);
        if (playlist.size() > capacity)
        {
        	// If the recently played list has exceeded the capacity, remove the oldest song from the end
            playlist.removeLast();
        }
     // Store the updated recently played list for the user
        store.put(user, playlist);
    }

    public static void main(String[] args)
    {
    	// Create a new RecentlyPlayedStore with a capacity of 3
        RecentlyPlayedStore store = new RecentlyPlayedStore(3);
        
        // Add three songs for user1
        System.out.println("adding songs");
        store.addSong("user1", "S1");
        store.addSong("user1", "S2");
        store.addSong("user1", "S3");
        
     // Print user1's recently played songs (should be [S3, S2, S1])
        System.out.println("user1's recent songs: "+store.getRecentlyPlayed("user1")+"\n"); // [S3, S2, S1]
       
     // Add a fourth song for user1
        System.out.println("user1 adding songs4(4)");
        store.addSong("user1", "S4");// user1 adding songs4(4)
     // Print user1's recently played songs (should be [S4, S3, S2])
        System.out.println("user1's recent songs: "+store.getRecentlyPlayed("user1")+"\n"); // [S4, S3, S2]
       
     // Add a second song for user1
        System.out.println("user1 adding songs2(2)");
        store.addSong("user1", "S2");// user1 adding songs2(2)
     // Print user1's recently played songs (should be [S2, S4, S3])
        System.out.println("user1's recent songs: "+store.getRecentlyPlayed("user1")+"\n"); // [S2, S4, S3]
        
        System.out.println("user1 adding songs1(1)");
        store.addSong("user1", "S1"); // user1 adding songs1(1)
        // Print user1's recently played songs (should be [S1, S2, S4])
        System.out.println("user1's recent songs: "+store.getRecentlyPlayed("user1")); // [S1, S2, S4]
    }
}
