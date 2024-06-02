/**
 * @author Andres Arevalo
 * @author Walter Chu
 * @version 1.0
 */
public abstract class MusicMedia
{
    private final String songTitle;
    private final String artistName;

    public MusicMedia(final String songTitle,
                      final String artistName)
    {
        validateString(songTitle);
        validateString(artistName);

        this.songTitle = songTitle;
        this.artistName = artistName;
    }

    public abstract void play();

    public String getSongTitle()
    {
        return songTitle;
    }

    public String getArtistName()
    {
        return artistName;
    }

    private static void validateString(final String string)
    {
        if(string == null ||
           string.isEmpty() ||
           string.isBlank())
        {
            throw new IllegalArgumentException("The string cannot be null, empty, or blank.");
        }
    }

    @Override
    public String toString()
    {
        return "MusicMedia{" +
           "songTitle=" + songTitle +
           ", artistName=" + artistName +
           '}';
    }
}
