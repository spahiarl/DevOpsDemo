package ch.zhaw.iwi.devops.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PathListEntryTest {
    @Test
    void testSetAndGetKey() {
        PathListEntry<Integer> entry = new PathListEntry<>();
        entry.setKey(1, "Key 1");
        Assertions.assertEquals(1, entry.getKey().getKey());
        Assertions.assertEquals("Key 1", entry.getKey().getName());
    }

    @Test
    void testSetName() {
        PathListEntry<String> entry = new PathListEntry<>();
        entry.setName("John Doe");
        Assertions.assertEquals("John Doe", entry.getName());
    }
    
}
