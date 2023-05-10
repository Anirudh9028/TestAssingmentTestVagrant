package secondSolution;
import java.util.Arrays;

import org.testng.annotations.*;

public class RecentlyPlayedStoreTest {
    @Test
    public void test() {
        // Create a new store with a capacity of 3
        RecentlyPlayedStore store = new RecentlyPlayedStore(3);
        
        // Add three songs played by Alice to the store
        store.add("Alice", "S1");
        store.add("Alice", "S2");
        store.add("Alice", "S3");
        
        // Check that the most recent songs played by Alice are S3, S2, and S1
        assert store.getRecent("Alice").equals(Arrays.asList("S3", "S2", "S1"));
        
        // Add a fourth song played by Alice to the store
        store.add("Alice", "S4");
        
        // Check that the most recent songs played by Alice are now S4, S3, and S2
        assert store.getRecent("Alice").equals(Arrays.asList("S4", "S3", "S2"));
        
        // Add a song played by Alice that is already in the store
        store.add("Alice", "S2");
        
        // Check that the most recent songs played by Alice are now S2, S4, and S3
        assert store.getRecent("Alice").equals(Arrays.asList("S2", "S4", "S3"));
        
        // Add a song played by Alice that is already in the store
        store.add("Alice", "S1");
        
        // Check that the most recent songs played by Alice are now S1, S2, and S4
        assert store.getRecent("Alice").equals(Arrays.asList("S1", "S2", "S4"));
    }
}
