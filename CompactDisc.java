/**
 * @author Andres Arevalo
 * @author Walter Chu
 * @version 1.0
 */
public class CompactDisc extends MusicMedia
{
    private static final String READING_METHOD;
    private static final int    MINIMUM_NUMBER_OF_TRACKS;

    static
    {
        READING_METHOD           = "laser";
        MINIMUM_NUMBER_OF_TRACKS = 1;
    }

    private final int numberOfTracks;

    public CompactDisc(final String songTitle,
                       final String artistName,
                       final int    numberOfTracks)
    {
        super(songTitle,
              artistName);

        validateNumberOfTracks(numberOfTracks);

        this.numberOfTracks = numberOfTracks;
    }

    public int getNumberOfTracks()
    {
        return numberOfTracks;
    }

    private static void validateNumberOfTracks(final int numberOfTracks)
    {
        if(numberOfTracks < MINIMUM_NUMBER_OF_TRACKS)
        {
            throw new IllegalArgumentException(String.format("The number of tracks cannot be less than %s.",
                                                             MINIMUM_NUMBER_OF_TRACKS));
        }
    }

    @Override
    public String toString()
    {
        return "CompactDisc{" +
           "numberOfTracks=" + numberOfTracks +
           "} " + super.toString();
    }

    @Override
    public void play()
    {
        System.out.println("The compact disc is being played.");
    }
}
