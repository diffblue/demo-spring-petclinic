package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VisitDiffblueTest {
  /**
   * Test new {@link Visit} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Visit}
   */
  @Test
  @DisplayName("Test new Visit (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Visit.<init>()"})
  void testNewVisit() {
    // Arrange and Act
    Visit actualVisit = new Visit();

    // Assert
    assertNull(actualVisit.getId());
    assertNull(actualVisit.getDescription());
    assertTrue(actualVisit.isNew());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Visit#setDate(LocalDate)}
   *   <li>{@link Visit#setDescription(String)}
   *   <li>{@link Visit#getDate()}
   *   <li>{@link Visit#getDescription()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDate Visit.getDate()", "String Visit.getDescription()", "void Visit.setDate(LocalDate)",
      "void Visit.setDescription(String)"})
  void testGettersAndSetters() {
    // Arrange
    Visit visit = new Visit();
    LocalDate date = LocalDate.of(1970, 1, 1);

    // Act
    visit.setDate(date);
    visit.setDescription("The characteristics of someone or something");
    LocalDate actualDate = visit.getDate();
    String actualDescription = visit.getDescription();

    // Assert
    assertEquals("1970-01-01", actualDate.toString());
    assertEquals("The characteristics of someone or something", actualDescription);
    assertSame(date, actualDate);
  }
}
