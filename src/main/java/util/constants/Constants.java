package util.constants;

public class Constants {
    private Constants() {

    }

    public static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private static final String USER_DIR = System.getProperty("user.dir");
    public static final String FOLDER_TEST = USER_DIR + FILE_SEPARATOR + "src" + FILE_SEPARATOR + "test"
            + FILE_SEPARATOR;
    public static final String TEST_RESOURCES = FOLDER_TEST + "resources" + FILE_SEPARATOR;
    public static final String TEST_RESOURCES_PROPERTIES = TEST_RESOURCES + "Properties" + FILE_SEPARATOR;

}
