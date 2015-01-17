package com.theta360.ptp.io;

import com.theta360.ptpip.io.PacketOutputStream;
import com.theta360.ptpip.packet.EndDataPacket;
import com.theta360.ptpip.packet.PtpIpPacket;
import com.theta360.ptpip.packet.StartDataPacket;
import com.theta360.ptp.type.UINT32;
import com.theta360.ptp.type.UINT64;
import com.theta360.test.categories.UnitTest;
import com.theta360.util.ByteUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Category(UnitTest.class)
public class PacketOutputStreamTest {
    private ByteArrayOutputStream baos;
    private PacketOutputStream pos;

    @Before
    public void setUp() {
        baos = new ByteArrayOutputStream();
        pos = new PacketOutputStream(baos);
    }

    @After
    public void cleanUp() throws IOException {
        pos.close();
    }

    @Test
    public void write() throws IOException {
        // given
        byte[] given = new byte[]{0x12, 0x34};

        // expected
        byte[] expected = new byte[]{
                0x0A, 0x00, 0x00, 0x00, // Length
                0x01, 0x00, 0x00, 0x00, // Type
                0x12, 0x34
        };

        // act
        pos.write(new PtpIpPacket(PtpIpPacket.Type.INIT_COMMAND_REQUEST, given));

        // verify
        byte[] actual = baos.toByteArray();
        assertThat(actual, is(expected));
    }

    @Test
    public void writeData() throws IOException {
        // given
        UINT32 transactionID = new UINT32(2);
        byte[] given = new byte[]{0x12, 0x34};

        // expected
        byte[] expected = ByteUtils.join(
                new StartDataPacket(transactionID, new UINT64(given.length)).bytes(),
                new EndDataPacket(transactionID, given).bytes()
        );

        // act
        pos.writeData(transactionID, given);

        // verify
        byte[] actual = baos.toByteArray();
        assertThat(actual, is(expected));
    }
}
