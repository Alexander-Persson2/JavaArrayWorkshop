package se.lexicon;

public class NameRepository {
    private static String[] names = new String[0];

    public static int getSize() {
        return names.length;
    }

    public static void setNames(String[] newNames) {
        names = newNames;
    }

    public static void clear() {
        names = new String[0];
    }

    public static String[] findAll() {
        return names.clone();
    }

    public static String find(String fullName) {
        for (String name : names) {
            if (name.equals(fullName)) {
                return name;
            }
        }
        return null;
    }

    public static boolean add(String fullName) {
        if (find(fullName) != null) {
            return false;
        }
        String[] newNames = new String[names.length + 1];
        System.arraycopy(names, 0, newNames, 0, names.length);
        newNames[names.length] = fullName;
        names = newNames;
        return true;
    }

    public static String[] findByFirstName(String firstName) {
        String[] result = new String[names.length];
        int count = 0;
        for (String name : names) {
            if (name.startsWith(firstName + " ")) {
                result[count++] = name;
            }
        }
        return trimArray(result, count);
    }

    public static String[] findByLastName(String lastName) {
        String[] result = new String[names.length];
        int count = 0;
        for (String name : names) {
            if (name.endsWith(" " + lastName)) {
                result[count++] = name;
            }
        }
        return trimArray(result, count);
    }

    public static boolean update(String original, String updatedName) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(original)) {
                if (find(updatedName) != null) {
                    return false;
                }
                names[i] = updatedName;
                return true;
            }
        }
        return false;
    }

    public static boolean remove(String fullName) {
        int index = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(fullName)) {
                index = i;
                break;
            }
        }
    if (index == -1) {
        return false;
    }
    String[] newNames = new String[names.length -1];
    System.arraycopy(names, 0, newNames, 0, index);
    System.arraycopy(names, index + 1, newNames, index, names.length - index - 1);
    names = newNames;
    return true;
    }

    private static String[] trimArray(String[] array, int size) {
        String[] result = new String[size];
        System.arraycopy(array, 0, result, 0, size);
        return result;
    }
}


