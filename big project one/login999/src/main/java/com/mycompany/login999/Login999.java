
package com.mycompany.login999;


import javax.swing.JLabel;//box
import javax.swing.JPanel;//box
import java.awt.Font;//size
import java.awt.Color;//colour 

import javax.swing.JOptionPane;//method 
import javax.swing.UIManager;//colour

class Login999 {

  
    String user;
    String password;
    String firstName;
    String lastName;
    private Task[] tasks;
    private int taskCount;

    
    boolean checkUserName(String user) {
        return user.length() >= 6 && user.contains("_");
    }
     boolean checkPassword(String password) {
        boolean hasUpperCase = !password.equals(password.toLowerCase());
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSpecialChar = !password.matches("[A-Za-z0-9 ]*");
        if (password.length() >= 8 && hasUpperCase && hasNumber && hasSpecialChar) {
            return true;
        } else {
            return false;
        }
    }


    // Method to prompt user for registration details
    void promptUser() {
        // Prompt for first name and last name
        firstName = JOptionPane.showInputDialog(null, "Enter your first name:");
        lastName = JOptionPane.showInputDialog(null, "Enter your last name:");

        // Prompt for username
        user = JOptionPane.showInputDialog(null,
                "Enter a username (at least 6 characters and contain an underscore):");
        while (!checkUserName(user)) {
            user = JOptionPane.showInputDialog(null,
                    "Invalid username. Please enter a username (at least 6 characters and contain an underscore):");
        }

        // Prompt for password with special character validation
        password = JOptionPane.showInputDialog(null, "Enter a password (at least 8 characters and contain a special character):");
        while (password.length() < 8 || !password.matches(".*[!@#$%^&*()+\\-=\\[\\]{};':\"\\\\|,.<>?].*")) {
            password = JOptionPane.showInputDialog(null, "Invalid password. Please enter a password (at least 8 characters and contain a special character):");
        }
    
}
    

    // Method to check if the entered username and password match the registered user's credentials
    boolean login(String enteredUser, String enteredPassword) {
        return enteredUser.equals(user) && enteredPassword.equals(password);
    }


