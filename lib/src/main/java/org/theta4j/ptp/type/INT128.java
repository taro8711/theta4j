/*
 * Copyright (C) 2015 theta4j project
 */

package org.theta4j.ptp.type;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

/**
 * A class represents 128 defined in PTP standard.
 */
public class INT128 extends PtpInteger {
    // Utility Field

    /**
     * Size of type in bytes.
     */
    public static final int SIZE_IN_BYTES = 16;

    public static final INT128 MIN_VALUE = new INT128(BigIntegerUtils.minOfSigned(SIZE_IN_BYTES));
    public static final INT128 MAX_VALUE = new INT128(BigIntegerUtils.maxOfSigned(SIZE_IN_BYTES));

    public static final INT128 ZERO = new INT128(0);

    // Constructor

    public INT128(long value) {
        super(value);
    }

    public INT128(BigInteger value) {
        super(value);
    }

    public INT128(byte[] bytes) {
        super(bytes);
    }

    // Static Factory Method

    public static INT128 read(InputStream is) throws IOException {
        byte[] bytes = new byte[SIZE_IN_BYTES];

        if (is.read(bytes) != SIZE_IN_BYTES) {
            throw new EOFException();
        }

        return new INT128(bytes);
    }

    // LittleEndianInteger

    @Override
    protected int sizeInBytes() {
        return SIZE_IN_BYTES;
    }

    @Override
    protected boolean isSigned() {
        return true;
    }
}
