package me.rajarya.algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianOfStreamsTest {

    @Test
    public void testMedianOfStreamOfNumbers() {
        MedianOfStreams streams = new MedianOfStreams();
        streams.addNum(3);
        assertEquals(streams.getMedian(), 3.0);
        streams.addNum(1);
        assertEquals(streams.getMedian(), 2.0);
        streams.addNum(8);
        assertEquals(streams.getMedian(), 3.0);
        streams.addNum(2);
        assertEquals(streams.getMedian(), 2.5);
        streams.addNum(7);
        assertEquals(streams.getMedian(), 3.0);
    }
}
