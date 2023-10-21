package com.mycompany.login999;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Login999test {
   
    public Login999test() {
    }
   
    @BeforeAll
    public static void setUpClass() {
    }
   
    @AfterAll
    public static void tearDownClass() {
    }
   
    @BeforeEach
    public void setUp() {
    }
   
    @AfterEach
    public void tearDown() {
    }
    @Test
public void testCheckUserName() {
    Login999 pp2 = new Login999();

    // Test case 1: Valid username
    String validUsername = "john_doe";
    boolean result1 = pp2.checkUserName(validUsername);
    assertTrue(result1, "Username validation failed for a valid username");

    // Test case 2: Invalid username (length less than 5)
    String invalidUsername1 = "abc";
    boolean result2 = pp2.checkUserName(invalidUsername1);
    assertFalse(result2, "Username validation passed for an invalid username with length less than 5");

    // Test case 3: Invalid username (no underscore)
    String invalidUsername2 = "johndoe";
    boolean result3 = pp2.checkUserName(invalidUsername2);
    assertFalse(result3, "Username validation passed for an invalid username without an underscore");
}

@Test
public void testCheckPassword() {
    Login999 pp2 = new Login999();

    // Test case 1: Valid password
    String validPassword = "P@ssw0rd";
    boolean result1 = pp2.checkPassword(validPassword);
    assertTrue(result1, "Password validation failed for a valid password");

    // Test case 2: Invalid password (length less than 8)
    String invalidPassword1 = "abc123";
    boolean result2 = pp2.checkPassword(invalidPassword1);
    assertFalse(result2, "Password validation passed for an invalid password with length less than 8");

    // Test case 3: Invalid password (no capital letter)
    String invalidPassword2 = "password123";
    boolean result3 = pp2.checkPassword(invalidPassword2);
    assertFalse(result3, "Password validation passed for an invalid password without a capital letter");

    // Test case 4: Invalid password (no number)
    String invalidPassword3 = "Password";
    boolean result4 = pp2.checkPassword(invalidPassword3);
    assertFalse(result4, "Password validation passed for an invalid password without a number");

    // Test case 5: Invalid password (no special character)
    String invalidPassword4 = "Password123";
    boolean result5 = pp2.checkPassword(invalidPassword4);
    assertFalse(result5, "Password validation passed for an invalid password without a special character");
}

@Test
public void testLogin() {
    Login999 pp2 = new Login999();

    // Set up user and password for testing
    pp2.setUser("john_doe");
    pp2.setPassword("P@ssw0rd");

    // Test case 1: Valid login credentials
    String validUser = "john_doe";
    String validPassword = "P@ssw0rd";
    boolean result1 = pp2.login(validUser, validPassword);
    assertTrue(result1, "Login validation passed for valid credentials");

    // Test case 2: Invalid login credentials (wrong username)
    String invalidUser1 = "jane_";
    String validPassword2 = "P@ssw0rd";
    boolean result2 = pp2.login(invalidUser1, validPassword2);
    assertFalse(result2, "Login validation passed for invalid username");
        // Test case 3: Invalid login credentials (wrong password)
    String validUser2 = "john_doe";
    String invalidPassword1 = "password";
    boolean result3 = pp2.login(validUser2, invalidPassword1);
    assertFalse(result3, "Login validation passed for invalid password");

    // Test case 4: Invalid login credentials (wrong username and password)
    String invalidUser2 = "jane_doe";
    String invalidPassword2 = "password";
    boolean result4 = pp2.login(invalidUser2, invalidPassword2);
    assertFalse(result4, "Login validation passed for invalid username and password");
}

@Test
public void testTaskDescriptionLength() {

    // Test case 1: Valid task description (less than or equal to 50 characters)
    Task task1 = new Task("Task 1", "This is a valid task description", "John Doe", 5, 1);
    boolean result1 = task1.getDescription().length() <= 50;
    assertTrue(result1, "Task description validation failed for a valid description");

    // Test case 2: Invalid task description (more than 50 characters)
    Task task2 = new Task("Task 2", "This is a long task description that exceeds the limit of 50 characters", "John Doe", 5, 2);
    boolean result2 = task2.getDescription().length() <= 50;
    assertFalse(result2, "Task description validation passed for an invalid description");
}

@Test
public void testTaskID() {

    // Test case 1: Task ID is set correctly
    Task task = new Task("Task Name", "Task Description", "John Doe", 5, 1);
    task.setID("AD:1:BYN");
    assertEquals("AD:1:BYN", task.getID(), "Task ID is incorrect");

    // Test case 2: Task ID for additional tasks
    Task task1 = new Task("Task 1", "Description 1", "Developer 1", 10, 0);
    task1.setID("CR:0:IKE");
    assertEquals("CR:0:IKE", task1.getID(), "Task ID for additional task 1 is incorrect");

    Task task2 = new Task("Task 2", "Description 2", "Developer 2", 12, 1);
    task2.setID("CR:1:ARD");
    assertEquals("CR:1:ARD", task2.getID(), "Task ID for additional task 2 is incorrect");

    Task task3 = new Task("Task 3", "Description 3", "Developer 3", 55, 2);
    task3.setID("CR:2:THA");
    assertEquals("CR:2:THA", task3.getID(), "Task ID for additional task 3 is incorrect");

    Task task4 = new Task("Task 4", "Description 4", "Developer 4", 11, 3);
    task4.setID("CR:3:ND");
    assertEquals("CR:3:ND", task4.getID(), "Task ID for additional task 4 is incorrect");
}

@Test
public void testTotalTaskDuration() {

    // Test case 1: Valid task durations (18 hours)
    int taskCount1 = 2;
    Task[] tasks1

= new Task[taskCount1];
    tasks1[0] = new Task("Task 1", "Description 1", "Developer 1", 10, 0);
    tasks1[1] = new Task("Task 2", "Description 2", "Developer 2", 8, 1);
    int totalDuration1 = 0;
    for (Task task : tasks1) {
        totalDuration1 += task.getDuration();
    }

    assertEquals(18, totalDuration1, "Total task duration is incorrect for test case 1");

    // Test case 2: Valid task durations (89 hours)
    int taskCount2 = 5;
    Task[] tasks2 = new Task[taskCount2];
    tasks2[0] = new Task("Task 1", "Description 1", "Developer 1", 10, 0);
    tasks2[1] = new Task("Task 2", "Description 2", "Developer 2", 12, 1);
    tasks2[2] = new Task("Task 3", "Description 3", "Developer 3", 55, 2);
    tasks2[3] = new Task("Task 4", "Description 4", "Developer 4", 11, 3);
    tasks2[4] = new Task("Task 5", "Description 5", "Developer 5", 1, 4);

    int totalDuration2 = 0;
    for (Task task : tasks2) {
        totalDuration2 += task.getDuration();
    }

    assertEquals(89, totalDuration2, "Total task duration is incorrect for test case 2");
}

 @Test
   public void testDeveloperArrayCorrectlyPopulated() {
        // Test data
        Task[] tasks = {
            new Task("Task 1", "Description 1", "Mike Smith", 10, 1),
            new Task("Task 2", "Description 2", "Edward Harrington", 8, 2),
            new Task("Task 3", "Description 3", "Samantha Paulson", 6, 3),
            new Task("Task 4", "Description 4", "Glenda Oberholzer", 11, 4)
        };

        // Set up the POE_FINAL instance
       Login999 poeFinal = new Login999();
        poeFinal.setTasks(tasks);

        // Expected developer array
        String[] expectedDevelopers = {"Mike Smith", "Edward Harrington", "Samantha Paulson", "Glenda Oberholzer"};

        // Actual developer array
        String[] actualDevelopers = poeFinal.getDevelopers();

        // Assert the developer arrays are equal
        Assertions.assertArrayEquals(expectedDevelopers, actualDevelopers);
    }

    @Test
    public void testDisplayDeveloperAndDurationForTaskWithLongestDuration() {
        // Test data
        Task[] tasks = {
            new Task("Task 1", "Description 1", "Mike Smith", 10, 1),
            new Task("Task 2", "Description 2", "Edward Harrington", 8, 2),
            new Task("Task 3", "Description 3", "Samantha Paulson", 6, 3),
            new Task("Task 4", "Description 4", "Glenda Oberholzer", 11, 4)
        };

        // Set up the POE_FINAL instance
        Login999 poeFinal = new Login999();
        poeFinal.setTasks(tasks);

        // Expected result
        String expectedOutput = "Glenda Oberholzer, 11";

        // Actual output
        String actualOutput = poeFinal.displayDeveloperAndDurationForTaskWithLongestDuration();

        // Assert the outputs are equal
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
   public void testSearchForTasks() {
        // Test data
        Task[] tasks = {
            new Task("Task 1", "Description 1", "Mike Smith", 10, 1),
            new Task("Task 2", "Description 2", "Edward Harrington", 8, 2),
            new Task("Task 3", "Description 3", "Samantha Paulson", 6, 3),
            new Task("Task 4", "Description 4", "Glenda Oberholzer", 11, 4)
        };

        // Set up the POE_FINAL instance
        Login999 poeFinal = new Login999();
        poeFinal.setTasks(tasks);

        // Test search query
        String searchQuery = "Create Login";

        // Expected result
        String expectedOutput = "Task not found";

        // Actual output
        String actualOutput = poeFinal.searchForTasks(searchQuery);

        // Assert the outputs are equal
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testSearchAllTasksAssignedToDeveloper() {
        // Test data
        Task[] tasks = {
            new Task("Task 1", "Description 1", "Mike Smith", 10, 1),
            new Task("Task 2", "Description 2", "Edward Harrington", 8, 2),
            new Task("Task 3", "Description 3", "Samantha Paulson", 6, 3),
            new Task("Task 4", "Description 4", "Glenda Oberholzer", 11, 4)
        };

        // Set up the POE_FINAL instance
        Login999 poeFinal = new Login999();
        poeFinal.setTasks(tasks);

        // Test developer
        String developer = "Samantha Paulson";

        // Expected result
        String expectedOutput = "Description 3;";

        // Actual output
        String actualOutput = poeFinal.searchAllTasksAssignedToDeveloper(developer);

        // Assert the outputs are equal
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
 @Test
public void testDeleteTaskFromArray() {
    // Test data
    String taskName = "Create Reports";
    String expectedOutput = "Task 'Create Reports' successfully deleted";

    // Create an instance of POE_FINAL
    Login999 poeFinal = new Login999();

    // Delete the task from the array
    String output = poeFinal.deleteTask(taskName); // Pass the taskName parameter

    // Compare the expected output with the actual output
    Assertions.assertEquals(expectedOutput, output);
}


    @Test
    public void testDisplayReport() {
        // Create an instance of POE_FINAL
        Login999 poeFinal = new Login999();

        // Get the report
        String report = poeFinal.getReport();

        // Check if the report is not null or empty
        Assertions.assertNotNull(report);
        Assertions.assertFalse(report.isEmpty());
    }
}


