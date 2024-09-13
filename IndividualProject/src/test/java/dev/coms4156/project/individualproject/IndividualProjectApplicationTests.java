package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * Unit testing for the IndividualProjectApplication Class.
 */
@SpringBootTest
@ContextConfiguration
public class IndividualProjectApplicationTests {

  @BeforeAll
  public static void setupAppForTesting() {
    testApp = new IndividualProjectApplication();
    mockDatabase = Mockito.mock(MyFileDatabase.class);
  }

  @Test
  public void mainTest() {
    String[] args = {"set up"};
    testApp.main(args);

    assertNotNull(testApp);

  }

  @Test
  public void runTest() {
    String[] args = {"set up"};
    testApp.run(args);

    assertNotNull(testApp);
  }

  @Test
  public void overrideDatabaseTest() {
    testApp.overrideDatabase(mockDatabase);

    assertNotNull(testApp);
  }

  public static IndividualProjectApplication testApp;
  public static MyFileDatabase mockDatabase;
}
