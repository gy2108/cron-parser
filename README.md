### CronExpression Parser

### How To Build and Run the Application

Navigate to the project inside `/cron-parser` path and build the project with the command `mvn clean install`
Inside the `target/` folder there will be a jar created with name `cron-parser-1.0-SNAPSHOT.jar`

To run the jar use the belwo command on the terminal
`$ java -jar cron-parser-1.0-SNAPSHOT.jar (Arguments)`

Format of Arguments should be in below format:
`(minute) (hour) (day of month) (month) (day of week) (command args1 args2)`
Sample: `*/15 0 1,15 * 1-5 /usr/bin/find`

Sample command
`java -jar cron-parser-1.0-SNAPSHOT.jar "*/15 0 1,15 * 1-5 /usr/bin/find"`

Cron Expression Parsed Output
```
minute        0 15 30 45
hour          0
day of month  1 15
month         1 2 3 4 5 6 7 8 9 10 11 12
day of week   1 2 3 4 5
command       /usr/bin/find
```