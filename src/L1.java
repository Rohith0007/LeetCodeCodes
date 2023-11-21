//import java.util.HashMap;
//import java.util.Map;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class L1 {
//    public static void main(String[] args) {
//        L1 l1 = new L1();
//        String[][] s = {
//                {"SET_AT_WITH_TTL", "A", "B", "C", "1", "10"},
//                {"BACKUP", "3"},
//                {"SET_AT", "A", "D", "E", "4"},
//                {"BACKUP", "5"},
//                {"DELETE_AT", "A", "B", "8"},
//                {"BACKUP", "9"},
//                {"RESTORE", "10", "7"},
//                {"BACKUP", "11"},
//                {"SCAN_AT", "A", "15"},
//                {"SCAN_AT", "A", "16"}
//        };
//
//        String[] result = l1.solution(s);
//
//        // Print the result
//        for (String value : result) {
//            System.out.println(value);
//        }
//    }
//
//    String[] solution(String[][] queries) {
//        Map<String, Map<String, FieldValue>> database = new HashMap<>();
//        List<String> output = new ArrayList<>();
//        Map<String, Map<String, FieldValue>> backupDatabase = new HashMap<>();
//        for (int i = 0; i < queries.length; i++) {
//            String operation = queries[i][0];
//            String key = queries[i][1];
//
//
//            if ("SET".equals(operation)) {
//                String field = queries[i][2];
//                String value = queries[i][3];
//                database.computeIfAbsent(key, k -> new HashMap<>()).put(field, new FieldValue(value));
//                output.add(""); // Add an empty string for SET operation
//            } else if ("GET".equals(operation)) {
//                String field = queries[i][2];
//                Map<String, FieldValue> recordMap = database.get(key);
//                if (recordMap != null) {
//                    FieldValue fieldValue = recordMap.get(field);
//                    output.add(fieldValue != null ? fieldValue.getValue() : ""); // Add the value or an empty string
//                } else {
//                    output.add(""); // Add an empty string for non-existing record
//                }
//            } else if ("DELETE".equals(operation)) {
//                String field = queries[i][2];
//                Map<String, FieldValue> recordMap = database.get(key);
//                if (recordMap != null) {
//                    if (recordMap.containsKey(field)) {
//                        recordMap.remove(field);
//                        output.add("true"); // Field was successfully deleted
//                    } else {
//                        output.add("false"); // Field does not exist
//                    }
//                } else {
//                    output.add("false"); // Record does not exist
//                }
//            } else if ("SET_AT".equals(operation)) {
//                String field = queries[i][2];
//                String value = queries[i][3];
//                long timestamp = parseTimestamp(queries[i][4]);
//                if (timestamp >= 0) {
//                    database.computeIfAbsent(key, k -> new HashMap<>()).put(field, new FieldValue(value, timestamp));
//                    output.add(""); // Add an empty string for SET_AT operation
//                } else {
//                    output.add("Invalid timestamp"); // Handle invalid timestamp
//                }
//            } else if ("SET_AT_WITH_TTL".equals(operation)) {
//                String field = queries[i][2];
//                String value = queries[i][3];
//                long timestamp = parseTimestamp(queries[i][4]);
//                long ttl = parseTimestamp(queries[i][5]);
//                if (timestamp >= 0 && ttl >= 0) {
//                    database.computeIfAbsent(key, k -> new HashMap<>()).put(field, new FieldValue(value, timestamp, ttl));
//                    output.add(""); // Add an empty string for SET_AT_WITH_TTL operation
//                } else {
//                    output.add("Invalid timestamp or TTL"); // Handle invalid timestamp or TTL
//                }
//            } else if ("DELETE_AT".equals(operation)) {
//                String field = queries[i][2];
//                long timestamp = parseTimestamp(queries[i][3]);
//                Map<String, FieldValue> recordMap = database.get(key);
//                if (timestamp >= 0) {
//                    if (recordMap != null) {
//                        if (recordMap.containsKey(field) && recordMap.get(field).isAlive(timestamp)) {
//                            recordMap.remove(field);
//                            output.add("true"); // Field was successfully deleted
//                        } else {
//                            output.add("false"); // Field does not exist or has expired
//                        }
//                    } else {
//                        output.add("false"); // Record does not exist
//                    }
//                } else {
//                    output.add("Invalid timestamp"); // Handle invalid timestamp
//                }
//            } else if ("GET_AT".equals(operation)) {
//                String field = queries[i][2];
//                long timestamp = parseTimestamp(queries[i][3]);
//                Map<String, FieldValue> recordMap = database.get(key);
//                if (timestamp >= 0) {
//                    if (recordMap != null) {
//                        FieldValue fieldValue = recordMap.get(field);
//                        if (fieldValue != null && fieldValue.isAlive(timestamp)) {
//                            output.add(fieldValue.getValue()); // Add the value if it exists and has not expired
//                        } else {
//                            output.add(""); // Add an empty string for non-existing or expired field
//                        }
//                    } else {
//                        output.add(""); // Add an empty string for non-existing record
//                    }
//                } else {
//                    output.add("Invalid timestamp"); // Handle invalid timestamp
//                }
//            } else if ("SCAN_AT".equals(operation)) {
//                long timestamp = parseTimestamp(queries[i][2]);
//                Map<String, FieldValue> recordMap = database.get(key);
//                if (timestamp >= 0) {
//                    if (recordMap != null) {
//                        // Sort fields lexicographically and format as "<field1>(<value1>), <field2>(<value2>), ..."
//                        String fieldsString = recordMap.entrySet().stream()
//                                .filter(entry -> entry.getValue().isAlive(timestamp))
//                                .sorted(Map.Entry.comparingByKey())
//                                .map(entry -> entry.getKey() + "(" + entry.getValue().getValue() + ")")
//                                .collect(Collectors.joining(", "));
//                        output.add(fieldsString);
//                    } else {
//                        output.add(""); // Add an empty string for non-existing record
//                    }
//                } else {
//                    output.add("Invalid timestamp"); // Handle invalid timestamp
//                }
//            } else if ("SCAN_BY_PREFIX_AT".equals(operation)) {
//                long timestamp = parseTimestamp(queries[i][3]);
//                String prefix = queries[i][2];
//                Map<String, FieldValue> recordMap = database.get(key);
//                if (timestamp >= 0) {
//                    if (recordMap != null) {
//                        // Filter and sort fields by prefix and format as in SCAN_AT
//                        String fieldsString = recordMap.entrySet().stream()
//                                .filter(entry -> entry.getKey().startsWith(prefix) && entry.getValue().isAlive(timestamp))
//                                .sorted(Map.Entry.comparingByKey())
//                                .map(entry -> entry.getKey() + "(" + entry.getValue().getValue() + ")")
//                                .collect(Collectors.joining(", "));
//                        output.add(fieldsString);
//                    } else {
//                        output.add(""); // Add an empty string for non-existing record
//                    }
//                } else {
//                    output.add("Invalid timestamp"); // Handle invalid timestamp
//                }
//            } else if ("SCAN".equals(operation)) {
//                Map<String, FieldValue> recordMap = database.get(key);
//                if (recordMap != null) {
//                    // Sort fields lexicographically and format as "<field1>(<value1>), <field2>(<value2>), ..."
//                    String fieldsString = recordMap.entrySet().stream()
//                            .sorted(Map.Entry.comparingByKey())
//                            .map(entry -> entry.getKey() + "(" + entry.getValue().getValue() + ")")
//                            .collect(Collectors.joining(", "));
//                    output.add(fieldsString);
//                } else {
//                    output.add(""); // Add an empty string for non-existing record
//                }
//            } else if ("SCAN_BY_PREFIX".equals(operation)) {
//                String prefix = queries[i][2];
//                Map<String, FieldValue> recordMap = database.get(key);
//                if (recordMap != null) {
//                    // Filter and sort fields by prefix and format as in SCAN
//                    String fieldsString = recordMap.entrySet().stream()
//                            .filter(entry -> entry.getKey().startsWith(prefix))
//                            .sorted(Map.Entry.comparingByKey())
//                            .map(entry -> entry.getKey() + "(" + entry.getValue().getValue() + ")")
//                            .collect(Collectors.joining(", "));
//                    output.add(fieldsString);
//                } else {
//                    output.add(""); // Add an empty string for non-existing record
//                }
//            } else if ("BACKUP".equals(operation)) {
//                long timestamp = Long.parseLong(queries[i][1]);
//
//                // Create a deep copy of the current database state and save it in the backup
//
//                for (Map.Entry<String, Map<String, FieldValue>> entry : database.entrySet()) {
//                    key = entry.getKey();
//                    Map<String, FieldValue> record = entry.getValue();
//                    Map<String, FieldValue> recordCopy = new HashMap<>();
//                    for (Map.Entry<String, FieldValue> fieldEntry : record.entrySet()) {
//                        String field = fieldEntry.getKey();
//                        FieldValue fieldValue = fieldEntry.getValue();
//                        long originalTimestamp = fieldValue.getTimestamp();
//                        long originalTTL = fieldValue.getTTL();
//                        long remainingTTL = originalTTL - (timestamp - originalTimestamp);
//                        if (remainingTTL > 0) {
//                            recordCopy.put(field, new FieldValue(fieldValue.getValue(), originalTimestamp, remainingTTL));
//                        }
//                    }
//                    if (!recordCopy.isEmpty()) {
//                        backupDatabase.put(key, recordCopy);
//                    }
//                }
//
//                // Calculate and return the number of non-empty non-expired records
//                int count = 0;
//                for (Map.Entry<String, Map<String, FieldValue>> entry : backupDatabase.entrySet()) {
//                    key = entry.getKey();
//                    Map<String, FieldValue> record = entry.getValue();
//                    boolean hasNonEmptyField = false;
//                    for (FieldValue fieldValue : record.values()) {
//                        if (fieldValue.isAlive(timestamp)) {
//                            hasNonEmptyField = true;
//                            break;
//                        }
//                    }
//                    if (hasNonEmptyField) {
//                        count++;
//                    }
//                }
//                output.add(String.valueOf(count));
//            }
//
//            else if ("RESTORE".equals(operation)) {
//                // Find the latest backup before or at timestampToRestore
//                Map.Entry<String, Map<String, Map<String, FieldValue>>> latestBackupEntry = null;
//                long latestBackupTimestamp = 0;
//
//                for (Map.Entry<String, Map<String, Map<String, FieldValue>>> backupEntry : backupDatabase.entrySet()) {
//                    long backupTimestamp = Long.parseLong(backupEntry.getKey());
//                    if (backupTimestamp <= timestampToRestore && backupTimestamp > latestBackupTimestamp) {
//                        latestBackupEntry = backupEntry;
//                        latestBackupTimestamp = backupTimestamp;
//                    }
//                }
//
//// Restore the database state
//                if (latestBackupEntry != null) {
//                    // Clear the current database
//                    database.clear();
//
//                    // Restore data from the latest backup
//                    for (Map.Entry<String, Map<String, FieldValue>> entry : latestBackupEntry.getValue().entrySet()) {
//                        String key = entry.getKey();
//                        Map<String, FieldValue> record = entry.getValue();
//                        Map<String, FieldValue> recordCopy = new HashMap<>();
//                        for (Map.Entry<String, FieldValue> fieldEntry : record.entrySet()) {
//                            String field = fieldEntry.getKey();
//                            FieldValue fieldValue = fieldEntry.getValue();
//                            recordCopy.put(field, new FieldValue(fieldValue.getValue(), timestampToRestore, fieldValue.getTTL()));
//                        }
//                        database.put(key, recordCopy);
//                    }
//                }
//
//                output.add(""); // Add an empty string as required
//
//            }
//
//
//            else {
//                output.add("Invalid operation");
//            }
//        }
//
//        // Convert the output list to a String array
//        String[] result = new String[output.size()];
//        result = output.toArray(result);
//        return result;
//    }
//
//    private long parseTimestamp(String timestampStr) {
//        try {
//            return Long.parseLong(timestampStr);
//        } catch (NumberFormatException e) {
//            return -1; // Indicates an invalid timestamp
//        }
//    }
//
//    private static class FieldValue {
//        private final String value;
//        private final long timestamp;
//        private final long ttl;
//
//        FieldValue(String value) {
//            this.value = value;
//            this.timestamp = System.currentTimeMillis(); // Use current time as the default timestamp
//            this.ttl = -1; // No TTL set
//        }
//
//        FieldValue(String value, long timestamp) {
//            this.value = value;
//            this.timestamp = timestamp;
//            this.ttl = -1; // No TTL set
//        }
//
//        FieldValue(String value, long timestamp, long ttl) {
//            this.value = value;
//            this.timestamp = timestamp;
//            this.ttl = ttl;
//        }
//
//
//        public long getTimestamp() {
//            return timestamp;
//        }
//
//        public long getTTL() {
//            return ttl;
//        }
//
//        String getValue() {
//            return value;
//        }
//
//        boolean isAlive(long currentTimestamp) {
//            if (ttl == -1) {
//                return true; // No TTL set
//            }
//            return currentTimestamp >= timestamp && currentTimestamp < timestamp + ttl;
//        }
//    }
//}
