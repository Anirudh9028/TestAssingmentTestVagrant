package secondSolution;

import java.util.*;
import java.util.stream.Collectors;

import java.util.*;


import java.util.*;

public class RecentlyPlayedStore
{
	private final int capacity;
	private final Map<String, LinkedList<String>> store;

	public RecentlyPlayedStore(int capacity) 
	{
	    // Set the capacity of the store to the given value
	    this.capacity = capacity;
	    
	    // Create a new map to store the songs played by each user
	    this.store = new HashMap<>();
	}

	public void add(String user, String song) {
	    // Get the list of songs played by the given user
	    LinkedList<String> songs = store.get(user);
	    
	    // If the user hasn't played any songs yet, create a new list for them
	    if (songs == null) {
	        songs = new LinkedList<>();
	        store.put(user, songs);
	    }
	    
	    // Remove the song from its current position in the list, if it's already there
	    songs.remove(song);
	    
	    // Add the song to the beginning of the list
	    songs.addFirst(song);
	    
	    // If the list has grown beyond the capacity, remove the least recently played song
	    if (songs.size() > capacity) {
	        songs.removeLast();
	    }
	}

	public List<String> getRecent(String user) {
	    // Get the list of songs played by the given user
	    LinkedList<String> songs = store.get(user);
	    
	    // If the user hasn't played any songs yet, return an empty list
	    if (songs == null) {
	        return Collections.emptyList();
	    }
	    
	    // Return a new list containing the songs played by the user
	    return new ArrayList<>(songs);
	}

}



