# File Explorer - Visitor Pattern Demo

A minimal JavaFX application that demonstrates the **Visitor Design Pattern** through a visual File Explorer Simulator.

## Overview

This project showcases how the Visitor Pattern allows you to add new operations to existing object structures without modifying those structures. The file system items (files and folders) remain unchanged while different visitors perform various operations on them.

## Project Structure

```
src/main/java/com/madias/visitor/visitor/
├── FSItem.java              # Element interface
├── FileItem.java            # Concrete element (File)
├── FolderItem.java          # Concrete element (Folder)
├── FSVisitor.java           # Visitor interface
├── InfoVisitor.java         # Concrete visitor (Info display)
├── IconVisitor.java         # Concrete visitor (Icon display)
├── SizeVisitor.java         # Concrete visitor (Size calculation)
├── FileExplorerApp.java     # Main JavaFX application
├── HelloApplication.java    # Application entry point
├── HelloController.java     # (Legacy file)
└── Launcher.java            # (Legacy file)
```

## Visitor Pattern Components

### 1. Element Interface (`FSItem`)

- Defines the `accept(FSVisitor visitor)` method
- All file system items implement this interface

### 2. Concrete Elements

- **FileItem**: Represents a file with name and size
- **FolderItem**: Represents a folder with name and item count

### 3. Visitor Interface (`FSVisitor`)

- Defines `visit(FileItem)` and `visit(FolderItem)` methods
- Declares operations that can be performed on elements

### 4. Concrete Visitors

- **InfoVisitor**: Generates descriptive text about items
  - File → "File: <name>, size: <X>"
  - Folder → "Folder: <name>, items: <N>"
- **IconVisitor**: Returns appropriate emoji icons
  - File → 📄
  - Folder → 📁
- **SizeVisitor**: Calculates size in bytes
  - File → actual file size
  - Folder → mocked total size (itemCount × 1024)

## How to Run

### Using Maven:

```bash
mvn clean javafx:run
```

### Using Maven Wrapper (Windows):

```bash
.\mvnw.cmd clean javafx:run
```

### Using Maven Wrapper (Unix/Mac):

```bash
./mvnw clean javafx:run
```

## Features

1. **ListView Display**: Shows preloaded file system items

   - Documents (folder with 15 items)
   - Pictures (folder with 42 items)
   - notes.txt (file, 2048 bytes)
   - music.mp3 (file, 3,145,728 bytes)

2. **Interactive Selection**: Click any item to view:

   - Icon (via IconVisitor)
   - Detailed information (via InfoVisitor)
   - Size in bytes and KB (via SizeVisitor)

3. **Visual Feedback**: Information panel displays all visitor results

## Key Benefits of Visitor Pattern

✅ **Open/Closed Principle**: Add new operations (visitors) without modifying element classes  
✅ **Single Responsibility**: Each visitor handles one specific operation  
✅ **Easy to Add Operations**: Create new visitors for new functionality  
✅ **Centralized Logic**: Related operations are grouped in visitor classes

## Requirements

- Java 21
- JavaFX 21.0.6
- Maven 3.x

## Learning Points

This demo illustrates:

- How to implement the Visitor Pattern in Java
- Double dispatch mechanism (element.accept() → visitor.visit())
- Separation of data structures (elements) from operations (visitors)
- Practical application in a GUI context

## Where the Pattern is Used

The Visitor Pattern is applied in `FileExplorerApp.displayItemDetails()`:

```java
// Item accepts each visitor
item.accept(iconVisitor);      // Returns icon emoji
item.accept(infoVisitor);      // Returns descriptive text
item.accept(sizeVisitor);      // Returns size calculation

// Each visitor performs its operation based on item type
// without the item needing to know what operation is being performed
```

## License

Educational demonstration project.
