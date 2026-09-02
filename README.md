# Task Tracker CLI

A simple command-line task tracking application built with **Java**.

This project allows users to manage tasks directly from the terminal. Tasks are stored locally in a JSON file, making the application lightweight and easy to use without requiring a database or external framework.

## Features

The application supports the following operations:

- Add a new task
- Update an existing task
- Delete a task
- Mark a task as `in-progress`
- Mark a task as `done`
- List all tasks
- List tasks by status:
  - `todo`
  - `in-progress`
  - `done`

## Technologies

- Java
- Java File I/O
- Command Line Arguments
- JSON file storage
- Git

No external libraries or frameworks are required.

## Project Structure

```text
task-tracker-cli/
│
├── src/
│   └── Main.java
│
├── tasks.json
├── README.md
└── .gitignore
```

> `tasks.json` is automatically created when the application runs if the file does not already exist.

## Task Properties

Each task contains the following fields:

```json
{
  "id": 1,
  "description": "Buy groceries",
  "status": "todo",
  "createdAt": "2026-09-02T13:30:00",
  "updatedAt": "2026-09-02T13:30:00"
}
```

| Property | Description |
|---|---|
| `id` | Unique identifier of the task |
| `description` | Description of the task |
| `status` | Current status: `todo`, `in-progress`, or `done` |
| `createdAt` | Date and time when the task was created |
| `updatedAt` | Date and time when the task was last modified |

## Requirements

Before running the application, make sure Java is installed.

Check your Java installation:

```bash
java -version
```

Check the Java compiler:

```bash
javac -version
```

Java 17 or newer is recommended.

## Installation

Clone the repository:

```bash
git clone <repository-url>
```

Navigate to the project directory:

```bash
cd task-tracker-cli
```

Compile the Java source code:

```bash
javac -d out src/Main.java
```

Run the application:

```bash
java -cp out Main
```

## Usage

The application accepts commands through positional command-line arguments.

### Add a Task

```bash
java -cp out Main add "Buy groceries"
```

Example output:

```text
Task added successfully (ID: 1)
```

### Update a Task

```bash
java -cp out Main update 1 "Buy groceries and cook dinner"
```

Example output:

```text
Task updated successfully.
```

### Delete a Task

```bash
java -cp out Main delete 1
```

Example output:

```text
Task deleted successfully.
```

### Mark a Task as In Progress

```bash
java -cp out Main mark-in-progress 1
```

Example output:

```text
Task marked as in-progress.
```

### Mark a Task as Done

```bash
java -cp out Main mark-done 1
```

Example output:

```text
Task marked as done.
```

### List All Tasks

```bash
java -cp out Main list
```

### List Completed Tasks

```bash
java -cp out Main list done
```

### List Todo Tasks

```bash
java -cp out Main list todo
```

### List Tasks In Progress

```bash
java -cp out Main list in-progress
```

## Optional Executable Command

To use commands in a format similar to:

```bash
task-cli add "Buy groceries"
```

you can create a small shell script or operating-system-specific launcher that runs:

```bash
java -cp out Main "$@"
```

For the basic project requirements, running the Java program directly from the command line is sufficient.

## Supported Commands

| Command | Usage |
|---|---|
| Add | `add "description"` |
| Update | `update <id> "new description"` |
| Delete | `delete <id>` |
| Mark In Progress | `mark-in-progress <id>` |
| Mark Done | `mark-done <id>` |
| List All | `list` |
| List Done | `list done` |
| List Todo | `list todo` |
| List In Progress | `list in-progress` |

## Error Handling

The application should handle invalid input gracefully.

Examples include:

- Missing command arguments
- Invalid task IDs
- Updating a task that does not exist
- Deleting a task that does not exist
- Invalid task status filters
- Empty task descriptions
- Missing or corrupted `tasks.json`
- File read/write errors

Example:

```text
Error: Task with ID 5 was not found.
```

For invalid commands, the application should display usage information instead of terminating unexpectedly.

## Data Storage

All tasks are stored inside:

```text
tasks.json
```

The file is located in the current project directory.

The application should:

1. Check whether `tasks.json` exists.
2. Create it automatically if it does not exist.
3. Read existing tasks before performing an operation.
4. Update the in-memory task list.
5. Write the updated task list back to the JSON file.

## Suggested Java Classes

A simple implementation can use the following structure:

```text
Main
 ├── parses command-line arguments
 └── calls TaskManager methods

Task
 ├── id
 ├── description
 ├── status
 ├── createdAt
 └── updatedAt

TaskManager
 ├── addTask()
 ├── updateTask()
 ├── deleteTask()
 ├── markInProgress()
 ├── markDone()
 ├── listTasks()
 ├── loadTasks()
 └── saveTasks()
```

This structure keeps command handling, task data, and file operations separated.

## Development Plan

A practical implementation order is:

1. Create the `Task` model.
2. Implement JSON file creation.
3. Implement loading tasks from the file.
4. Implement saving tasks to the file.
5. Implement the `add` command.
6. Implement the `list` command.
7. Implement `update`.
8. Implement `delete`.
9. Implement `mark-in-progress`.
10. Implement `mark-done`.
11. Add filtering to the `list` command.
12. Add input validation and error handling.
13. Test all CLI commands.

## Example Workflow

```bash
java -cp out Main add "Learn Java"
java -cp out Main add "Build Task Tracker CLI"

java -cp out Main list

java -cp out Main mark-in-progress 2

java -cp out Main list in-progress

java -cp out Main mark-done 1

java -cp out Main list done

java -cp out Main update 2 "Complete Task Tracker CLI"

java -cp out Main delete 1
```

## Testing

Test each command individually and check `tasks.json` after each operation.

Important cases to test:

- Add the first task
- Add multiple tasks
- Restart the application and verify that tasks remain stored
- Update a valid task
- Update an invalid task ID
- Delete a valid task
- Delete an invalid task ID
- Mark tasks as `in-progress`
- Mark tasks as `done`
- Filter tasks by every supported status
- Run commands with missing arguments
- Run an unknown command

## Learning Objectives

This project is designed to practice:

- Java fundamentals
- Object-oriented programming
- File handling
- Working with command-line arguments
- Data serialization and parsing
- CRUD operations
- Error handling
- Application structure
- Git and project documentation

## Future Improvements

Possible extensions include:

- Due dates
- Task priorities
- Search functionality
- Sorting tasks
- Categories or tags
- Colored terminal output
- Unit tests
- Maven or Gradle support
- Database storage
- Interactive CLI mode

## License

This project is intended for educational purposes.
