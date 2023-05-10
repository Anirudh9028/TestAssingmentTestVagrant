# TestAssingmentTestVagrant
It is coding Assignment From test vagrant basically i used two diffrent logic concept to complete the code 

# 1. Using Java (\src\test\java\firstSolution)
# class RecentlyPlayedStore Explanation: 
This code is an implementation of a RecentlyPlayedStore that keeps track of the songs recently played by different users. The store has a capacity limit, and when a user plays a new song, it is added to the beginning of their list of recently played songs, and if the list exceeds the capacity limit, the oldest song is removed from the end.

The main method tests the RecentlyPlayedStore implementation by creating a store with a capacity of 3, adding songs for a user, and then printing the user's recently played songs after each addition. The output shows the correct behavior of the RecentlyPlayedStore, where the list of recently played songs is updated correctly after each addition, and the oldest song is removed when the capacity limit is reached.


# 2. using Java + TestNg (src\test\java\secondSolution)
# class RecentlyPlayedStore Explanation:
1.We have a RecentlyPlayedStore class that takes an int as the capacity parameter in its constructor. This represents the maximum number of songs that can be stored for each user.
2.The store is implemented as a Map<String, LinkedList<String>> where the key is the user and the value is a linked list of songs.
3.The add method takes a user and a song parameter, and adds the song to the user's list of songs. If the list already contains the song, it is moved to the front.     If the list exceeds the capacity, the least recently played song is removed from the end of the list.
4.The getRecent method takes a user parameter and returns a list of the user's recently played songs. If the user does not exist in the store, an empty list is returned.
  
# class RecentlyPlayedStoreTest Explanation:
 This is a test class that tests the RecentlyPlayedStore class. It has a single test method called test that creates a new RecentlyPlayedStore object with an initial capacity of 3, and then adds several songs to the store for the user "Alice". It then calls the getRecent method on the store to get the most recent songs played by "Alice" and asserts that the result is equal to the expected list of songs. This is repeated several times with different songs added to the store to test that the store correctly tracks the most recent songs played by the user and eliminates the least recently played songs when the store becomes full.



