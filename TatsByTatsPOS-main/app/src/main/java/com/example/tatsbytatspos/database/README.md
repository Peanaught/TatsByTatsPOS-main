# Database Connection Stability Utilities

This package contains utilities to help monitor and verify database connection stability in the TatsByTatsPOS application.

## Overview

The SQLite database connections in Android applications can sometimes become unstable due to various reasons such as:
- Memory constraints
- Improper connection closing
- Database corruption
- Concurrent access issues

These utilities provide a way to check connection stability and recover from potential issues.

## Components

### 1. DatabaseConnectionChecker

A utility class that provides methods to check if database connections are stable and functioning properly.

```kotlin
// Check if all database connections are stable
val isStable = DatabaseConnectionChecker.areAllDatabaseConnectionsStable(context)

// Check specific database connection
val isOrderDbStable = DatabaseConnectionChecker.isOrderDatabaseConnectionStable(context)

// Attempt to recover unstable connections
val recovered = DatabaseConnectionChecker.recoverDatabaseConnections(context)
```

### 2. DatabaseConnectionManager

A higher-level utility that provides user-friendly methods to check connections and display appropriate messages.

```kotlin
// Create an instance
val dbManager = DatabaseConnectionManager(context)

// Check connections with automatic recovery attempt
if (!dbManager.checkDatabaseConnections()) {
    // Handle unrecoverable connection issues
}

// Get detailed status of each database connection
val statusMap = dbManager.getDatabaseConnectionStatus()

// Show a toast with connection status
dbManager.showDatabaseConnectionStatus()
```

## Implementation Example

See the `DatabaseConnectionExample` class for a complete implementation example that shows how to:

1. Check database connections on application startup
2. Display appropriate error messages
3. Attempt connection recovery
4. Verify connection before performing database operations

## Best Practices

1. Always check database connection stability before performing critical database operations
2. Properly close database connections when they're no longer needed
3. Handle database exceptions gracefully
4. Implement a recovery mechanism for unstable connections
5. Provide clear feedback to users when database issues occur

## Integration

To integrate these utilities into existing activities or fragments:

```kotlin
// In your activity's onCreate or fragment's onCreateView
val dbManager = DatabaseConnectionManager(this)
if (!dbManager.checkDatabaseConnections()) {
    // Handle connection issues
    showErrorMessage()
    disableDatabaseFeatures()
}
```