import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class LogFileProcessorApp {

    // The LogEntry class
    public static class LogEntry {
        private String ipAddress;
        private String userIdentifier;
        private String userId;
        private String dateTime;
        private String method;
        private String resource;
        private String protocol;
        private int statusCode;
        private int bytes;

        // Getters and Setters
        public String getIpAddress() { return ipAddress; }
        public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }
        public String getUserIdentifier() { return userIdentifier; }
        public void setUserIdentifier(String userIdentifier) { this.userIdentifier = userIdentifier; }
        public String getUserId() { return userId; }
        public void setUserId(String userId) { this.userId = userId; }
        public String getDateTime() { return dateTime; }
        public void setDateTime(String dateTime) { this.dateTime = dateTime; }
        public String getMethod() { return method; }
        public void setMethod(String method) { this.method = method; }
        public String getResource() { return resource; }
        public void setResource(String resource) { this.resource = resource; }
        public String getProtocol() { return protocol; }
        public void setProtocol(String protocol) { this.protocol = protocol; }
        public int getStatusCode() { return statusCode; }
        public void setStatusCode(int statusCode) { this.statusCode = statusCode; }
        public int getBytes() { return bytes; }
        public void setBytes(int bytes) { this.bytes = bytes; }

        @Override
        public String toString() {
            return "LogEntry{" +
                    "ipAddress='" + ipAddress + '\'' +
                    ", userIdentifier='" + userIdentifier + '\'' +
                    ", userId='" + userId + '\'' +
                    ", dateTime='" + dateTime + '\'' +
                    ", method='" + method + '\'' +
                    ", resource='" + resource + '\'' +
                    ", protocol='" + protocol + '\'' +
                    ", statusCode=" + statusCode +
                    ", bytes=" + bytes +
                    '}';
        }
    }

    // The LogFileProcessor class
    public static class LogFileProcessor {
        private static final String LOG_ENTRY_PATTERN = 
            "^([\\d.]+) (\\S+) (\\S+) \\[([\\w:/]+\\s[+\\-]\\d{4})\\] \"(\\S+) (.*?) (\\S+)\" (\\d{3}) (\\d+|\\-)";
        
        private Pattern pattern;

        public LogFileProcessor() {
            pattern = Pattern.compile(LOG_ENTRY_PATTERN);
        }

        public List<LogEntry> parseLogFile(String filePath) throws IOException {
            List<LogEntry> logEntries = new ArrayList<>();
            
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    LogEntry entry = new LogEntry();
                    entry.setIpAddress(matcher.group(1));
                    entry.setUserIdentifier(matcher.group(2));
                    entry.setUserId(matcher.group(3));
                    entry.setDateTime(matcher.group(4));
                    entry.setMethod(matcher.group(5));
                    entry.setResource(matcher.group(6));
                    entry.setProtocol(matcher.group(7));
                    entry.setStatusCode(Integer.parseInt(matcher.group(8)));
                    entry.setBytes(matcher.group(9).equals("-") ? 0 : Integer.parseInt(matcher.group(9)));
                    
                    logEntries.add(entry);
                }
            }
            
            return logEntries;
        }
    }

    // Main method to run the LogFileProcessorApp
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java LogFileProcessorApp <log_file_path>");
            return;
        }

        String logFilePath = args[0];
        LogFileProcessor processor = new LogFileProcessor();
        
        try {
            List<LogEntry> logEntries = processor.parseLogFile(logFilePath);
            for (LogEntry entry : logEntries) {
                System.out.println(entry);
            }
        } catch (IOException e) {
            System.err.println("Error processing log file: " + e.getMessage());
        }
    }
}
