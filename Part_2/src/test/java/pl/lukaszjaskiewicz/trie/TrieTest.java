package pl.lukaszjaskiewicz.trie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

    Trie trie;

    @BeforeEach
    void setUp(){
        trie = new Trie();
    }

    @Test
    void insert_whenCalled_addsWordToTrie() {

        trie.insert("cat");
        trie.insert("cathode");
        trie.insert("cabbage");
        System.out.println("done");
    }

    @Test
    void contains_whenCalledWithTrieContainingWord_shouldReturnTrue(){

        trie.insert("canada");
        trie.insert("can");
        trie.insert("boy");

        assertTrue(trie.contains("canada"));
        assertTrue(trie.contains("can"));
        assertTrue(trie.contains("boy"));
    }

    @Test
    void contains_whenCalledWithTrieNotContainingWord_shouldReturnFalse() {

        trie.insert("canada");
        trie.insert("can");
        trie.insert("boy");

        assertFalse(trie.contains("cat"));
        assertFalse(trie.contains("canting"));
        assertFalse(trie.contains("bo"));
        assertFalse(trie.contains("boyish"));
    }

    @Test
    void containsRec_whenCalledWithTrieContainingWord_shouldReturnTrue(){

        trie.insert("canada");
        trie.insert("can");
        trie.insert("boy");

        assertTrue(trie.containsRec("canada"));
        assertTrue(trie.containsRec("can"));
        assertTrue(trie.containsRec("boy"));
    }

    @Test
    void containsRec_whenCalledWithTrieNotContainingWord_shouldReturnFalse() {

        trie.insert("canada");
        trie.insert("can");
        trie.insert("boy");

        assertFalse(trie.containsRec("cat"));
        assertFalse(trie.containsRec("canting"));
        assertFalse(trie.containsRec("bo"));
        assertFalse(trie.containsRec("boyish"));
    }

    @Test
    void traverse_whenCalled_ShouldTraverseTheTriePreOrder(){
        trie.insert("canada");

        assertEquals("canada", trie.traverse());
    }

    @Test
    void remove_whenCalled_shouldRemoveAWord(){
        Trie trie = new Trie();
        trie.insert("canada");
        trie.insert("can");
        trie.insert("boy");

        assertTrue(trie.contains("canada"));
        assertTrue(trie.contains("can"));
        assertTrue(trie.contains("boy"));

        trie.remove("canada");
        assertFalse(trie.contains("canada"));
        assertTrue(trie.contains("can"));
        assertTrue(trie.contains("boy"));

        trie.remove("boy");
        assertFalse(trie.contains("canada"));
        assertTrue(trie.contains("can"));
        assertFalse(trie.contains("boy"));

        trie.remove("can");
        assertFalse(trie.contains("canada"));
        assertFalse(trie.contains("can"));
        assertFalse(trie.contains("boy"));
        assertEquals("", trie.traverse());
    }

    @Test
    void autoComplete_whenCalledWithNull_shouldReturn(){
        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        trie.insert("careful");
        trie.insert("egg");

        assertEquals(0, trie.autoComplete(null).size());
    }

    @Test
    void autoComplete_whenCalled_shouldReturnAutocompleteListOfWords(){
        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        trie.insert("careful");
        trie.insert("egg");

        List<String> list = trie.autoComplete("");
        assertArrayEquals(new String[]{"car", "card", "care", "careful", "egg"}, list.toArray(new String[0]));

        list = trie.autoComplete("c");
        assertArrayEquals(new String[]{"car", "card", "care", "careful"}, list.toArray(new String[0]));

        list = trie.autoComplete("car");
        assertArrayEquals(new String[]{"car", "card", "care", "careful"}, list.toArray(new String[0]));

        list = trie.autoComplete("care");
        assertArrayEquals(new String[]{"care", "careful"}, list.toArray(new String[0]));
    }

    @Test
    void countWords_whenCalled_shouldReturnWordCount(){
        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        trie.insert("careful");
        trie.insert("egg");

        System.out.println(trie.countWords());
    }

    @Test
    void getLongestPrefix_whenCalled_shouldReturnTheLongestPrefix(){
        trie.insert("card");
        trie.insert("care");

        assertEquals("car", trie.getLongestPrefix());

        trie = new Trie();
        trie.insert("car");
        trie.insert("care");

        assertEquals("car", trie.getLongestPrefix());

        trie = new Trie();
        trie.insert("car");
        trie.insert("dog");

        assertEquals("", trie.getLongestPrefix());

        trie = new Trie();
        trie.insert("car");

        assertEquals("car", trie.getLongestPrefix());
    }
}