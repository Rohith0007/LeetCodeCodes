import java.util.*;

public class Main {
    public static class User {
        private int capacity;
        private int usedCapacity;
        private Map<String, Integer> files;

        public User(int capacity) {
            this.capacity = capacity;
            this.usedCapacity = 0;
            this.files = new HashMap<>();
        }

        public boolean addFile(String name, int size) {
            if (usedCapacity + size <= capacity && !files.containsKey(name)) {
                files.put(name, size);
                usedCapacity += size;
                return true;
            }
            return false;
        }

        public String getFileSize(String name) {
            return files.containsKey(name) ? Integer.toString(files.get(name)) : "";
        }

        public int getCapacity() {
            return capacity;
        }

        public int getUsedCapacity() {
            return usedCapacity;
        }

        public Map<String, Integer> getFiles() {
            return files;
        }

        public void updateCapacity(int newCapacity) {
            if (newCapacity < usedCapacity) {
                // Remove the largest files until capacity is within the limit
                List<Map.Entry<String, Integer>> sortedFiles = new ArrayList<>(files.entrySet());
                sortedFiles.sort((a, b) -> {
                    int sizeComparison = b.getValue().compareTo(a.getValue());
                    return sizeComparison != 0 ? sizeComparison : a.getKey().compareTo(b.getKey());
                });

                Iterator<Map.Entry<String, Integer>> iterator = sortedFiles.iterator();
                while (usedCapacity > newCapacity && iterator.hasNext()) {
                    Map.Entry<String, Integer> entry = iterator.next();
                    usedCapacity -= entry.getValue();
                    iterator.remove();
                }

                files = new HashMap<>();
                for (Map.Entry<String, Integer> entry : sortedFiles) {
                    files.put(entry.getKey(), entry.getValue());
                }
            }
            capacity = newCapacity;
        }
    }

    public static Map<String, User> users = new HashMap<>();

    public static String[] solution(String[][] queries) {
        List<String> results = new ArrayList<>();

        for (String[] query : queries) {
            String operation = query[0];
            String userId = query[1];
            String result = "";

            if (operation.equals("ADD_USER")) {
                int capacity = Integer.parseInt(query[2]);
                if (!users.containsKey(userId)) {
                    users.put(userId, new User(capacity));
                    result = "true";
                } else {
                    result = "false";
                }
            } else if (operation.equals("ADD_FILE_BY")) {
                int size = Integer.parseInt(query[3]);
                User user = users.get(userId);
                if (user != null) {
                    if (user.addFile(query[2], size)) {
                        result = Integer.toString(user.getCapacity() - user.getUsedCapacity());
                    } else {
                        result = "";
                    }
                }
            } else if (operation.equals("UPDATE_CAPACITY")) {
                int newCapacity = Integer.parseInt(query[2]);
                User user = users.get(userId);
                if (user != null) {
                    int removedFiles = 0;
                    if (newCapacity < user.getUsedCapacity()) {
                        int oldCapacity = user.getCapacity();
                        user.updateCapacity(newCapacity);
                        removedFiles = oldCapacity - newCapacity;
                    }
                    result = Integer.toString(removedFiles);
                }
            } else if (operation.equals("FIND_FILE")) {
                User user = users.get(userId);
                if (user != null) {
                    String prefix = query[2];
                    String suffix = query[3];
                    List<Map.Entry<String, Integer>> matchingFiles = new ArrayList<>();

                    // Find matching files by prefix and suffix
                    for (Map.Entry<String, Integer> entry : user.getFiles().entrySet()) {
                        String fileName = entry.getKey();
                        if (fileName.startsWith(prefix) && fileName.endsWith(suffix)) {
                            matchingFiles.add(entry);
                        }
                    }

                    // Sort matching files by size in descending order (or lexicographically in case of ties)
                    matchingFiles.sort((a, b) -> {
                        int sizeComparison = b.getValue().compareTo(a.getValue());
                        return sizeComparison != 0 ? sizeComparison : a.getKey().compareTo(b.getKey());
                    });

                    // Construct the result string
                    StringBuilder resultBuilder = new StringBuilder();
                    for (int i = 0; i < matchingFiles.size(); i++) {
                        Map.Entry<String, Integer> entry = matchingFiles.get(i);
                        resultBuilder.append(entry.getKey()).append("(").append(entry.getValue()).append(")");
                        if (i < matchingFiles.size() - 1) {
                            resultBuilder.append(", ");
                        }
                    }
                    result = resultBuilder.toString();
                }
            }

            results.add(result);
        }

        return results.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[][] queries = {
                {"ADD_USER", "user1", "125"},
                {"ADD_USER", "user1", "100"},
                {"ADD_USER", "user2", "100"},
                {"ADD_FILE_BY", "user1", "/dir/file.big", "50"},
                {"ADD_FILE_BY", "user1", "/file.med", "30"},
                {"ADD_FILE_BY", "user2", "/file.med", "40"},
                {"COPY_FILE", "/file.med", "/dir/another/file.med"},
                {"COPY_FILE", "/file.med", "/dir/another/another/file.med"},
                {"ADD_FILE_BY", "user1", "/dir/file.small", "10"},
                {"ADD_FILE", "/dir/admin_file", "200"},
                {"ADD_FILE_BY", "user1", "/dir/file.small", "5"},
                {"ADD_FILE_BY", "user1", "/my_folder/file.huge", "100"},
                {"ADD_FILE_BY", "user3", "/my_folder/file.huge", "100"},
                {"UPDATE_CAPACITY", "user1", "300"},
                {"UPDATE_CAPACITY", "user1", "50"},
                {"UPDATE_CAPACITY", "user2", "1000"}
        };
        String[] results = solution(queries);

        for (String result : results) {
            System.out.println(result);
        }
    }
}
