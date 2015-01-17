package com.theta360.ptpip.packet;

import com.theta360.ptp.io.PtpInputStream;
import com.theta360.ptp.type.UINT32;
import com.theta360.util.Validators;

import java.io.IOException;

/**
 * InitEventRequest Packet defined in PTP-IP
 */
public final class InitEventRequestPacket extends PtpIpPacket {
    private static final int SIZE = UINT32.SIZE;

    private final UINT32 connectionNumber;

    // Constructor

    public InitEventRequestPacket(UINT32 connectionNumber) {
        super(Type.INIT_EVENT_REQUEST);

        Validators.validateNonNull("connectionNumber", connectionNumber);

        this.connectionNumber = connectionNumber;
        super.payload = connectionNumber.bytes();
    }

    // Getter

    public UINT32 getConnectionNumber() {
        return connectionNumber;
    }

    // Static Factory Method

    public static InitEventRequestPacket read(PtpInputStream pis) throws IOException {
        long length = pis.readUINT32().longValue();
        long payloadLength = length - UINT32.SIZE - UINT32.SIZE;
        PtpIpPacket.Type type = PtpIpPacket.Type.read(pis);

        PacketUtils.assertType(type, Type.INIT_EVENT_REQUEST);
        PacketUtils.checkLength((int) payloadLength, SIZE);

        UINT32 connectionNumber = pis.readUINT32();

        return new InitEventRequestPacket(connectionNumber);
    }

    // Basic Method

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InitEventRequestPacket that = (InitEventRequestPacket) o;

        if (!connectionNumber.equals(that.connectionNumber)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return connectionNumber.hashCode();
    }

    @Override
    public String toString() {
        return "InitEventRequestPacket{" +
                "connectionNumber=" + connectionNumber +
                '}';
    }
}