# Logging config for spring boot

```yaml
logging:
  level:
    root: INFO
    org.springframework.web: DEBUG
    panomete.project.spb4featsnip: DEBUG # Your base package
    org.hibernate: INFO
  pattern:
    console: "%clr(%d{${LOG_DATEFORMAT_PATTERN:yyyy-MM-dd HH:mm:ss.SSS Z}}){magenta} |  %clr(${LOG_LEVEL_PATTERN:%-5p}) | %clr(%-40.40logger{39}){cyan} | %clr(%-25.25M){yellow} | %m%n${LOG_EXCEPTION_CONVERSION_WORD:%wEx}"

```

| Component                                                                                | Description                                                                                      |
|------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------|
| `logging.level.root: INFO`                                                               | Sets the root logging level to INFO, meaning                                                     |
| all logs at INFO level and above will be recorded.                                       |                                                                                                  |
| `logging.level.org.springframework.web: DEBUG`                                           | Sets the logging level for Spring Web package to DEBUG, enabling detailed logs for web requests. |
| `logging.level.panomete.project.spb4featsnip: DEBUG`                                     | Sets                                                                                             |
| the logging level for the specified base package to DEBUG for detailed application logs. |                                                                                                  |
| `logging.level.org.hibernate: INFO`                                                      | Sets the logging level for Hibernate to INFO, reducing verbosity for database operations.        |
| `logging.pattern.console`                                                                | Defines the log output format for console logs.                                                  |
| `%clr(%d{${LOG_DATEFORMAT_PATTERN:yyyy-MM-dd HH:mm:ss.S                                  |                                                                                                  |
| SS Z}}){magenta}`                                                                        | Formats the date and time of the log entry in magenta color.                                     |
| `%clr(${LOG_LEVEL_PATTERN:%-5p})`                                                        | Formats the log level                                                                            |
| (e.g., INFO, DEBUG) in default color.                                                    |                                                                                                  |
| `%clr(%-40.40logger{39}){cyan}`                                                          | Formats the logger name in cyan color, with a maximum length of 40 characters.                   |
| `%clr(%-25.25M){yellow}`                                                                 | Formats the method name in                                                                       |
| yellow color, with a maximum length of 25 characters.                                    |                                                                                                  |
| `%m`                                                                                     | Represents the actual log message.                                                               |
| `%n`                                                                                     | Inserts a new line after each log entry.                                                         |
| `${LOG_EXCEPTION_CONVERSION_WORD:%wEx}`                                                  | Formats exception stack traces if present                                                        |
| , using the default conversion word.                                                     |                                                                                                  |

This configuration enhances log readability by using colors and structured formatting, making it easier to identify key information in the logs.
