package ch.zhaw.iwi.devops.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PathListEntryTest {
    

    @Test
    void testDefaultConstructor() {
        PathListEntry<Integer> entry;
        entry = new PathListEntry<>();
        Assertions.assertTrue(entry.isActive());
        Assertions.assertNull(entry.getKey());
        Assertions.assertNull(entry.getName());
        Assertions.assertNull(entry.getColor());
        Assertions.assertNull(entry.getIcon());
        Assertions.assertNull(entry.getUrl());
        Assertions.assertNull(entry.getPage());
        Assertions.assertNull(entry.getType());
        Assertions.assertNull(entry.getTooltip());
        Assertions.assertTrue(entry.getDetails().isEmpty());
        Assertions.assertEquals(0.0f, entry.getOrder());
        Assertions.assertNull(entry.getForm());
    }

    @Test
    void testSetAndGetKey() {
        PathListEntry<Integer> entry;
        entry = new PathListEntry<>();
        entry.setKey(1, "Key 1");
        Assertions.assertEquals(1, entry.getKey().getKey());
        Assertions.assertEquals("Key 1", entry.getKey().getName());
    }

    @Test
    void testSetName() {
        PathListEntry<Integer> entry;
        entry = new PathListEntry<>();
        entry.setName("John Doe");
        Assertions.assertEquals("John Doe", entry.getName());
    }

    @Test
    void testSetColor() {
        PathListEntry<Integer> entry;
        entry = new PathListEntry<>();
        entry.setColor("red");
        Assertions.assertEquals("red", entry.getColor());
    }

    @Test
    void testSetAndGetDetails() {
        PathListEntry<Integer> entry;
        entry = new PathListEntry<>();
        List<String> details = Arrays.asList("Detail 1", "Detail 2");
        entry.setDetails(details);
        Assertions.assertEquals(details, entry.getDetails());
    }

    @Test
    void testSetAndGetUrl() {
        PathListEntry<Integer> entry;
        entry = new PathListEntry<>();
        entry.setUrl("https://example.com");
        Assertions.assertEquals("https://example.com", entry.getUrl());
    }

    @Test
    void testSetActive() {
        PathListEntry<Integer> entry;
        entry = new PathListEntry<>();
        entry.setActive(true);
        Assertions.assertTrue(entry.isActive());
        entry.setActive(false);
        Assertions.assertFalse(entry.isActive());
    }

    @Test
    void testSetAndGetOrder() {
        PathListEntry<Integer> entry;
        entry = new PathListEntry<>();
        entry.setOrder(5.0f);
        Assertions.assertEquals(5.0f, entry.getOrder());
    }

    @Test
    void testSetAndGetPage() {
        PathListEntry<Integer> entry;
        entry = new PathListEntry<>();
        entry.setPage("home");
        Assertions.assertEquals("home", entry.getPage());
    }

    @Test
    void testSetAndGetTooltip() {
        PathListEntry<Integer> entry;
        entry = new PathListEntry<>();
        entry.setTooltip("Hover over me");
        Assertions.assertEquals("Hover over me", entry.getTooltip());
    }

    @Test
    void testSetAndGetForm() {
        PathListEntry<Integer> entry;
        entry = new PathListEntry<>();
        entry.setForm("registration");
        Assertions.assertEquals("registration", entry.getForm());
    }
}