package dev.ivanqueiroz.algovault.operations;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SinglyLinkedListTest {

  private SinglyLinkedList<String> linkedlist;

  @BeforeEach
  void setUp() {
    linkedlist = new SinglyLinkedList<>();
    linkedlist.append("A"); linkedlist.append("B"); linkedlist.append("C");
    linkedlist.append("D"); linkedlist.append("E"); linkedlist.append("F");
  }

  @Test
  void reverse_list() {
    linkedlist.reverseIteratively();
    log.info("Reverse list Iteratively {}", linkedlist);
    assertEquals("F-->E-->D-->C-->B-->A", linkedlist.toString());

    linkedlist.reverseRecursively();
    log.info("Reverse list Recursively {}", linkedlist);
    assertEquals("A-->B-->C-->D-->E-->F", linkedlist.toString());
  }
}
