package org.springframework.samples.petclinic;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;
import java.nio.file.Paths;
import javax.management.loading.MLet;
import org.apache.catalina.webresources.ClasspathURLStreamHandler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.aot.hint.RuntimeHints;

class PetClinicRuntimeHintsDiffblueTest {
  /**
   * Method under test:
   * {@link PetClinicRuntimeHints#registerHints(RuntimeHints, ClassLoader)}
   */
  @Test
  void testRegisterHints() throws MalformedURLException {
    // Arrange
    PetClinicRuntimeHints petClinicRuntimeHints = new PetClinicRuntimeHints();
    RuntimeHints hints = new RuntimeHints();
    URLStreamHandlerFactory urlStreamHandlerFactory = mock(URLStreamHandlerFactory.class);
    when(urlStreamHandlerFactory.createURLStreamHandler(Mockito.<String>any()))
        .thenReturn(new ClasspathURLStreamHandler());

    // Act
    petClinicRuntimeHints.registerHints(hints,
        new URLClassLoader(new URL[]{Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()},
            new MLet(), urlStreamHandlerFactory));

    // Assert
    verify(urlStreamHandlerFactory).createURLStreamHandler(Mockito.<String>any());
  }
}
