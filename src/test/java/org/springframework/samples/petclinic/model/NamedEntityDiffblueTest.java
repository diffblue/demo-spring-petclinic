package org.springframework.samples.petclinic.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NamedEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NamedEntity}
   *   <li>{@link NamedEntity#setName(String)}
   *   <li>{@link NamedEntity#toString()}
   *   <li>{@link NamedEntity#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamedEntity.<init>()", "String NamedEntity.getName()", "void NamedEntity.setName(String)",
      "String NamedEntity.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    NamedEntity actualNamedEntity = new NamedEntity();
    actualNamedEntity.setName("Bella");
    String actualToStringResult = actualNamedEntity.toString();

    // Assert
    assertEquals("Bella", actualNamedEntity.getName());
    assertEquals("Bella", actualToStringResult);
    assertNull(actualNamedEntity.getId());
  }
}
