/**
 * @author Andres Arevalo
 * @author Walter Chu
 * @version 1.0
 */
public class AudioFile extends MusicMedia implements FileManager
{
    private static final int MINIMUM_BPS;
    private static final int MAXIMUM_BPS;

    static
    {
        MINIMUM_BPS = 32;
        MAXIMUM_BPS = 9216;
    }

    private final int fileSizeBitsPerSecond;

    private String fileName;

    public AudioFile(final String songTitle,
                     final String artistName,
                     final String fileName,
                     final int    fileSizeBitsPerSecond)
    {
        super(songTitle,
              artistName);

        validateFileName(fileName);
        validateFileSizeBitsPerSecond(fileSizeBitsPerSecond);

        this.fileName              = fileName;
        this.fileSizeBitsPerSecond = fileSizeBitsPerSecond;
    }

    public int getFileSizeBitsPerSecond()
    {
        return fileSizeBitsPerSecond;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(final String fileName)
    {
        validateFileName(fileName);

        this.fileName = fileName;
    }

    private static void validateFileName(final String string)
    {
        if(string == null ||
           string.isEmpty() ||
           string.isBlank())
        {
            throw new IllegalArgumentException("The string cannot be null, empty, or blank.");
        }
    }

    private static void validateFileSizeBitsPerSecond(final int fileSizeBitsPerSecond)
    {
        if(fileSizeBitsPerSecond < MINIMUM_BPS ||
           fileSizeBitsPerSecond > MAXIMUM_BPS)
        {
            throw new IllegalArgumentException(String.format("The file size in BPS must be between %d & %d.",
                                                             MINIMUM_BPS,
                                                             MAXIMUM_BPS));
        }
    }

    @Override
    public String toString()
    {
        return "AudioFile{" +
           "fileSizeBitsPerSecond=" + fileSizeBitsPerSecond +
           ", fileName='" + fileName + '\'' +
           "} " + super.toString();
    }

    @Override
    public void play()
    {
        System.out.println("The audio file is being played.");
    }

    @Override
    public void save(final String fileName)
    {
        System.out.println(String.format("The file has been saved as %s.",
                                         fileName));
    }

    @Override
    public void delete(final String fileName)
    {
        System.out.println(String.format("The file %s has been deleted.",
                                         fileName));
    }
}
