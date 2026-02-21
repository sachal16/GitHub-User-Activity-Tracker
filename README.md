# GitHub User Activity

CLI that fetches a GitHub user’s recent events and prints push activity in the terminal.

## Build & run

```bash
# Compile and run (requires Java 17+)
mvn compile exec:java -Dexec.mainClass="com.sachal.githubactivity.Main" -Dexec.args="octocat"

# Run tests
mvn test

# Build fat JAR (run anywhere)
mvn package
java -jar target/github-useractivity-1.0-SNAPSHOT-cli.jar <username>
```

## Usage

```text
github-activity <username>
```

Example: `github-activity octocat` shows recent push events for the Octocat user.
