package org.springframework.samples.petclinic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.management.loading.MLet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.aot.hint.JavaSerializationHint;
import org.springframework.aot.hint.RuntimeHints;

class PetClinicRuntimeHintsDiffblueTest {
  /**
   * Test {@link PetClinicRuntimeHints#registerHints(RuntimeHints, ClassLoader)}.
   * <p>
   * Method under test: {@link PetClinicRuntimeHints#registerHints(RuntimeHints, ClassLoader)}
   */
  @Test
  @DisplayName("Test registerHints(RuntimeHints, ClassLoader)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PetClinicRuntimeHints.registerHints(RuntimeHints, ClassLoader)"})
  void testRegisterHints() {
    // Arrange
    PetClinicRuntimeHints petClinicRuntimeHints = new PetClinicRuntimeHints();
    RuntimeHints hints = new RuntimeHints();

    // Act
    petClinicRuntimeHints.registerHints(hints, new MLet());

    // Assert
    Stream<JavaSerializationHint> javaSerializationHintsResult = hints.serialization().javaSerializationHints();
    List<JavaSerializationHint> collectResult = javaSerializationHintsResult.limit(5).collect(Collectors.toList());
    assertEquals(3, collectResult.size());
    assertNull(collectResult.get(0).getReachableType());
    assertNull(collectResult.get(1).getReachableType());
    assertNull(collectResult.get(2).getReachableType());
  }
}
