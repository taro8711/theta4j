package org.theta4j.data;

import org.theta4j.ptp.type.UINT16;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StillCaptureModeTest {
    @Test
    public void value() {
        assertThat(StillCaptureMode.VIDEO.value(), is(UINT16.ZERO));
    }
}