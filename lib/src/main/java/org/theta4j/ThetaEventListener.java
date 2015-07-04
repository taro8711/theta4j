package org.theta4j;

import java.util.EventListener;

/**
 * The listener interface for the events of RICOH THETA.
 *
 * @see Theta#addListener(ThetaEventListener)
 * @see Theta#removeListener(ThetaEventListener)
 */
public interface ThetaEventListener extends EventListener {
    /**
     * Notification of an object addition
     *
     * @param objectHandle The ObjectHandle of the added object.
     */
    void onObjectAdded(long objectHandle);

    void onCaptureStatusChanged();

    void onRecordingTimeChanged();

    void onRemainingRecordingTimeChanged();

    void onStoreFull(long storageID);

    void onCaptureComplete(long transactionID);
}