    public static void main(String[] args) {
         // Set the color and style for the message box
      UIManager.put("OptionPane.background", Color.BLACK); 
     UIManager.put("Panel.background", Color.BLACK);        
     UIManager.put("OptionPane.messageForeground", Color.green);
     UIManager.put("Button.background", Color.BLACK);  
     UIManager.put("Button.foreground", Color.WHITE);    


// Create a JLabel with a custom font and size
   JLabel label = new JLabel("Welcome to EasyKanban!");
        label.setFont(new Font("Arial", Font.BOLD, 40));

        // Create a JPanel and add the label
        JPanel panel = new JPanel();
        panel.setBackground(Color.green); // Set the background color
        panel.add(label);

        // Display the customized message box
        JOptionPane.showMessageDialog(null, panel, "Welcome", JOptionPane.PLAIN_MESSAGE);
         JOptionPane.showMessageDialog(null, " YOU CAN START WITH  YOUR  REGISTRATION  FOR Easykanban !");
   // Method to check if the entered username and password match the registered user's credentials
    Login999 user1 = new Login999();
        user1.promptUser();
 JOptionPane.showMessageDialog(null, " YOUR REGISTRATION PAGE FOR Easykanban IS SUCCESSFUL!");
  JOptionPane.showMessageDialog(null, "WELCOME TO YOUR LOGIN PAGE FOR Easykanban !");
        boolean loggedIn = false;
        int loginAttempts = 0;

        do {
            // Prompt for username and password for login
            Object[] options = { "Login", "Quit" };
            int choice = JOptionPane.showOptionDialog(null, "Enter your username:", "Login", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            if (choice == 1) {
                break; // Quit option selected
            }

            String enteredUser = JOptionPane.showInputDialog(null, "Enter your username:");
            String enteredPassword = JOptionPane.showInputDialog(null, "Enter your password:");

            if (user1.login(enteredUser, enteredPassword)) {
                // User Authentication
                boolean authenticated = authenticate();

                if (authenticated) {
                    loggedIn = true;
                    // Welcome Message to EasyKanban
                       JOptionPane.showMessageDialog(null, "YOUR LOGIN PAGE FOR Easykanban IS SUCCESSFUL!");
                    JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!");
                    

                    // Numeric Menu
                    int option = 0;
                    int taskCount = getTaskCount();
                    Task[] tasks = new Task[taskCount];
                    int taskIndex = 0;

                    do {
                        // Display menu options
                        option = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                              Choose an option:
                                                                              1. Add tasks
                                                                              2. Show report
                                                                              3. Display tasks with status 'Done'
                                                                              4. Display task with longest duration
                                                                              5. Search for a task by name
                                                                              6. Search tasks assigned to a developer
                                                                              7. Delete a task by name
                                                                              8. Quit"""));

                        switch (option) {
                            case 1 -> {
                      
                                tasks[taskIndex] = getTask(taskIndex + 1);
                                taskIndex++;
                            }
                                     
                            case 2 -> displayTasks(tasks);
                            case 3 -> displayTasksWithStatus(tasks, "Done");
                            case 4 -> displayTaskWithLongestDuration(tasks);
                            case 5 -> searchTaskByName(tasks);
                            case 6 -> searchTasksByDeveloper(tasks);
                            case 7 -> deleteTaskByName(tasks);
                            case 8 -> {
                            }
                            default -> JOptionPane.showMessageDialog(null, "Invalid option. Please choose a valid option.");
                        }
                    } while (option != 8);
                }
            } else {
                Object[] retryOptions = { "Retry", "Quit" };
                int retryChoice = JOptionPane.showOptionDialog(null, "Invalid username or password. Please try again.",
                        "Login Failed", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, retryOptions,
                        retryOptions[0]);

                if (retryChoice == 1) {
                    break; // Quit option selected
                }
                loginAttempts++;
            }

            if (loginAttempts >= 3) {
                JOptionPane.showMessageDialog(null, "TOO MANY LOGIN ATTEMPTS . EXITING.");
                break;
            }
        } while (!loggedIn);

        if (loggedIn) {
            // Goodbye message
            JOptionPane.showMessageDialog(null, "THANK YOU FOR USING EASYKANBAN.GOODBYE AND HAVE A NICE DAY!");
              JOptionPane.showMessageDialog(null, "SPONSORED BY THAMI THE HACKER ");
        }
    }


 private static boolean authenticate() {
        // TODO: Implement user authentication
        return true; // For demo purposes
    }

   private static int getTaskCount() {
         String input = JOptionPane.showInputDialog("Enter the number of tasks you wish to enter:");
        return Integer.parseInt(input);
    }



    private static Task getTask(int number) {
          // Prompt for task details
    String name = JOptionPane.showInputDialog("Enter the name of the task:");
    String description = JOptionPane.showInputDialog("Enter the description of the task:");
    String developer = JOptionPane.showInputDialog("Enter the developer assigned to the task:");
    int duration;
    while (true) {
        try {
            String durationStr = JOptionPane.showInputDialog("Enter the estimated duration of the task in hours:");
            duration = Integer.parseInt(durationStr);
            break;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a numeric value for the duration.");
        }
    }
     // Create a new Task object with the provided details
    Task task = new Task(name, description, developer, duration, number);
   // Generate a unique task ID based on task details
    String[] parts = name.split(" ");
    String taskID = parts[0].substring(0, 2).toUpperCase()
            + ":" + number
            + ":" + developer.substring(developer.length() - 3).toUpperCase();
    task.setID(taskID);

    // Prompt for task status
    String[] statuses = {"To Do", "Done", "Doing"};
    int statusOption = JOptionPane.showOptionDialog(null, "Select the status of the task:", "Task Status",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
            statuses, statuses[0]);
    String status = statuses[statusOption];
    task.setStatus(status);

    // Display the entered task
    StringBuilder taskDetails = new StringBuilder();
    taskDetails.append("Task Details:\n");
    taskDetails.append("Name: ").append(task.getName()).append("\n");
    taskDetails.append("Description: ").append(task.getDescription()).append("\n");
    taskDetails.append("Developer: ").append(task.getDeveloper()).append("\n");
    taskDetails.append("Duration: ").append(task.getDuration()).append(" hours").append("\n");
    taskDetails.append("ID: ").append(task.getID()).append("\n");
    taskDetails.append("Status: ").append(task.getStatus()).append("\n");

    JOptionPane.showMessageDialog(null, taskDetails.toString());
    
    // Return the created Task object
    return task;
}

          public void setUser(String user) {
        this.user = user;
    }
            public void setPassword(String password) {
        this.password = password;
    }

    private static void displayTasks(Task[] tasks) {
        StringBuilder output = new StringBuilder();

        for (Task task : tasks) {
            if (task != null) {
                output.append("Task Status: ").append(task.getStatus()).append("\n");
                output.append("Developer Details: ").append(task.getDeveloper()).append("\n");
                output.append("Task Number: ").append(task.getNumber()).append("\n");
                output.append("Task Name: ").append(task.getName()).append("\n");

                if (task.getDescription().length() > 50) {
                    JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                } else {
                    output.append("Task Description: ").append(task.getDescription()).append("\n");
                    output.append("Task ID: ").append(task.getID()).append("\n");
                    output.append("Task Duration: ").append(task.getDuration()).append(" hours\n\n");
                }
            }
        }

        JOptionPane.showMessageDialog(null, output.toString());
    }

    private static void displayTasksWithStatus(Task[] tasks, String status) {
        StringBuilder output = new StringBuilder();

        for (Task task : tasks) {
            if (task != null && task.getStatus().equalsIgnoreCase(status)) {
                output.append("Task Status: ").append(task.getStatus()).append("\n");
                output.append("Developer Details: ").append(task.getDeveloper()).append("\n");
                output.append("Task Number: ").append(task.getNumber()).append("\n");
                output.append("Task Name: ").append(task.getName()).append("\n");

                if (task.getDescription().length() > 50) {
                    JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                } else {
                    output.append("Task Description: ").append(task.getDescription()).append("\n");
                    output.append("Task ID: ").append(task.getID()).append("\n");
                    output.append("Task Duration: ").append(task.getDuration()).append(" hours\n\n");
                }
            }
        }

        JOptionPane.showMessageDialog(null, output.toString());
    }

    private static void displayTaskWithLongestDuration(Task[] tasks) {
      Task longestDurationTask = null;
    int maxDuration = -1;

    for (Task task : tasks) {
        if (task != null && task.getDuration() > maxDuration) {
            maxDuration = task.getDuration();
            longestDurationTask = task;
        }
    }

    if (longestDurationTask != null) {
        StringBuilder output = new StringBuilder();
        output.append("Tasks with Longest Duration:\n");

        for (Task task : tasks) {
            if (task != null && task.getDuration() == maxDuration) {
                output.append("Task Name: ").append(task.getName()).append("\n");
                output.append("Developer Details: ").append(task.getDeveloper()).append("\n");
                output.append("Task Duration: ").append(task.getDuration()).append(" hours\n");
                output.append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, output.toString());
    } else {
        JOptionPane.showMessageDialog(null, "No tasks found.");
    }
    }

    private static void searchTaskByName(Task[] tasks) {
        String taskName = JOptionPane.showInputDialog("Enter the task name to search:");

        for (Task task : tasks) {
            if (task != null && task.getName().equalsIgnoreCase(taskName)) {
                StringBuilder output = new StringBuilder();
                output.append("Task Name: ").append(task.getName()).append("\n");
                output.append("Developer Details: ").append(task.getDeveloper()).append("\n");
                output.append("Task Status: ").append(task.getStatus()).append("\n");

                JOptionPane.showMessageDialog(null, output.toString());
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Task not found.");
    }

    private static void searchTasksByDeveloper(Task[] tasks) {
        String developerName = JOptionPane.showInputDialog("Enter the developer name to search:");

        StringBuilder output = new StringBuilder();
        boolean foundTasks = false;

        for (Task task : tasks) {
            if (task != null && task.getDeveloper().equalsIgnoreCase(developerName)) {
                foundTasks = true;
                output.append("Task Name: ").append(task.getName()).append("\n");
                output.append("Task Status: ").append(task.getStatus()).append("\n");
                output.append("\n");
            }
        }

        if (foundTasks) {
            JOptionPane.showMessageDialog(null, output.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No tasks found for the specified developer.");
        }
    }
     String deleteTask(String taskName) {
    
    String deleteTask(String taskName) {
    // Check if task exists and delete it
    boolean taskDeleted = deleteTaskByName(taskName);

    // If task is deleted, return success message
    if (taskDeleted) {
        return "Task '" + taskName + "' successfully deleted";
    } else {
        return "No task found with the name '" + taskName + "'. Nothing to delete.";
    }
}

}
     public String[] getDevelopers() {
        String[] developers = new String[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            developers[i] = tasks[i].getDeveloper();
        }
        return developers;
    }

   public String displayDeveloperAndDurationForTaskWithLongestDuration() {
    if (tasks.length == 0) {
        return "No tasks available.";
    }
    
    Task longestTask = tasks[0];
    for (int i = 1; i < tasks.length; i++) {
        if (tasks[i].getDuration() > longestTask.getDuration()) {
            longestTask = tasks[i];
        }
    }
    return longestTask.getDeveloper() + ", " + longestTask.getDuration();
}


    public String searchForTasks(String searchQuery) {
        for (Task task : tasks) {
            if (task.getDescription().contains(searchQuery)) {
                return task.getDeveloper() + ", " + task.getDescription();
            }
        }
        return "Task not found";
    }

   public String searchAllTasksAssignedToDeveloper(String developer) {
    StringBuilder result = new StringBuilder();
    boolean foundTasks = false;
    
    for (Task task : tasks) {
        if (task.getDeveloper().equals(developer)) {
            result.append(task.getDescription()).append("; ");
            foundTasks = true;
        }
    }
    
    if (!foundTasks) {
        return "No tasks found for the developer: " + developer;
    }
    
    return result.toString().trim();
}


   public String displayReport() {
    StringBuilder report = new StringBuilder("<Report>\n");
    if (tasks.length == 0) {
        report.append("No tasks available.");
    } else {
        for (Task task : tasks) {
            report.append(task.toString()).append("\n");
        }
    }
    return report.toString();
}

String getReport() {
    if (tasks.length == 0) {
        return "No report available.";
    }
    
    String report = "This is the report";
    return report;
}



    private static void deleteTaskByName(Task[] tasks) {
        String taskName = JOptionPane.showInputDialog("Enter the task name to delete:");

        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null && tasks[i].getName().equalsIgnoreCase(taskName)) {
                tasks[i] = null;
                JOptionPane.showMessageDialog(null, "Task deleted successfully.");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Task not found.");
    }

  
     public void setTasks(Task[] tasks) {
    this.tasks = tasks;
}  
}

class Task {
    private final String name;
    private final String description;
    private final String developer;
    private final int duration;
    private String ID;
    private final int number;
    private String status;

    public Task(String name, String description, String developer, int duration, int number) {
        this.name = name;
        this.description = description;
        this.developer = developer;
        this.duration = duration;
        this.number = number;
        this.status = "To Do";
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDeveloper() {
        return developer;
    }

    public int getDuration() {
        return duration;
    }

    public String getID() {
        return ID;
    }

    public int getNumber() {
        return number;
    }

    public String getStatus() {
        return status;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setStatus(String status) {
        this.status = status;
    }
     public void checkUserName(String username) {
        
    }

    public void checkPassword(String password) {
        
    }

    public void login(String username, String password) {
    
    }
}


