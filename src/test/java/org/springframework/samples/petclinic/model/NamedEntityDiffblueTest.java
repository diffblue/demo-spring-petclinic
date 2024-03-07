package org.springframework.samples.petclinic.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class NamedEntityDiffblueTest {
  /**
   * Methods under test:
   * 
   * <ul>
   *   <li>default or parameterless constructor of {@link NamedEntity}
   *   <li>{@link NamedEntity#setName(String)}
   *   <li>{@link NamedEntity#toString()}
   *   <li>{@link NamedEntity#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    NamedEntity actualNamedEntity = new NamedEntity();
    actualNamedEntity.setName("Bella");
    String actualToStringResult = actualNamedEntity.toString();

    // Assert that nothing has changed
    assertEquals("Bella", actualNamedEntity.getName());
    assertEquals("Bella", actualToStringResult);
  }
}
