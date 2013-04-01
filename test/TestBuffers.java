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
		buffer.flip();
		printBufferCharacteristics(buffer);
	}

	private void printBufferCharacteristics(final CharBuffer buffer) {
		System.out.println("position=" + buffer.position() + ", length=" + buffer.length() + ", capacity=" + buffer.capacity());
	}
}
