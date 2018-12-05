package appprint.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {

    private static String JOB_OK_LINE = "25, 10, false";

    @Test
    public void jobGetTotalPages() throws Exception{
        Job job = new Job(JOB_OK_LINE);
        assertEquals(25, job.getTotalPages());
    }

    @Test
    public void jobGetColorPages() throws Exception{
        Job job = new Job(JOB_OK_LINE);
        assertEquals(10, job.getColorPages());
    }

    @Test
    public void jobGetBlackAndWhitePages() throws Exception{
        Job job = new Job(JOB_OK_LINE);
        int baw = job.getTotalPages() - job.getColorPages();
        assertEquals(baw, job.getBlackAndWhitePages());
    }

    @Test
    public void jobGetDouble() throws Exception{
        Job job = new Job(JOB_OK_LINE);
        assertEquals(false, job.isDouble());
    }

    @Test
    public void jobIncorrectDoubleValue() throws Exception{
        Job job = new Job("25, 10, FAlsfewe");
        assertEquals(false, job.isDouble());
    }

    @Test (expected = RuntimeException.class)
    public void jobIncorrectTotalPages() throws Exception{
        Job job = new Job("25., 10, false");
    }

    @Test (expected = RuntimeException.class)
    public void jobIncorrectColorPages() throws Exception{
        Job job = new Job("25, 10.5, false");
    }

    @Test (expected = RuntimeException.class)
    public void jobEmptyLine() throws Exception{
        Job job = new Job("");
    }

    @Test (expected = RuntimeException.class)
    public void jobInvalidAmountOfColumns() throws Exception{
        Job job = new Job(",");
    }
}