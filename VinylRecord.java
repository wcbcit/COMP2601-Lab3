/**
 * @author Andres Arevalo
 * @author Walter Chu
 * @version 1.0
 */
public class VinylRecord extends MusicMedia
{
    private static final int    MINIMUM_NUMBER_OF_TRACKS;
    private static final String VALID_SMALL_SIZE;
    private static final String VALID_MEDIUM_SIZE;
    private static final String VALID_LARGE_SIZE;
    private static final String VALID_SMALL_SIZE_WEIGHT;
    private static final String VALID_MEDIUM_SIZE_WEIGHT;
    private static final String VALID_LARGE_SIZE_LOW_WEIGHT;
    private static final String VALID_LARGE_SIZE_MEDIUM_WEIGHT;
    private static final String VALID_LARGE_SIZE_HIGH_WEIGHT;

    static
    {
        MINIMUM_NUMBER_OF_TRACKS       = 1;
        VALID_SMALL_SIZE               = "7\"";
        VALID_MEDIUM_SIZE              = "10\"";
        VALID_LARGE_SIZE               = "12\"";
        VALID_SMALL_SIZE_WEIGHT        = "40g";
        VALID_MEDIUM_SIZE_WEIGHT       = "100g";
        VALID_LARGE_SIZE_LOW_WEIGHT    = "140g";
        VALID_LARGE_SIZE_MEDIUM_WEIGHT = "180g";
        VALID_LARGE_SIZE_HIGH_WEIGHT   = "200g";
    }

    private final int    numberOfTracks;
    private final String sizeInches;
    private final String weightGrahams;

    public VinylRecord(final String songTitle,
                       final String artistName,
                       final int    numberOfTracks,
                       final String sizeInches,
                       final String weightGrahams)
    {
        super(songTitle,
              artistName);

        validateNumberOfTracks(numberOfTracks);
        validateSize(sizeInches);
        validateWeight(sizeInches, weightGrahams);

        this.numberOfTracks = numberOfTracks;
        this.sizeInches     = sizeInches;
        this.weightGrahams  = weightGrahams;
    }

    public int getNumberOfTracks()
    {
        return numberOfTracks;
    }

    public String getSizeInches()
    {
        return sizeInches;
    }

    public String getWeightGrahams()
    {
        return weightGrahams;
    }

    private static void validateNumberOfTracks(final int numberOfTracks)
    {
        if(numberOfTracks < MINIMUM_NUMBER_OF_TRACKS)
        {
            throw new IllegalArgumentException(String.format("The number of tracks cannot be less than %s.",
                                                             MINIMUM_NUMBER_OF_TRACKS));
        }
    }

    private static void validateSize(final String sizeInches)
    {
        if(!sizeInches.equals(VALID_SMALL_SIZE) &&
           !sizeInches.equals(VALID_MEDIUM_SIZE) &&
           !sizeInches.equals(VALID_LARGE_SIZE))
        {
            throw new IllegalArgumentException(String.format("The size must be %s, %s, or %s.",
                                                             VALID_SMALL_SIZE,
                                                             VALID_MEDIUM_SIZE,
                                                             VALID_LARGE_SIZE));
        }
    }

    private static void validateWeight(final String sizeInches,
                                       final String weightGrahams)
    {
        if(sizeInches.equals(VALID_SMALL_SIZE))
        {
            if(!weightGrahams.equals(VALID_SMALL_SIZE_WEIGHT))
            {
                throw new IllegalArgumentException(String.format("For the %s size, the weight must be %s.",
                                                                 VALID_SMALL_SIZE,
                                                                 VALID_SMALL_SIZE_WEIGHT));
            }
        }

        if(sizeInches.equals(VALID_MEDIUM_SIZE))
        {
            if(!weightGrahams.equals(VALID_MEDIUM_SIZE_WEIGHT))
            {
                throw new IllegalArgumentException(String.format("For the %s size, the weight must be %s.",
                                                                 VALID_MEDIUM_SIZE,
                                                                 VALID_MEDIUM_SIZE_WEIGHT));
            }
        }

        if(sizeInches.equals(VALID_LARGE_SIZE))
        {
            if(!weightGrahams.equals(VALID_LARGE_SIZE_LOW_WEIGHT) &&
               !weightGrahams.equals(VALID_LARGE_SIZE_MEDIUM_WEIGHT) &&
               !weightGrahams.equals(VALID_LARGE_SIZE_HIGH_WEIGHT))
            {
                throw new IllegalArgumentException(String.format("For the %s size, the weight must be %s, %s, or %s.",
                                                                 VALID_LARGE_SIZE,
                                                                 VALID_LARGE_SIZE_LOW_WEIGHT,
                                                                 VALID_LARGE_SIZE_MEDIUM_WEIGHT,
                                                                 VALID_LARGE_SIZE_HIGH_WEIGHT));
            }
        }
    }

    @Override
    public String toString()
    {
        return "VinylRecord{" +
           "numberOfTracks=" + numberOfTracks +
           ", sizeInches='" + sizeInches + '\'' +
           ", weightGrahams='" + weightGrahams + '\'' +
           "} " + super.toString();
    }

    @Override
    public void play()
    {
        System.out.println("The vinyl record is being played.");
    }
}
