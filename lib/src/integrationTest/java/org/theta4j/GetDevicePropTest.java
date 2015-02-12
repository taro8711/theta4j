package org.theta4j;

import org.theta4j.ptp.PtpException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class GetDevicePropTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetDevicePropTest.class);

    private static ThetaEventListener listener = new ThetaEventListener() {
        @Override
        public void onObjectAdded(long objectHandle) {
            LOGGER.info("onObjectAdded: " + objectHandle);
        }

        @Override
        public void onCaptureStatusChanged() {
            LOGGER.info("onCaptureStatusChanged");
        }

        @Override
        public void onRecordingTimeChanged() {
            LOGGER.info("onRecordingTimeChanged");
        }

        @Override
        public void onRemainingRecordingTimeChanged() {
            LOGGER.info("onRemainingRecordingTimeChanged");
        }

        @Override
        public void onStoreFull(long storageID) {
            LOGGER.info("onStoreFull: " + storageID);
        }

        @Override
        public void onCaptureComplete(long transactionID) {
            LOGGER.info("onCaptureComplete: " + transactionID);
        }
    };

    private static Theta theta;

    @BeforeClass
    public static void connect() throws IOException, PtpException {
        theta = new Theta();
        theta.addListener(listener);
    }

    @AfterClass
    public static void close() throws IOException, InterruptedException, PtpException {
        theta.close();
        Thread.sleep(TestParameters.INTERVAL_MS);
    }

    // Test

    @Test
    public void getBatteryLevel() throws IOException, PtpException {
        LOGGER.info("Battery Level: " + theta.getBatteryLevel());
    }

    @Test
    public void getWhiteBalance() throws IOException, PtpException {
        LOGGER.info("White Balance: " + theta.getWhiteBalance());
    }

    @Test
    public void getExposureIndex() throws IOException, PtpException {
        LOGGER.info("Exposure Index: " + theta.getExposureIndex());
    }

    @Test
    public void getExposureBiasCompensation() throws IOException, PtpException {
        LOGGER.info("Exposure Bias Compensation: " + theta.getExposureIndex());
    }

    @Test
    public void getDateTime() throws IOException, PtpException {
        LOGGER.info("DateTime: " + theta.getDateTime());
    }

    @Test
    public void getStillCaptureMode() throws IOException, PtpException {
        LOGGER.info("Still Capture Mode: " + theta.getStillCaptureMode());
    }

    @Test
    public void getTimelapseNumber() throws IOException, PtpException {
        LOGGER.info("Timelapse Number: " + theta.getTimelapseNumber());
    }

    @Test
    public void getTimelapseInterval() throws IOException, PtpException {
        LOGGER.info("Timelapse Interval: " + theta.getTimelapseInterval());
    }

    @Test
    public void getAudioVolume() throws IOException, PtpException {
        LOGGER.info("Audio Volume: " + theta.getAudioVolume());
    }

    @Test
    public void getErrorInfo() throws IOException, PtpException {
        LOGGER.info("Error Info: " + theta.getErrorInfo());
    }

    @Test
    public void getShutterSpeed() throws IOException, PtpException {
        LOGGER.info("Shutter Speed: " + theta.getShutterSpeed());
    }

    @Test
    public void getGPSInfo() throws IOException, PtpException {
        LOGGER.info("GPS Info: " + theta.getGPSInfo());
    }

    @Test
    public void getAutoPowerOffDelay() throws IOException, PtpException {
        LOGGER.info("Auto Power Delay: " + theta.getAutoPowerOffDelay());
    }

    @Test
    public void getSleepDelay() throws IOException, PtpException {
        LOGGER.info("Sleep Delay: " + theta.getSleepDelay());
    }

    @Test
    public void getChannelNumber() throws IOException, PtpException {
        LOGGER.info("Channel Number: " + theta.getChannelNumber());
    }

    @Test
    public void getCaptureStatus() throws IOException, PtpException {
        LOGGER.info("Capture Status: " + theta.getCaptureStatus());
    }

    @Test
    public void getRecordingTime() throws IOException, PtpException {
        LOGGER.info("Recording Time: " + theta.getRecordingTime());
    }

    @Test
    public void getRemainingRecordingTime() throws IOException, PtpException {
        LOGGER.info("Remaining Recording Time: " + theta.getRemainingRecordingTime());
    }
}