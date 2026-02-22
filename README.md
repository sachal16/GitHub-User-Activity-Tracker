# GitHub User Activity

A small CLI that fetches a GitHub user’s recent events and prints their **push activity** (repo name and commit count) in the terminal.

## Prerequisites

- **Java 25** (or whatever version matches `maven.compiler.release` in `pom.xml`)
- **Maven**

## Build & run

```bash
mvn compile
```

Run `com.sachal.githubactivity.Main` from your IDE and pass a GitHub username as the program argument (e.g. `octocat`).

## Usage

```text
github-activity <username>
```

- **\<username\>** — GitHub username (e.g. `octocat`).

Example output:

```text
octocat
https://api.github.com/users/octocat/events
Pushed: 2 of octocat/Hello-World
Pushed: 1 of octocat/linguist
```

## Tests

```bash
mvn test
```

Uses JUnit 5. Tests cover `ApiResponse`, event parsing (Gson), and `GitHubClient.wiring()`.

## Tech

- Java (HTTP client, no extra HTTP lib)
- [Gson](https://github.com/google/gson) for JSON
- [GitHub Events API](https://docs.github.com/en/rest/activity/events#list-events-for-the-authenticated-user) (public, no token required for public events)
