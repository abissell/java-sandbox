import org.junit.Test;

import java.nio.CharBuffer;

public class TestBuffers {
	public TestBuffers() {

	}

	@Test
	public void testModifyReadOnlyBuffer() {
		final char[] charArray = {'a', 'b', 'c'};
		final CharBuffer modifiableBuffer = CharBuffer.wrap(charArray);
		final CharBuffer readOnlyBuffer = modifiableBuffer.asReadOnlyBuffer();

		final char[] arrayToMod = readOnlyBuffer.array();
		arrayToMod[0] = 'd';
	}

	@Test
	public void testBufferBasics() {
		final CharBuffer buffer = CharBuffer.allocate(300);
		buffer.append('0').append('c').append('j');
		printBufferCharacteristics(buffer);
		buffer.flip();
		printBufferCharacteristics(buffer);
		buffer.get();
		printBufferCharacteristics(buffer);
		buffer.flip();
		printBufferCharacteristics(buffer);

		final char[] wrapped = {'1', '2', '3'};
		final CharBuffer buffer2 = CharBuffer.wrap(wrapped);
		printBufferCharacteristics(buffer2);
		final CharBuffer readOnlyBuffer = buffer2.asReadOnlyBuffer();
		printBufferCharacteristics(readOnlyBuffer);
	}

	private void printBufferCharacteristics(final CharBuffer buffer) {
		System.out.println("position=" + buffer.position() + ", length=" + buffer.length() + ", remaining=" + buffer.remaining() + ", capacity=" + buffer.capacity());
	}
}
